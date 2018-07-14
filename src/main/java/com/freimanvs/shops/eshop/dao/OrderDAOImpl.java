package com.freimanvs.shops.eshop.dao;

import com.freimanvs.shops.eshop.dao.interfaces.OrderDAO;
import com.freimanvs.shops.eshop.entities.Order;
import org.hibernate.Hibernate;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderDAOImpl implements OrderDAO{

    @PersistenceContext(unitName = "eshopmysql")
    private EntityManager em;

    public OrderDAOImpl() {
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public long add(Order obj) {
        em.persist(obj);
        em.flush();
        return obj.getId();
    }

    @Override
    public List<Order> getList() {
        TypedQuery<Order> query = em.createQuery("SELECT g FROM Order g", Order.class);
        List<Order> list = query.getResultList();

        if (list != null && !list.isEmpty())
            list.forEach(this::initialize);

        return list;
    }

    @Override
    public Order getById(long id) {
        Order obj = em.find(Order.class, id);
        initialize(obj);
        return obj;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void deleteById(long id) {
        Order objFromDB = getById(id);
        em.remove(objFromDB);
        em.flush();
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

    @Override
    public Order getByUnique(String uniqParam, String value) {

        TypedQuery<Order> query = em.createQuery("select DISTINCT r from Order r"
                +" WHERE r." + uniqParam + " = :theValue", Order.class)
                .setParameter("theValue", value);

        List<Order> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            list.forEach(this::initialize);
            return list.get(0);
        } else {
            return null;
        }
    }

    private void initialize(Order r) {
        if (r != null) {
            Hibernate.initialize(r);
            r.getGoods().forEach(Hibernate::initialize);
        }
    }
}
