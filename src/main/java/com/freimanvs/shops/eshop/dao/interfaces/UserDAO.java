package com.freimanvs.shops.eshop.dao.interfaces;

import com.freimanvs.shops.eshop.entities.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserDAO {
    long add(User obj);
    List<User> getList();
    User getById(long id);
    void deleteById(long id);
    void updateById(long id, User obj);
    User getByUnique(String uniqParam, String value);
}
