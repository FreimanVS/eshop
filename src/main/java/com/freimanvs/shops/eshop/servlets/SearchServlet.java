package com.freimanvs.shops.eshop.servlets;

import com.freimanvs.shops.eshop.entities.Goods;
import com.freimanvs.shops.eshop.services.interfaces.SearchService;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @EJB
    private SearchService searchService;

    private static final Jsonb JSONB = JsonbBuilder.create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> goods = searchService.find(req.getParameter("q"));
        String json = JSONB.toJson(goods);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf8");

        try (PrintWriter pw = resp.getWriter()) {
            pw.println(json);
        }

//        req.setAttribute("goods", goods);
//        req.getRequestDispatcher("/eshop/search.jsp").forward(req, resp);
    }
}
