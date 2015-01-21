package com.fpmislata.banco.dominio;

import com.fpmislata.banco.dominio.TipoMovimientoBancario;


public class MovimientoBancario {

    int idMovimientoBancario;

    int CuentaOrigen;

    int CuentaDestino;

    double cantidad;

    String motivo;

    private TipoMovimientoBancario tipoMovimientoBancario;

    public MovimientoBancario(int idMovimientoBancario, int CuentaOrigen, int CuentaDestino, double cantidad, String motivo, TipoMovimientoBancario tipoMovimientoBancario) {
        this.idMovimientoBancario = idMovimientoBancario;
        this.CuentaOrigen = CuentaOrigen;
        this.CuentaDestino = CuentaDestino;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.tipoMovimientoBancario = tipoMovimientoBancario;

    }
    public MovimientoBancario(){
        
    }

    public int getIdMovimientoBancario() {
        return idMovimientoBancario;
    }

    public void setIdMovimientoBancario(int idMovimientoBancario) {
        this.idMovimientoBancario = idMovimientoBancario;
    }

    public int getCuentaOrigen() {
        return CuentaOrigen;
    }

    public void setCuentaOrigen(int CuentaOrigen) {
        this.CuentaOrigen = CuentaOrigen;
    }

    public int getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(int CuentaDestino) {
        this.CuentaDestino = CuentaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the tipoMovimientoBancario
     */
    public TipoMovimientoBancario getTipoMovimientoBancario() {
        return tipoMovimientoBancario;
    }

    /**
     * @param tipoMovimientoBancario the tipoMovimientoBancario to set
     */
    public void setTipoMovimientoBancario(TipoMovimientoBancario tipoMovimientoBancario) {
        this.tipoMovimientoBancario = tipoMovimientoBancario;
    }
}
