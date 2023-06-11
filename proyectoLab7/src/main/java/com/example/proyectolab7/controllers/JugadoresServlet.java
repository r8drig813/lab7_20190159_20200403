package com.example.proyectolab7.controllers;

import com.example.proyectolab7.models.beans.jugador;
import com.example.proyectolab7.models.daos.JugadoresDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "JugadoresServlet", value = "/JugadoresServlet")
public class JugadoresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JugadoresDao jugadoresDao = new JugadoresDao();
        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        switch (action) {
            case "listar":
                request.setAttribute("listaJugadores", jugadoresDao.listaJugadores());
                request.getRequestDispatcher("/Jugadores.jsp").forward(request, response);
                break;
            case "crear":
                request.setAttribute("listaSelecciones", jugadoresDao.listaSelecciones());
                request.getRequestDispatcher("/NuevoJugador.jsp").forward(request, response);
                break;
        }/*

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");
        switch (action) {
            case "listar":
                request.setAttribute("listaJugadores", jugadoresDao.listaJugadores());
                request.getRequestDispatcher("/Jugadores.jsp").forward(request, response);
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
       /* }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("p") == null ? "crear": request.getParameter("p");
        JugadoresDao jugadoresDao = new JugadoresDao();
        switch (action){
            case "crear":
                jugador jugador = parseJugador(request);
                try{
                    jugadoresDao.guardarJugador(jugador);
                    response.sendRedirect(request.getContextPath() + "/JugadoresServlet");
                }catch (SQLException ex){
                    System.out.println("Existe un error");
                }
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

    public jugador parseJugador(HttpServletRequest request){
        jugador jugador = new jugador();
        JugadoresDao jugadoresDao = new JugadoresDao();
        String name = request.getParameter("name");
        String edad = request.getParameter("edad");
        String posicion = request.getParameter("posicion");
        String club = request.getParameter("club");
        String seleccion = request.getParameter("seleccion");

        if (name.isEmpty() || edad.isEmpty() || posicion.isEmpty() || club.isEmpty() || seleccion.isEmpty()) {
            // Hay algun casillero vacio
        }
        try {
            jugador.setNombre(name);
            jugador.setEdad(Integer.parseInt(edad));
            jugador.setPosicion(posicion);
            jugador.setClub(club);
            jugador.setIdSeleccion(Integer.parseInt(seleccion));
        } catch (NumberFormatException e) {
            //Se valida el parseo
        }
        // Validar que el nombre del jugador no se repita en una misma selección
        if (jugadoresDao.jugadorRepetidoEnSeleccion(jugador.getNombre(), jugador.getIdSeleccion())) {
            // El nombre del jugador ya existe en esta selección
        }
        return jugador;

    }
}
