package com.example.proyectolab7.models.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.example.proyectolab7.models.beans.estadio;

public class EstadioDao extends DaoBase{

    public ArrayList<estadio> lista() {

        ArrayList<estadio> list = new ArrayList<>();
        try (Connection conn = getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM estadio;")) {

            while (rs.next()) {
                estadio estadio = new estadio();
                estadio.setIdEstadio(rs.getInt(1));
                estadio.setNombre(rs.getString(2));
                list.add(estadio);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return list;
    }

}
