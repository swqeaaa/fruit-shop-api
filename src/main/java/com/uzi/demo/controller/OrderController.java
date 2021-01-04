package com.uzi.demo.controller;

import com.uzi.demo.RespEntity;
import com.uzi.demo.RespGoods;
import com.uzi.demo.RespOrder;
import com.uzi.mapper.OrderToGoodsMapper;
import com.uzi.mapper.OrdersMapper;
import com.uzi.model.*;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


@RestController
public class OrderController {
    @Autowired
    OrdersMapper ordersMapper;
    @Autowired
    OrderToGoodsMapper orderToGoodsMapper;
    @Autowired
    Environment environment;

    /**
     * 获取所有订单
     *
     * @param mp
     * @return
     */
    @PostMapping("/order/get")
    public RespEntity get(@RequestBody Map<String, Object> mp) {
        Integer userid = (Integer) mp.get("userid");
        OrdersExample orderExample = new OrdersExample();
        orderExample.createCriteria().andUseridEqualTo(userid);
        List<Orders> orderList = ordersMapper.selectByExample(orderExample);

        List<RespOrder> respOrderList = new ArrayList<>();
        for (Orders orders : orderList) {
            Integer isOver = orders.getIsover();//
            Integer orderid = orders.getOrdersid();
            OrderToGoodsExample orderToGoodsExample = new OrderToGoodsExample();
            orderToGoodsExample.createCriteria().andOrderidEqualTo(orderid);
            List<OrderToGoods> orderToGoodsExampleList = orderToGoodsMapper.selectByExample(orderToGoodsExample);

            List<RespGoods> respGoodsList = new ArrayList<>();
            for (OrderToGoods orderToGoods : orderToGoodsExampleList) {
                Integer goodsid = orderToGoods.getGoodsid();
                Goods goods = GoodsController.findGoodsById(goodsid);////
                Integer num = orderToGoods.getNum();//
                try {
//                    System.err.println("name: " + goods.getGoodsname());
//                    goods.setGoodsimg("http://10.161.69.88:8080" + goods.getGoodsimg());
//                    goods.setGoodsimg("http://localhost:8080" + goods.getGoodsimg());
                    goods.setGoodsimg(environment.getProperty("myhost") + goods.getGoodsimg());
                    respGoodsList.add(new RespGoods(num, goods));
                } catch (Exception ignored) {
                }
            }
            respOrderList.add(new RespOrder(isOver, respGoodsList,orderid));
        }
        respOrderList.sort(Comparator.comparing(RespOrder::getOrderid));
        return new RespEntity("ok", 200, respOrderList);
    }

    /**
     * 由购物车生成订单, 并删除购物车
     *
     * @param mp
     * @return
     */
    @PostMapping("/order/generate")
    public RespEntity generate(@RequestBody Map<String, Object> mp) {

        Integer userid = (Integer) mp.get("userid");
        List<Integer> cartIds = (List<Integer>) mp.get("carts");
        boolean isEnough = true;
        for (Integer cartid : cartIds) {
            System.err.println("cartid:" + cartid);
            if (!CartController.isEnough(cartid)) {
                isEnough = false;
                break;
            }
        }

        if (isEnough) {
            // 插入order表
            Orders orders = new Orders();
            orders.setUserid(userid);
            orders.setIsover(1);
            ordersMapper.insertSelective(orders);

            // 2019/11 update
            // 查询新插入数据的自增长主键值
            //mybatis在mapperxml的insertByExample里加useGeneratedKeys="true" keyProperty="id"
            //用getId()即可.

            // 2019年12月13日 update
            // 上面的方法对于mysql是可以的
            // 但对于oracle, 没有官方的自增主键设置, 好像就不可以这么搞
            // 只能老老实实的看哪条记录是新加的, 然后再取出来.
            OrdersExample ordersExample = new OrdersExample();
            ordersExample.createCriteria().andUseridEqualTo(userid);
            Integer ordersid = -1;
            List<Orders> list = ordersMapper.selectByExample(ordersExample);
            for (Orders orders1 : list) {
                if (orders1.getOrdersid() > ordersid) ordersid = orders1.getOrdersid();
            }

            //如果库存足够, 就继续加入order to goods 的表
            for (Integer cartid : cartIds) {
                Integer num = CartController.findNumByCartId(cartid);
                Integer goodsid = CartController.findGoodsIdByCartId(cartid);
                OrderToGoods orderToGoods = new OrderToGoods();
                orderToGoods.setGoodsid(goodsid);
                orderToGoods.setNum(num);
                orderToGoods.setOrderid(ordersid);
                orderToGoodsMapper.insertSelective(orderToGoods);
            }

            // 减少库存
            for(Integer cartid: cartIds){
                Integer num = CartController.findNumByCartId(cartid);
                Integer goodsid = CartController.findGoodsIdByCartId(cartid);
                GoodsController.reduceGoodsNumById(goodsid,num);
            }

            // 删除购物车
            for (Integer cartid : cartIds) {
                CartController.deleteCartByCartId(cartid);
            }
            return new RespEntity("ok", 200, null);
        } else {
            return new RespEntity("库存不足", 400, null);
        }


    }

    /**
     * 根据订单号获取对应订单总价(回应请求)
     * @param mp
     * @return
     */
    @PostMapping("/order/totalprice")
    public RespEntity getTotalPrice(@RequestBody Map<String,Object>mp){
        Integer orderId=(Integer)mp.get("orderid");
        return getPriceByOrderId(orderId);
    }

    /**
     * 返回最新订单的总价
     * @return
     */
    @PostMapping("/order/recentprice")
    public RespEntity getRecentPrice(){
        OrdersExample ordersExample=new OrdersExample();
        List<Orders>ordersList=ordersMapper.selectByExample(ordersExample);
        Integer orderId=-1;
        for(Orders orders:ordersList){
            if(orderId<orders.getOrdersid())orderId=orders.getOrdersid();
        }


        return getPriceByOrderId(orderId);
    }

    /**
     * 根据订单号获取对应订单总价
     * @param orderId
     * @return
     */
    private RespEntity getPriceByOrderId(Integer orderId){
        OrderToGoodsExample orderToGoodsExample=new OrderToGoodsExample();
        orderToGoodsExample.createCriteria().andOrderidEqualTo(orderId);
        List<OrderToGoods>orderToGoodsList=orderToGoodsMapper.selectByExample(orderToGoodsExample);
        int totalPrice=0;
        for(OrderToGoods orderToGoods:orderToGoodsList){
            Integer goodsId=orderToGoods.getGoodsid();
            totalPrice+=GoodsController.findGoodsById(goodsId).getGoodsprice()*orderToGoods.getNum();
        }
        return new RespEntity("ok",200,totalPrice);
    }

}
