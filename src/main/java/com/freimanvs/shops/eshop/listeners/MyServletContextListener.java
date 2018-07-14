package com.freimanvs.shops.eshop.listeners;

import com.freimanvs.shops.eshop.utils.interfaces.InitDBBean;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.sql.*;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(MyServletContextListener.class);

    private static String IP;
    private static String URL;
    private static String LOGIN;
    private static String PASSWORD;

    @EJB
    private InitDBBean initDBBean;

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        IP = arg0.getServletContext().getInitParameter("DB_IP");
        URL = "jdbc:mysql://" + IP + ":3306/sys?useSSL=false";
        LOGIN = "root";
        PASSWORD = "pass";

        //to sleep until a database is ready
        while (!connIsOk()) {
            LOGGER.warn(String.format("DB is not ready yet or incorrect data:\r\n" +
                    "URL: %s\r\n" +
                    "LOGIN: %s\r\n" +
                    "PASSWORD: %s\r\n", URL, LOGIN, PASSWORD));
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                LOGGER.error(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }

        initDBBean.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    private static boolean connIsOk() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
        } catch (Exception e) {
            return false;
        }

        try (Connection conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT 1")) {

            StringBuilder sb = new StringBuilder();
            while(resultSet.next()){
                sb.append(resultSet.getInt("1"));
            }

            return "1".equals(sb.toString());

        } catch (SQLException e) {
            return false;
        }
    }
}