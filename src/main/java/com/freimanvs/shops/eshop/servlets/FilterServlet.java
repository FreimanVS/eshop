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

@WebServlet("/filter")
public class FilterServlet extends HttpServlet {

    @EJB
    private SearchService searchService;

    private static final Jsonb JSONB = JsonbBuilder.create();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sliderValue = req.getParameter("sliderValue");
        String[] arr = sliderValue.split(",");
        int from = 0;
        int to = 0;
        if (arr.length >= 2) {
            from = Integer.parseInt(arr[0]);
            to = Integer.parseInt(arr[1]);
        }

        List<Goods> goods = searchService.byPrice(from, to);
        String json = JSONB.toJson(goods);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf8");

        try (PrintWriter pw = resp.getWriter()) {
            pw.println(json);
        }
    }
}
