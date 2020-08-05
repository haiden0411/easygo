package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Author：胡灯
 * Date：2020-08-04 22:14
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaAp {
    public static void main(String[] args) {
        System.out.println("注册中心9001...");
        SpringApplication.run(EurekaAp.class,args);
    }
}
