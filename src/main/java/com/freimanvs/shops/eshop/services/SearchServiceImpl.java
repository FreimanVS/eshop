package com.freimanvs.shops.eshop.services;

import com.freimanvs.shops.eshop.entities.Goods;
import com.freimanvs.shops.eshop.services.interfaces.SearchService;
import org.hibernate.Hibernate;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SearchServiceImpl implements SearchService {

    @PersistenceContext(unitName = "eshopmysql")
    private EntityManager em;

    @Override
    public List<Goods> find(String q) {
        TypedQuery<Goods> query = em.createQuery("select g from Goods g"
                +" WHERE g.name LIKE :name"
                + " OR g.img LIKE :img", Goods.class)
                .setParameter("name", "%"+q+"%")
                .setParameter("img", "%"+q+"%");

        List<Goods> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            list.forEach(this::initialize);
        }

        return list;
    }

    @Override
    public List<Goods> byPrice(double from, double to) {
        TypedQuery<Goods> query = em.createQuery("select g from Goods g"
                +" WHERE g.price >= :priceFrom"
                + " AND g.price <= :priceTo", Goods.class)
                .setParameter("priceFrom", from)
                .setParameter("priceTo", to);

        List<Goods> list = query.getResultList();

        if (list != null && !list.isEmpty()) {
            list.forEach(this::initialize);
        }

        return list;
    }

    private void initialize(Goods g) {
        Hibernate.initialize(g);
        g.getOrders().forEach(Hibernate::initialize);
    }
}
