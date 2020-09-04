package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author：胡灯
 * Date：2020-09-02 22:49
 * Description：<描述>
 */

@SpringBootApplication
@EnableEurekaClient
public class ItemServiceApp {
    public static void main(String[] args) {
        System.out.println("商品分类服务启动："+9008);
        SpringApplication.run(ItemServiceApp.class,args);
    }
}
