package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-10-01 22:48
 * Description：<描述>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 6611634520362681600L;
    private Long id; //订单详情实体
    private Long item_id; //skuID
    private Long goods_id;
    private Long order_id; //订单ID
    private String title;
    private Double price;
    private Long num;
    private Double total_fee;
    private String pic_path;
    private String seller_id;
}
