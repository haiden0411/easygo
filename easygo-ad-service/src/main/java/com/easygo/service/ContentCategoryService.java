package com.easygo.service;

import com.easygo.pojo.ContentCategory;

import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-12 20:59
 * Description：<描述>
 */
public interface ContentCategoryService {
    public Integer getTotalCount(Map<String,Object> map);
    public List<ContentCategory> getContentCategoryPages(Map<String,Object> map);
    public int addContentCategory(ContentCategory category);
    public int updateContentCategory(ContentCategory category);
    public int delContentCategory(Integer id);
    public ContentCategory getById(Integer id);

    public List<ContentCategory> getContentCategorys();

}
