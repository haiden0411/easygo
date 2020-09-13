package com.easygo;

import com.easygo.api.GoodsClient;
import com.easygo.pojo.Goods;
import com.easygo.serivce.GoodsService;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

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

    @Autowired
    GoodsClient goodsClient;

    @Autowired
    GoodsService goodsService;

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

    @Test
    public void testAddDocuments(){
        List<Goods> allGoods = goodsClient.getAllGoods(1);
        allGoods.forEach(System.out::println);
        goodsService.saveDocuments(allGoods);
        System.out.println("批量导入成功");
    }

    @Test
    public void testDeleAllDocument(){
        goodsService.deleteAllDocument();
        System.out.println("删除成功");
    }

    @Test
    public void testGetDocumentById(){
        Goods goods = goodsService.getDocuemntById(149187842867926L);
        System.out.println(goods);
    }

    @Test
    public void testUpdateDocumentById(){
        Goods goods = goodsService.getDocuemntById(149187842867986L);
        goods.setGoods_name("华为手机bbbb");
        goods.setPrice(250.00);
        goodsService.updateDocumentById(goods);
        System.out.println("更新成功");
    }

    @Test
    public void testDeleteDocumentById(){
        goodsService.deleteDocumentById(149187842867914L);
        System.out.println("删除成功");
    }

    @Test
    public void testQuery1(){
        int pageIndex =2;
        int pageSize = 4;
        String keyWord = "手机";
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.queryStringQuery(keyWord).defaultField("goods_name")).withPageable(PageRequest.of(pageIndex - 1, pageSize)).build();

        AggregatedPage<Goods> page = elasticsearchTemplate.queryForPage(searchQuery, Goods.class);

        System.out.println("当前页码："+pageIndex);
        System.out.println("页面大小："+pageSize);
        System.out.println("总页面："+page.getTotalPages());
        System.out.println("总条法:"+page.getTotalElements());
        System.out.println("当前页面的数据为：");
        List<Goods> contents = page.getContent();
        contents.forEach(System.out::println);
    }

    @Test
    public void testQeury2(){
        int pageIndex = 1;
        int pageSize = 3;
        String keyWords = "火爆";
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        if (StringUtils.isNotEmpty(keyWords)) {
            builder.withQuery(QueryBuilders.multiMatchQuery(keyWords,"goods_name","caption"));
        }
        builder.withPageable(PageRequest.of(pageIndex-1,pageSize));
        NativeSearchQuery searchQuery = builder.build();
        AggregatedPage<Goods> page = elasticsearchTemplate.queryForPage(searchQuery, Goods.class);
        System.out.println("当前页码："+pageIndex);
        System.out.println("页面大小："+pageSize);
        System.out.println("总页面："+page.getTotalPages());
        System.out.println("总条法:"+page.getTotalElements());
        System.out.println("当前页面的数据为：");
        List<Goods> contents = page.getContent();
        contents.forEach(System.out::println);

    }


}
