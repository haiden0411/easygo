package com.easygo.api;

import com.easygo.pojo.Specification;
import com.easygo.pojo.SpecificationOption;
import com.easygo.utils.MessageResults;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-08-22 21:37
 * Description：<描述>
 */
@FeignClient("easygo-specification-service")
public interface SpecificationClient {
    @RequestMapping("/specification_page")
    public PageUtils<Specification> specification_pages(@RequestParam(defaultValue = "1",required = false) Integer pageIndex, @RequestParam(defaultValue = "5",required = false)Integer pageSize,@RequestParam(defaultValue = "",required = false) String spec_name);

    @RequestMapping("/specification_add")
    public Integer addSpecification(@RequestParam String spec_name, @RequestParam String[] option_name, @RequestParam Integer[] orders);

    @RequestMapping("/specification_getById")
    public Map<String,Object> getSpecificationOptionById(@RequestParam Integer id);

    @RequestMapping("/specification_update")
    public Integer specification_update(@RequestParam Integer id,@RequestParam String spec_name,@RequestParam String[] option_name,@RequestParam Integer[] orders);

    @RequestMapping("/specification_getSpecs")
    public List<Specification> getSpecifications();

    @RequestMapping("/specification_getSpecById")
    public Specification getSpecById(@RequestParam Integer id);
}
