package com.easygo.api;

import com.easygo.pojo.ItemCat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-06 22:31
 * Description：<描述>
 */
@FeignClient(value = "easygo-itemcat-service")
public interface ItemCatClient {
    @RequestMapping("/itemcat_all")
    public List<ItemCat> getItemCats();
}
