package com.freimanvs.shops.eshop.mail.servlet;

import com.freimanvs.shops.eshop.jasper.ReportFiller;
import com.freimanvs.shops.eshop.mail.EmailUtil;
import com.freimanvs.shops.eshop.services.interfaces.UserService;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/newsLetters")
public class NewsLettersServlet extends HttpServlet {

    @Inject
    private EmailUtil emailUtil;

    @Resource(mappedName = "jdbc/eshopMySQL")
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        try (PrintWriter pw = response.getWriter()){

            ReportFiller filler = new ReportFiller();
            filler.setDataSource(dataSource);

            String email = request.getParameter("email");

            String subject = "Eshop greetings";
            String body = "Hello!";
            body = body + "\r\nTime is: " + new Date();

            emailUtil.sendEmail(email, subject, body);

            pw.println("The file has been sent to " + email + " successfully");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
