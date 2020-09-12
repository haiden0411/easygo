package com.easygo.serivce.impl;

import com.easygo.dao.GoodsDao;
import com.easygo.pojo.Goods;
import com.easygo.serivce.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-12 22:59
 * Description：<描述>
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;
    @Override
    public Goods saveDocument(Goods goods) {
        return goodsDao.save(goods);
    }

    @Override
    public Iterable<Goods> saveDocuments(List<Goods> goodsList) {
        return goodsDao.saveAll(goodsList);
    }

    @Override
    public Goods getDocuemntById(Long id) {
        return goodsDao.findById(id).get();
    }

    @Override
    public void updateDocumentById(Goods goods) {
        goodsDao.save(goods);
    }

    @Override
    public void deleteDocumentById(Long id) {
        goodsDao.deleteById(id);
    }

    @Override
    public void deleteAllDocument() {
        goodsDao.deleteAll();
    }
}
