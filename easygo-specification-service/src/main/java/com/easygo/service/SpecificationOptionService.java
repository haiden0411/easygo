package com.easygo.service;

import com.easygo.pojo.SpecificationOption;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-23 22:40
 * Description：<描述>
 */
public interface SpecificationOptionService {
    public Integer addSpecificationOption(SpecificationOption specificationOption);
    public List<SpecificationOption> getSpecificationOptionById(Integer id);
    public Integer deleteSpecificationById(Integer id);
    public Integer updateSpecifications(SpecificationOption specificationOption);
}
