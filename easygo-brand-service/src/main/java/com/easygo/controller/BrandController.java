package com.easygo.controller;

import com.easygo.pojo.Brand;
import com.easygo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-04 21:42
 * Description：<描述>
 */
@RestController
@Scope("prototype")
public class BrandController {
    @Autowired
    BrandService brandService;

    @RequestMapping("/brand_getBrands")
    public List<Brand> getBrands(){
        return brandService.getBrands();
    }

    @RequestMapping("/brand_add")
    public int addBrand(Brand brand){
        return brandService.addBrand(brand);
    }
    @RequestMapping("/brand_update")
    public  int updateBrand(Brand brand){
        return brandService.updateBrand(brand);
    }
    @RequestMapping("/brand_getBrandById")
    public Brand getBrandById(Integer id){
        return brandService.getBrandById(id);
    }
    @RequestMapping("/brand_deleteById")
    public int deleteBrandById(Integer id){
        return brandService.deleteBrandById(id);
    }
}
