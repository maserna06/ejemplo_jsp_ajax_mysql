$('#frmUsuario').submit(function(event) {
    event.preventDefault();
    crearUsuario();
});

function crearUsuario() {
    let nombres     = $('#txtNombres').val();
    let apellidos   = $('#txtApellidos').val();
    let email       = $('#txtEmail').val();
    let contrasenia = $('#txtContrasenia').val();

    $.ajax({
        method : 'post',
        url    : "ServletUsuario",
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
        }
    });
}