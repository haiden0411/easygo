package com.easygo.controller;

import com.easygo.pojo.Brand;
import com.easygo.pojo.ContentCategory;
import com.easygo.service.ContentCategoryService;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-12 22:17
 * Description：<描述>
 */
@RestController
@Scope("prototype")
public class ContentCategoryController {
    @Autowired
    ContentCategoryService categoryService;

    @RequestMapping("/contentCategory_delete")
    public int deleteContentCategory(@RequestParam Integer id){
        return categoryService.delContentCategory(id);
    }

    @RequestMapping("/contentCategory_update")
    public int updateContentCategory(@RequestBody ContentCategory contentCategory){
        return categoryService.updateContentCategory(contentCategory);
    }

    @RequestMapping("/contentCategory_getById")
    public ContentCategory getById(@RequestParam Integer id){
        return  categoryService.getById(id);
    }

    @RequestMapping("/contentCategory_add")
    public int addContentCategory(@RequestBody ContentCategory contentCategory){
        return categoryService.addContentCategory(contentCategory);
    }


    @RequestMapping("/contentCategory_page")
    public PageUtils getContentCategorys(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false) Integer pageSize,@RequestParam(defaultValue = "",required = false) String name){
        Map<String, Object> params = new HashMap<>();
        params.put("name","%"+name+"%");
        params.put("pageStart",(pageIndex-1)*pageSize);
        params.put("pageSize",pageSize);
        System.out.println("参数："+params);
        Integer totalCount = categoryService.getTotalCount(params);
        List<ContentCategory> categoryPages = categoryService.getContentCategoryPages(params);
        //封闭一个通用的分页工具类
        PageUtils pageUtils = new PageUtils(pageIndex,pageSize,totalCount,categoryPages);
        return pageUtils;
    }

    //查询有效的广告分类
    @RequestMapping("/contentCategory_list")
    public List<ContentCategory> getContentCategorys(){
        return categoryService.getContentCategorys();
    }




}
