package com.easygo.controller;

import com.easygo.api.TypeTemplateClient;
import com.easygo.pojo.TypeTemplate;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author：胡灯
 * Date：2020-08-25 22:59
 * Description：<描述>
 */
@Controller
public class TypeTemplateController {
    @Autowired
    TypeTemplateClient typeTemplateClient;
    @RequestMapping("/typetemplate_page")
    public String typeTemplate_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize, @RequestParam(defaultValue = "",required = false) String name, Model model){
        PageUtils<TypeTemplate> pageUtils = typeTemplateClient.typeTemplate_pages(pageIndex, pageSize, name);
        model.addAttribute("pageUtils",pageUtils);
        model.addAttribute("name",name);
        return "type_template";
    }
}
