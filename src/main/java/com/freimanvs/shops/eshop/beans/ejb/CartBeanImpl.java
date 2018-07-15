package com.freimanvs.shops.eshop.beans.ejb;

import com.freimanvs.shops.eshop.beans.ejb.interfaces.CartBean;
import com.freimanvs.shops.eshop.entities.Goods;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@SessionScoped
public class CartBeanImpl implements CartBean {
    private Map<Goods, Long> cart = new HashMap<>();

    @Override
    public void add(Goods goods) {
        cart.computeIfPresent(goods, (key, count) -> count = count + 1);
        cart.putIfAbsent(goods, 1L);
    }

    @Override
    public Map<Goods, Long> get() {
        return cart;
    }

    @Override
    public void update(Goods goods, Long count) {
        cart.compute(goods, (k, v) -> v = count);
    }

    @Override
    public void remove(Goods goods) {
        cart.remove(goods);
    }
}
