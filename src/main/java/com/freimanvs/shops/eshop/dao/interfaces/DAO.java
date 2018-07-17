package com.freimanvs.shops.eshop.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface DAO<T> extends Serializable {
    long add(T obj);
    List<T> getList();
    T getById(long id);
    void deleteById(long id);
    void updateById(long id, T obj);
    T getByUnique(String uniqParam, String value);
}
