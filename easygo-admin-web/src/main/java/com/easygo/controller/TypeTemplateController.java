package com.easygo.controller;

import com.easygo.api.BrandClient;
import com.easygo.api.SpecificationClient;
import com.easygo.api.TypeTemplateClient;
import com.easygo.pojo.*;
import com.easygo.utils.JsonUtils;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author：胡灯
 * Date：2020-08-25 22:59
 * Description：<描述>
 */
@Controller
public class TypeTemplateController {
    @Autowired
    TypeTemplateClient typeTemplateClient;

    @Autowired
    BrandClient brandClient;

    @Autowired
    SpecificationClient specificationClient;

    @RequestMapping("/typeTemplate_page")
    public String typeTemplate_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize, @RequestParam(defaultValue = "",required = false) String name, Model model){
        PageUtils<TypeTemplate> pageUtils = typeTemplateClient.typeTemplate_pages(pageIndex, pageSize, name);
        model.addAttribute("pageUtils",pageUtils);
        model.addAttribute("name",name);
        return "type_template";
    }
    /**
     *  新增界面的页面回显
     */
    @RequestMapping("/typeTemplate_getBrandsAndSpecs")
    @ResponseBody
    public Map<String,Object> getBrandsAndSpecs(){
        //查询所有品牌
        List<Brand> brands = brandClient.getBrands();
        //所有的规格
        List<Specification> specifications = specificationClient.getSpecifications();
        Map<String,Object> map = new HashMap<>();
        map.put("brands",brands);
        map.put("specifications",specifications);
        return map;
    }

    @RequestMapping("/typeTemplate_add")
    @ResponseBody
    public MessageResults addtypeTemplate(String name,Integer[] brandIds,Integer[] specIds,String[] customAttrs){
        //转成json存入数据库
        TypeTemplate typeTemplate = new TypeTemplate();

        //brand转Json
        List<JsonObject> brands = Stream.of(brandIds).map(brandClient::getBrandById).map(brand -> new JsonObject(brand.getId(), brand.getName())).collect(Collectors.toList());

        List<JsonObject> specs = Stream.of(specIds).map(specificationClient::getSpecById).map(spec -> new JsonObject(spec.getId(), spec.getSpec_name())).collect(Collectors.toList());

        List<CustomAttributeItemsObject> cutoms = Stream.of(customAttrs).map(s -> new CustomAttributeItemsObject(s)).collect(Collectors.toList());


        String brans_str = JsonUtils.obj2String(brands);
        String spec_str = JsonUtils.obj2String(specs);
        String customs_str = JsonUtils.obj2String(cutoms);

        typeTemplate.setCustom_attribute_items(customs_str);
        typeTemplate.setName(name);
        typeTemplate.setSpec_ids(spec_str);
        typeTemplate.setBrand_ids(brans_str);

        System.out.println("typeTemplate:"+typeTemplate);

        Integer count = typeTemplateClient.addTypeTemplate(typeTemplate);

        MessageResults results = null;
        if (count>0) {
            results = new MessageResults(200,"新增成功");
        }else{
            results = new MessageResults(500,"新增失败");
        }
        return results;
    }
    //更新时的数据回显
    @RequestMapping("/typeTemplate_goUpdate")
    @ResponseBody
    public TypeTemplate goUpdataTypeTemplate(Integer id) {
        TypeTemplate typeTemplate = typeTemplateClient.getTypeTemplateById(id);

        //数据库查询所有品牌
        List<Brand> brands = brandClient.getBrands();
        //所有的规格
        List<Specification> specifications = specificationClient.getSpecifications();

        //brand转Json
        List<JsonObject> brands_template = JsonUtils.string2Obj(typeTemplate.getBrand_ids(), new TypeReference<List<JsonObject>>() {
        });
        List<JsonObject> specs_template = JsonUtils.string2Obj(typeTemplate.getSpec_ids(), new TypeReference<List<JsonObject>>() {
        });

        //比较两个集合，找出相同的Id,设置flag为true;
        for (Brand brand : brands) {
            for (JsonObject jsonObject : brands_template) {
                if (brand.getId().equals(jsonObject.getId())) {
                    brand.setFlag(true);
                }
            }
        }

        for (Specification specification : specifications) {
            for (JsonObject jsonObject : specs_template) {
                if (specification.getId().equals(jsonObject.getId())) {
                    specification.setFlag(true);
                }
            }
        }
        //把集合再转成json
        String brand_str = JsonUtils.obj2String(brands);
        String specs_str = JsonUtils.obj2String(specifications);

        typeTemplate.setBrand_ids(brand_str);
        typeTemplate.setSpec_ids(specs_str);

        return typeTemplate;

    }
}
