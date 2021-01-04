package com.uzi.demo.controller;

import com.uzi.demo.RespEntity;
import com.uzi.demo.RespShopCart;
import com.uzi.mapper.ShopCartMapper;
import com.uzi.model.ShopCart;
import com.uzi.model.ShopCartExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CartController {
    @Autowired
    ShopCartMapper shopCartMapper;
    static ShopCartMapper shopCartMapper2;
    @Autowired
    Environment env;

    /**
     * 获取当前用户的购物车,list
     *
     * @param // userid
     * @return list
     */
    @PostMapping("/cart/get")
    public RespEntity get(@RequestBody Map<String, Object> mp) {
        Integer userid = (Integer) mp.get("userid");
        ShopCartExample shopCartExample = new ShopCartExample();
        shopCartExample.createCriteria().andUseridEqualTo(userid);
        List<ShopCart> list = shopCartMapper.selectByExample(shopCartExample);
        List<RespShopCart> rList = new ArrayList<>();
        for (ShopCart cart : list) {
            rList.add(new RespShopCart(cart,env));
        }
        if (rList.isEmpty()) return new RespEntity("ok", 200, rList);
        RespShopCart rsc = rList.get(0);
        return new RespEntity("ok", 200, rList);
    }

    /**
     * 根据userid和cartsid加入购物车. 如果有就++, 没有就新增
     *
     * @param // userid cartsid
     * @return
     */
    @PostMapping("/cart/add")
    public RespEntity add(@RequestBody Map<String, Object> mp) {
        Integer userid = (Integer) mp.get("userid");
        Integer cartid = (Integer) mp.get("cartid");
        ShopCartExample example = new ShopCartExample();
        example.createCriteria().andUseridEqualTo(userid)
                .andCartidEqualTo(cartid);
        List<ShopCart> list = shopCartMapper.selectByExample(example);
        ShopCart shopCart = new ShopCart();
        if (list.isEmpty()) {
            shopCart.setCartid(cartid);
            shopCart.setGoodsInCartNum(1);
            shopCart.setUserid(userid);
            shopCartMapper.insertSelective(shopCart);
        } else {
            shopCart = list.get(0);
            shopCart.setGoodsInCartNum(shopCart.getGoodsInCartNum() + 1);
            shopCartMapper.updateByExampleSelective(shopCart, example);
        }
        return new RespEntity("ok", 200, null);
    }

    /**
     * 购物车某一项的个数+1
     *
     * @param mp
     * @return
     */
    @PostMapping("/cart/addwithgoods")
    public RespEntity add2(@RequestBody Map<String, Object> mp) {
        Integer userid = (Integer) mp.get("userid");
        Integer goodsid = (Integer) mp.get("goodsid");
        ShopCartExample example = new ShopCartExample();
        example.createCriteria().andUseridEqualTo(userid)
                .andGoodsidEqualTo(goodsid);
        List<ShopCart> list = shopCartMapper.selectByExample(example);
        ShopCart shopCart = new ShopCart();
        if (list.isEmpty()) {
            shopCart.setGoodsid(goodsid);
            shopCart.setGoodsInCartNum(1);
            shopCart.setUserid(userid);
            shopCartMapper.insertSelective(shopCart);
        } else {
            shopCart = list.get(0);
            shopCart.setGoodsInCartNum(shopCart.getGoodsInCartNum() + 1);
            shopCartMapper.updateByExampleSelective(shopCart, example);
        }
        return new RespEntity("ok", 200, null);
    }


    /**
     * 购物车某一项的个数-1
     *
     * @param mp
     * @return
     */
    @PostMapping("/cart/reduce")
    public RespEntity reduce(@RequestBody Map<String, Object> mp) {
        Integer userid = (Integer) mp.get("userid");
        Integer cartid = (Integer) mp.get("cartid");
        ShopCartExample example = new ShopCartExample();
        example.createCriteria().andUseridEqualTo(userid)
                .andCartidEqualTo(cartid);
        List<ShopCart> list = shopCartMapper.selectByExample(example);
        ShopCart shopCart = new ShopCart();
        shopCart = list.get(0);
        shopCart.setGoodsInCartNum(shopCart.getGoodsInCartNum() - 1);
        shopCartMapper.updateByExampleSelective(shopCart, example);
        if (shopCart.getGoodsInCartNum() == 0) {
            shopCartMapper.deleteByExample(example);
        }
        return new RespEntity("ok", 200, null);
    }


//    @PostMapping("/cart/deletelist")
////    public RespEntity delete(@RequestBody Map<String,Object>mp){
////
////    }


    // 生成静态mapper
    @PostConstruct
    public void init() {
        shopCartMapper2 = this.shopCartMapper;
    }

    public static Integer findNumByCartId(Integer cartid) {
        return shopCartMapper2.selectByPrimaryKey(cartid).getGoodsInCartNum();
    }

    public static Integer findGoodsIdByCartId(Integer cartid) {
        return shopCartMapper2.selectByPrimaryKey(cartid).getGoodsid();
    }

    public static Boolean isEnough(Integer cartid) {
        Integer goodsid = findGoodsIdByCartId(cartid);
        Integer goodsnum = GoodsController.findGoodsById(goodsid).getGoodsnum();
        Integer goodsNumInCart = shopCartMapper2.selectByPrimaryKey(cartid).getGoodsInCartNum();
        return goodsnum >= goodsNumInCart;
    }

    public static void deleteCartByCartId(Integer cartid) {
        shopCartMapper2.deleteByPrimaryKey(cartid);
    }

}
