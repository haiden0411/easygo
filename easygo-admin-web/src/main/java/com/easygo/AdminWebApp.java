package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Author：胡灯
 * Date：2020-08-04 23:51
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AdminWebApp {
    public static void main(String[] args) {
        System.out.println("运营端9002");
        SpringApplication.run(AdminWebApp.class,args);
    }
}
