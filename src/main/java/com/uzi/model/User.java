package com.uzi.model;

import java.util.Map;

public class User {
    private Integer userid;

    private String name;

    private String email;

    private Integer avatar;

    private String sex;

    private String address;

    private String passwd;

    private Integer islogin;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Integer getIslogin() {
        return islogin;
    }

    public void setIslogin(Integer islogin) {
        this.islogin = islogin;
    }


    public User() {
    }

    public User(Map<String, Object> mp) {
        // 用户id应该自动生成, 怎么办
//        this.setIslogin((Boolean) mp.get("islogin"));
        this.setEmail((String) mp.get("email"));
        this.setAddress((String) mp.get("address"));
        this.setAvatar((Integer) mp.get("avatar"));
        this.setPasswd((String) mp.get("passwd"));
        this.setName((String) mp.get("name"));
        this.setSex((String) mp.get("sex"));
    }

    public boolean partEmpty() {
        return this.getAddress().isEmpty()
                || this.getEmail().isEmpty() || this.getName().isEmpty()
                || this.getSex().isEmpty() || this.getPasswd().isEmpty();
    }
}