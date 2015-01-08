/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.impl.hibernate.commons;

import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import com.fpmislata.banco.persistencia.GenericDAO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author JuanPe
 */
public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private SessionFactory sessionFactory;

    public GenericDAOImplHibernate() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T get(ID id) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            T entity = (T)session.get(getEntityClass(), id);
            session.getTransaction().commit();
        
            return entity;
        } catch(Exception ex){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public T insert(T t) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(t);
            session.beginTransaction().commit();
            
            return t;
        } catch(Exception ex){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public T update(T t) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.update(t);
            session.beginTransaction().commit();
            
            return t;
        } catch(Exception ex){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(ID id) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            T entity = (T)session.get(getEntityClass(),id);
            if(entity != null){
                session.delete(entity);
            session.getTransaction().commit();
            }
        }catch(Exception ex){
            if(session.getTransaction().isActive()){    
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        try{
            Query query = session.createQuery("SELECT entity FROM "+ getEntityClass().getName() + " entity");
            List<T> entities = query.list();
            
            return entities; 
        } catch(Exception ex){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            throw new RuntimeException();
        }
    }
    
}
