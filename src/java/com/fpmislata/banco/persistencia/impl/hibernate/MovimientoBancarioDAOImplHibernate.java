
package com.fpmislata.banco.persistencia.impl.hibernate;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.dominio.TipoMovimientoBancario;
import com.fpmislata.banco.persistencia.MovimientoBancarioDAO;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.GenericDAOImplHibernate;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class MovimientoBancarioDAOImplHibernate extends GenericDAOImplHibernate<MovimientoBancario, Integer> implements MovimientoBancarioDAO{

    @Override
    public List<MovimientoBancario> getMovimientos(Integer idCuenta) throws BussinessException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        try{
        
            Query query = session.createQuery("SELECT movimientobancario FROM MovimientoBancario movimientobancario WHERE cuentaOrigen=? OR cuentaDestino=?");
            query.setInteger(0, idCuenta);
            query.setInteger(1, idCuenta);
            
            List<MovimientoBancario> lista = query.list();
            return lista;
            
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
    public MovimientoBancario insert(MovimientoBancario movimientoBancario) throws BussinessException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            this.updateSaldo(movimientoBancario);
            
            session.beginTransaction();
            session.save(movimientoBancario);
            session.getTransaction().commit();
            return movimientoBancario;
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
  
    private void updateSaldo(MovimientoBancario movimientoBancario)throws BussinessException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            Query query;
        
            if(movimientoBancario.getTipoMovimientoBancario()==TipoMovimientoBancario.DEBE){
                query = session.createQuery("UPDATE Cuenta cuenta SET cuenta.saldo=cuenta.saldo-? WHERE cuenta.idCuenta=?");
            } else {
                query = session.createQuery("UPDATE Cuenta cuenta SET cuenta.saldo=cuenta.saldo+? WHERE cuenta.idCuenta=?");
            }
            
            query.setDouble(0, movimientoBancario.getCantidad());
            query.setInteger(1, movimientoBancario.getCuentaOrigen());
            
            session.beginTransaction();
            query.executeUpdate();
            session.getTransaction().commit();
            
        
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
