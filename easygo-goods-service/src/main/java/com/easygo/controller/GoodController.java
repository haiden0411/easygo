package com.easygo.controller;

import com.easygo.pojo.Goods;
import com.easygo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-12 22:28
 * Description：<描述>
 */
@RestController
public class GoodController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods_getGoods")
    public List<Goods> getAllGoods(@RequestParam Integer is_marketable) {
        return goodsService.getAllGoods(is_marketable);
    }
}
