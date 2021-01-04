package com.uzi.demo;

import java.util.Comparator;
import java.util.List;

public class RespOrder {

    private Integer isOver;
    private List<RespGoods>respGoodsList;
    private Integer price;
    private Integer orderid;

    public RespOrder(Integer isOver, List<RespGoods> respGoodsList,Integer orderid) {
        this.isOver=isOver;
        this.respGoodsList=respGoodsList;
        price=0;
        for(RespGoods respGoods:respGoodsList){
            price+=respGoods.getGoodsPrice();
        }
        this.orderid=orderid;
    }

    public Integer getIsOver() {
        return isOver;
    }

    public void setIsOver(Integer isOver) {
        this.isOver = isOver;
    }

    public List<RespGoods> getRespGoodsList() {
        return respGoodsList;
    }

    public void setRespGoodsList(List<RespGoods> respGoodsList) {
        this.respGoodsList = respGoodsList;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
}
