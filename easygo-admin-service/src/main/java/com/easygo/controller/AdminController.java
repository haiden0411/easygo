package com.easygo.controller;

import com.easygo.pojo.Admin;
import com.easygo.pojo.LoginLog;
import com.easygo.service.AdminService;
import com.easygo.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    LoginLogService logService;

    @RequestMapping("/admin_login")
    public Admin adminLogin(@RequestBody Admin admin){
        return adminService.adminLogin(admin);
    }

    /**
     * 新增日志
     * @param log
     * @return
     */
    @RequestMapping("/loginLog_add")
    public int addLoginLog(@RequestBody LoginLog log){
        return logService.addLoginLog(log);
    }

    @RequestMapping("/loginLog_logs")
    public List<LoginLog> getMyLoginLog(@RequestParam String username){
        return logService.getMyLoginLog(username);
    }

}
