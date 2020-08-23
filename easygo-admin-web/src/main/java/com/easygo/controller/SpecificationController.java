package com.easygo.controller;

import com.easygo.api.SpecificationClient;
import com.easygo.pojo.Specification;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * Author：胡灯
 * Date：2020-08-22 21:45
 * Description：<描述>
 */
@Controller
@Scope("prototype")
public class SpecificationController {
    @Autowired
    SpecificationClient specificationClient;

    @RequestMapping("/specification_page")
    public String specification_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize, @RequestParam(defaultValue = "",required = false) String spec_name, Model model){
        PageUtils<Specification> pageUtils = specificationClient.specification_pages(pageIndex, pageSize, spec_name);
        model.addAttribute("pageUtils",pageUtils);
        model.addAttribute("spec_name",spec_name);
        return "specification";
    }

    @RequestMapping("/specification_add")
    @ResponseBody
    public MessageResults specification_add(@RequestParam String spec_name,@RequestParam String[] option_name,@RequestParam String[] orders){
        System.out.println("spec_name:"+spec_name);
        System.out.println("option_name:"+ Arrays.toString(option_name));
        System.out.println("orders:"+ Arrays.toString(orders));
        MessageResults results = new MessageResults(200,"新增成功");
        return results;

    }
}
