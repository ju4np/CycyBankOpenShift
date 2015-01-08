
package com.fpmislata.banco.presentacion.listener.hibernate;


import static com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil.buildSessionFactory;
import static com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil.closeSessionFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextLisenerImplHibernate implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        buildSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        closeSessionFactory();
    }

}
