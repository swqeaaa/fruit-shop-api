package com.uzi.service;


//import org.omg.CORBA.Environment;
//import com.sun.deploy.Environment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@Service
@Slf4j
public class StoreService {

    //用于获取配置文件中的属性的类
    @Autowired
    private Environment env;

    //文件保存路径
    private String fileStorePath;

    //用于锁
    private final Object createFileLock = new Object();

    /**
     * 保存文件 返回file key         记得改成respEntity
     */
    public String upload(MultipartFile file) {
        return storeFile(file);
    }

    public void download(String key, HttpServletResponse response) {
        Assert.hasText(key, "Invalid key");
        try {
            Files.copy(getFile(key), response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("下载发送错误");
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Invalid key!");
        }
    }


    @PostConstruct
    private void setFileStorePath() {
        String property = env.getProperty("file.store.path");
        Assert.notNull(property, "must set fileStorePath");
        System.out.println("path: "+property);
        fileStorePath = property;
    }

    private boolean checkPathConflict(Path path) {
        return Files.exists(path);
    }


    //创建图片的保存路径
    private Path name2Path(String fileName) {
        //16 * 16 * (16*16)
        return Paths.get(fileStorePath, fileName.substring(0, 2), fileName.substring(2, 4), fileName);
    }

    //保存文件实现
    private String storeFile(MultipartFile file) {
        synchronized (createFileLock) {
            //文件保存路径
            Path path;
            //图片名称
            String fileName;
            String urlName="/files/";
            do {
                //图片名称赋值
                fileName = UUID.randomUUID().toString();
                String preName=file.getOriginalFilename();
                System.err.println("pre-name"+preName);
                String suffix=preName.substring(preName.lastIndexOf("."),preName.length());
                System.err.println(suffix);
                fileName+=suffix;
                //保存路径赋值
                path = name2Path(fileName);
                //循环条件就是 如果文件地址不存在的情况下
            } while (checkPathConflict(path));
            try {
                //创建文件夹
                Files.createDirectories(path.getParent());
                //复制文件到指定文件夹下面
                Files.copy(file.getInputStream(), path);
                urlName+=fileName.substring(0, 2)+"/"+fileName.substring(2, 4)+"/"+fileName;
                System.err.println("url:  "+urlName);
                return urlName;
//                return fileName;
            } catch (IOException e) {
                System.out.println("io err: "+e);
                throw new IllegalArgumentException("文件上传失败");
            }
        }
    }

    //现在图片实现
    private Path getFile(String fileName) {
        //获取文件保存路径

        Path path = name2Path(fileName);

        System.err.println(path.toString());
        Assert.isTrue(Files.exists(path), "Invalid Filename " + fileName);
        return path;
    }


}