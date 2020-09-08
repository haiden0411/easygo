package com.easygo.controller;

import com.easygo.api.ContentClient;
import com.easygo.api.ItemCatClient;
import com.easygo.pojo.Content;
import com.easygo.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
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

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @RequestMapping({"/","/index"})
    public String index(Model model){
        getContens(model);
        getItemCats(model);
        return "index";
    }


    private  void getItemCats(Model model)
    {
        //加缓存
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        List<ItemCat> allItemcats = (ArrayList<ItemCat>) redisTemplate.opsForValue().get("allItemcats_key");
        if (allItemcats == null) {
            System.out.println("缓存中没有分类数据,查询数据库");
            allItemcats = itemCatClient.getItemCats();
            redisTemplate.opsForValue().set("allItemcats_key",allItemcats);
        }else {
            System.out.println("缓存中有分类数据,不需要查询数据库");
        }
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
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        List<Content> lunbo_contents = (ArrayList<Content>) redisTemplate.opsForValue().get("lunbo_contents_key");
        List<Content> shenxian_contents = (ArrayList<Content>) redisTemplate.opsForValue().get("shenxian_contents_key");
        if (lunbo_contents == null) {
            System.out.println("缓存中没有轮播图数据,查询数据库");
            lunbo_contents = contentClient.getContentsByCategoryId(1);
            redisTemplate.opsForValue().set("lunbo_contents_key",lunbo_contents);
        }else {
            System.out.println("缓存中有轮播图数据，不用管数据库了");
        }

        if (shenxian_contents == null) {
            System.out.println("缓存中没有生鲜数据,查询数据库");
            shenxian_contents = contentClient.getContentsByCategoryId(10);
            redisTemplate.opsForValue().set("shenxian_contents_key",shenxian_contents);
        }else {
            System.out.println("缓存中有生鲜数据，不用管数据库了");
        }

        model.addAttribute("lunbo_contents",lunbo_contents);
        model.addAttribute("shenxian_contents",shenxian_contents);
    }
}
