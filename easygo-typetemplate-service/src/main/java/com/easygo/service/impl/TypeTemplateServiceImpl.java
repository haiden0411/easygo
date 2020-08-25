package com.easygo.service.impl;

import com.easygo.mapper.TypeTemplateMapper;
import com.easygo.pojo.TypeTemplate;
import com.easygo.service.TypeTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-25 22:20
 * Description：<描述>
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Resource
    TypeTemplateMapper typeTemplateMapper;

    @Override
    public Integer getTotalcount(Map<String, Object> map) {
        return typeTemplateMapper.getTotalcount(map);
    }

    @Override
    public List<TypeTemplate> getTypeTemplatePage(Map<String, Object> map) {
        return typeTemplateMapper.getTypeTemplatePage(map);
    }
}
