package com.freimanvs.shops.eshop.servlets;

import com.freimanvs.shops.eshop.utils.MessageSource;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {

    @Inject
    private MessageSource messageSource;

    private HttpSession session;
    private Locale locale;

    private void setMessage(String key) {
        session.setAttribute(key, messageSource.getMessage(key, locale));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.session = req.getSession();
//        this.session.setAttribute("locale", resp.getLocale());
//        locale = (Locale) this.session.getAttribute("locale");

        locale = this.session.getAttribute("locale") == null ? resp.getLocale() : (Locale)req.getSession().getAttribute("locale");
        setMessage("page.header.home");
        setMessage("page.header.contact");
        setMessage("page.header.login");
        setMessage("page.header.cart");
        setMessage("page.header.search");
        setMessage("page.footer.about.description");
        setMessage("page.footer.about.email");
        setMessage("page.footer.logo.description");
        setMessage("page.footer.about");
    }
}
