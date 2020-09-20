package com.easygo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author：胡灯
 * Date：2020-09-20 7:21
 * Description：<描述>
 */
@Controller
@Scope("prototype")
public class CommonController {
    @RequestMapping("/page_{page}")
    public String page(@PathVariable("page") String page){
        return page;
    }
}
