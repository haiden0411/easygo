package com.easygo.mapper;

import com.easygo.pojo.Content;
import com.easygo.pojo.ContentCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-15 22:36
 * Description：<描述>
 */
@Mapper
public interface ContentMapper {
    public Integer getTotalCount();
    public List<Content> getContents(Map<String,Object> map);
    public List<Content> getContentsByCategoryId(Integer categoryId);
    public Integer updateStatus(Map<String,Object> map);
    public Integer addContent(Content content);
}
