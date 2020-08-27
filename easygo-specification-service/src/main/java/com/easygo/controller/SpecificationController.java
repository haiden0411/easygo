package com.easygo.controller;

import com.easygo.pojo.Specification;
import com.easygo.pojo.SpecificationOption;
import com.easygo.service.SpecificationOptionService;
import com.easygo.service.SpecificationService;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-22 0:20
 * Description：<描述>
 */
@RestController
@Scope("prototype")
public class SpecificationController {
    @Autowired
    SpecificationService specificationService;

    @Autowired
    SpecificationOptionService specificationOptionService;

    @RequestMapping("/specification_page")
    public PageUtils<Specification> specification_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize, @RequestParam(defaultValue = "",required = false) String spec_name){
        Map<String,Object> map = new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("spec_name","%"+spec_name+"%");
        Integer totalCount = specificationService.totalCount(map);
        List<Specification> specifications = specificationService.getSpecificationPage(map);
        PageUtils<Specification> pageUtils = new PageUtils<>(pageIndex,pageSize,totalCount,specifications);
        return pageUtils ;
    }

    @RequestMapping("/specification_add")
    public Integer addSpecification(@RequestParam String spec_name, @RequestParam String[] option_name, @RequestParam Integer[] orders){
        return specificationService.addSpecificationTransaction(spec_name,option_name,orders);
    }

    //根据Specification id查询 pecificationOption
    @RequestMapping("/specification_getById")
    public Map<String,Object> getSpecificationOptionById(@RequestParam Integer id){
        System.out.println("id:"+id);
        Specification specification = specificationService.getSpecificationById(id);
        List<SpecificationOption> specificationOptions = specificationOptionService.getSpecificationOptionById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("specification",specification);
        map.put("specificationOptions",specificationOptions);
        return map;
    }

    @RequestMapping("/specification_update")
    public Integer specification_update(@RequestParam Integer id,@RequestParam String spec_name,@RequestParam String[] option_name,@RequestParam Integer[] orders){

        Integer count = specificationService.updateSpecificationTransaction(id, spec_name, option_name, orders);
        return count;
    }

    @RequestMapping("/specification_getSpecs")
    public List<Specification> getSpecifications(){
        return specificationService.getSpecifications();
    }

    @RequestMapping("/specification_getSpecById")
    public Specification getSpecById(@RequestParam Integer id){
        return  specificationService.getSpecificationById(id);
    }

}
