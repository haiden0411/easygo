package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-09-27 21:12
 * Description：<描述>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartBean implements Serializable {
    private static final long serialVersionUID = 1260077915392672132L;
    private Long item_id; //skuID
    private Long goods_id;
    private String title;
    private Double price;
    private Long num;
    private Double total_fee;
    private String pic_path;
    private String seller_id;
}
