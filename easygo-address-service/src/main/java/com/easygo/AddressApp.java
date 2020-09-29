package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author：胡灯
 * Date：2020-09-29 21:44
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
public class AddressApp {
    public static void main(String[] args) {
        System.out.println("地址服务已经启动....9013");
        SpringApplication.run(AddressApp.class,args);
    }
}
