package com.easygo.mapper;

import com.easygo.pojo.Order;
import com.easygo.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-10-01 22:56
 * Description：<描述>
 */
@Mapper
public interface OrderMapper {
    Integer addOrder(Order order);
    Integer addOrderItem(@Param("orderItems") List<OrderItem> orderItems);
}
