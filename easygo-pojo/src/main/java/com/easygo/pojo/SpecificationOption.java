package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-08-21 23:46
 * Description：<描述>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationOption implements Serializable {
    private static final long serialVersionUID = -2089964877041763283L;
    private Integer id;
    private String option_name;
    private Specification specifiction;
    private Integer orders;
    private Integer del;
}
