package com.freimanvs.shops.eshop.dao.interfaces;

import com.freimanvs.shops.eshop.entities.Order;

import javax.ejb.Remote;

@Remote
public interface OrderDAO  extends DAO<Order> {
}
