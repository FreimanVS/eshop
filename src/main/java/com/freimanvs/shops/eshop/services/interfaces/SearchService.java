package com.freimanvs.shops.eshop.services.interfaces;

import com.freimanvs.shops.eshop.entities.Goods;

import java.util.List;

public interface SearchService {
    List<Goods> find(String q);
    List<Goods> byPrice(double from, double to);
}
