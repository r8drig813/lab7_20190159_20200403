<%@ page import="com.example.proyectolab7.models.beans.seleccion" %>
<%@ page import="com.example.proyectolab7.models.beans.listarSeleccion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<listarSeleccion> lista = (ArrayList<listarSeleccion>) request.getAttribute("lista");
%>
<html>
<head>
    <title>Lista Selecciones</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
    <jsp:include page="/navbar.jsp">
        <jsp:param name="currentPage" value="emp"/>
    </jsp:include>
    <div class="row mt-2 mb-3">
        <h1 class="col-10">Lista de Seleccciones</h1>
        <div class="text-center">
            <a class="btn btn-success" href="<%=request.getContextPath()%>/SeleccionesServlet?a=agregar"><i class="bi bi-plus-circle"></i> Registrar Selecciones</a>
        </div>
    </div>


    <table class="table table-stripped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Seleccion</th>
            <th>Tecnico</th>
            <th>Estadio</th>
            <th>Primer Partido</th>
            <th>Borrar</th>
        </tr>
        </thead>
        <tbody>
        <% for (listarSeleccion j : lista) { %>
        <tr>
            <td><%=j.getIdSeleccion()%>
            </td>
            <td><%=j.getNombrePais() %>
            </td>
            <td><%=j.getTecnico()%>
            </td>
            <td><%=j.getNombreEstadio()%>
            </td>
            <td><%=j.getPrimerPartido()%>
            </td>
            <td>
                <a class="btn btn-danger"
                   href="<%=request.getContextPath()%>/SeleccionesServlet?a=borrar&id=<%=j.getIdSeleccion()%>">
                    <i class="bi bi-trash3"></i>
                </a>
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
