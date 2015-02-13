package com.fpmislata.banco.dominio;

import java.util.Date;

public class Cliente {

    int idCliente;
    String usuario;
    String contrasenya;
    String nombre;
    String dni;
    Date fechaNacimiento;

    public Cliente(int idCliente, String usuario, String contrasenya, String nombre, String dni, Date fechaNacimiento) {
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente() {

    }

    private boolean ValidarDni(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int valor;
        boolean isCorrect;

        if (this.dni.startsWith("X")) {

            valor = Integer.parseInt(this.dni.substring(1, this.dni.length() - 1));
        } else if (this.dni.startsWith("Y")) {

            valor = 10000000 + Integer.parseInt(this.dni.substring(1, this.dni.length() - 1));
        } else if (this.dni.startsWith("Z")) {

            valor = 20000000 + Integer.parseInt(this.dni.substring(1, this.dni.length() - 1));
        } else {

            valor = Integer.parseInt(this.dni.substring(0, this.dni.length() - 1));
        }

        String letraCorrecta = "" + letras.charAt(valor % 23);

        if (this.dni.endsWith(letraCorrecta) == true) {
            isCorrect = true;
        } else {
            isCorrect = false;
        }
        return isCorrect;

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
