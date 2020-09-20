package com.easygo;

import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author：胡灯
 * Date：2020-09-19 22:55
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
public class UsersServiceApp {
    public static void main(String[] args) {
        System.out.println("会员注册服务启动....9012");
        SpringApplication.run(UsersServiceApp.class,args);
    }
}
