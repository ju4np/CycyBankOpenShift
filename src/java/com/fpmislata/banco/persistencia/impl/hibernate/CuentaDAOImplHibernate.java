

package com.fpmislata.banco.persistencia.impl.hibernate;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.persistencia.CuentaDAO;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.GenericDAOImplHibernate;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class CuentaDAOImplHibernate extends GenericDAOImplHibernate<Cuenta, Integer> implements CuentaDAO{
    @Override
    public List<Cuenta> getCuentas(Integer idSucursalBancaria){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            Query query = session.createQuery("SELECT cuenta FROM Cuenta cuenta WHERE sucursalbancaria=?");
            query.setInteger(0, idSucursalBancaria);
            List<Cuenta> sucursalBancarias = query.list();
            if(sucursalBancarias.size()==0){
                throw new BussinessException("404","No encontradas.");
            }
            return sucursalBancarias; 
        } catch(Exception ex){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }
    public Cuenta insert(Cuenta cuenta){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            Query query = session.createQuery("SELECT MAX(cuenta.cuentaBancaria) FROM Cuenta cuenta");
            int cuentaBancaria;
            if(query.uniqueResult()==null){
                cuentaBancaria=0;
            } else {
                cuentaBancaria = (int)query.uniqueResult();
            }
            
            if(cuentaBancaria==0){
                cuentaBancaria=1;
            } else{
                cuentaBancaria = cuentaBancaria+1;
            }
            
            cuenta.setCuentaBancaria(cuentaBancaria);
            session.beginTransaction();
            session.save(cuenta);
            session.getTransaction().commit();
            
            return cuenta;
            
        }catch(Exception ex){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Cuenta getCuentaByCuentaBancaria(Integer cuentaBancaria) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try{
            Query query = session.createQuery("SELECT cuenta FROM Cuenta cuenta WHERE cuentaBancaria=?");
            query.setInteger(0, cuentaBancaria);
            
            Cuenta cuenta = (Cuenta)query.uniqueResult();
            if(cuenta==null){
                throw new BussinessException("404", "Cuenta No encontrada.");
            }
            return cuenta;
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
