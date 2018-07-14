package com.freimanvs.shops.eshop.rest.interceptors;

import com.freimanvs.shops.eshop.dao.interfaces.GoodsDAO;
import com.freimanvs.shops.eshop.dao.interfaces.OrderDAO;
import com.freimanvs.shops.eshop.dao.interfaces.RoleDAO;
import com.freimanvs.shops.eshop.entities.Order;
import com.freimanvs.shops.eshop.rest.GoodsRest;
import com.freimanvs.shops.eshop.rest.OrderRest;
import com.freimanvs.shops.eshop.rest.RoleRest;
import com.freimanvs.shops.eshop.rest.UserRest;
import com.freimanvs.shops.eshop.services.interfaces.UserService;

import javax.ejb.EJB;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;

public class NotFoundInterceptor {

//    private GoodsService goodsService
//            = CDI.current().select(GoodsService.class).get()
//            ;

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
        if (ic.getTarget() instanceof GoodsRest) {
            for (Object param : params) {
                if (param instanceof Long
                        && goodsDAO.getById((Long) param) == null) {
                    throw new NotFoundException();
                }
            }
        } else if (ic.getTarget() instanceof RoleRest) {
            for (Object param : params) {
                if (param instanceof Long
                        && roleDAO.getById((Long) param) == null) {
                    throw new NotFoundException();
                }
            }
        } else if (ic.getTarget() instanceof OrderRest) {
            for (Object param : params) {
                if (param instanceof Long
                        && orderDao.getById((Long) param) == null) {
                    throw new NotFoundException();
                }
            }
        } else if (ic.getTarget() instanceof UserRest) {
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
