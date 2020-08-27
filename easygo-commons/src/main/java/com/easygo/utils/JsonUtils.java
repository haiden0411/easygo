package com.easygo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Author：胡灯
 * Date：2020-08-25 23:54
 * Description：<描述>
 */
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    //对象转字符串
    public static <T> String obj2String(T obj){
        if (obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //字符串转对象
    public static <T> T string2Obj(String str,Class<T> clazz){
        if (StringUtils.isEmpty(str) || clazz == null){
            return null;
        }
        try {
            return clazz.equals(String.class)? (T) str :objectMapper.readValue(str,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //字符串转list
    public static <T> T string2Obj(String str, TypeReference<T> typeReference){
        if (StringUtils.isEmpty(str)){
            return null;
        }
        try {
            return objectMapper.readValue(str,typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
