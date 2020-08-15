package com.easygo.service.impl;

import com.easygo.mapper.ContentCategoryMapper;
import com.easygo.pojo.ContentCategory;
import com.easygo.service.ContentCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-12 21:00
 * Description：<描述>
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Resource
    ContentCategoryMapper mapper;

    @Override
    public Integer getTotalCount(Map<String, Object> map) {
        return mapper.getTotalCount(map);
    }

    @Override
    public List<ContentCategory> getContentCategoryPages(Map<String, Object> map) {
        return mapper.getContentCategoryPages(map);
    }

    @Override
    public int addContentCategory(ContentCategory category) {
        return mapper.addContentCategory(category);
    }

    @Override
    public int updateContentCategory(ContentCategory category) {
        return mapper.updateContentCategory(category);
    }

    @Override
    public int delContentCategory(Integer id) {
        return mapper.delContentCategory(id);
    }

    @Override
    public ContentCategory getById(Integer id) {
        return mapper.getById(id);
    }
}
