package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-08-25 21:59
 * Description：<描述>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeTemplate implements Serializable {
    private static final long serialVersionUID = -8445303324216725667L;
    private Integer id;
    private String name;
    private String spec_ids;
    private String brand_ids;
    private String custom_attribute_items;
    private Integer del;

}
