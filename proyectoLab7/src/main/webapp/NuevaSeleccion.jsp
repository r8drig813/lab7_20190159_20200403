<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.proyectolab7.models.beans.estadio" %>
<%@ page import="com.example.proyectolab7.models.beans.seleccion" %>
<%@ page import="com.example.proyectolab7.models.beans.listarSeleccion" %>

<jsp:useBean id="listaSelecciones" type="java.util.ArrayList<com.example.proyectolab7.models.beans.seleccion>" scope="request"/>
<jsp:useBean id="listaEstadios" type="java.util.ArrayList<com.example.proyectolab7.models.beans.estadio>" scope="request"/>
<html>
<head>
    <title>Crear Seleccion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 class='mb-3'>Crear una nueva seleccion</h2>
    <form method="POST" action="<%=request.getContextPath()%>/SeleccionesServlet?p=guardar">
        <div class="mb-3">
            <label for="nombre">Nombre</label>
            <input type="text" class="form-control" name="nombre" id="nombre">
        </div>
        <div class="mb-3">
            <label for="tecnico">Tecnico</label>
            <input type="text" class="form-control" name="tecnico" id="tecnico">
        </div>
        <div class="mb-3">
            <label for="estadio_idEstadio">Estadio</label>
            <select class="form-select" name="estadio_idEstadio">
                <% for (estadio estadio : listaEstadios) { %>
                <option value="<%=estadio.getIdEstadio()%>">
                    <%=estadio.getNombre()%>
                </option>
                <% } %>
            </select>
        </div>
        <a class="btn btn-danger" href="<%=request.getContextPath()%>/SeleccionesServlet">Cancelar</a>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>

