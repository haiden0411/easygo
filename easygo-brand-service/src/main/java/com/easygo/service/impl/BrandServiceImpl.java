package com.easygo.service.impl;

import com.easygo.mapper.BrandMapper;
import com.easygo.pojo.Brand;
import com.easygo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-04 21:39
 * Description：<描述>
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    BrandMapper brandMapper;
    @Override
    public List<Brand> getBrands() {
        return brandMapper.getBrands();
    }

    @Override
    public int addBrand(Brand brand) {
        return brandMapper.addBrand(brand);
    }

    @Override
    public int updateBrand(Brand brand) {
        return brandMapper.updateBrand(brand);
    }

    @Override
    public Brand getBrandById(Integer id) {
        return brandMapper.getBrandById(id);
    }

    @Override
    public int deleteBrandById(Integer id) {
        return brandMapper.deleteBrandById(id);
    }

    @Override
    public int deleteSome(String ids) {
        return brandMapper.deleteSome(ids);
    }

    @Override
    public int getTotalCount() {
        return brandMapper.getTotalCount();
    }

    @Override
    public List<Brand> getPageBrands(Map<String, Object> params) {
        return brandMapper.getPageBrands(params);
    }
}
