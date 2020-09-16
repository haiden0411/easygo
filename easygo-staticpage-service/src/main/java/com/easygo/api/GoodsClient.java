package com.easygo.api;

import com.easygo.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author：胡灯
 * Date：2020-09-16 9:59
 * Description：<描述>
 */
@FeignClient(value = "easygo-goods-service")
public interface GoodsClient {
    @RequestMapping("/goods_getGoodByI")
    public Goods getAllGoods(@RequestParam Long id);
}
