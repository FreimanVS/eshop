package com.freimanvs.shops.eshop.servlets;

import com.freimanvs.shops.eshop.utils.interfaces.I18n;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("/locale")
public class LocaleServlet extends HttpServlet {

//    private ResourceBundle resourceBundle = ResourceBundle.getBundle("MessageResources_enus");

    @Inject
    private I18n i18n;

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Locale locale = resourceBundle.getLocale();
//        try (PrintWriter pw = resp.getWriter()) {
//            pw.println(locale);
//            pw.println(resourceBundle.getString("hello"));
//        }

//        Locale locale = req.getLocale();
        Locale ruRU = new Locale("ru", "RU");
        Locale enUS = new Locale("en", "US");

        if (req.getSession().getAttribute("locale").equals(ruRU))
            req.getSession().setAttribute("locale", enUS);
        else
            req.getSession().setAttribute("locale", ruRU);

//        resp.setLocale(enUS);
    }
}
