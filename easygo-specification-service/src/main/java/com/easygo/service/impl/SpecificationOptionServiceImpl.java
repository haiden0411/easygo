package com.easygo.service.impl;

import com.easygo.mapper.SpecificationOptionMapper;
import com.easygo.pojo.Specification;
import com.easygo.pojo.SpecificationOption;
import com.easygo.service.SpecificationOptionService;
import com.easygo.service.SpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-23 22:41
 * Description：<描述>
 */
@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

    @Resource
    SpecificationOptionMapper mapper;
    @Override
    public Integer addSpecificationOption(SpecificationOption specificationOption) {
        return mapper.addSpecificationOption(specificationOption);
    }

    @Override
    public List<SpecificationOption> getSpecificationOptionById(Integer id) {
        return mapper.getSpecificationOptionById(id);
    }

    @Override
    public Integer deleteSpecificationById(Integer id) {
        return mapper.deleteSpecificationById(id);
    }

    @Override
    public Integer updateSpecifications(SpecificationOption specificationOption) {
        return mapper.updateSpecifications(specificationOption);
    }


}
