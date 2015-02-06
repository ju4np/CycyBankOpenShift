package com.fpmislata.banco.persistencia;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.dominio.Cuenta;
import java.util.List;

public interface CuentaDAO  extends GenericDAO<Cuenta,Integer>{
    public List<Cuenta> getCuentas(Integer idSucursalBancaria) throws BussinessException;
    public Cuenta getCuentaByCuentaBancaria(Integer cuentaBancaria) throws BussinessException;
}
