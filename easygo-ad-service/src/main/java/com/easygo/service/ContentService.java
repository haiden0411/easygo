package com.easygo.service;

import com.easygo.pojo.Content;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-16 21:00
 * Description：<描述>
 */
public interface ContentService {
    public Integer getTotalCount();
    public List<Content> getContents(Map<String,Object> map);
    public List<Content> getContentsByCategoryId(Integer categoryId);
    public Integer updateStatus(Map<String,Object> map);
    public Integer addContent(Content content);
}
