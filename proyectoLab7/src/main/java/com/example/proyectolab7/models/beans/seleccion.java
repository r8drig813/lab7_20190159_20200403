package com.example.proyectolab7.models.beans;

public class seleccion {

    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private estadio estadio_idEstadio;

    public estadio getEstadio_idEstadio() {
        return estadio_idEstadio;
    }

    public void setEstadio_idEstadio(estadio estadio_idEstadio) {
        this.estadio_idEstadio = estadio_idEstadio;
    }

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }


}
