
package com.fpmislata.banco.persistencia;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.dominio.Empleado;


public interface EmpleadoDAO extends GenericDAO<Empleado, Integer>{
    public Empleado getByUsuario(String Usuario)throws BussinessException;
}
