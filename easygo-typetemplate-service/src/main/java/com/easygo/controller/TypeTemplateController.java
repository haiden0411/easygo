package com.easygo.controller;

import com.easygo.pojo.CustomAttributeItemsObject;
import com.easygo.pojo.JsonObject;
import com.easygo.pojo.TypeTemplate;
import com.easygo.service.TypeTemplateService;
import com.easygo.utils.JsonUtils;
import com.easygo.utils.PageUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author：胡灯
 * Date：2020-08-25 22:50
 * Description：<描述>
 */
@RestController
public class TypeTemplateController {

    @Autowired
    TypeTemplateService typeTemplateService;
    @RequestMapping("/typeTemplate_page")
    public PageUtils<TypeTemplate> typeTemplate_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize, @RequestParam(defaultValue = "",required = false) String name){
        Map<String,Object> map = new HashMap<>();
        map.put("pageStart",(pageIndex-1)*pageSize);
        map.put("pageSize",pageSize);
        map.put("name","%"+name+"%");
        Integer totalCount = typeTemplateService.getTotalcount(map);
        List<TypeTemplate> typeTemplates = typeTemplateService.getTypeTemplatePage(map);
        //将json解析成字符串
        List<TypeTemplate> typeTemplates_str =  new ArrayList<>();
        for (TypeTemplate typeTemplate : typeTemplates) {
            TypeTemplate template = new TypeTemplate();
            List<JsonObject> brandObjects = JsonUtils.string2Obj(typeTemplate.getBrand_ids(), new TypeReference<List<JsonObject>>() {
            });
            List<JsonObject> specObjects = JsonUtils.string2Obj(typeTemplate.getSpec_ids(),new TypeReference<List<JsonObject>>() {
            });
            List<CustomAttributeItemsObject> customAttributeItemsObjects = JsonUtils.string2Obj(typeTemplate.getCustom_attribute_items(), new TypeReference<List<CustomAttributeItemsObject>>() {
            });
            String brands = brandObjects.stream().map(JsonObject::getText).collect(Collectors.joining(","));
            String specs = specObjects.stream().map(JsonObject::getText).collect(Collectors.joining(","));
            String customs = customAttributeItemsObjects.stream().map(CustomAttributeItemsObject::getText).collect(Collectors.joining(","));
            template.setBrand_ids(brands);
            template.setSpec_ids(specs);
            template.setCustom_attribute_items(customs);
            template.setId(typeTemplate.getId());
            template.setName(typeTemplate.getName());
            //加入list
            typeTemplates_str.add(template);
        }

        PageUtils<TypeTemplate> pageUtils = new PageUtils<>(pageIndex,pageSize,totalCount,typeTemplates_str);
        return pageUtils ;
    }

    @RequestMapping("/typeTemplate_add")
    public Integer addTypeTemplate(@RequestBody TypeTemplate typeTemplate){
        System.out.println("服务器:"+typeTemplate);
       return  typeTemplateService.addTypeTemplate(typeTemplate);
    }

    @RequestMapping("/typeTemplate_getById")
    public TypeTemplate getTypeTemplateById(@RequestParam Integer id){
      return   typeTemplateService.getTypeTemplateById(id);
    }
}
