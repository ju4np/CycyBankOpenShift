package com.fpmislata.banco.dominio.seguridad;

import com.fpmislata.banco.dominio.Empleado;

public interface EmpleadoAuthentication {
    public Empleado Authenticate(Credencial credencial);
}
