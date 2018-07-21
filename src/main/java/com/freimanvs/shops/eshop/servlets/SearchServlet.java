package com.freimanvs.shops.eshop.servlets;

import com.freimanvs.shops.eshop.entities.Goods;
import com.freimanvs.shops.eshop.services.interfaces.SearchService;
import com.freimanvs.shops.eshop.utils.MessageSource;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @EJB
    private SearchService searchService;

    @Inject
    private MessageSource messageSource;

    private static final Jsonb JSONB = JsonbBuilder.create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String q = req.getParameter("q");

        Locale sessionLocale = (Locale)req.getSession().getAttribute("locale");
        Locale locale = sessionLocale != null ? sessionLocale : resp.getLocale();

        Enumeration<String> keys = messageSource.getKeys(locale);
        List<String> listOfKeys = new ArrayList<>();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = messageSource.getMessage(key, locale);

            if (value.contains(q) && key.contains("page.goods.name")) {
                listOfKeys.add(key.replaceAll("[.]{1}", "_"));

            }
        }

        List<Goods> resultList = new ArrayList<>();
        for (String key : listOfKeys) {
            List<Goods> curList = searchService.find(key);
            resultList.addAll(curList);
        }

        String json = JSONB.toJson(resultList);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf8");

        try (PrintWriter pw = resp.getWriter()) {
            pw.println(json);
        }
    }
}
