/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.presentacion.filter.hibernate;

import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author alumno
 */
public class HibernateFilter implements Filter{
     @Override
     public void init(FilterConfig filterConfig) throws ServletException {
     }

     @Override
     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         try {
             HibernateUtil.openSessionAndBindToThread();
             filterChain.doFilter(servletRequest, servletResponse);
         } finally {
             HibernateUtil.closeSessionAndUnbindFromThread();
         }
     }

     @Override
     public void destroy() {
     }
}
