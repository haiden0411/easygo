package com.easygo.api;

import com.easygo.pojo.ItemCat;
import com.easygo.utils.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author：胡灯
 * Date：2020-09-03 21:47
 * Description：<描述>
 */
@FeignClient(value = "easygo-itemcat-service")
public interface ItemCatClient {
    @RequestMapping("/itemcat_getById")
    public ItemCat getItemCatById(@RequestParam Integer id);
}
