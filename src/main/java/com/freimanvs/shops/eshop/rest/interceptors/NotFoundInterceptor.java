package com.freimanvs.shops.eshop.rest.interceptors;

import com.freimanvs.shops.eshop.dao.interfaces.GoodsDAO;
import com.freimanvs.shops.eshop.dao.interfaces.OrderDAO;
import com.freimanvs.shops.eshop.dao.interfaces.RoleDAO;
import com.freimanvs.shops.eshop.rest.GoodsResource;
import com.freimanvs.shops.eshop.rest.OrderResource;
import com.freimanvs.shops.eshop.rest.RoleResource;
import com.freimanvs.shops.eshop.rest.UserResource;
import com.freimanvs.shops.eshop.services.interfaces.UserService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ws.rs.NotFoundException;

public class NotFoundInterceptor {

    @EJB
    private GoodsDAO goodsDAO;

    @EJB
    private RoleDAO roleDAO;

    @EJB
    private OrderDAO orderDao;

    @Inject
    private UserService userService;

    @AroundInvoke
    public Object notFound(InvocationContext ic) throws Exception {
        Object[] params = ic.getParameters();
        if (ic.getTarget() instanceof GoodsResource) {
            for (Object param : params) {
                if (param instanceof Long
                        && goodsDAO.getById((Long) param) == null) {
                    throw new NotFoundException();
                }
            }
        } else if (ic.getTarget() instanceof RoleResource) {
            for (Object param : params) {
                if (param instanceof Long
                        && roleDAO.getById((Long) param) == null) {
                    throw new NotFoundException();
                }
            }
        } else if (ic.getTarget() instanceof OrderResource) {
            for (Object param : params) {
                if (param instanceof Long
                        && orderDao.getById((Long) param) == null) {
                    throw new NotFoundException();
                }
            }
        } else if (ic.getTarget() instanceof UserResource) {
            for (Object param : params) {
                if (param instanceof Long
                        && userService.getById((Long) param) == null) {
                    throw new NotFoundException();
                }
            }
        }

        return ic.proceed();
    }
}
