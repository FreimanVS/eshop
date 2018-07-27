package com.freimanvs.shops.eshop.servlets;

import com.freimanvs.shops.eshop.utils.MessageSource;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/locale")
public class LocaleServlet extends HttpServlet {

    @Inject
    private MessageSource messageSource;

    private HttpSession session;
    private Locale locale;

    private void setMessage(String key) {
        session.setAttribute(key, messageSource.getMessage(key, locale));
    }

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String l = req.getParameter("l") == null ? resp.getLocale().getLanguage() : req.getParameter("l");
        switch (l) {
            case "ru":
                req.getSession().setAttribute("locale", new Locale("ru", "RU"));
                break;
            case "en":
                req.getSession().setAttribute("locale", Locale.ENGLISH);
                break;
            default:
                req.getSession().setAttribute("locale", Locale.ENGLISH);
        }

        session = req.getSession();
        locale = (Locale)session.getAttribute("locale");

        setMessage("page.header.home");
        setMessage("page.header.contact");
        setMessage("page.header.login");
        setMessage("page.header.cart");
        setMessage("page.header.search");
        setMessage("page.header.language");
        setMessage("page.header.logout");
        setMessage("page.header.admin");

        setMessage("page.footer.about.description");
        setMessage("page.footer.about.email");
        setMessage("page.footer.logo.description");
        setMessage("page.footer.about");

        setMessage("page.main.priceRange");
        setMessage("page.main.accept");

        setMessage("page.goods.featuresItems");
        setMessage("page.goods.addToCart");
        setMessage("page.goods.prev");
        setMessage("page.goods.next");
        setMessage("page.goods.name.id1");
        setMessage("page.goods.name.id2");
        setMessage("page.goods.name.id3");
        setMessage("page.goods.name.id4");
        setMessage("page.goods.name.id5");
        setMessage("page.goods.name.id6");
        setMessage("page.goods.name.id7");
        setMessage("page.goods.name.id8");
        setMessage("page.goods.name.id9");
        setMessage("page.goods.name.id10");
        setMessage("page.goods.name.id11");

        setMessage("page.cart.confirmation");

        setMessage("page.contact.getInTouch");
        setMessage("page.contact.contactInfo");
        setMessage("page.contact.name");
        setMessage("page.contact.email");
        setMessage("page.contact.subject");
        setMessage("page.contact.message");
        setMessage("page.contact.submit");

        setMessage("page.login.auth.topic");
        setMessage("page.login.auth.name");
        setMessage("page.login.auth.password");
        setMessage("page.login.auth.confirm");
        setMessage("page.login.register.topic");
        setMessage("page.login.register.name");
        setMessage("page.login.register.password");
        setMessage("page.login.register.email");
        setMessage("page.login.register.confirm");
        setMessage("page.login.or");

        setMessage("page.cart.item");
        setMessage("page.cart.price");
        setMessage("page.cart.quantity");
        setMessage("page.cart.total");
        setMessage("page.cart.to");
        setMessage("page.cart.name");
        setMessage("page.cart.phone");
        setMessage("page.cart.street");
        setMessage("page.cart.house");
        setMessage("page.cart.apartment");
        setMessage("page.cart.floor");
        setMessage("page.cart.code");
        setMessage("page.cart.comment");
        setMessage("page.cart.submit");

        setMessage("errors.noPage");
        setMessage("errors.back");
        setMessage("errors.404.description");
        setMessage("errors.403");
        setMessage("errors.badCredentials");

        String prevLink = req.getHeader("referer");
        resp.sendRedirect(prevLink);
    }
}
