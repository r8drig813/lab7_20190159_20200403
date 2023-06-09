package com.example.proyectolab7.models.daos;

import com.example.proyectolab7.models.beans.jugador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JugadoresDao extends DaoBase {
    public ArrayList<jugador> listaJugadores() {
        ArrayList<jugador> listaJugadores = new ArrayList<>();

        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM jugador");) {

            while (rs.next()) {
                jugador jugador = new jugador();
                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                jugador.setEdad(rs.getInt(3));
                jugador.setPosicion(rs.getString(4));
                jugador.setClub(rs.getString(5));
                jugador.setIdSeleccion(rs.getInt(6));
                listaJugadores.add(jugador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaJugadores;
    }
}
