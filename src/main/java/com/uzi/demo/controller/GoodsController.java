package com.uzi.demo.controller;


import com.uzi.demo.RespEntity;
import com.uzi.mapper.GoodsMapper;
import com.uzi.model.Goods;
import com.uzi.model.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {

    @Autowired
    Environment ev;


    @Autowired
    public GoodsMapper goodsMapper;// edit profile settings
    static GoodsMapper gm2;

    /**
     * 获取全部商品信息
     *
     * @return
     */
    @PostMapping("/goods/get-all-info")
    public RespEntity getAllInfo() {
        GoodsExample example = new GoodsExample();
        example.createCriteria().andGoodsidIsNotNull();
        List<Goods> list = goodsMapper.selectByExample(example);
        for (Goods goods : list) {
            goods.setGoodsimg(ev.getProperty("myhost") + goods.getGoodsimg());
        }
        list.sort(Comparator.comparing(Goods::getGoodsid));
        return new RespEntity("ok", 200, list);
    }

    /**
     * 新增商品
     * 先调用/file/upload上传图片, 服务器返回图片截断url后, 上传商品信息
     *
     * @return
     */
    @PostMapping("/goods/add")
    public RespEntity add(@RequestBody Map<String, Object> mp) {
        if (mp.isEmpty()) return new RespEntity("不能为空", 400, null);
        Goods goods = new Goods(mp);
        System.err.println(goods.getGoodsid());
        if (goods.partEmpty()) return new RespEntity("不能为空", 400, null);
        goodsMapper.insertSelective(goods);
        return new RespEntity("ok", 200, null);

    }


    /**
     * 修改某个商品的信息
     * 同样要先整url
     * 返回修改后的这个商品
     */
    @PostMapping("/goods/modify")
    public RespEntity modify(@RequestBody Map<String, Object> mp) {
        Goods goods = new Goods(mp);
        if (goods.partEmpty()) return new RespEntity("不能为空", 400, null);
        GoodsExample example = new GoodsExample();
        example.createCriteria().andGoodsidEqualTo((Integer) mp.get("goodsid"));
        goodsMapper.updateByExampleSelective(goods, example);
        Goods goods1 = goodsMapper.selectByPrimaryKey((Integer) mp.get("goodsid"));
        return new RespEntity("ok", 200, goods1);
    }

    /**
     * 删除某个商品
     *
     * @param // goodsid
     * @return
     */
    @PostMapping("/goods/delete")
    public RespEntity delete(@RequestBody Map<String, Object> mp) {
        goodsMapper.deleteByPrimaryKey((Integer) mp.get("goodsid"));
        return new RespEntity("ok", 200, null);
    }

    // 生成静态mapper
    @PostConstruct
    public void init() {

//        System.err.println("have run init!!!!!!!!");
        gm2 = this.goodsMapper;

//        if (gm2 != null) System.err.println("gm2 is not null!!!!!!!");
    }

    public static Goods findGoodsById(Integer id) {
        return gm2.selectByPrimaryKey(id);
    }

    public static void reduceGoodsNumById(Integer id, Integer num) {
        Goods goods=gm2.selectByPrimaryKey(id);
        goods.setGoodsnum(goods.getGoodsnum()-num);
        gm2.updateByPrimaryKeySelective(goods);
    }

}
