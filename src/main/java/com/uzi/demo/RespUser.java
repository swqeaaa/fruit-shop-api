package com.uzi.demo;

import com.uzi.model.User;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class RespUser {
    private Integer islogin,avatar;
    private Integer userid;
    private String email,sex,name,address;


    public Integer getIslogin() {
        return islogin;
    }

    public void setIslogin(Integer islogin) {
        this.islogin = islogin;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RespUser(){}

    public RespUser(Integer islogin, Integer avatar, Integer userid, String email, String sex, String name, String address) {
        this.islogin = islogin;
        this.avatar = avatar;
        this.userid = userid;
        this.email = email;
        this.sex = sex;
        this.name = name;
        this.address = address;
    }

    public RespUser(User user){
        this.islogin = user.getIslogin();
        this.userid = user.getUserid();
        this.email =user.getEmail();
        this.sex = user.getSex();
        this.name = user.getName();
        this.avatar = user.getAvatar();
        this.address = user.getAddress();
    }


}
