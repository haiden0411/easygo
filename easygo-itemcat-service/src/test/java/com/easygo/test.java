package com.easygo;

import com.easygo.mapper.ItemCatMapper;
import com.easygo.pojo.ItemCat;
import org.assertj.core.util.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-09-02 23:03
 * Description：<描述>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Resource
    ItemCatMapper mapper;

    @Test
    public void testselect(){
        ItemCat itemCat = mapper.getItemCatById(4);
        System.out.println(itemCat);
    }

    @Test
    public void testPage(){
        Map<String,Object> map = new HashMap<>();
        map.put("parentId",2);
        map.put("pageStart",2);
        map.put("pageSize",5);
        List<ItemCat> items = mapper.getItemCatsByPage(map);
        items.forEach(System.out::println);
    }
}
