<%
    Usuario usuarioLogueado = null;
    
    if(session.getAttribute("usuarioLogueado") != null) {
        usuarioLogueado = (Usuario)session.getAttribute("usuarioLogueado");
%>
        <%@page import="clases.Usuario"%>
<%
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <!-- Inclusion de la hoja de estilos bajada de https://bootswatch.com -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        
        <title>JSP Ajax Test</title>
    </head>
    
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">App Personas</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor01">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <a class="nav-link" href="?">Inicio <span class="sr-only">(current)</span></a>
                </li>
                <%
                    if(usuarioLogueado != null) {
                %>
                        <li class="nav-item">
                            <a class="nav-link" href="?op=usuarios">Usuarios</a>
                        </li>
                <%
                    }
                %>
              </ul>
                
              <form class="form-inline my-2 my-lg-0">
                <ul class="navbar-nav mr-auto">
                    <%
                        if(usuarioLogueado != null) {
                    %>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="perfil">
                                    <% out.print(usuarioLogueado.getNombres()); %>
                                    <span class="caret"></span></a>
                                <div class="dropdown-menu" aria-labelledby="perfil">
                                  <a id="logout" class="dropdown-item" href="#">Cerrar Sesión</a>
                                </div>
                            </li>
                    <%
                        } else {
                    %>
                            <li class="nav-item">
                              <a class="nav-link" href="?op=login">Login</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="?op=registro">Registro</a>
                            </li>
                            <%
                        }
                    %>
                </ul>
              </form>
            </div>
        </nav>
        
        <br>
        
        <!--capa con clase container con la cual se centra el contenido y se dan espacios-->
        <div class="container">
            <%
                // Opcion recibida
                String op = request.getParameter("op");

                if(op == null) {
            %>
                    <%@ include file="inicio.jsp" %>
            <%
                } else if(op.equals("usuarios") && usuarioLogueado != null) {
            %>
                    <%@ include file="usuarios.jsp" %>
            <%
                } else if(op.equals("login") && usuarioLogueado == null) {
            %>
                <%@ include file="login.jsp" %>
            <%
                } else if(op.equals("registro") && usuarioLogueado == null) {
            %>
                <%@ include file="registro.jsp" %>
            <%
                } else {
            %>
                    <%@ include file="noencontrado.jsp" %>
            <%
                }
            %>
        </div>
        
        <%@ include file="includes_js_generales.html" %>
        
        <%
            if(usuarioLogueado != null) {
        %>
        
            <script src="js/js_login.js"></script>

            <script>
                $('.dropdown-toggle').dropdown();
            </script>
        
        <%
            }
        %>
    </body>
</html>