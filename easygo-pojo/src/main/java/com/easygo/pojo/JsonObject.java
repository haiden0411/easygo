package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-08-26 23:27
 * Description：<描述>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonObject implements Serializable {
    private static final long serialVersionUID = -4500337745486069924L;
    private Integer id;
    private String text;
}
