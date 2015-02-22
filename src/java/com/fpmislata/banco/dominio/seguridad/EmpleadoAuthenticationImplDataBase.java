package com.fpmislata.banco.dominio.seguridad;

import com.fpmislata.banco.common.exceptions.BussinessException;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoAuthenticationImplDataBase implements EmpleadoAuthentication {

    @Autowired
    EmpleadoDAO empleadoDAO;

    @Override
    public Empleado Authenticate(Credencial credencial) throws BussinessException {
        try {
            Empleado empleado = empleadoDAO.getByUsuario(credencial.getUsuario());

            if (empleado != null) {
                //En caso de que haya un empleado
                if (!(empleado.getPassword().equals(credencial.getContrasenya()))) {
                    //En caso de que la contraseña sea distinta
                    empleado = null;
                } else {
                    //En caso de que la contraseña sea igual
                }
            } else {
                //En caso de que exista un empleado.
            }

            return empleado;
        } catch (BussinessException be) {
            throw be;
        }
    }
}
