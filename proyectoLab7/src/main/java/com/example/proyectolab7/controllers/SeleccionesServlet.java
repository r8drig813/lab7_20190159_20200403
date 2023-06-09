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
                request.getRequestDispatcher("/Selecciones.jsp").forward(request, response);
                break;
            case "agregar":

                request.setAttribute("listaSelecciones",seleccionesDao.listarSeleccion());
                request.setAttribute("listaEstadios",estadioDao.lista());
                view = request.getRequestDispatcher("/NuevaSeleccion.jsp");
                view.forward(request, response);
                break;
                /*
            case "crear":
                request.getRequestDispatcher("jobs/nuevo.jsp").forward(request, response);
                break;
            case "editar":
                String id = request.getParameter("id");
                request.setAttribute("job", jobDao.listar(id));
                request.getRequestDispatcher("jobs/editar.jsp").forward(request, response);
                break;
            case "borrar":
                String id2 = request.getParameter("id");

                jobDao.borrar(id2);
                response.sendRedirect(request.getContextPath() + "/JobServlet");
                break;*/
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
                /*
            case "a": //actualizar
                Employee employee1 = parseEmployee(request);
                employeeDao.actualizar(employee1);
                response.sendRedirect(request.getContextPath() + "/EmployeeServlet");
                break;
            case "b": //buscar
                String textoBuscar = request.getParameter("textoEnBusqueda");
                request.setAttribute("lista",employeeDao.buscarPorTitle(textoBuscar));
                request.getRequestDispatcher("employee/lista.jsp").forward(request,response);
                break;
                */
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