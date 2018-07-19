package com.freimanvs.shops.eshop.dao;

import com.freimanvs.shops.eshop.dao.accessory.DAOImpl;
import com.freimanvs.shops.eshop.dao.interfaces.RoleDAO;
import com.freimanvs.shops.eshop.entities.Role;

import javax.ejb.*;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class RoleDAOImpl extends DAOImpl<Role> implements RoleDAO {

    public RoleDAOImpl() {
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void updateById(long id, Role obj) {
        Role objFromDB = getById(id);
        objFromDB.setName(obj.getName());
        em.flush();
    }
}