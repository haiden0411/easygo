package com.easygo.service.impl;

import com.easygo.mapper.ItemCatMapper;
import com.easygo.pojo.ItemCat;
import com.easygo.service.ItemCatService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-09-02 23:58
 * Description：<描述>
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Resource
    ItemCatMapper itemCatMapper;
    @Override
    public Integer getTotalCount(Map<String, Object> map) {
        return itemCatMapper.getTotalCount(map);
    }

    @Override
    public List<ItemCat> getItemCatsByPage(Map<String, Object> map) {
        return itemCatMapper.getItemCatsByPage(map);
    }

    @Override
    public ItemCat getItemCatById(Integer id) {
        return itemCatMapper.getItemCatById(id);
    }
}
