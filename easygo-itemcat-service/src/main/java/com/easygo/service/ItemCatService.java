package com.easygo.service;

import com.easygo.pojo.ItemCat;

import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-09-02 23:57
 * Description：<描述>
 */
public interface ItemCatService {
    public Integer getTotalCount(Map<String,Object> map);
    public List<ItemCat> getItemCatsByPage(Map<String,Object> map);
}
