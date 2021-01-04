package com.uzi.demo;
import lombok.Data;

import java.io.Serializable;

@Data
public class RespEntity implements Serializable {

    private String info;//返回信息
    private Integer code;// 返回码
    private Object data;// 返回数据

    public RespEntity() {
    }

    public RespEntity(String info, Integer code, Object data) {
        this.info = info;
        this.code = code;
        this.data = data;
    }
}
