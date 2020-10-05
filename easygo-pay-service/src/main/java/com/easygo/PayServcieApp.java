package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author：胡灯
 * Date：2020-10-05 21:23
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
public class PayServcieApp {
    public static void main(String[] args) {
        System.out.println("支付服务启动....9015");
        SpringApplication.run(PayServcieApp.class,args);
    }
}
