package com.freimanvs.shops.eshop.dao;

import com.freimanvs.shops.eshop.dao.accessory.DAOImpl;
import com.freimanvs.shops.eshop.dao.interfaces.OrderDAO;
import com.freimanvs.shops.eshop.entities.Order;

import javax.ejb.*;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderDAOImpl extends DAOImpl<Order> implements OrderDAO {

    public OrderDAOImpl() {
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void updateById(long id, Order obj) {
        Order objFromDB = getById(id);
        objFromDB.setName(obj.getName());
        objFromDB.setApartment(obj.getApartment());
        objFromDB.setCodeEntrance(obj.getCodeEntrance());
        objFromDB.setComment(obj.getComment());
        objFromDB.setFloor(obj.getFloor());
        objFromDB.setHouseNumber(obj.getHouseNumber());
        objFromDB.setPhoneNumber(obj.getPhoneNumber());
        objFromDB.setGoods(obj.getGoods());
        objFromDB.setStreet(obj.getStreet());
        objFromDB.setUser(obj.getUser());
        em.flush();
    }
}