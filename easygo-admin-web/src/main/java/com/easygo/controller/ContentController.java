package com.easygo.controller;

import com.easygo.api.ContentCategoryClient;
import com.easygo.api.ContentClient;
import com.easygo.pojo.ContentCategory;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
    ContentClient client;
    @RequestMapping("/content_page")
    public String getContentPages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false) Integer pageSize, Model model){
        PageUtils pageUtils = client.getContent_page(pageIndex, pageSize);
        model.addAttribute("pageUtils",pageUtils);
        return "content";
    }

    @RequestMapping("/content_updateStatus")
    @ResponseBody
    public MessageResults updateStatus(Integer id,Integer status){
        MessageResults results = null;

        Integer count = client.updateStatus(id, status);
        if (count>0) {
            results = new MessageResults(200,"修改成功");
        }else {
            results = new MessageResults(500,"修改失败");
        }
        return results;
    }
}
