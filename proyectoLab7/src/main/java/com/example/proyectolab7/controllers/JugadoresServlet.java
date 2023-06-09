package com.example.proyectolab7.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "JugadoresServlet", value = "/JugadoresServlet")
public class JugadoresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JobDao jobDao = new JobDao();

        String action = request.getParameter("a") == null ? "listar" : request.getParameter("a");

        switch (action) {
            case "listar":
                request.setAttribute("lista", jobDao.listar());
                request.getRequestDispatcher("jobs/lista.jsp").forward(request, response);
                break;
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
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
