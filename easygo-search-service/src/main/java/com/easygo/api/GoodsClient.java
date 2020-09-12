package com.easygo.api;

import com.easygo.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-12 22:41
 * Description：<描述>
 */
@FeignClient(value = "easygo-goods-service")
public interface GoodsClient {
    @RequestMapping("/goods_getGoods")
    public List<Goods> getAllGoods(@RequestParam Integer is_marketable);
}
