package com.easygo.mapper;

import com.easygo.pojo.TypeTemplate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-25 22:10
 * Description：<描述>
 */
@Mapper
public interface TypeTemplateMapper {
    public Integer getTotalcount(Map<String,Object> map);
    public List<TypeTemplate> getTypeTemplatePage(Map<String,Object> map);
    public Integer addTypeTemplate(TypeTemplate typeTemplate);
    public TypeTemplate getTypeTemplateById(Integer id);
}
