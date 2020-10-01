package com.easygo.api;

import com.easygo.pojo.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author：胡灯
 * Date：2020-10-01 23:42
 * Description：<描述>
 */
@FeignClient(value = "easygo-order-service")
public interface OrderClient {
    @RequestMapping("/order_add")
    public Integer addOrder(@RequestBody OrderInfo orderInfo);
}
