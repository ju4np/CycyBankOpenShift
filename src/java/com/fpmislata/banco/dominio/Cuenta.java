

    package com.fpmislata.banco.dominio;

import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotBlank;


public class Cuenta {


    int idCuenta;
    
    @NotBlank
    String cliente;

    @Digits(integer=10, fraction=2)
    double saldo;

    @Past
    Date fechaCreacion;

    int sucursalBancaria;
    
    @Digits(integer=4, fraction=0)
    int pin;
    
    String cuentaBancaria;

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }


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

    public int getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(int SucursalBancaria) {
        this.sucursalBancaria = SucursalBancaria;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
    
    
}