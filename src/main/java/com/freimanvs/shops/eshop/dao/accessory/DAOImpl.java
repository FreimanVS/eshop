package com.freimanvs.shops.eshop.dao.accessory;

import com.freimanvs.shops.eshop.entities.interfaces.Idable;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public abstract class DAOImpl<T extends Idable>extends DAOImplSuperclass<T> {

    private static final Logger LOGGER = Logger.getLogger(DAOImpl.class);
    private Type mySuperclass = getClass().getGenericSuperclass();
    private Type tType = ((ParameterizedType) mySuperclass).getActualTypeArguments()[0];

    @PersistenceContext(unitName = "eshopmysql")
    protected EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public long add(T obj) {
        em.persist(obj);
        em.flush();
        return obj.getId();
    }

    public List<T> getList() {
        try {
            Class<?> cl = Class.forName(tType.getTypeName());

            String className = cl.getSimpleName();
            Class<T> clazz = (Class<T>) cl.newInstance().getClass();

            TypedQuery<T> query = em.createQuery("SELECT g FROM " + className + " g", clazz);
            List<T> list = query.getResultList();

            if (list != null && !list.isEmpty())
                list.forEach(this::initialize);

            return list;

        } catch (Exception e) {
            LOGGER.warn(e.getLocalizedMessage());
            return null;
        }
    }

    public T getById(long id) {

        try {
            Class<?> cl = Class.forName(tType.getTypeName());
            Class<T> clazz = (Class<T>) cl.newInstance().getClass();

            T obj = em.find(clazz, id);
            initialize(obj);
            return obj;
        } catch (Exception e) {
            LOGGER.warn(e.getLocalizedMessage());
            return null;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteById(long id) {
        T objFromDB = getById(id);
        em.remove(objFromDB);
        em.flush();
    }

    public T getByUnique(String uniqParam, String value) {

        try {
            Class<?> cl = Class.forName(tType.getTypeName());
            String className = cl.getSimpleName();
            Class<T> clazz = (Class<T>) cl.newInstance().getClass();

            TypedQuery<T> query = em.createQuery("select DISTINCT r from " + className + " r"
                    + " WHERE r." + uniqParam + " = :theValue", clazz)
                    .setParameter("theValue", value);

            List<T> list = query.getResultList();
            if (list != null && !list.isEmpty()) {
                list.forEach(this::initialize);
                return list.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            LOGGER.warn(e.getLocalizedMessage());
            return null;
        }
    }

    private void initialize(T r) {

        Hibernate.initialize(r);

        try {
            if (r != null) {
                for (Method method : r.getClass().getDeclaredMethods()) {
                    if ((
                            (method.getReturnType().toString().equals("interface java.util.List"))
                                    || (method.getReturnType().toString().equals("interface java.util.Set"))
                    )
                            && (
                            !(method.getName()).contains("_persistence")
                    )) {
                        ((Collection)method.invoke(r)).forEach(Hibernate::initialize);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
