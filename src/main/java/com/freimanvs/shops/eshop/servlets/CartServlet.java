package com.freimanvs.shops.eshop.servlets;

import com.freimanvs.shops.eshop.beans.ejb.interfaces.CartBean;
import com.freimanvs.shops.eshop.dao.interfaces.GoodsDAO;
import com.freimanvs.shops.eshop.entities.Goods;
import com.freimanvs.shops.eshop.utils.MessageSource;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Inject
    private CartBean cartBean;

    @EJB
    private GoodsDAO goodsDAO;

    @Inject
    private MessageSource messageSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Locale sessionLocale = (Locale)req.getSession().getAttribute("locale");
        Locale locale = sessionLocale != null ? sessionLocale : resp.getLocale();

        if (req.getParameter("id") != null) {
            Goods goods = goodsDAO.getById(Long.valueOf(req.getParameter("id")));
            goods.setName(goods.getName().replaceAll("[_]{1}", "."));
            goods.setName(messageSource.getMessage(goods.getName(), locale));
            cartBean.add(goods);
        } else {
            req.getSession().setAttribute("mapOfGoods", cartBean.get());
            req.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Goods goods = goodsDAO.getById(Long.valueOf(req.getParameter("id")));
        Long count = Long.valueOf(req.getParameter("count"));
        cartBean.update(goods, count);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Goods goods = goodsDAO.getById(Long.valueOf(req.getParameter("id")));
        cartBean.remove(goods);
    }
}
