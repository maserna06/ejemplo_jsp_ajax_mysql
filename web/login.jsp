<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <h1 class="text-center">Login</h1>

        <div id="resultado"></div>
        
        <form id="frmLogin">
            <fieldset>
                <div class="form-group">
                    <label for="txtEmail">Email</label>
                    <input type="email" class="form-control" id="txtEmail" name="txtEmail" placeholder="Ingrese el Email" required>
                </div>
                <div class="form-group">
                    <label for="txtContrasenia">Contrseņa</label>
                    <input type="password" class="form-control" id="txtContrasenia" name="txtContrasenia" placeholder="Ingrese la contraseņa" required>
                </div>
                <button type="submit" class="btn btn-outline-success btn-block">Ingresar</button>
            </fieldset>
        </form>
    </div>
    <div class="col-md-3"></div>
</div>

<%@ include file="includes_js_generales.html" %>

<script src="js/js_login.js"></script>