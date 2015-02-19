

package com.fpmislata.banco.dominio;

import javax.validation.constraints.Digits;
import org.hibernate.validator.constraints.NotBlank;

public class Transaccion {
    int cuentaOrigen;
    
    int cuentaDestino;
    
    @Digits(integer=4, fraction=0)
    int pin;
    
    @Digits(integer=10, fraction=2)
    double cantidad;
    
    @NotBlank
    String concepto;

    public Transaccion(int cuentaOrigen, int cuentaDestino, int pin, double cantidad, String concepto) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.pin = pin;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public Transaccion() {
    }

    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public int getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(int cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    
}