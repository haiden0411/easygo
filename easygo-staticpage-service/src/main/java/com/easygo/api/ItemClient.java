package com.easygo.api;

import com.easygo.pojo.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-03 21:47
 * Description：<描述>
 */
@FeignClient(value = "easygo-goods-service")
public interface ItemClient {
    @RequestMapping("/item_getItemsByGoodsId")
    public List<Item> getItemsByGoodsId(@RequestParam Long id);
}
