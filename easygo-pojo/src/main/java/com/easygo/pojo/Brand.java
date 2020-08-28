package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-08-03 22:55
 * Description：<描述>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand implements Serializable{
    private static final long serialVersionUID = -6695469532964990880L;
    private Integer id;
    private String name;
    private String image;
    private String first_char;
    private Integer del;
    private Boolean flag;
}
