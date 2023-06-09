<%@ page import="com.example.proyectolab7.models.beans.seleccion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<seleccion> lista = (ArrayList<seleccion>) request.getAttribute("lista");
%>
<html>
<head>
    <title>Lista jobs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row mt-2 mb-3">
        <h1 class="col-10">Lista de jobs HR</h1>
        <div class="col-2">
            <a class="btn btn-success" href="<%=request.getContextPath()%>/JobServlet?a=crear">Crear trabajo</a>
        </div>
    </div>
    <div class="row">
        <div class="col-10">
            <div class="form-floating">
                <form method="post" action="<%=request.getContextPath()%>/JobServlet?p=b">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" placeholder="Buscador" name="textoBuscar">
                        <label>Buscador</label>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-2">
            <a class="btn btn-secondary" href="<%=request.getContextPath()%>/JobServlet">Limpiar</a>
        </div>
    </div>

    <table class="table table-stripped">
        <thead>
        <tr>
            <th>job title</th>
            <th>min salary</th>
            <th>max salary</th>
        </tr>
        </thead>
        <tbody>
        <% for (seleccion j : lista) { %>
        <tr>
            <td><%=j.getIdSeleccion()%>
            </td>
            <td><%=j.getNombre() %>
            </td>
            <td><%=j.getTecnico()%>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <a href="<%=request.getContextPath()%>/empleados">Ir a lista de empleados</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>
