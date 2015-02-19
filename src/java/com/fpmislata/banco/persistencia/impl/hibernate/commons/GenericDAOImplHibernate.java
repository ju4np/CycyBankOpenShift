/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.impl.hibernate.commons;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import com.fpmislata.banco.persistencia.GenericDAO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID>{

    private SessionFactory sessionFactory;

    public GenericDAOImplHibernate() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T get(ID id) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            T entity = (T)session.get(getEntityClass(), id);
            session.getTransaction().commit();
        
            return entity;
        } catch (javax.validation.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //   LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //    LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //   LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //  LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public T insert(T t) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            
            return t;
        } catch (javax.validation.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //   LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //    LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //   LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //  LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public T update(T t) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            
            return t;
        } catch (javax.validation.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //   LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //    LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //   LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //  LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(ID id) throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            T entity = (T)session.get(getEntityClass(),id);
            if(entity != null){
                session.delete(entity);
            session.getTransaction().commit();
            }
        } catch (javax.validation.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //   LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //    LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //   LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //  LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<T> findAll() throws BussinessException {
        Session session = sessionFactory.getCurrentSession();
        try{
            Query query = session.createQuery("SELECT entity FROM "+ getEntityClass().getName() + " entity");
            List<T> entities = query.list();
            
            return entities; 
        } catch (javax.validation.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //   LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //    LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new BussinessException(cve);
        } catch (RuntimeException ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //   LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw ex;
        } catch (Exception ex) {
            try {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } catch (Exception exc) {
                //  LOGGER.log(Level.WARNING,"Falló al hacer un rollback", exc);
            }
            throw new RuntimeException(ex);
        }
    }
}
