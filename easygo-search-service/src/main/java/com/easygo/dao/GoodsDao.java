package com.easygo.dao;

import com.easygo.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Author：胡灯
 * Date：2020-09-12 22:44
 * Description：<描述>
 */
@Repository
public interface GoodsDao extends ElasticsearchRepository<Goods,Long> {
}
