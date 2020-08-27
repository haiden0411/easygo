package com.easygo.service.impl;

import com.easygo.mapper.SpecificationMapper;
import com.easygo.mapper.SpecificationOptionMapper;
import com.easygo.pojo.Specification;
import com.easygo.pojo.SpecificationOption;
import com.easygo.service.SpecificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    SpecificationMapper specificationMapper;

    @Resource
    SpecificationOptionMapper specificationOptionMapper;

    @Override
    public Integer totalCount(Map<String, Object> map) {
        return specificationMapper.totalCount(map);
    }

    @Override
    public List<Specification> getSpecificationPage(Map<String, Object> map) {
        return specificationMapper.getSpecificationPage(map);
    }

    @Override
    public Integer addSpecification(Specification specification) {
        return specificationMapper.addSpecification(specification);
    }

    //事务版本的级联新增
    @Override
    @Transactional
    public Integer addSpecificationTransaction(String spec_name, String[] option_name, Integer[] orders) {
        Specification specification = new Specification();
        specification.setSpec_name(spec_name);
        specificationMapper.addSpecification(specification);
        System.out.println("specification:"+specification);
        for (int i = 0; i < option_name.length; i++) {
            SpecificationOption option  = new SpecificationOption();
            option.setOption_name(option_name[i]);
            option.setOrders(orders[i]);
            option.setSpecification(specification);
            specificationOptionMapper.addSpecificationOption(option);
        }
        return 1;
    }

    @Override
    public Specification getSpecificationById(Integer id) {
        return specificationMapper.getSpecificationById(id);
    }

    @Override
    @Transactional
    public Integer updateSpecificationTransaction(Integer id, String spec_name, String[] option_name, Integer[] orders) {
        Specification specification = new Specification();
        specification.setId(id);
        specification.setSpec_name(spec_name);
        specificationMapper.updateSpecification(specification);
        //删除specification选项，重新添加
        specificationOptionMapper.deleteSpecificationById(id);
        //循环插入
        for (int i = 0; i < option_name.length; i++) {
            SpecificationOption option = new SpecificationOption();
            option.setSpecification(specification);
            option.setOrders(orders[i]);
            option.setOption_name(option_name[i]);
            specificationOptionMapper.addSpecificationOption(option);
        }
        return 1;
    }

    @Override
    public List<Specification> getSpecifications() {
        return specificationMapper.getSpecifications();
    }

}
