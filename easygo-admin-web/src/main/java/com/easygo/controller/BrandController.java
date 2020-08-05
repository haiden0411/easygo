package com.easygo.controller;

import com.easygo.api.BrandClient;
import com.easygo.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-04 23:55
 * Description：<描述>
 */
@RestController
@Scope("prototype")
public class BrandController {
    @Autowired
    BrandClient brandClient;
    @RequestMapping("/brand_getBrands")
    public List<Brand> getBrands(){
        return brandClient.getBrands();
    }
}
