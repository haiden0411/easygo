package com.easygo.controller;

import com.easygo.pojo.Specification;
import com.easygo.service.SpecificationService;
import com.easygo.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
