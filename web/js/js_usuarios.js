$('#frmUsuario').submit(function(event) {
    event.preventDefault();
    crearUsuario();
});

function crearUsuario() {
    let nombres              = $('#txtNombres').val();
    let apellidos            = $('#txtApellidos').val();
    let email                = $('#txtEmail').val();
    let contrasenia          = $('#txtContrasenia').val();
    let confirmarContrasenia = $('#txtConfirmarContrasenia').val();
    
    if(contrasenia !== confirmarContrasenia) {
        $('#resultado-msj').html(
        "<div class=\"alert alert-dismissible alert-danger\">\n" +
        "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
        "   <strong>Error!</strong> Las contraseñas no coinciden.\n" +
        "</div>");
    } else {
        $.ajax({
            method : 'post',
            url    : "ServletUsuario",
            data   : {
              accion      : 'crear',
              nombres     : nombres,
              apellidos   : apellidos,
              email       : email,
              contrasenia : contrasenia
            },
            beforeSend() {
                $('#cargador-crear-usuario').show();
            },
            success: function( resultado ) {
                let msj;
                if(resultado > 0) { 
                    msj = 
                    "<div class=\"alert alert-dismissible alert-success\">\n" +
                    "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                    "   <strong>Confirmación!</strong> Usuario creado con Exito.\n" +
                    "</div>";
                } else {
                    msj =
                    "<div class=\"alert alert-dismissible alert-danger\">\n" +
                    "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                    "   <strong>Error!</strong> Creando el usuario.\n" +
                    "</div>";
                }

                $('#resultado-msj').html(msj);
                listarUsuarios();
                
                $('#cargador-crear-usuario').hide();

                $('#txtNombres').val('');
                $('#txtApellidos').val('');
                $('#txtEmail').val('');
                $('#txtContrasenia').val('');
            }
        });
    }
}

function listarUsuarios() {
    $.ajax({
        method : 'post',
        url    : "ServletUsuario",
        data   : {
          accion : 'listar'
        },
        success: function( resultado ) {
            $('#resultado').html(resultado);
        }
    });
}

function editarUsuario(id) {
    console.log('id editar:', id);
    
    $.ajax({
        method : 'post',
        url    : "ServletUsuario",
        data   : {
          accion : 'editar',
          id     : id
        },
        success: function( resultado ) {
            console.log('datosUsuarioEditar:', resultado);
//            $('#resultado').html(resultado);
        }
    });
}

function eliminarUsuario(id) {
    console.log('id eliminar:', id)
}