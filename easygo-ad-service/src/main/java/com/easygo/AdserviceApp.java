package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author：胡灯
 * Date：2020-08-12 20:48
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
public class AdserviceApp {
    public static void main(String[] args) {
        System.out.println("广告服务9004...");
        SpringApplication.run(AdserviceApp.class,args);
    }
}
