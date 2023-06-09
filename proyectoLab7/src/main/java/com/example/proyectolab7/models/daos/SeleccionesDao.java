package com.example.proyectolab7.models.daos;

import com.example.proyectolab7.models.beans.estadio;
import com.example.proyectolab7.models.beans.seleccion;
import com.example.proyectolab7.models.beans.listarSeleccion;

import com.example.proyectolab7.models.beans.jugador;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionesDao extends DaoBase{

    public ArrayList<seleccion> listarSeleccionOficial() {

        ArrayList<seleccion> lista = new ArrayList<>();

        String sql = "select * from seleccion s \n" +
                "inner join estadio e on e.idEstadio = s.estadio_idEstadio;";

        try (Connection conn = getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                seleccion employee = fetchEmployeeData(rs);
                lista.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public ArrayList<listarSeleccion> listarSeleccion() {

        ArrayList<listarSeleccion> lista = new ArrayList<>();

        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select idSeleccion, nombrePais, tecnico, nombre, fecha_partido, primer_partido\n" +
                     "from (\n" +
                     "    SELECT s.idSeleccion, s.nombre AS nombrePais, s.tecnico, e.nombre, p.fecha AS fecha_partido, CONCAT(s.nombre, ' vs ', se.nombre) AS primer_partido,\n" +
                     "           row_number() over (PARTITION BY s.nombre ORDER BY p.fecha ASC) AS row_num\n" +
                     "    FROM seleccion s\n" +
                     "    left join partido p on (s.idSeleccion = p.seleccionLocal OR s.idSeleccion = p.seleccionVisitante)\n" +
                     "    left join estadio e on e.idEstadio = s.estadio_idEstadio\n" +
                     "    left join seleccion se on (case when s.idSeleccion = p.seleccionLocal then se.idSeleccion = p.seleccionVisitante else se.idSeleccion = p.seleccionLocal end)\n" +
                     "    where s.nombre is not null \n" +
                     ") as subquery\n" +
                     "where row_num = 1\n" +
                     "order by idSeleccion;");) {

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

    private seleccion fetchEmployeeData(ResultSet rs) throws SQLException {
        seleccion seleccion = new seleccion();
        seleccion.setIdSeleccion(rs.getInt(1));
        seleccion.setNombre(rs.getString(2));
        seleccion.setTecnico(rs.getString(3));


        estadio estadio = new estadio();
        estadio.setIdEstadio(Integer.parseInt(rs.getString("e.idEstadio")));
        estadio.setNombre(rs.getString(6));
        seleccion.setEstadio_idEstadio(estadio);

        return seleccion;
    }


    public void guardarSeleccion(seleccion seleccion){

        String sql = "INSERT INTO seleccion (nombre, tecnico, estadio_idEstadio) VALUES (?, ?, ?);";
        try (Connection conn = this.getConection();
            PreparedStatement pstmt = conn.prepareStatement(sql);) {

            setSeleccioData(seleccion,pstmt);
            pstmt.executeUpdate();

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private void setSeleccioData(seleccion seleccion, PreparedStatement pstmt) throws SQLException {

        pstmt.setString(1, seleccion.getNombre());
        pstmt.setString(2, seleccion.getTecnico());
        pstmt.setInt(3, seleccion.getEstadio_idEstadio().getIdEstadio());


    }

}
