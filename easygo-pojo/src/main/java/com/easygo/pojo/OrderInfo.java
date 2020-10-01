package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-10-01 22:47
 * Description：<描述>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 4212489161388958832L;
    private Order order;
    List<OrderItem> orderItems;

}
