package com.freimanvs.shops.eshop.servlets;


import com.freimanvs.shops.eshop.dao.interfaces.GoodsDAO;
import com.freimanvs.shops.eshop.dao.interfaces.OrderDAO;
import com.freimanvs.shops.eshop.dao.interfaces.RoleDAO;
import com.freimanvs.shops.eshop.dao.interfaces.UserDAO;
import com.freimanvs.shops.eshop.entities.Goods;
import com.freimanvs.shops.eshop.entities.Order;
import com.freimanvs.shops.eshop.entities.Role;
import com.freimanvs.shops.eshop.entities.User;
import com.freimanvs.shops.eshop.services.interfaces.UserService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/test")
public class DaoTestServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @EJB
    private GoodsDAO goodsDAO;

    @EJB
    private OrderDAO orderDAO;

    @EJB
    private RoleDAO roleDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

////        User user = new User();
////        user.setLogin("login");
////        user.setPassword("pass");
////        userDAO.add(user);
//
//        Goods goods = new Goods();
//        goods.setName("goods");
//        goods.setPrice(123.00);
//        goods.setImg("product12.jpg");
//
//        Goods goods2 = new Goods();
//        goods2.setName("goods2");
//        goods2.setPrice(123.00);
//        goods2.setImg("product11.jpg");
//
//        Goods goods3 = new Goods();
//        goods3.setName("goods3");
//        goods3.setPrice(123.00);
//        goods3.setImg("product10.jpg");
//
//        Goods goods4 = new Goods();
//        goods4.setName("goods4");
//        goods4.setPrice(123.00);
//        goods4.setImg("product9.jpg");
//
//        Goods goods5 = new Goods();
//        goods5.setName("goods5");
//        goods5.setPrice(123.00);
//        goods5.setImg("product8.jpg");
////
////        Set<Order> orders = new HashSet<>();
////        orders.add(orderDAO.getById(1L));
////        goods.setOrders(orders);
////
//        goodsDAO.add(goods);
//        goodsDAO.add(goods2);
//        goodsDAO.add(goods3);
//        goodsDAO.add(goods4);
//        goodsDAO.add(goods5);




//        Order order = new Order();
//        order.setName("name5");
//        order.setApartment("apartment");
//        order.setCodeEntrance("123");
//        order.setComment("asdf");
//        order.setFloor("123");
//        order.setHouseNumber("123");
//        order.setPhoneNumber("1234");
//
//        Set<Goods> goods = order.getGoods();
//        goods.add(goodsDAO.getById(2L));
//
//        order.setGoods(goods);
//        order.setStreet("street");
//        order.setUser(userDAO.getById(4L));
//        orderDAO.add(order);



//        Role role = new Role();
//        role.setName("user");
//        roleDAO.add(role);
//
//
//        User user = new User();
//        user.setLogin("aaaaa");
//        user.setPassword("bbbbb");
//
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleDAO.getById(1L));
//        user.setRoles(roles);
//
//        userService.add(user);

//        Goods goods15 = new Goods();
//        goods15.setName("goods15");
//        goods15.setPrice(123.45);
//        goods15.setImg("product12.jpg");
//        goodsDAO.add(goods15);

        List<Order> list = orderDAO.getList();
        for (int i = 1; i <= list.size(); i++) {
            orderDAO.deleteById(i);
        }
        try (PrintWriter pw = resp.getWriter()) {
            pw.println("OK");
        }
    }
}
