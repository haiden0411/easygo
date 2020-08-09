package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author：胡灯
 * Date：2020-08-09 8:30
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
public class AdminServiceApp {
    public static void main(String[] args) {
        System.out.println("登录服务启动9003....");
        SpringApplication.run(AdminServiceApp.class,args);
    }
}
