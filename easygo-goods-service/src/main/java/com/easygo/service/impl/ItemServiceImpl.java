package com.easygo.service.impl;

import com.easygo.mapper.ItemMapper;
import com.easygo.pojo.Item;
import com.easygo.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-16 20:45
 * Description：<描述>
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    ItemMapper itemMapper;
    @Override
    public List<Item> getItemsByGoodsId(Long id) {
        return itemMapper.getItemsByGoodsId(id);
    }
}
