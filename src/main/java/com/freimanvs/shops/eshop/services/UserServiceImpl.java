package com.freimanvs.shops.eshop.services;

import com.freimanvs.shops.eshop.dao.interfaces.RoleDAO;
import com.freimanvs.shops.eshop.dao.interfaces.UserDAO;
import com.freimanvs.shops.eshop.entities.Role;
import com.freimanvs.shops.eshop.entities.User;
import com.freimanvs.shops.eshop.security.beans.interfaces.SecurityBean;
import com.freimanvs.shops.eshop.services.interfaces.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Set;

@Dependent
public class UserServiceImpl implements UserService {

    @EJB
    private UserDAO userDAO;

    @EJB
    private RoleDAO roleDAO;

    @Inject
    private SecurityBean securityBean;

    public UserServiceImpl() {
    }

    @Override
    public long add(User obj) {

        if (userDAO.getById(obj.getId()) != null) {
            throw new EntityExistsException("The entity already exists: " + obj.toString());
        }

        //encode password
        obj.setPassword(securityBean.encodeSha(obj.getPassword()));

        Set<Role> roles = obj.getRoles();
        roles.add(roleDAO.getById(1L));

        return userDAO.add(obj);
    }

    @Override
    public List<User> getList() {
        return userDAO.getList();
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    public void updateById(long id, User obj) {
        String oldPass = userDAO.getById(id).getPassword();
        String newPass = obj.getPassword();
        if (!oldPass.equals(newPass)) {
            obj.setPassword(securityBean.encodeSha(obj.getPassword()));
        }
        userDAO.updateById(id, obj);
    }

    @Override
    public User getByUnique(String uniqParam, String value) {
        return userDAO.getByUnique(uniqParam, value);
    }
}
