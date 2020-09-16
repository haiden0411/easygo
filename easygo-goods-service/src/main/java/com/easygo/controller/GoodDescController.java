package com.easygo.controller;

import com.easygo.pojo.GoodsDesc;
import com.easygo.service.GoodsDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：胡灯
 * Date：2020-09-16 11:19
 * Description：<描述>
 */
@RestController
@Scope("prototype")
public class GoodDescController {
    @Autowired
    GoodsDescService goodsDescService;
    @RequestMapping("/goodsDesc_getDescById")
    public GoodsDesc getGoodsDescById(@RequestParam Long id) {
        return goodsDescService.getGoodsDescById(id);
    }
}
