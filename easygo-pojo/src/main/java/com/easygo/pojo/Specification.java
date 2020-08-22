package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-08-21 23:43
 * Description：<描述>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Specification implements Serializable {
    private static final long serialVersionUID = -5479028628225469900L;
    private Integer id;
    private String spec_name;
    private Integer del;
}
