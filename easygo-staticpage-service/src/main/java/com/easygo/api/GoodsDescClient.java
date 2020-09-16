package com.easygo.api;

import com.easygo.pojo.GoodsDesc;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author：胡灯
 * Date：2020-09-16 11:25
 * Description：<描述>
 */
@FeignClient(value = "easygo-goods-service")
public interface GoodsDescClient {
    @RequestMapping("/goodsDesc_getDescById")
    public GoodsDesc getGoodsDescById(@RequestParam Long id);
}
