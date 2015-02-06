
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


public class ClienteDAOImplHibernate extends GenericDAOImplHibernate<Cliente,Integer> implements ClienteDAO{

    @Override
    public Cliente getByUsuario(String usuario) throws BussinessException{
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT cliente FROM Cliente cliente WHERE usuario=?");
        query.setString(0, usuario);
        if(query.list().size()==0){
            throw new BussinessException("404","Usuario no Encontrado.");
        }else {
            List<Cliente> lista = query.list();
            Cliente cliente = lista.get(0);
        
            return cliente;
        }
    }
    
}
