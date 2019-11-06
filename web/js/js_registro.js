$('#frmRegistro').submit(function(event) {
    event.preventDefault();
    registroUsuario();
});

function registroUsuario() {
    let nombres              = $('#txtNombres').val();
    let apellidos            = $('#txtApellidos').val();
    let email                = $('#txtEmail').val();
    let contrasenia          = $('#txtContrasenia').val();
    let confirmarContrasenia = $('#txtConfirmarContrasenia').val();
    
    if(contrasenia !== confirmarContrasenia) {
        $('#resultado').html(
            "<div class=\"alert alert-dismissible alert-danger\">\n" +
            "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
            "   <strong>Error!</strong> Las contraseñas no coinciden.\n" +
            "</div>");
    } else {
        $.ajax({
            method : 'post',
            url    : "ServletRegistro",
            data   : {
              nombres     : nombres,
              apellidos   : apellidos,
              email       : email,
              contrasenia : contrasenia
            },
            success: function( resultado ) {
                $('#resultado').html(resultado);

                $('#txtNombres').val('');
                $('#txtApellidos').val('');
                $('#txtEmail').val('');
                $('#txtContrasenia').val('');
                $('#txtConfirmarContrasenia').val('');
            }
        });
    }
}