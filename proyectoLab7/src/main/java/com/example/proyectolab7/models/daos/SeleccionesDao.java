package com.example.proyectolab7.models.daos;

import com.example.proyectolab7.models.beans.seleccion;
import com.example.proyectolab7.models.beans.jugador;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionesDao extends DaoBase{

    public ArrayList<seleccion> listaSelecciones() {

        ArrayList<seleccion> listaSelecciones = new ArrayList<>();

        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM seleccion");) {

            while (rs.next()) {
                seleccion seleccion = new seleccion();
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));
                seleccion.setEstadio_idEstadio(rs.getInt(4));
                listaSelecciones.add(seleccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaSelecciones;
    }

    public ArrayList<seleccion> listar() {
        ArrayList<seleccion> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * FROM seleccion";
        String url = "jdbc:mysql://localhost:3306/lab7";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                seleccion seleccion = new seleccion();
                seleccion.setIdSeleccion(rs.getInt(1));
                seleccion.setNombre(rs.getString(2));
                seleccion.setTecnico(rs.getString(3));
                seleccion.setEstadio_idEstadio(rs.getInt(4));
                lista.add(seleccion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }
}
