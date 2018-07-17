package com.freimanvs.shops.eshop.dao.interfaces;

import com.freimanvs.shops.eshop.entities.Goods;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface GoodsDAO extends DAO<Goods> {
}
