package com.uzi.demo;

import com.uzi.model.Goods;

public class RespGoods {

    private Goods goods;
    private Integer num;
    private Integer goodsPrice;

    public RespGoods(Integer num, Goods goods) {
        this.goods=goods;
        this.num=num;
        this.goodsPrice=num*goods.getGoodsprice();
    }


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
