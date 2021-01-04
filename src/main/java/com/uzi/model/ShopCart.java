package com.uzi.model;

public class ShopCart {
    private Integer cartid;

    private Integer userid;

    private Integer goodsid;

    private Integer goodsInCartNum;

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getGoodsInCartNum() {
        return goodsInCartNum;
    }

    public void setGoodsInCartNum(Integer goodsInCartNum) {
        this.goodsInCartNum = goodsInCartNum;
    }
}