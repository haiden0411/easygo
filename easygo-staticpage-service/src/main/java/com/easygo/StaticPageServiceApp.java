package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Author：胡灯
 * Date：2020-09-14 21:11
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class StaticPageServiceApp {
    public static void main(String[] args) {
        System.out.println("页面静态化服务启动...9011");
        SpringApplication.run(StaticPageServiceApp.class,args);
    }
}
