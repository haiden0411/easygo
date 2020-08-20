package com.easygo.controller;

import com.easygo.api.ContentCategoryClient;
import com.easygo.api.ContentClient;
import com.easygo.pojo.Content;
import com.easygo.pojo.ContentCategory;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-12 22:39
 * Description：<描述>
 */
@Controller
@Scope("prototype")
public class ContentController {
    @Autowired
    ContentClient contentClient;

    @Autowired
    ContentCategoryClient contentCategoryClient;

    @RequestMapping("/content_page")
    public String getContentPages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false) Integer pageSize, Model model){
        PageUtils pageUtils = contentClient.getContent_page(pageIndex, pageSize);
        model.addAttribute("pageUtils",pageUtils);
        return "content";
    }

    @RequestMapping("/content_updateStatus")
    @ResponseBody
    public MessageResults updateStatus(Integer id,Integer status){
        MessageResults results = null;

        Integer count = contentClient.updateStatus(id, status);
        if (count>0) {
            results = new MessageResults(200,"更新成功");
        }else {
            results = new MessageResults(500,"更新失败");
        }
        return results;
    }

    @RequestMapping("/content_add")
    @ResponseBody
    public MessageResults addContent(Content content){
        MessageResults results = null;
        Integer count = contentClient.addContent(content);
        if (count>0) {
            results = new MessageResults(200,"新增成功");
        }else {
            results = new MessageResults(500,"新增失败");
        }
        return results;
    }

    //跳转更新页面
    @RequestMapping("/content_goUpdate")
    @ResponseBody
    public Map<String,Object> content_update(Integer id){
        Content content = contentClient.getContentById(id);
        List<ContentCategory> contentCategorys = contentCategoryClient.getContentCategorys();
        Map<String, Object> map = new HashMap<>();
        map.put("content",content);
        map.put("contentCategorys",contentCategorys);
        return map;
    }
    @RequestMapping("/content_update")
    @ResponseBody
    public MessageResults updateContent( Content content){
        String pic = content.getPic();
        String oldPic = contentClient.getContentById(content.getId()).getPic();
        if (!oldPic.equals(pic)) {
            //如果不同，则删除原来的图片
        }
        MessageResults results = null;
        Integer count = contentClient.updateContent(content);
        if (count > 0) {
            results = new MessageResults(200, "更新成功");
        } else {
            results = new MessageResults(500, "更新失败");
        }
        return results;
    }
}
