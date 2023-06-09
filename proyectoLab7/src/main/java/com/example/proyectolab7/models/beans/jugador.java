package com.example.proyectolab7.models.beans;

public class jugador {
    private int idJugador;
    private String nombre;
    private int edad;
    private String posicion;
    private String club;
    private int idSeleccion;
    private String nameSeleccion;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNameSeleccion() {
        return nameSeleccion;
    }

    public void setNameSeleccion(String nameSeleccion) {
        this.nameSeleccion = nameSeleccion;
    }
}
