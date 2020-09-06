package com.easygo.controller;

import com.easygo.api.ItemCatClient;
import com.easygo.pojo.ItemCat;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Author：胡灯
 * Date：2020-09-03 21:48
 * Description：<描述>
 */
@Controller
public class ItemCatController {
    @Autowired
    ItemCatClient itemCatClient;

    @RequestMapping("/itemcat_page")
    public String itemcat_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize, @RequestParam(defaultValue ="0",required = false) Integer parentId, Model model){

        //是否是三级分灰，用来确认是否到底
        boolean flag = false;
        PageUtils<ItemCat> pageUtils = itemCatClient.itemcat_pages(pageIndex, pageSize, parentId);
        StringBuffer sb = new StringBuffer();
        sb.append("<li><a href=\"javascript:queryChilds("+0+");\" >顶级分类列表</a></li>");
        String item_two = "";
        String item_third = "";
        if (parentId!=0) {
            //二级分类
            ItemCat itemcat_two = itemCatClient.getItemCatById(parentId);

            if (itemcat_two != null) {
                item_two = "<li><a href=\"javascript:queryChilds("+itemcat_two.getId()+");\" >"+itemcat_two.getName()+"</a></li>";
                ItemCat itemcat_three = itemCatClient.getItemCatById(itemcat_two.getParentId());
                if (itemcat_three != null) {
                    item_third = "<li><a href=\"javascript:queryChilds("+itemcat_three.getId()+");\" >"+itemcat_three.getName()+"</a></li>";
                    flag = true;
                }
            }
        }
        sb.append(item_third).append(item_two);
        model.addAttribute("pageUtils",pageUtils);
        model.addAttribute("parentId",parentId);
        model.addAttribute("str",sb.toString());
        model.addAttribute("flag",flag);
        return "item_cat";
    }

    @RequestMapping("/itemcat_add")
    @ResponseBody
    public MessageResults itemcat_add(ItemCat itemCat){
        int count = itemCatClient.itemcat_add(itemCat);
        MessageResults results = null;
        if (count>0) {
            results = new MessageResults(200,"新增成功");
        }else {
            results = new MessageResults(500,"新增失败");
        }
        return results;
    }

    @RequestMapping("/itemcat_update")
    @ResponseBody
    public MessageResults itemcat_update(ItemCat itemCat){
        int count = itemCatClient.itemcat_update(itemCat);
        MessageResults results = null;
        if (count>0) {
            results = new MessageResults(200,"更新成功");
        }else {
            results = new MessageResults(500,"更新失败");
        }
        return results;
    }

    @RequestMapping("/itemcat_goUpdate")
    @ResponseBody
    public ItemCat itemCat_goUpdate(@RequestParam Integer id){
        return  itemCatClient.getItemCatById(id);
    }

}
