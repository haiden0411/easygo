package com.easygo.service.impl;


import com.easygo.mapper.OrderMapper;
import com.easygo.pojo.Order;
import com.easygo.pojo.OrderInfo;
import com.easygo.pojo.OrderItem;
import com.easygo.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-10-01 23:03
 * Description：<描述>
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public Integer addOrder(OrderInfo orderInfo) {

        orderMapper.addOrder(orderInfo.getOrder());
        List<OrderItem> orderItems = orderInfo.getOrderItems();
        orderMapper.addOrderItem(orderItems);
        return 1;
    }
}
