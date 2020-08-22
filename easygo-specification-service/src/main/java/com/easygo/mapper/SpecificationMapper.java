package com.easygo.mapper;

import com.easygo.pojo.Specification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-21 23:56
 * Description：<描述>
 */
@Mapper
public interface SpecificationMapper {
    public Integer totalCount(Map<String,Object> map);
    public List<Specification> getSpecificationPage(Map<String,Object> map);
}
