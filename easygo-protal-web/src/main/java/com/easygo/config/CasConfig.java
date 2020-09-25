package com.easygo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Author：胡灯
 * Date：2020-09-24 21:09
 * Description：<描述>
 */
@Configuration
@ConfigurationProperties(prefix = "cas")
@Data
public class CasConfig {
    private String casServerUrlPrefix = "https://server.fable.com:8443/cas";
    private String casServerLoginUrl = casServerUrlPrefix + "/login";
    private String casServerLogoutUrl = casServerUrlPrefix + "/logout";
    private String localServerUrlPrefix = "http://client1.fable.com:8081/aaaa";
    private String casFilterUrlPattern = "/shiro-cas";
    private String localServerLoginUrl = casServerLoginUrl + "?service=" + localServerUrlPrefix + casFilterUrlPattern;
    public String getCasService() {
        return localServerUrlPrefix + casFilterUrlPattern;
    }
}
