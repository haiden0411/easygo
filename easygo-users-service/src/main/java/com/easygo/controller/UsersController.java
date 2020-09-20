package com.easygo.controller;

import com.easygo.pojo.Users;
import com.easygo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：胡灯
 * Date：2020-09-19 23:16
 * Description：<描述>
 */
@RestController
@Scope("prototype")
public class UsersController {
    @Autowired
    UsersService usersService;

    @RequestMapping("/users_add")
    public Integer addUsers(@RequestBody Users users){
        return usersService.addUsers(users);
    }
}
