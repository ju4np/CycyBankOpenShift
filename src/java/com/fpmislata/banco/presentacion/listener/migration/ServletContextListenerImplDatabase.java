package com.fpmislata.banco.presentacion.listener.migration;

import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ServletContextListenerImplDatabase implements ServletContextListener {

    InitialContext initialContext;
    DataSource dataSource;
 
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("*/*/*/*/*/*/*/*/*/ServletContextListener started ");
        try {
            //Ahora mismo esto no se usa            
            //Codigo para que funcione el autowired
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext());
            AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
            autowireCapableBeanFactory.autowireBean(this);
            
            //Ejecutamos los script de sql
            initialContext = new InitialContext();

            this.dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/MySQLDS");

            initialContext.close();
           
            Flyway flyway = new Flyway();
            try {
                flyway.setDataSource(dataSource);
            } catch (Exception ex) {
                this.dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/cycybank");
                flyway.setDataSource(dataSource);
            }
            flyway.setLocations("com.fpmislata.banco.persistencia.migration");
            flyway.setEncoding("utf-8");
            flyway.migrate();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("*/*/*/*/*/*/*/*/*/ServletContextListener destroyed");
    }

}
