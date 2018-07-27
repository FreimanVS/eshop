package com.freimanvs.shops.eshop.listeners;

import com.freimanvs.shops.eshop.utils.interfaces.InitDBBean;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @EJB
    private InitDBBean initDBBean;

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        initDBBean.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }
}