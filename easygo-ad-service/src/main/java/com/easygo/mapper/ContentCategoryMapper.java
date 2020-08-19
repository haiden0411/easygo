package com.easygo.mapper;

import com.easygo.pojo.Content;
import com.easygo.pojo.ContentCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-12 20:53
 * Description：<描述>
 */
@Mapper
public interface ContentCategoryMapper {
    public Integer getTotalCount(Map<String,Object> map);
    public List<ContentCategory> getContentCategoryPages(Map<String,Object> map);
    public int addContentCategory(ContentCategory category);
    public int updateContentCategory(ContentCategory category);
    public int delContentCategory(Integer id);
    public ContentCategory getById(Integer id);

    //查询所有的广告分类
    public List<ContentCategory> getContentCategorys();
}
