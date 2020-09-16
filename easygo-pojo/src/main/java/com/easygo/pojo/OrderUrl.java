package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-09-16 18:22
 * Description：<描述>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderUrl implements Serializable {

    private static final long serialVersionUID = -874813865009477331L;
    private String order;
    private String url;
}
