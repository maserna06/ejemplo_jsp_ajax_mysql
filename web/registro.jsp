<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <h1 class="text-center">Registro</h1>
        
        <div id="resultado"></div>
        
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
                    <label for="txtContrasenia">Contrse�a</label>
                    <input type="password" class="form-control" id="txtContrasenia" name="txtContrasenia" placeholder="Ingrese la contrase�a" required>
                </div>
                <div class="form-group">
                    <label for="txtConfirmarContrasenia">Confirmar Contrse�a</label>
                    <input type="password" class="form-control" id="txtConfirmarContrasenia" name="txtConfirmarContrasenia" placeholder="Confirme la contrase�a" required>
                </div>
                <button type="submit" class="btn btn-outline-success btn-block">
                    <span id="cargador-registrar-usuario" class="spinner-border spinner-border-sm" role="status" aria-hidden="true" style="display: none;"></span>
                    Registrar
                </button>
            </fieldset>
        </form>
    </div>
    <div class="col-md-3"></div>
</div>

<%@ include file="includes_js_generales.html" %>

<!-- js para la seccion personas -->
<script src="js/js_registro.js"></script>