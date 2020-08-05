package com.easygo.api;

import com.easygo.pojo.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-08-05 0:03
 * Description：<描述>
 */
@FeignClient(value = "easygo-brand-service")
public interface BrandClient {
    @RequestMapping("/brand_getBrands")
    public List<Brand> getBrands();

    @RequestMapping("/brand_add")
    public int addBrand(@RequestBody Brand brand);

    @RequestMapping("/brand_getBrandById")
    public Brand getBrandById(@RequestParam Integer id);
}
