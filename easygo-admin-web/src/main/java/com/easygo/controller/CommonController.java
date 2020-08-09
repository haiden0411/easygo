package com.easygo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author：胡灯
 * Date：2020-08-09 8:52
 * Description：<描述>
 */
@Controller
public class CommonController {
    @RequestMapping({"/","/admin"})
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/page_{page}")
    public String page(@PathVariable String page){
        return page;
    }
}
