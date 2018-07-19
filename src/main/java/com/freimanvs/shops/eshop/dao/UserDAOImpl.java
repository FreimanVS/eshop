package com.freimanvs.shops.eshop.dao;

import com.freimanvs.shops.eshop.dao.accessory.DAOImpl;
import com.freimanvs.shops.eshop.dao.interfaces.UserDAO;
import com.freimanvs.shops.eshop.entities.User;

import javax.ejb.*;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserDAOImpl extends DAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void updateById(long id, User obj) {
        User objFromDB = getById(id);
        objFromDB.setLogin(obj.getLogin());
        objFromDB.setPassword(obj.getPassword());
        objFromDB.setEmail(obj.getEmail());
        objFromDB.setRoles(obj.getRoles());
        em.flush();
    }
}
