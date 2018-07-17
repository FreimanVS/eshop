package com.freimanvs.shops.eshop.servlets;

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

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    @Inject
    private EmailService emailService;

    private static final Logger LOGGER = Logger.getLogger(ContactServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/contact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fromName = request.getParameter("fromName");
        String fromEmail = request.getParameter("fromEmail");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        final String TO_EMAIL = "ii5557261@mail.ru";

        response.setContentType("text/html");
        try (PrintWriter pw = response.getWriter()){
            emailService.sendEmail(fromName, fromEmail, TO_EMAIL, subject, message);

            pw.println("<html>");
            pw.println("<p>The file has been sent successfully</p>");
            pw.println("<p><a href=\"" + request.getContextPath() + "/\">main page</a></p>");
            pw.println("</html>");
        } catch (Exception e) {
            LOGGER.warn(e.getLocalizedMessage());
            throw new ServletException(e);
        }
    }
}
