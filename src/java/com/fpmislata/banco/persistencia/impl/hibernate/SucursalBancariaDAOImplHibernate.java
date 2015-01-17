
package com.fpmislata.banco.persistencia.impl.hibernate;

import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.SucursalBancariaDAO;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.GenericDAOImplHibernate;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class SucursalBancariaDAOImplHibernate extends GenericDAOImplHibernate<SucursalBancaria, Integer> implements SucursalBancariaDAO{
    
    @Override
    public List<SucursalBancaria> getSucursales(Integer idEntidadBancaria){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            Query query = session.createQuery("SELECT sucursalBancaria FROM SucursalBancaria sucursalBancaria WHERE entidadBancaria=?");
            query.setInteger(0, idEntidadBancaria);
            List<SucursalBancaria> sucursalBancarias = query.list();
            
            return sucursalBancarias; 
        } catch(Exception ex){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }
    
}
