package com.easygo.controller;

import com.easygo.pojo.Item;
import com.easygo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-16 20:46
 * Description：<描述>
 */
@RestController
@Scope("prototype")
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping("/item_getItemsByGoodsId")
    public List<Item> getItemsByGoodsId(@RequestParam Long id){
        return itemService.getItemsByGoodsId(id);
    }

    @RequestMapping("/item_getById")
    public Item getItemById(@RequestParam Long id){
        return itemService.getItemById(id);
    }

}
