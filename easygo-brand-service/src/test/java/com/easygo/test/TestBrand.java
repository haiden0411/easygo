package com.easygo.test;

import com.easygo.BrandServiceApp;
import com.easygo.mapper.BrandMapper;
import com.easygo.pojo.Brand;
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
 * Date：2020-08-03 23:29
 * Description：<描述>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBrand {
    @Resource
    BrandMapper mapper;
    @Test
    public void testBrands(){
        System.out.println(mapper.getBrands());
    }

    @Test
    public void testGetbyId(){
        Brand brand = mapper.getBrandById(1);
        System.out.println(brand);
    }
    @Test
    public void testAdd(){
        Brand brand = new Brand();
        brand.setName("品牌测试");
        brand.setFirst_char("C");
        brand.setImage("12121212.jpg");
        int count = mapper.addBrand(brand);
        System.out.println(count > 0 ? "新增成功" : "新增失败");
    }

    @Test
    public void testUpdata(){
        Brand brand = mapper.getBrandById(1);
        brand.setName("联想");
        int count = mapper.updateBrand(brand);
        System.out.println(count > 0 ? "更新成功" : "更新失败");
    }
    @Test
    public void testDel(){
        int count = mapper.deleteBrandById(45);
        System.out.println(count > 0 ? "删除成功" : "删除失败");
    }

    @Test
    public void testCount(){
        int totalCount = mapper.getTotalCount();
        System.out.println("total:"+totalCount);
    }

    @Test
    public void testPage(){
        int pageIndex = 1;
        int pageSize = 5;
        Map<String,Object> param = new HashMap<>();
        param.put("pageStart",(pageIndex-1)*pageSize);
        param.put("pageSize",pageSize);
        List<Brand> pageBrands = mapper.getPageBrands(param);
        pageBrands.forEach(System.out::println);
    }


}
