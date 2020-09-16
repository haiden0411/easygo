package com.easygo.test;

import com.easygo.api.*;
import com.easygo.pojo.*;
import com.easygo.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-09-16 10:31
 * Description：<描述>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCreatehtml {

    @Autowired
    GoodsClient goodsClient;

    @Autowired
    BrandClient brandClient;

    @Autowired
    GoodsDescClient goodsDescClient;

    @Autowired
    ItemCatClient itemCatClient;

    @Autowired
    ItemClient itemClient;


    @Test
    public void testcreateProduct() throws IOException {
        //Goods goods = goodsClient.getAllGoods(149187842868052L);
        Goods goods = goodsClient.getAllGoods(149187842868045L);
        System.out.println("goods:"+goods);
        //品牌id
        Brand brand = brandClient.getBrandById(goods.getBrand_id());
        System.out.println("brand："+brand);
        //商品详情
        GoodsDesc goodsDesc = goodsDescClient.getGoodsDescById(goods.getId());
        System.out.println("goodsDesc:"+goodsDesc);
        //商品小图集合
        String item_images = goodsDesc.getItem_images();
        List<OrderUrl> orderUrls = JsonUtils.string2Obj(item_images, new TypeReference<List<OrderUrl>>() {
        });
        System.out.println("orderUrls:"+orderUrls);
        //商品规格集合
        String custom_attribute_items = goodsDesc.getSpecification_items();
        List<AttributeObject> attributeObjects = JsonUtils.string2Obj(custom_attribute_items, new TypeReference<List<AttributeObject>>() {
        });
        System.out.println("attributeObjects："+attributeObjects);
        //分类路径
        Integer category1_id = goods.getCategory1_id();
        String name1 = itemCatClient.getItemCatById(category1_id).getName();//一级分类
        Integer category2_id = goods.getCategory2_id();
        String name2 = itemCatClient.getItemCatById(category2_id).getName();//二级分类
        Integer category3_id = goods.getCategory3_id();
        String name3 = itemCatClient.getItemCatById(category3_id).getName();//三级分类

        //sku集合，一个商品下面有多个sku
        List<Item> skus = itemClient.getItemsByGoodsId(goods.getId());
        List<SkuBean> skuList = new ArrayList<>();
        for (Item item : skus) {
            Long sku_id = item.getId();
            String title = item.getTitle();
            Double price = item.getPrice();
            String spec = item.getSpec();
            Map<String, Object> map = JsonUtils.string2Obj(spec, new TypeReference<Map<String, Object>>() {
            });
            SkuBean skuBean = new SkuBean(sku_id, title, price, map);
            skuList.add(skuBean);
        }
        String sku_jsons = JsonUtils.obj2String(skuList);
        System.out.println("sku_json:"+sku_jsons);


        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        FileWriter fileWriter = new FileWriter("d:/test/aa/"+goods.getId()+".html");
        Context context = new Context();
        //放入测试数据
        context.setVariable("goods",goods);
        context.setVariable("brand",brand);
        context.setVariable("goodsDesc",goodsDesc);
        context.setVariable("orderUrls",orderUrls);//商品小图片集合
        context.setVariable("attributeObjects",attributeObjects);//商品规格集合
        context.setVariable("name1",name1);//商品规格集合
        context.setVariable("name2",name2);//商品规格集合
        context.setVariable("name3",name3);//商品规格集合
        context.setVariable("sku_jsons",sku_jsons);//sku集合


        templateEngine.process("Product",context,fileWriter);
    }
}
