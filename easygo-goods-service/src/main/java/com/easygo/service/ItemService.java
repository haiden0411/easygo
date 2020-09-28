package com.easygo.service;

import com.easygo.pojo.Item;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-16 20:45
 * Description：<描述>
 */
public interface ItemService {
    public List<Item> getItemsByGoodsId(Long id);
    public Item getItemById(Long id);
}
