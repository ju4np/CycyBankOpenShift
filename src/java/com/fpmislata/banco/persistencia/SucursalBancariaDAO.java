
package com.fpmislata.banco.persistencia;

import com.fpmislata.banco.dominio.SucursalBancaria;
import java.util.List;

public interface SucursalBancariaDAO extends GenericDAO<SucursalBancaria, Integer>{
    public List<SucursalBancaria> getSucursales(Integer idEntidadBancaria);
}
