package com.freimanvs.shops.eshop.mail.servlet;

import com.freimanvs.shops.eshop.mail.EmailService;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/newsLetters")
public class NewsLettersServlet extends HttpServlet {

    @Inject
    private EmailService emailService;

    private static final String FROM_EMAIL = "eshop@mail.ru";
    private static final String FROM_PERSON = "eshop manager";
    private static final Logger LOGGER = Logger.getLogger(EmailService.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter pw = response.getWriter()){

            String email = request.getParameter("email");

            String subject = "Eshop greetings";
            String body = "Hello!";
            body = body + "\r\nTime is: " + new Date();

            emailService.sendEmail(FROM_PERSON, FROM_EMAIL, email, subject, body);

            pw.println("<html>");
            pw.println("<p>The file has been sent to " + email + " successfully</p>");
            pw.println("<p><p><a href=\"" + request.getContextPath() + "/\">main page</a></p></p>");
            pw.println("</html>");
        } catch (Exception e) {
            LOGGER.warn(e.getLocalizedMessage());
            throw new ServletException(e);
        }
    }
}
