package com.easygo.controller;

import com.easygo.api.SpecificationClient;
import com.easygo.pojo.Specification;
import com.easygo.pojo.SpecificationOption;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

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
    public MessageResults specification_add(@RequestParam String spec_name,@RequestParam String[] option_name,@RequestParam Integer[] orders){

        MessageResults results = null;
        try {
            int count = specificationClient.addSpecification(spec_name,option_name,orders);
            if (count>0) {
                results = new MessageResults(200,"新增成功");
            }else {
                results = new MessageResults(500,"新增失败");
            }
        } catch (Exception e) {
            results = new MessageResults(503,"服务器异常....");
        }
        return results;
    }

    @RequestMapping("/specification_getById")
    @ResponseBody
    public Map<String,Object> getSpecificationOptionById(@RequestParam Integer id){
        Map<String, Object> map = specificationClient.getSpecificationOptionById(id);
        return map;
    }

    @RequestMapping("/specification_update")
    @ResponseBody
    public MessageResults specification_update(@RequestParam Integer id,@RequestParam String spec_name,@RequestParam String[] option_name,@RequestParam Integer[] orders){

        MessageResults results = null;
        try {
            int count = specificationClient.specification_update(id,spec_name,option_name,orders);
            if (count>0) {
                results = new MessageResults(200,"更新成功");
            }else {
                results = new MessageResults(500,"更新失败");
            }
        } catch (Exception e) {
            results = new MessageResults(503,"服务器异常....");
        }
        return results;
    }




}
