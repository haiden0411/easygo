package com.easygo.serivce;

import com.easygo.pojo.Goods;

import java.util.List;

/**
 * Author：胡灯
 * Date：2020-09-12 22:59
 * Description：<描述>
 */
public interface GoodsService {
    public Goods saveDocument(Goods goods);
    public Iterable<Goods> saveDocuments(List<Goods> goodsList);
    public Goods getDocuemntById(Long id);
    public void updateDocumentById(Goods goods);
    public void deleteDocumentById(Long id);
    public void deleteAllDocument();

}
