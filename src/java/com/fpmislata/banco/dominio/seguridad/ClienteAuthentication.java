

package com.fpmislata.banco.dominio.seguridad;
import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.dominio.Cliente;


public interface ClienteAuthentication {
    public Cliente Authenticate(Credencial credencial) throws BussinessException;
}
