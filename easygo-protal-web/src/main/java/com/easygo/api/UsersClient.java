package com.easygo.api;

import com.easygo.pojo.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author：胡灯
 * Date：2020-09-19 23:20
 * Description：<描述>
 */
@FeignClient(value = "easygo-users-service")
public interface UsersClient {
    @RequestMapping("/users_add")
    public Integer addUsers(@RequestBody Users users);
}
