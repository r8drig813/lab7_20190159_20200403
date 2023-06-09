<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Jugador</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 class='mb-3'>Crear un nuevo jugador</h2>
    <form method="POST" action="<%=request.getContextPath()%>/JugadoresServlet?p=crear">
        <div class="mb-3">
            <label for="name">Nombre</label>
            <input type="text" class="form-control" name="name" id="name">
        </div>
        <div class="mb-3">
            <label for="edad">Edad</label>
            <input type="text" class="form-control" name="edad" id="edad">
        </div>
        <div class="mb-3">
            <label for="posicion">Posición</label>
            <input type="text" class="form-control" name="posicion" id="posicion">
        </div>
        <div class="mb-3">
            <label for="club">Club</label>
            <input type="text" class="form-control" name="club" id="club">
        </div>
        <div class="mb-3">
            <label for="seleccion">Selección</label>
            <input type="text" class="form-control" name="seleccion" id="seleccion">
        </div>
        <a class="btn btn-danger" href="<%=request.getContextPath()%>/JugadoresServlet">Cancelar</a>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>

