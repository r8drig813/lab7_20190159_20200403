package com.example.proyectolab7.models.beans;

import java.sql.Date;

public class listarSeleccion {
    private int idSeleccion;
    private String nombrePais;
    private String tecnico;
    private String nombreEstadio;
    private Date fecha;
    private String primerPartido;

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPrimerPartido() {
        return primerPartido;
    }

    public void setPrimerPartido(String primerPartido) {
        this.primerPartido = primerPartido;
    }
}
