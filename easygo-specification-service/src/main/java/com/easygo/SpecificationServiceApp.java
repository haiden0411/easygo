package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Author：胡灯
 * Date：2020-08-21 23:53
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
public class SpecificationServiceApp {
    public static void main(String[] args) {
        System.out.println("规格服务9006.....");
        SpringApplication.run(SpecificationServiceApp.class,args);
    }
}
