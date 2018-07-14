package com.freimanvs.shops.eshop.services.interfaces;

import com.freimanvs.shops.eshop.entities.User;

import java.util.List;

public interface UserService {
    long add(User obj);
    List<User> getList();
    User getById(long id);
    void deleteById(long id);
    void updateById(long id, User obj);
    User getByUnique(String uniqParam, String value);
}
