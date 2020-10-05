package com.easygo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-10-05 21:43
 * Description：<描述>
 */
@FeignClient(value = "easygo-pay-service")
public interface PayClient {
    @RequestMapping("/createNative")
    public Map<String,String> createNative(@RequestParam("out_trade_no") String out_trade_no, @RequestParam("total_fee") String total_fee);

    @RequestMapping("/queryPayStatus")
    public Map<String,String> queryPayStatus(@RequestParam("out_trade_no") String out_trade_no);

}
