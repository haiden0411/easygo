package com.easygo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author：胡灯
 * Date：2020-08-25 22:07
 * Description：<描述>
 */
@SpringBootApplication
@EnableEurekaClient
public class TypeTemplateServiceApp {
    public static void main(String[] args) {
        System.out.println("规格服务9007.....");
        SpringApplication.run(TypeTemplateServiceApp.class,args);
    }
}
