package com.easygo.controller;

import com.easygo.pojo.Specification;
import com.easygo.pojo.TypeTemplate;
import com.easygo.service.TypeTemplateService;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-25 22:50
 * Description：<描述>
 */
@RestController
public class TypeTemplateController {

    @Autowired
    TypeTemplateService typeTemplateService;
    @RequestMapping("/typetemplate_page")
    public PageUtils<TypeTemplate> typeTemplate_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize, @RequestParam(defaultValue = "",required = false) String name){
        Map<String,Object> map = new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("name","%"+name+"%");
        Integer totalCount = typeTemplateService.getTotalcount(map);
        List<TypeTemplate> specifications = typeTemplateService.getTypeTemplatePage(map);
        PageUtils<TypeTemplate> pageUtils = new PageUtils<>(pageIndex,pageSize,totalCount,specifications);
        return pageUtils ;
    }
}
