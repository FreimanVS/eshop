package com.freimanvs.shops.eshop.dao.interfaces;


import com.freimanvs.shops.eshop.entities.Order;

import java.io.Serializable;
import java.util.List;

public interface OrderDAO extends Serializable {
    long add(Order obj);
    List<Order> getList();
    Order getById(long id);
    void deleteById(long id);
    void updateById(long id, Order obj);
    Order getByUnique(String uniqParam, String value);
}
