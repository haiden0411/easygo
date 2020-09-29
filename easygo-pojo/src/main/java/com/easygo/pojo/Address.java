package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-09-29 21:34
 * Description：<描述>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = -7132899921571757277L;
    private Long id;
    private String username;
    private String province_id;
    private String city_id;
    private String town_id;
    private String mobile;
    private String address;
    private String contact;
    private String notes;
    private String is_default;
    private String create_date;
    private String alias;
}
