package com.easygo.service.impl;

import com.easygo.mapper.ContentMapper;
import com.easygo.pojo.Content;
import com.easygo.service.ContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-16 21:01
 * Description：<描述>
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Resource
    ContentMapper contentMapper;

    @Override
    public Integer getTotalCount() {
        return contentMapper.getTotalCount();
    }

    @Override
    public List<Content> getContents(Map<String, Object> map) {
        return contentMapper.getContents(map);
    }
}
