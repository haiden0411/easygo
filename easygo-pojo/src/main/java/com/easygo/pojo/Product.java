package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author：胡灯
 * Date：2020-09-26 20:53
 * Description：<描述>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private Long sum;
    private Double price;
    private Double total_fre;
}
