package com.easygo.test;

import com.easygo.mapper.ContentCategoryMapper;
import com.easygo.mapper.ContentMapper;
import com.easygo.pojo.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-12 21:08
 * Description：<描述>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestContent {
    @Resource
    ContentCategoryMapper mapper;

    @Resource
    ContentMapper contentMapper;

    @Test
    public void testdel(){
        int count = mapper.delContentCategory(1);
        System.out.println(count>0?"删除成功":"删除失败");
    }

    @Test
    public void testGettotalcount(){
        String key = "";
        Map<String,Object> map = new HashMap<>();
        map.put("name","%"+key+"%");
        Integer totalCount = mapper.getTotalCount(map);
        System.out.println(totalCount);
    }

    @Test
    public void testgetContentByid(){
        List<Content> contents = contentMapper.getContentsByCategoryId(1);
        contents.forEach(System.out::println);

    }
}
