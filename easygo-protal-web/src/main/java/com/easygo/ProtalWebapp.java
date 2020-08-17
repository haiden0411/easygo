package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Author：胡灯
 * Date：2020-08-16 23:14
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ProtalWebapp {
    public static void main(String[] args) {
        System.out.println("门户网站9005...");
        SpringApplication.run(ProtalWebapp.class,args);
    }
}
