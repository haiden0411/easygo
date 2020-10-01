package com.easygo.controller;

import com.easygo.pojo.OrderInfo;
import com.easygo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author：胡灯
 * Date：2020-10-01 23:38
 * Description：<描述>
 */
@RestController
@Scope("prototype")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/order_add")
    public Integer addOrder(@RequestBody OrderInfo orderInfo){
        System.out.println("服务端："+orderInfo);
        return orderService.addOrder(orderInfo);

    }
}
