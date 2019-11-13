
<div class="row">
    <div class="col-md-12">
        <h1 class="text-center">Usuarios</h1>
        <br>
    </div>
</div>

<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <div id="resultado-msj"></div>
        
        <form id="frmUsuario">
            <fieldset>
                <input type="hidden" class="form-control" id="txtId" name="txtId">
                
                <div class="form-group">
                    <label for="txtNombres">Nombres</label>
                    <input type="text" class="form-control" id="txtNombres" name="txtNombres" placeholder="Ingrese los nombres" required>
                </div>
                <div class="form-group">
                    <label for="txtApellidos">Apellidos</label>
                    <input type="text" class="form-control" id="txtApellidos" name="txtApellidos" placeholder="Ingrese los apellidos" required>
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
                <div class="form-group text-right">
                    <button type="submit" id="btn-crear-usuario" class="btn btn-outline-success">
                        <span id="cargador-crear-usuario" class="spinner-border spinner-border-sm" role="status" aria-hidden="true" style="display: none;"></span>
                        Crear
                    </button>
                    <button type="reset" id="btn-cancelar" class="btn btn-secondary">
                        Cancelar
                    </button>
                </div>
            </fieldset>
        </form>
    </div>
    <div class="col-md-3"></div>
</div>

<br><br><br>

<div class="row">
    <div class="col-md-12">
        <div id="resultado"></div>
    </div>
</div>

<%@ include file="includes_js_generales.html" %>

<!-- js para la seccion personas -->
<script src="js/js_usuarios.js"></script>

<script>
    listarUsuarios();
</script>