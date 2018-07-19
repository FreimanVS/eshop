package com.freimanvs.shops.eshop.dao;

import com.freimanvs.shops.eshop.dao.accessory.DAOImpl;
import com.freimanvs.shops.eshop.dao.interfaces.GoodsDAO;
import com.freimanvs.shops.eshop.entities.Goods;

import javax.ejb.*;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GoodsDAOImpl extends DAOImpl<Goods> implements GoodsDAO {

    public GoodsDAOImpl() {
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void updateById(long id, Goods obj) {
        Goods objFromDB = getById(id);
        objFromDB.setName(obj.getName());
        objFromDB.setOrders(obj.getOrders());
        objFromDB.setPrice(obj.getPrice());
        objFromDB.setImg(obj.getImg());
        em.flush();
    }
}
