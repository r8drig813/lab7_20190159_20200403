package com.example.proyectolab7.models.daos;

import com.example.proyectolab7.models.beans.jugador;
import com.example.proyectolab7.models.beans.seleccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String sql = "INSERT INTO jugador (nombre, edad, posicion, club, sn_idSeleccion)  VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            setJugadorParams(pstmt, jugador);
            pstmt.executeUpdate();
        }
    }
    private void setJugadorParams(PreparedStatement pstmt, jugador jugador) throws SQLException {
        pstmt.setString(1, jugador.getNombre());
        pstmt.setInt(2, jugador.getEdad());
        pstmt.setString(3, jugador.getPosicion());
        pstmt.setString(4, jugador.getClub());
        pstmt.setInt(5, jugador.getIdSeleccion());
    }

    public ArrayList<seleccion> listaSelecciones() {

        ArrayList<seleccion> lista = new ArrayList<>();

        String sql = "SELECT * FROM seleccion";

        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                seleccion seleccion = new seleccion();
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));
                lista.add(seleccion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JugadoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean jugadorRepetidoEnSeleccion(String nombreJugador, int idSeleccion) {
        String sql = "SELECT COUNT(*) FROM jugadores WHERE sn_idSeleccion = ? AND nombre = ?";
        int count = 0;

        try (Connection conn = getConection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSeleccion);
            stmt.setString(2, nombreJugador);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JugadoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count > 0;
    }
}

