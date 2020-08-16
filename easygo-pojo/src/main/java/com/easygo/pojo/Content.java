package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-08-15 22:30
 * Description：<描述>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content implements Serializable {
    private static final long serialVersionUID = 3639835685319218895L;
    private Integer id;
    private ContentCategory contentCategory;
    private String title;
    private String url;
    private String pic;
    private Integer status;
    private Integer sort_order;
    private Integer del;
}
