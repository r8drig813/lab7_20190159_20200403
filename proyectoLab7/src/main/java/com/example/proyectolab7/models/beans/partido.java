package com.example.proyectolab7.models.beans;

import java.sql.Date;
import java.time.LocalDate;

public class partido {
    private int idpPartido;
    private int seleccionLocal;
    private int seleccionVisitante;
    private int arbitro;
    private Date fecha;
    private int numeroJornada;



    public int getIdpPartido() {
        return idpPartido;
    }

    public void setIdpPartido(int idpPartido) {
        this.idpPartido = idpPartido;
    }

    public int getSeleccionLocal() {
        return seleccionLocal;
    }

    public void setSeleccionLocal(int seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public int getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public void setSeleccionVisitante(int seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public int getArbitro() {
        return arbitro;
    }

    public void setArbitro(int arbitro) {
        this.arbitro = arbitro;
    }



    public int getNumeroJornada() {
        return numeroJornada;
    }

    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }
}
