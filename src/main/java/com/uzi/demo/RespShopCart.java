package com.uzi.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uzi.demo.controller.GoodsController;
import com.uzi.model.Goods;
import com.uzi.model.ShopCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RespShopCart {


    // 来自ShopCart类
    private Integer cartid;
    private Integer goodsincartnum;// 购物车中的个数
    //

    // 来自Goods类
    private String goodsname;
    private Integer goodsprice;
    private String goodsinfo;
    private Integer goodsnum;// 库存
    private String goodsimg;// 要补全url
    //



    public RespShopCart(ShopCart shopCart,Environment env) {
        this.cartid = shopCart.getCartid();
        this.goodsincartnum = shopCart.getGoodsInCartNum();
        System.err.println(shopCart.getGoodsid());
        Goods goods = GoodsController.findGoodsById(shopCart.getGoodsid());
//        System.err.println(goods.getGoodsname());

        this.goodsname = goods.getGoodsname();
        this.goodsinfo = goods.getGoodsinfo();
        this.goodsnum = goods.getGoodsnum();
        this.goodsprice = goods.getGoodsprice();
//        this.goodsimg = "http://10.161.69.88:8080" + goods.getGoodsimg();
//        this.goodsimg = "http://localhost:8080" + goods.getGoodsimg();
        this.goodsimg=env.getProperty("myhost")+ goods.getGoodsimg();

    }

//get and set
    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public Integer getGoodsincartnum() {
        return goodsincartnum;
    }

    public void setGoodsincartnum(Integer goodsincartnum) {
        this.goodsincartnum = goodsincartnum;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Integer getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Integer goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsinfo() {
        return goodsinfo;
    }

    public void setGoodsinfo(String goodsinfo) {
        this.goodsinfo = goodsinfo;
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }
}
