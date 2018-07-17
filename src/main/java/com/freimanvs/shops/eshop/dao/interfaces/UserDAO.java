package com.freimanvs.shops.eshop.dao.interfaces;

import com.freimanvs.shops.eshop.entities.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserDAO extends DAO<User> {
}
