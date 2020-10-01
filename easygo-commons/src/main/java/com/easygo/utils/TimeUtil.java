package com.easygo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author：胡灯
 * Date：2020-10-02 0:00
 * Description：<描述>
 */
public class TimeUtil {
    private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static String getNow(){
       return  df.format(LocalDateTime.now());
    }

}
