package com.uzi.model;

public class OrderToGoods {
    private Integer otgid;

    private Integer orderid;

    private Integer goodsid;

    private Integer num;

    public Integer getOtgid() {
        return otgid;
    }

    public void setOtgid(Integer otgid) {
        this.otgid = otgid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}