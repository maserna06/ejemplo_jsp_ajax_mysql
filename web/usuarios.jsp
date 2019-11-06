<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <h1>Usuarios</h1>

        <!--Formulario de captura de datos-->
        <form id="frmUsuario">
            <div class="form-group">
                <label for="txtNombres">Nombres</label>
                <input type="text" class="form-control" id="txtNombres" name="txtNombres" required>
            </div>

            <div class="form-group">
                <label for="txtApellidos">Apellidos</label>
                <input type="text" class="form-control" id="txtApellidos" name="txtApellidos" required>
            </div>
            
            <div class="form-group">
                <label for="txtEmail">Email</label>
                <input type="email" class="form-control" id="txtEmail" name="txtEmail" required>
            </div>
            
            <div class="form-group">
                <label for="txtContrasenia">Contraseña</label>
                <input type="text" class="form-control" id="txtContrasenia" name="txtContrasenia" required>
            </div>

            <button type="submit" class="btn btn-primary btn-block">Crear</button>
        </form>

        <br><br>

        <!--div donde se muestran los resultados obtenidos con ajax-->
        <div id="resultado"></div>
    </div>
    <div class="col-md-3"></div>
</div>

<%@ include file="includes_js_generales.html" %>

<!-- js para la seccion personas -->
<script src="js/js_usuarios.js"></script>