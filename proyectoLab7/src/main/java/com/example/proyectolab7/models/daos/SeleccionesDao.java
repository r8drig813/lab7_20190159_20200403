package com.example.proyectolab7.models.daos;

import com.example.proyectolab7.models.beans.estadio;
import com.example.proyectolab7.models.beans.seleccion;
import com.example.proyectolab7.models.beans.listarSeleccion;

import com.example.proyectolab7.models.beans.jugador;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionesDao extends DaoBase{


    public ArrayList<listarSeleccion> listarSeleccion() {

        ArrayList<listarSeleccion> lista = new ArrayList<>();

        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT s.idSeleccion, s.nombre as nombrePais, s.tecnico, e.nombre,  p.fecha AS fecha_partido, concat(s.nombre,' vs ', se.nombre) AS primer_partido FROM seleccion s\n" +
                     "left join partido p ON (s.idSeleccion = p.seleccionLocal OR s.idSeleccion = p.seleccionVisitante)\n" +
                     "inner join estadio e on e.idEstadio = s.estadio_idEstadio\n" +
                     "inner JOIN seleccion se ON (CASE WHEN s.idSeleccion = p.seleccionLocal THEN se.idSeleccion = p.seleccionVisitante ELSE se.idSeleccion = p.seleccionLocal END)\n" +
                     "ORDER BY p.fecha ASC \n" +
                     "LIMIT 3;");) {

            while (rs.next()) {
                listarSeleccion listarSeleccion1 = new listarSeleccion();
                listarSeleccion1.setIdSeleccion(rs.getInt(1));
                listarSeleccion1.setNombrePais(rs.getString(2));
                listarSeleccion1.setTecnico(rs.getString(3));
                listarSeleccion1.setNombreEstadio(rs.getString( 4));
                listarSeleccion1.setFecha(rs.getDate(   5));
                listarSeleccion1.setPrimerPartido(rs.getString(6));

                lista.add(listarSeleccion1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
