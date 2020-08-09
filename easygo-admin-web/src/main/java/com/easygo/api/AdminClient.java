package com.easygo.api;

import com.easygo.pojo.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author：胡灯
 * Date：2020-08-09 8:47
 * Description：<描述>
 */

@FeignClient("easygo-admin-service")
public interface AdminClient {
    @RequestMapping("/admin_login")
    public Admin adminLogin(@RequestBody Admin admin);
}
