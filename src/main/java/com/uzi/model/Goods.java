package com.uzi.model;

import java.util.Map;

public class Goods {
    private Integer goodsid;

    private String goodsname;

    private String goodsimg;

    private Integer goodsprice;

    private String goodsinfo;

    private Integer goodsnum;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg == null ? null : goodsimg.trim();
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
        this.goodsinfo = goodsinfo == null ? null : goodsinfo.trim();
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }



    public Goods() {
    }

    public Goods(Map<String, Object> mp) {
//        this.goodsid = (Integer) mp.get("goodsid");
        this.goodsimg = (String) mp.get("goodsimg");
        this.goodsinfo = (String) mp.get("goodsinfo");
        this.goodsname = (String) mp.get("goodsname");
        this.goodsnum = (Integer) mp.get("goodsnum");
        this.goodsprice = (Integer) mp.get("goodsprice");
    }

    public boolean partEmpty() {
        return null == this.goodsname || null == this.goodsinfo
                || null == this.goodsimg
                || this.goodsname.isEmpty() || this.goodsinfo.isEmpty()
                || this.goodsimg.isEmpty();
    }
}