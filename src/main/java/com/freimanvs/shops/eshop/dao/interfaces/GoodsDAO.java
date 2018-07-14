package com.freimanvs.shops.eshop.dao.interfaces;

import com.freimanvs.shops.eshop.entities.Goods;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface GoodsDAO {
    long add(Goods obj);
    List<Goods> getList();
    Goods getById(long id);
    void deleteById(long id);
    void updateById(long id, Goods obj);
    Goods getByUnique(String uniqParam, String value);
}
