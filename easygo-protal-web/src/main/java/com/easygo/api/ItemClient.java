package com.easygo.api;

import com.easygo.pojo.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author：胡灯
 * Date：2020-09-27 21:51
 * Description：<描述>
 */

@FeignClient(value = "easygo-goods-service")
public interface ItemClient {
    @RequestMapping("/item_getById")
    public Item getItemById(@RequestParam Long id);
}
