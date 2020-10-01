package com.easygo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author：胡灯
 * Date：2020-10-01 22:53
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderServiceApp {
    public static void main(String[] args) {
        System.out.println("订单服务启动....9014");
        SpringApplication.run(OrderServiceApp.class,args);
    }
}
