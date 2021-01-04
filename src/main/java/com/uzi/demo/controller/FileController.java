package com.uzi.demo.controller;

import com.uzi.demo.RespEntity;
import com.uzi.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * storeService因为根启动类不一个包(?), 所以找不到了
 * 这个注解让我们能找到这个storeService
 */
@ComponentScan("com.uzi.service")
@Slf4j
@RestController
public class FileController {
    @Autowired
    StoreService storeService;

        @PostMapping(value = "/file/upload")
    public Object upload(@RequestBody MultipartFile multipartFile) {
//        System.err.println("here::: ");
//        System.err.println(multipartFile.getContentType());
//        System.err.println(multipartFile.getName());
//        System.err.println(multipartFile.getResource().toString());
//        System.err.println(multipartFile.getOriginalFilename());
//        /*if (null == multipartFile)*/ System.err.println("cnm!!!");
        return new RespEntity("ok", 200, storeService.upload(multipartFile));
    }

    @PostMapping(value = "/file/download")
    public Object download(String key, HttpServletResponse response) {
        storeService.download(key, response);
        return key + "图片返回成功";
    }


}
