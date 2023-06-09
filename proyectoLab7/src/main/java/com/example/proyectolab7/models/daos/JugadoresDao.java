package com.example.proyectolab7.models.daos;

import com.example.proyectolab7.models.beans.jugador;
import com.example.proyectolab7.models.beans.seleccion;

import java.sql.*;
import java.util.ArrayList;

public class JugadoresDao extends DaoBase {
    public ArrayList<jugador> listaJugadores() {
        ArrayList<jugador> listaJugadores = new ArrayList<>();

        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT idJugador,jugador.nombre,edad,posicion,club,seleccion.nombre, idSeleccion FROM jugador\n" +
                     "JOIN seleccion ON jugador.sn_idSeleccion = seleccion.idSeleccion");) {

            while (rs.next()) {
                jugador player = new jugador();
                player.setIdJugador(rs.getInt(1));
                player.setNombre(rs.getString(2));
                player.setEdad(rs.getInt(3));
                player.setPosicion(rs.getString(4));
                player.setClub(rs.getString(5));
                player.setNameSeleccion(rs.getString(6));
                player.setIdSeleccion(rs.getInt(7));
                listaJugadores.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaJugadores;
    }
    public void guardarJugador(jugador jugador) throws SQLException {
        String sql = "INSERT INTO employees (nombre, edad, posicion, club, nombre, idSeleccion) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            setJugadorParams(pstmt, jugador);
            pstmt.executeUpdate();
        }
    }
    private void setJugadorParams(PreparedStatement pstmt, jugador jugador) throws SQLException {
        pstmt.setString(1, jugador.getNombre());
        pstmt.setInt(2, jugador.getEdad());
        pstmt.setInt(3, jugador.getEdad());
        pstmt.setString(4, jugador.getPosicion());
        pstmt.setString(5, jugador.getClub());
        pstmt.setInt(6, jugador.getIdSeleccion());
    }

}

