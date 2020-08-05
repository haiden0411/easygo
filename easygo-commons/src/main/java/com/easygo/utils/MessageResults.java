package com.easygo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author：胡灯
 * Date：2020-08-05 22:16
 * Description：<描述>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResults {
    private Integer code;
    private String message;
}
