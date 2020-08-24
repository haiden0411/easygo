package com.easygo.mapper;

import com.easygo.pojo.Specification;
import com.easygo.pojo.SpecificationOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-23 22:32
 * Description：<描述>
 */
@Mapper
public interface SpecificationOptionMapper {
    public Integer addSpecificationOption(SpecificationOption specificationOption);
    public List<SpecificationOption> getSpecificationOptionById(Integer id);
    public Integer deleteSpecificationById(Integer id);
    public Integer updateSpecifications(SpecificationOption specificationOption);
}
