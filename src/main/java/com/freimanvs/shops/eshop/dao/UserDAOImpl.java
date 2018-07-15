package com.freimanvs.shops.eshop.dao;

import com.freimanvs.shops.eshop.dao.interfaces.UserDAO;
import com.freimanvs.shops.eshop.entities.User;
import org.hibernate.Hibernate;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserDAOImpl implements UserDAO {

    @PersistenceContext(unitName = "eshopmysql")
    private EntityManager em;

    public UserDAOImpl() {
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public long add(User obj) {
        em.persist(obj);
        em.flush();
        return obj.getId();
    }

    @Override
    public List<User> getList() {
        TypedQuery<User> query = em.createQuery("SELECT g FROM User g", User.class);
        List<User> list = query.getResultList();

        if (list != null && !list.isEmpty())
            list.forEach(this::initialize);

        return list;
    }

    @Override
    public User getById(long id) {
        User obj = em.find(User.class, id);
        initialize(obj);
        return obj;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void deleteById(long id) {
        User objFromDB = getById(id);
        em.remove(objFromDB);
        em.flush();
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

    @Override
    public User getByUnique(String uniqParam, String value) {

        TypedQuery<User> query = em.createQuery("select DISTINCT r from User r"
                +" WHERE r." + uniqParam + " = :theValue", User.class)
                .setParameter("theValue", value);

        List<User> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            list.forEach(this::initialize);
            return list.get(0);
        } else {
            return null;
        }
    }

    private void initialize(User r) {
        if (r != null) {
            Hibernate.initialize(r);
            r.getRoles().forEach(Hibernate::initialize);
        }
    }
}
