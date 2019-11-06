<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <h1>Personas</h1>

        <!--Formulario de captura de datos-->
        <form id="frmPersona">
            <div class="form-group">
                <label for="txtNombres">Nombres</label>
                <input type="text" class="form-control" id="txtNombres" name="txtNombres" required>
            </div>

            <div class="form-group">
                <label for="txtApellidos">Apellidos</label>
            <input type="text" class="form-control" id="txtApellidos" name="txtApellidos" required>
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
<script src="js/js_personas.js"></script>

<script>
    datosPersonas();
</script>