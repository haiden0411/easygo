package com.easygo.controller;

import com.easygo.api.SpecificationClient;
import com.easygo.pojo.Specification;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
