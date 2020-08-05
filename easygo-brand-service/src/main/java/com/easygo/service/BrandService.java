package com.easygo.service;

import com.easygo.pojo.Brand;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-04 21:38
 * Description：<描述>
 */
public interface BrandService {
    public List<Brand> getBrands();
    public int addBrand(Brand brand);
    public  int updateBrand(Brand brand);
    public Brand getBrandById(Integer id);
    public int deleteBrandById(Integer id);
}
