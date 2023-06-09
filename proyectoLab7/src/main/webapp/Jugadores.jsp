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
    <!--div class="col-2">
      <a class="btn btn-success" href="<%=request.getContextPath()%>/EmployeeServlet?a=crear">Crear
        Empleado</a>
    </div-->
  </div>
  <!--div class="row">
    <div class="col-10">
      <div class="form-floating">
        <form method="post" action="<%=request.getContextPath()%>/EmployeeServlet?p=b">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" placeholder="Buscador" name="textoBuscar">
            <label>Buscador</label>
          </div>
        </form>
      </div>
    </div>
    <div class="col-2">
      <a class="btn btn-secondary" href="<%=request.getContextPath()%>/EmployeeServlet">Limpiar</a>
    </div>
  </div-->

  <table class="table">
    <thead>
    <tr>
      <th> Id de Jugador</th>
      <th>Nombre</th>
      <th>Edad</th>
      <th>Posicion</th>
      <th>Club</th>
      <th>Id de Seleccion</th>
    </tr>
    </thead>
    <tbody>
    <% for (jugador jugador : listaJugadores) { %>
    <tr>
      <td><%=jugador.getIdJugador() %>
      </td>
      <td><%=jugador.getNombre() %>
      </td>
      <td><%=jugador.getEdad()%>
      </td>
      <td><%=jugador.getPosicion()%>
      </td>
      <td><%=jugador.getClub()%>
      </td>
      <td><%=jugador.getIdSeleccion()%>
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
