package com.fpmislata.banco.persistencia.impl.hibernate;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.ClienteDAO;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.GenericDAOImplHibernate;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ClienteDAOImplHibernate extends GenericDAOImplHibernate<Cliente, Integer> implements ClienteDAO {

    @Override
    public Cliente getByUsuario(String usuario) throws BussinessException{
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            Query query = session.createQuery("SELECT cliente FROM Cliente cliente WHERE usuario=?");
            query.setString(0, usuario);
            List<Cliente> lista = query.list();
            Cliente cliente = lista.get(0);
            return cliente;
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
