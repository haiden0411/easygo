package com.easygo.controller;

import com.easygo.api.ContentClient;
import com.easygo.pojo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-16 23:30
 * Description：<描述>
 */
@Controller
@Scope("prototype")
public class IndexController {

    @Autowired
    ContentClient contentClient;

    @RequestMapping({"/","/index"})
    public String index(Model model){
        getContens(model);
        return "index";
    }

    private void getContens(Model model){
        List<Content> lunbo_contents = contentClient.getContentsByCategoryId(1);
        model.addAttribute("lunbo_contents",lunbo_contents);
        List<Content> shenxian_contents = contentClient.getContentsByCategoryId(10);
        model.addAttribute("shenxian_contents",shenxian_contents);
    }
}
