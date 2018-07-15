package com.freimanvs.shops.eshop.servlets;

import com.freimanvs.shops.eshop.dao.interfaces.OrderDAO;
import com.freimanvs.shops.eshop.entities.Goods;
import com.freimanvs.shops.eshop.entities.Order;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    @EJB
    private OrderDAO orderDAO;

    @Inject
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String street = req.getParameter("street");
        String house = req.getParameter("house");
        String apartment = req.getParameter("apartment");
        String floor = req.getParameter("floor");
        String codeEntrance = req.getParameter("codeEntrance");
        String comment = req.getParameter("comment");
        String username = req.getUserPrincipal() == null ? "guest" : req.getUserPrincipal().getName();
        Map<Goods, Long> mapOfGoods = (Map<Goods, Long>)(req.getSession().getAttribute("mapOfGoods"));

        List<Goods> list = new ArrayList<>();
        mapOfGoods.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                list.add(key);
            }
        });

        mapOfGoods.clear();

        Order order = new Order();
        order.setName(name);
        order.setStreet(street);
        order.setPhoneNumber(phone);
        order.setHouseNumber(house);
        order.setFloor(floor);
        order.setComment(comment);
        order.setCodeEntrance(codeEntrance);
        order.setApartment(apartment);

        order.setGoods(list);

        User user = userService.getByUnique("login", username);
        order.setUser(user);

        Long id = orderDAO.add(order);



        try (PrintWriter pw = resp.getWriter()) {
            pw.println("<html>");
            pw.println("Your order id is: #" + id);
            pw.println("<br><a href=\"" + req.getContextPath() + "/" + "\">to main page</a>");
            pw.println("</html>");
        }
    }
}
