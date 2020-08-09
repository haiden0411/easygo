package com.easygo.controller;

import com.easygo.api.AdminClient;
import com.easygo.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：胡灯
 * Date：2020-08-09 8:50
 * Description：<描述>
 */
@RestController
public class AdminController {
    @Autowired
    AdminClient adminClient;
    @RequestMapping("/admin_login")
    public Admin adminLogin(Admin admin){
        return adminClient.adminLogin(admin);
    }
}
