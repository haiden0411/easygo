package com.easygo.api;

import com.easygo.pojo.Specification;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author：胡灯
 * Date：2020-08-22 21:37
 * Description：<描述>
 */
@FeignClient("easygo-specification-service")
public interface SpecificationClient {
    @RequestMapping("/specification_page")
    public PageUtils<Specification> specification_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize,@RequestParam(defaultValue = "",required = false) String spec_name);
}
