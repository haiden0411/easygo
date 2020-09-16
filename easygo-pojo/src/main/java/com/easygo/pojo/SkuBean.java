package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-09-16 21:01
 * Description：<描述>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuBean implements Serializable {
    private static final long serialVersionUID = 3057065151226440229L;
    private Long id;
    private String title;
    private Double price;
    private Map<String,Object> spec;
}
