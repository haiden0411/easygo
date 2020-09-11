package com.easygo;

import com.easygo.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author：胡灯
 * Date：2020-09-11 23:56
 * Description：<描述>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEs {

    @Resource
    ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testConn(){
        System.out.println(elasticsearchTemplate);
    }

    @Test
    public void testCreateIndex(){
        elasticsearchTemplate.createIndex(Goods.class);
        System.out.println("创建索引库成功");
        elasticsearchTemplate.putMapping(Goods.class);
        System.out.println("创建goods的mapping成功");
    }

}
