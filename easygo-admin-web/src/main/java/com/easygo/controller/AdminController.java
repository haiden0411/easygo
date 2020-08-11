package com.easygo.controller;

import com.easygo.api.AdminClient;
import com.easygo.api.LoginLogClient;
import com.easygo.pojo.Admin;
import com.easygo.pojo.LoginLog;
import com.easygo.utils.MessageResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-09 8:50
 * Description：<描述>
 */
@Controller
public class AdminController {
    @Autowired
    AdminClient adminClient;

    @Autowired
    LoginLogClient logClient;

    @RequestMapping("/admin_login")
    @ResponseBody
    public MessageResults adminLogin(Admin admin,String ip,String city, HttpSession session){
        Admin adminLogin = adminClient.adminLogin(admin);
        System.out.println("当前用户登录用户:"+adminLogin);
        if (adminLogin!=null) {
            if ("1".equals(adminLogin.getStatus())) {
                System.out.println("登录成功");
                session.setAttribute("adminLogin",adminLogin);
                //插入日志
                LoginLog loginLog = new LoginLog(ip, adminLogin.getUsername(), city);
                logClient.addLoginLog(loginLog);
                System.out.println("当前用户："+adminLogin);
                System.out.println("ip:"+ip+" city:"+city);
                return  new MessageResults(200,"登录成功");
            }else{
                System.out.println("登录失败");
                return  new MessageResults(403,"该用户已被禁用,请联系管理员!");
            }

        }else{
            System.out.println("登录失败");
            return new MessageResults(500,"登录失败");
        }
    }

    @RequestMapping("/admin_logout")
    public String admin_logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @ResponseBody
    @RequestMapping("/admin_getLoginLogs")
    public List<LoginLog> getLoginLogs(HttpSession session){
        Admin admin = (Admin) session.getAttribute("adminLogin");
        List<LoginLog> myLoginLogs = logClient.getMyLoginLog(admin.getUsername());
        return myLoginLogs;
    }

}
