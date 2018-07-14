package com.freimanvs.shops.eshop.dao.interfaces;

import com.freimanvs.shops.eshop.entities.Role;

import java.util.List;

public interface RoleDAO {
    long add(Role obj);
    List<Role> getList();
    Role getById(long id);
    void deleteById(long id);
    void updateById(long id, Role obj);
    Role getByUnique(String uniqParam, String value);
}
