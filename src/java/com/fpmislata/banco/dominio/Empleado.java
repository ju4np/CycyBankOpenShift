
package com.fpmislata.banco.dominio;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class Empleado {
    
    int idEmpleado;
    
    @NotBlank
    @Size(min=6, max=40)
    String usuario, password, nombre;
    
    //@Pattern(regexp="\\d{9}\\D{1}")
    @NotBlank
    String dni;
    
    @NotBlank
    String sucursal;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String usuario, String password, String nombre, String dni, String sucursal) {
        this.idEmpleado = idEmpleado;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.dni = dni;
        this.sucursal = sucursal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
}
