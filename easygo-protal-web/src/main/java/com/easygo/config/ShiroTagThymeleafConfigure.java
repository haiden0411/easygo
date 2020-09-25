package com.easygo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author：胡灯
 * Date：2020-09-25 22:26
 * Description：<描述>
 */
@Configuration
public class ShiroTagThymeleafConfigure {

    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
