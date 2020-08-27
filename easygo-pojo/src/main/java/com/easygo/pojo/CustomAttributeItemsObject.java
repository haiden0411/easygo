package com.easygo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author：胡灯
 * Date：2020-08-26 23:29
 * Description：<描述>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomAttributeItemsObject implements Serializable {

    private static final long serialVersionUID = 5413129896802795580L;
    private String text;
}
