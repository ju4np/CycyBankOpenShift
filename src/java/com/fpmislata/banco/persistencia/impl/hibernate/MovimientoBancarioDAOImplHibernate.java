
package com.fpmislata.banco.persistencia.impl.hibernate;

import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.persistencia.MovimientoBancarioDAO;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.GenericDAOImplHibernate;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class MovimientoBancarioDAOImplHibernate extends GenericDAOImplHibernate<MovimientoBancario, Integer> implements MovimientoBancarioDAO{

    @Override
    public List<MovimientoBancario> getMovimientos(Integer idCuenta) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try{
        
            Query query = session.createQuery("SELECT movimientobancario FROM MovimientoBancario movimientobancario WHERE cuentaOrigen=? OR cuentaDestino=?");
            query.setInteger(0, idCuenta);
            query.setInteger(1, idCuenta);
            
            List<MovimientoBancario> lista = query.list();
            return lista;
            
        }catch(Exception ex){
            if(session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        }
    }
    
}
