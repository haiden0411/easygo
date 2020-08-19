package com.easygo.controller;

import com.easygo.api.ContentCategoryClient;
import com.easygo.pojo.ContentCategory;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-12 22:39
 * Description：<描述>
 */
@Controller
@Scope("prototype")
public class ContentCategoryController {
    @Autowired
    ContentCategoryClient client;

    @RequestMapping("/contentCategory_page")
    public String getContentCategorys(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false) Integer pageSize,@RequestParam(defaultValue = "",required = false) String name, Model model){
        PageUtils pageUtils = client.getContentCategorys(pageIndex, pageSize, name);
        System.out.println("name="+name);
        System.out.println("pageIndex="+pageIndex);
        System.out.println("pageSize="+pageSize);
        model.addAttribute("pageUtils",pageUtils);
        model.addAttribute("name",name);
        return "content_category";
    }

    @RequestMapping("/contentCategory_delete")
    public int deleteContentCategory(Integer id){
        System.out.println("要删除的id:"+id);
        return client.deleteContentCategory(id);
    }

    @RequestMapping("/contentCategory_update")
    @ResponseBody
    public MessageResults updateContentCategory(ContentCategory contentCategory){
        int count =  client.updateContentCategory(contentCategory);
        System.out.println("content:"+contentCategory);
        MessageResults results = null;
        if (count>0) {
            results = new MessageResults(200,"更新成功");
        }else {
            results = new MessageResults(500,"更新失败");
        }
        return results;
    }

    @RequestMapping("/contentCategory_getById")
    @ResponseBody
    public ContentCategory getById(Integer id){
        System.out.println("查询的id:"+id);
        return  client.getById(id);
    }

    @RequestMapping("/contentCategory_add")
    @ResponseBody
    public MessageResults addContentCategory(ContentCategory contentCategory){
        System.out.println("contentCategory:"+contentCategory);
        int count =  client.addContentCategory(contentCategory);
        MessageResults results = null;
        if (count>0) {
            results = new MessageResults(200,"新增成功");
        }else {
            results = new MessageResults(500,"新增失败");
        }
        return results;
    }

    @RequestMapping("/contentCategory_list")
    @ResponseBody
    public List<ContentCategory> getContentCategorys(){
        List<ContentCategory> contentCategorys = client.getContentCategorys();
        return contentCategorys;
    }
}
