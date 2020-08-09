package com.easygo.controller;

import com.easygo.pojo.Admin;
import com.easygo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：胡灯
 * Date：2020-08-09 8:41
 * Description：<描述>
 */
@RestController
@Scope("prototype")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/admin_login")
    public Admin adminLogin(@RequestBody Admin admin){
        return adminService.adminLogin(admin);
    }

}
