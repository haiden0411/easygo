package com.easygo.controller;

import com.easygo.api.BrandClient;
import com.easygo.pojo.Brand;
import com.easygo.utils.MessageResults;
import jdk.nashorn.internal.ir.BreakableNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/brand_update")
    @ResponseBody
    public  MessageResults updateBrand(Brand brand){
        int count = brandClient.updateBrand(brand);
        MessageResults results = null;
        if (count>0) {
            results = new MessageResults(200,"更新成功");
        }else {
            results = new MessageResults(500,"更新失败");
        }
        return results;
    };

    @RequestMapping("/brand_deleteById")
    @ResponseBody
    public MessageResults deleteBrandById(Integer id){
        int count = brandClient.deleteBrandById(id);
        MessageResults results = null;
        if (count>0) {
            results = new MessageResults(200,"删除成功");
        }else {
            results = new MessageResults(500,"删除失败");
        }
        return results;
    };

    @RequestMapping("/brand_deleteSome")
    @ResponseBody
    public MessageResults deleteBrandSome(String ids){
        int count = brandClient.deleteSome(ids);
        MessageResults results = null;
        if (count>0) {
            results = new MessageResults(200,"批量删除成功");
        }else {
            results = new MessageResults(500,"批量删除失败");
        }
        return results;
    };


}
