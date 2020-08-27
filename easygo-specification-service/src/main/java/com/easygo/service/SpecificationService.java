package com.easygo.service;

import com.easygo.pojo.Specification;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-21 23:56
 * Description：<描述>
 */
public interface SpecificationService {
    public Integer totalCount(Map<String, Object> map);
    public List<Specification> getSpecificationPage(Map<String, Object> map);
    public Integer addSpecification(Specification specification);
    public Integer addSpecificationTransaction( String spec_name, String[] option_name,Integer[] orders);
    public Specification getSpecificationById(Integer id);
    public Integer updateSpecificationTransaction(Integer id, String spec_name,String[] option_name,Integer[] orders);
    public List<Specification> getSpecifications();
}
