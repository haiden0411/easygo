package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author：胡灯
 * Date：2020-09-12 22:09
 * Description：<描述>
 */

@SpringBootApplication
@EnableEurekaClient
public class GoodsServiceApp {
    public static void main(String[] args) {
        System.out.println("商品服务启动9010");
        SpringApplication.run(GoodsServiceApp.class,args);
    }
}
