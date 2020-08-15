package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-08-12 20:44
 * Description：<描述>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentCategory implements Serializable {
    private static final long serialVersionUID = 5266300161133421639L;
    private Integer id;
    private String name;
    private Integer del;
}
