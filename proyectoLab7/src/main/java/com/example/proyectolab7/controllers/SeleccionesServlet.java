package com.example.proyectolab7.controllers;

import com.example.proyectolab7.models.beans.jugador;
import com.example.proyectolab7.models.beans.seleccion;
import com.example.proyectolab7.models.beans.estadio;
import com.example.proyectolab7.models.daos.EstadioDao;
import com.example.proyectolab7.models.daos.JugadoresDao;
import com.example.proyectolab7.models.daos.SeleccionesDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SeleccionesServlet", value = "/SeleccionesServlet")
public class SeleccionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher view;
        SeleccionesDao seleccionesDao = new SeleccionesDao();
        EstadioDao estadioDao = new EstadioDao();
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");

        switch (action) {
            case "listar":

                request.setAttribute("lista",seleccionesDao.listarSeleccion());
                request.getRequestDispatcher("Selecciones.jsp").forward(request, response);
                break;
            case "agregar":

                request.setAttribute("listaSelecciones",seleccionesDao.listarSeleccion());
                request.setAttribute("listaEstadios",estadioDao.lista());
                view = request.getRequestDispatcher("NuevaSeleccion.jsp");
                view.forward(request, response);
                break;
            case "borrar":
                if (request.getParameter("id") != null) {
                    String seleccionidString = request.getParameter("id");
                    int idSeleccion = 0;
                    try {
                        idSeleccion = Integer.parseInt(seleccionidString);
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("SeleccionesServlet");
                    }

                    seleccion sel = seleccionesDao.obtenerSeleccion(idSeleccion);

                    if (sel != null) {
                        seleccionesDao.borrarSeleccion(idSeleccion);
                    }
                }
                response.sendRedirect("SeleccionesServlet");
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("p") == null ? "guardar": request.getParameter("p");

        SeleccionesDao seleccionesDao = new SeleccionesDao();
        seleccion seleccion = setSeleccionData(request);

        switch (action){
            case "guardar":
                seleccionesDao.guardarSeleccion(seleccion);
                response.sendRedirect("SeleccionesServlet");
                break;
        }
    }

    public seleccion setSeleccionData(HttpServletRequest request){

        seleccion seleccion = new seleccion();
        seleccion.setNombre(request.getParameter("nombre"));
        seleccion.setTecnico(request.getParameter("tecnico"));

        estadio estadio = new estadio();
        estadio.setIdEstadio(Integer.parseInt(request.getParameter("estadio_idEstadio")));
        seleccion.setEstadio_idEstadio(estadio);
        return seleccion;
    }
}