package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author：胡灯
 * Date：2020-08-03 22:48
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
public class BrandServiceApp {
    public static void main(String[] args) {
        System.out.println("品牌服务启动9000.....");
        SpringApplication.run(BrandServiceApp.class,args);
    }
}
