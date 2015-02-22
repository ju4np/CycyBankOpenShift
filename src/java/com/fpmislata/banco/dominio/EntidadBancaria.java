package com.fpmislata.banco.dominio;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;


public class EntidadBancaria {

    private int idEntidadBancaria;
    
    @NotNull
    private String nombre;
    
    @NotBlank
    private String codigoEntidad;
    
    public EntidadBancaria(){
        
    }
    
    
    public EntidadBancaria(int idEntidadBancaria, String nombre, String codigoEntidad) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.nombre = nombre;
        this.codigoEntidad = codigoEntidad;
    }
    

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }
}
