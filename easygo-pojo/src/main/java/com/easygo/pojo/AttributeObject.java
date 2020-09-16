package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-16 18:44
 * Description：<描述>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttributeObject implements Serializable {
    private static final long serialVersionUID = 1228473029824683923L;
    private String attributeName;
    private List<String> attributeValue;
}
