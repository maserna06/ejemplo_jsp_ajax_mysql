<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <h1 class="text-center">Registro</h1>

        <form id="frmRegistro">
            <fieldset>
                <div class="form-group">
                    <label for="txtNombres">Nombres</label>
                    <input type="text" class="form-control" id="txtNombres" name="txtNombres" placeholder="Ingrese sus nombres" required>
                </div>
                <div class="form-group">
                    <label for="txtApellidos">Apellidos</label>
                    <input type="text" class="form-control" id="txtApellidos" name="txtApellidos" placeholder="Ingrese sus apellidos" required>
                </div>
                <div class="form-group">
                    <label for="txtEmail">email</label>
                    <input type="email" class="form-control" id="txtEmail" name="txtEmail" placeholder="Ingrese el Email" required>
                </div>
                <div class="form-group">
                    <label for="txtContrasenia">Contrseña</label>
                    <input type="password" class="form-control" id="txtContrasenia" name="txtContrasenia" placeholder="Ingrese la contraseña" required>
                </div>
                <div class="form-group">
                    <label for="txtConfirmarContrasenia">Confirmar Contrseña</label>
                    <input type="password" class="form-control" id="txtConfirmarContrasenia" name="txtConfirmarContrasenia" placeholder="Ingrese la contraseña" required>
                </div>
                <button type="submit" class="btn btn-outline-success btn-block">Registrar</button>
            </fieldset>
        </form>

        <br><br>

        <div id="resultado"></div>
    </div>
    <div class="col-md-3"></div>
</div>

<%@ include file="includes_js_generales.html" %>

<!-- js para la seccion personas -->
<script src="js/js_registro.js"></script>