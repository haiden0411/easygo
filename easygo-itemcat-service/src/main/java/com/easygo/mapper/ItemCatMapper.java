package com.easygo.mapper;


import com.easygo.pojo.ItemCat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemCatMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(ItemCat record);

    Integer insertSelective(ItemCat record);

    ItemCat getItemCatById(Integer id);

    Integer updateByPrimaryKeySelective(ItemCat record);

    Integer updateByPrimaryKey(ItemCat record);

    public Integer getTotalCount(Map<String,Object> map);

    public List<ItemCat> getItemCatsByPage(Map<String,Object> map);


}