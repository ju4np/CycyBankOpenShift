/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.persistencia.impl.hibernate;

import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.persistencia.CuentaDAO;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.GenericDAOImplHibernate;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alumno
 */
public class CuentaDAOImplHibernate extends GenericDAOImplHibernate<Cuenta, Integer> implements CuentaDAO{
            @Override
        public List<Cuenta> getCuentas(Integer idSucursalBancaria){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            Query query = session.createQuery("SELECT cuenta FROM Cuenta cuenta WHERE sucursalbancaria=?");
            query.setInteger(0, idSucursalBancaria);
            List<Cuenta> sucursalBancarias = query.list();
            
            return sucursalBancarias; 
        } catch(Exception ex){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }
}
