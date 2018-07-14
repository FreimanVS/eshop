package com.freimanvs.shops.eshop.servlets;

import com.freimanvs.shops.eshop.entities.User;
import com.freimanvs.shops.eshop.services.interfaces.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);

        userService.add(user);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
