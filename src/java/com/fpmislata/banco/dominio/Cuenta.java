
package com.fpmislata.banco.dominio;

import java.util.Date;


public class Cuenta {

    int idCuenta;
    
    String cliente;

    double saldo;

    Date fechaCreacion;

    String sucursalBancaria;
    
    int pin;

    

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(String SucursalBancaria) {
        this.sucursalBancaria = SucursalBancaria;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
    
    
}
