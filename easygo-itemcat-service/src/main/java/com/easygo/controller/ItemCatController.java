package com.easygo.controller;

import com.easygo.pojo.ItemCat;
import com.easygo.pojo.Specification;
import com.easygo.service.ItemCatService;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-09-03 21:37
 * Description：<描述>
 */
@RestController
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/itemcat_page")
    public PageUtils<ItemCat> itemcat_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize, @RequestParam(defaultValue ="0",required = false) Integer parentId){
        Map<String,Object> map = new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("parentId",parentId);
        int totalCount = itemCatService.getTotalCount(map);
        List<ItemCat> itemcats = itemCatService.getItemCatsByPage(map);
        PageUtils<ItemCat> pageUtils = new PageUtils<>(pageIndex,pageSize,totalCount,itemcats);
        return pageUtils;
    }
    @RequestMapping("/itemcat_getById")
    public ItemCat getItemCatById(@RequestParam Integer id) {
        return itemCatService.getItemCatById(id);
    }

    @RequestMapping("/itemcat_add")
    public Integer itemcat_add(@RequestBody ItemCat itemCat){
        return itemCatService.addItemCat(itemCat);
    }

    @RequestMapping("/itemcat_update")
    public Integer itemcat_update(@RequestBody ItemCat itemCat){
        return itemCatService.updateItemCat(itemCat);
    }

    @RequestMapping("/itemcat_all")
    public List<ItemCat> getItemCats(){
        return itemCatService.getItemCats();
    }

}
