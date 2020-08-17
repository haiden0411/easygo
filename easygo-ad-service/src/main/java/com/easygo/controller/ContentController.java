package com.easygo.controller;

import com.easygo.pojo.Content;
import com.easygo.pojo.ContentCategory;
import com.easygo.service.ContentService;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-16 21:03
 * Description：<描述>
 */
@RestController
@Scope("prototype")
public class ContentController {
    @Autowired
    ContentService contentService;

    //分页
    @RequestMapping("/content_page")
    public PageUtils<Content> getContent_page(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false) Integer pageSize){
        Map<String, Object> params = new HashMap<>();
        params.put("pageStart",(pageIndex-1)*pageSize);
        params.put("pageSize",pageSize);
        System.out.println("参数："+params);
        Integer totalCount = contentService.getTotalCount();
        List<Content> categoryPages = contentService.getContents(params);
        //封闭一个通用的分页工具类
        PageUtils pageUtils = new PageUtils(pageIndex,pageSize,totalCount,categoryPages);
        return pageUtils;
    }

    //获取某个Id下面的所有广告
    @RequestMapping("/content_getContentsByCategoryId")
    public List<Content> getContentsByCategoryId(@RequestParam Integer categoryId){
        return contentService.getContentsByCategoryId(categoryId);
    }

    @RequestMapping("/content_updateStatus")
    public Integer updateStatus(@RequestParam Integer id,@RequestParam Integer status){
        Map<String,Object> maps = new HashMap<>();
        maps.put("id",id);
        maps.put("status",status);
        return contentService.updateStatus(maps);
    }



}
