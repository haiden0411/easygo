package com.easygo.service.impl;

import com.easygo.mapper.SpecificationMapper;
import com.easygo.pojo.Specification;
import com.easygo.service.SpecificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-21 23:56
 * Description：<描述>
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Resource
    SpecificationMapper mapper;
    @Override
    public Integer totalCount(Map<String, Object> map) {
        return mapper.totalCount(map);
    }

    @Override
    public List<Specification> getSpecificationPage(Map<String, Object> map) {
        return mapper.getSpecificationPage(map);
    }
}
