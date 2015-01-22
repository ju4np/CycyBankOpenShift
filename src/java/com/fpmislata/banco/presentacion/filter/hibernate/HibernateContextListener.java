package com.fpmislata.banco.presentacion.filter.hibernate;

import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class HibernateContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        HibernateUtil.buildSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        HibernateUtil.closeSessionFactory();
    }
    
}
