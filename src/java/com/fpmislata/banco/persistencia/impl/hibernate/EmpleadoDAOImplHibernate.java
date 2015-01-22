package com.fpmislata.banco.persistencia.impl.hibernate;

import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.EmpleadoDAO;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.GenericDAOImplHibernate;
import com.fpmislata.banco.persistencia.impl.hibernate.commons.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class EmpleadoDAOImplHibernate extends GenericDAOImplHibernate<Empleado,Integer> implements EmpleadoDAO{
    @Override
    public Empleado getByUsuario(String usuario){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        
        Query query = session.createQuery("SELECT empleado FROM Empleado empleado WHERE usuario=?");
        query.setString(0, usuario);
        List<Empleado> lista = query.list();
        Empleado empleado;
        if(!lista.isEmpty()){
            empleado = lista.get(0);
        } else {
            empleado = null;
        }
        
        return empleado;
    }
}
