package com.easygo.api;

import com.easygo.pojo.LoginLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-11 20:51
 * Description：<描述>
 */
@FeignClient("easygo-admin-service")
public interface LoginLogClient {
    @RequestMapping("/loginLog_add")
    public int addLoginLog(@RequestBody LoginLog log);

    @RequestMapping("/loginLog_logs")
    public List<LoginLog> getMyLoginLog(@RequestParam String username);
}
