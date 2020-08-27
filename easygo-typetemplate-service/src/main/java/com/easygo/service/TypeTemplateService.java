package com.easygo.service;

import com.easygo.pojo.TypeTemplate;

import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-25 22:18
 * Description：<描述>
 */
public interface TypeTemplateService {
    public Integer getTotalcount(Map<String,Object> map);
    public List<TypeTemplate> getTypeTemplatePage(Map<String,Object> map);
    public Integer addTypeTemplate(TypeTemplate typeTemplate);
    public TypeTemplate getTypeTemplateById(Integer id);
}
