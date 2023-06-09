<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.proyectolab7.models.beans.jugador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<jugador> listaJugadores = (ArrayList<jugador>) request.getAttribute("listaJugadores"); %>
<html>
<head>
  <title>Lista Empleados</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
        crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Clasificatorias Sudamericanas Mundial 2026</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="#"></a>
        <a class="nav-link" href="<%=request.getContextPath()%>/JugadoresServlet">Jugadores</a>
        <a class="nav-link" href="<%=request.getContextPath()%>/SeleccionesServlet">Selecciones</a>
      </div>
    </div>
  </div>
</nav>
<div class="container">
  <div class="row mt-2 mb-3">
    <h1 class="col-10">Lista de Jugadores</h1>
    <div class="text-center">
      <a class="btn btn-success" href="<%=request.getContextPath()%>/JugadoresServlet?a=crear"><i class="bi bi-plus-circle"></i> Crear Jugador</a>
    </div>
  </div>

  <table class="table table-stripped">
    <thead>
    <tr>
      <th>Id jugador</th>
      <th>Nombre</th>
      <th>Edad</th>
      <th>Posicion</th>
      <th>Club</th>
      <th>Selección</th>
    </tr>
    </thead>
    <tbody>
    <% for (jugador j : listaJugadores) { %>
    <tr>
      <td><%=j.getIdSeleccion()%>
      </td>
      <td><%=j.getNombre() %>
      </td>
      <td><%=j.getEdad()%>
      </td>
      <td><%=j.getPosicion()%>
      </td>
      <td><%=j.getClub()%>
      </td>
      <td><%=j.getNameSeleccion()%>
      </td>
    </tr>
    <% } %>
    </tbody>
  </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>
