package com.freimanvs.shops.eshop.beans.ejb.interfaces;

import com.freimanvs.shops.eshop.entities.Goods;

import java.io.Serializable;
import java.util.Map;

public interface CartBean extends Serializable {
    void add(Goods goods);
    Map<Goods, Long> get();
    void remove(Goods goods);
    void update(Goods goods, Long count);
}
