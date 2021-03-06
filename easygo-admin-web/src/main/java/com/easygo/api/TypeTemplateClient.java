package com.easygo.api;

import com.easygo.pojo.TypeTemplate;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-25 22:57
 * Description：<描述>
 */
@FeignClient("easygo-typetemplate-service")
public interface TypeTemplateClient {
    @RequestMapping("/typeTemplate_page")
    public PageUtils<TypeTemplate> typeTemplate_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize, @RequestParam(defaultValue = "",required = false) String name);

    @RequestMapping("/typeTemplate_add")
    public Integer addTypeTemplate(@RequestBody TypeTemplate typeTemplate);

    @RequestMapping("/typeTemplate_update")
    public Integer updateTypeTemplate(@RequestBody TypeTemplate typeTemplate);

    @RequestMapping("/typeTemplate_getById")
    public TypeTemplate getTypeTemplateById(@RequestParam Integer id);

    @RequestMapping("/typeTemplate_all")
    public List<TypeTemplate> getAllTemplates();
}
