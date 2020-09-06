package com.easygo.controller;

import com.easygo.api.ContentClient;
import com.easygo.api.ItemCatClient;
import com.easygo.pojo.Content;
import com.easygo.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-16 23:30
 * Description：<描述>
 */
@Controller
@Scope("prototype")
public class IndexController {

    @Autowired
    ContentClient contentClient;

    @Autowired
    ItemCatClient itemCatClient;

    @RequestMapping({"/","/index"})
    public String index(Model model){
        getContens(model);
        getItemCats(model);
        return "index";
    }


    private  void getItemCats(Model model)
    {
        List<ItemCat> allItemcats = itemCatClient.getItemCats();
        List<ItemCat> itemcats_first = extractItemCats("1", allItemcats);
        List<ItemCat> itemcats_second = extractItemCats("2", allItemcats,itemcats_first);
        List<ItemCat> itemcats_third = extractItemCats("3", allItemcats,itemcats_second);
        model.addAttribute("itemcats_first",itemcats_first);
        model.addAttribute("itemcats_second",itemcats_second);
        model.addAttribute("itemcats_third",itemcats_third);
    }

    private List<ItemCat> extractItemCats(String type,List<ItemCat>... souceList){
        List<ItemCat> emptyList = new ArrayList<>();
        List<ItemCat> allList = souceList[0];
        if ("1".equals(type)){
            allList.stream().filter(itemCat -> itemCat.getParentId().toString().equals("0")).limit(10).forEach(emptyList::add);
        }

        if ("2".equals(type)){
            List<ItemCat> itemCats_one = souceList[1];
            for (ItemCat itemCat : itemCats_one) {
                for (ItemCat cat : allList) {
                    if (cat.getParentId().toString().equals(itemCat.getId().toString())) {
                        emptyList.add(cat);
                    }
                }
            }

        }

        if ("3".equals(type)){
            List<ItemCat> itemCats_two = souceList[1];
            for (ItemCat itemCat : itemCats_two) {
                for (ItemCat cat : allList) {
                    if (cat.getParentId().toString().equals(itemCat.getId().toString())) {
                        emptyList.add(cat);
                    }
                }
            }

        }

        return emptyList;
    }

    private void getContens(Model model){
        List<Content> lunbo_contents = contentClient.getContentsByCategoryId(1);
        model.addAttribute("lunbo_contents",lunbo_contents);
        List<Content> shenxian_contents = contentClient.getContentsByCategoryId(10);
        model.addAttribute("shenxian_contents",shenxian_contents);
    }
}
