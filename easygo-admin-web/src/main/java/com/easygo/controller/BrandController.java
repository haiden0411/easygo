package com.easygo.controller;

import com.easygo.api.BrandClient;
import com.easygo.pojo.Brand;
import com.easygo.utils.MessageResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-04 23:55
 * Description：<描述>
 */
@Controller
@Scope("prototype")
public class BrandController {
    @Autowired
    BrandClient brandClient;
    @RequestMapping("/brand_getBrands")
    public String getBrands(Model model){
        List<Brand> brands = brandClient.getBrands();
        model.addAttribute("brands",brands);
        return "brand";
    }

    @RequestMapping("/brand_add")
    @ResponseBody
    public MessageResults addBrand(Brand brand){
        MessageResults results = null;
        System.out.println("brand:"+brand);
        int count  = 0;
        try {
            count = brandClient.addBrand(brand);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if (count>0) {
            results = new MessageResults(200,"新增成功");
        }else {
            results = new MessageResults(500,"新增失败");
        }
        return results;
    }

    @RequestMapping("/brand_getBrandById")
    @ResponseBody
    public Brand getBrandById(Integer id){
        return  brandClient.getBrandById(id);
    }

}
