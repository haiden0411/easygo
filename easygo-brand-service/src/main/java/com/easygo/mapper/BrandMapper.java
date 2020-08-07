package com.easygo.mapper;

import com.easygo.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-03 23:06
 * Description：<描述>
 */
@Mapper
public interface BrandMapper {
    public List<Brand> getBrands();
    public int addBrand(Brand brand);
    public  int updateBrand(Brand brand);
    public Brand getBrandById(Integer id);
    public int deleteBrandById(Integer id);
    public int deleteSome(@Param("ids") String ids);
}
