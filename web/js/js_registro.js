$('#frmRegistro').submit(function(event) {
    event.preventDefault();
    registroUsuario();
});

$('#txtEmail').on('blur', function() {
    console.log('Email3:', $(this).val());
});

function registroUsuario() {
    let nombres              = $('#txtNombres').val();
    let apellidos            = $('#txtApellidos').val();
    let email                = $('#txtEmail').val();
    let contrasenia          = $('#txtContrasenia').val();
    let confirmarContrasenia = $('#txtConfirmarContrasenia').val();
    
    if(contrasenia !== confirmarContrasenia) {
        $('#resultado-msg').html(
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
            beforeSend() {
                $('#cargador-registrar-usuario').show();
            },
            success: function( resultado ) {
                
                let msj;
                if(resultado > 0) {
                    msj = ""+ 
                    "<div class=\"alert alert-dismissible alert-success\">\n" +
                    "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                    "   <strong>Confirmación!</strong> El usuario se ha registrado con Exito.\n" +
                    "</div>"; 
                } else {
                    msj = ""+
                    "<div class=\"alert alert-dismissible alert-danger\">\n" +
                    "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                    "   <strong>Error!</strong> EL usuario no pudo ser registrado.\n" +
                    "</div>"; 
                }
                
                $('#resultado-msg').html(msj);
                
                $('#cargador-registrar-usuario').hide();

                $('#txtNombres').val('');
                $('#txtApellidos').val('');
                $('#txtEmail').val('');
                $('#txtContrasenia').val('');
                $('#txtConfirmarContrasenia').val('');
            }
        });
    }
}