package com.freimanvs.shops.eshop.dao;

import com.freimanvs.shops.eshop.dao.interfaces.GoodsDAO;
import com.freimanvs.shops.eshop.entities.Goods;
import org.hibernate.Hibernate;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GoodsDAOImpl implements GoodsDAO {

    @PersistenceContext(unitName = "eshopmysql")
    private EntityManager em;

    public GoodsDAOImpl() {
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public long add(Goods obj) {
        em.persist(obj);
        em.flush();
        return obj.getId();
    }

    @Override
    public List<Goods> getList() {
        TypedQuery<Goods> query = em.createQuery("SELECT g FROM Goods g", Goods.class);
        List<Goods> list = query.getResultList();

        if (list != null && !list.isEmpty())
            list.forEach(this::initialize);

        return list;
    }

    @Override
    public Goods getById(long id) {
        Goods obj = em.find(Goods.class, id);
        initialize(obj);
        return obj;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void deleteById(long id) {
        Goods objFromDB = getById(id);
        em.remove(objFromDB);
        em.flush();
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

    @Override
    public Goods getByUnique(String uniqParam, String value) {

        TypedQuery<Goods> query = em.createQuery("select DISTINCT r from Goods r"
                +" WHERE r." + uniqParam + " = :theValue", Goods.class)
                .setParameter("theValue", value);

        List<Goods> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            list.forEach(this::initialize);
            return list.get(0);
        } else {
            return null;
        }
    }

    private void initialize(Goods r) {
        if (r != null) {
            Hibernate.initialize(r);
            r.getOrders().forEach(Hibernate::initialize);
        }
    }
}
