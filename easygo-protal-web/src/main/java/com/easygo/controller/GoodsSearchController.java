package com.easygo.controller;

import com.easygo.api.GoodsSearchClient;
import com.easygo.pojo.Goods;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author：胡灯
 * Date：2020-09-13 16:36
 * Description：<描述>
 */
@Controller
@Scope("prototype")
public class GoodsSearchController {
    @Autowired
    GoodsSearchClient goodsSearchClient;
    @RequestMapping("/goods_search")
    public String goods_search(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                               @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                               @RequestParam(value = "keywords",defaultValue = "") String keywords, Model model){

        PageUtils<Goods> pageUtils = goodsSearchClient.goods_search(pageIndex, pageSize, keywords);
        model.addAttribute("pageUtils",pageUtils);
        model.addAttribute("keywords",keywords);
        return "CategoryList";
    }
}

