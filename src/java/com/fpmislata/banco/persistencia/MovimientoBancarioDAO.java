

package com.fpmislata.banco.persistencia;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.dominio.MovimientoBancario;
import java.util.List;


public interface MovimientoBancarioDAO extends GenericDAO<MovimientoBancario,Integer>{
    List<MovimientoBancario> getMovimientos(Integer idCuenta) throws BussinessException ;
}
