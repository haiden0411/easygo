package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Author：胡灯
 * Date：2020-09-11 23:03
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SearchServiceApp {
    public static void main(String[] args) {
        System.out.println("启动搜索服务9009.....");
        SpringApplication.run(SearchServiceApp.class,args);
    }
}
