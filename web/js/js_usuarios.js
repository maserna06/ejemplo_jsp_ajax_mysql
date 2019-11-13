$('#frmUsuario').submit(function(event) {
    event.preventDefault();
    crearUsuario();
});

$('#btn-cancelar').click(function() {
    if($('#btn-crear-usuario').text() === 'Actualizar') {
        $('#btn-crear-usuario').text('Crear');
    }
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
        if($('#btn-crear-usuario').text().trim() === 'Crear') {
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
                    $('#txtConfirmarContrasenia').val('');
                }
            });
        } else {
            $.ajax({
                method : 'post',
                url    : "ServletUsuario",
                data   : {
                  accion      : 'actualizar',
                  id          : $('#txtId').val(),
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
                        "   <strong>Confirmación!</strong> Usuario actualizado con Exito.\n" +
                        "</div>";
                    } else {
                        msj =
                        "<div class=\"alert alert-dismissible alert-danger\">\n" +
                        "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                        "   <strong>Error!</strong> Actualizando el usuario.\n" +
                        "</div>";
                    }

                    $('#resultado-msj').html(msj);
                    listarUsuarios();
                    
                    $('#btn-crear-usuario').text('Crear');

                    $('#cargador-crear-usuario').hide();
                    
                    $('#txtId').val('');
                    $('#txtNombres').val('');
                    $('#txtApellidos').val('');
                    $('#txtEmail').val('');
                    $('#txtContrasenia').val('');
                    $('#txtConfirmarContrasenia').val('');
                }
            });  
        }
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

function datosUsuarioEditar(id) {
    $.ajax({
        method : 'post',
        url    : "ServletUsuario",
        data   : {
          accion : 'datosUsuarioEditar',
          id     : id
        },
        success: function( resultado ) {
            $('#txtId').val(resultado.id);
            $('#txtNombres').val(resultado.nombres);
            $('#txtApellidos').val(resultado.apellidos);
            $('#txtEmail').val(resultado.email);
            $('#txtContrasenia').val(resultado.contrasenia);
            $('#txtConfirmarContrasenia').val(resultado.contrasenia);
            $('#btn-crear-usuario').text('Actualizar');
        }
    });
}

function eliminarUsuario(id) {
    if(confirm('Esta seguro de eliminar el usuario con id: ' + id + '?')) {
        $.ajax({
        method : 'post',
        url    : "ServletUsuario",
        data   : {
          accion : 'eliminarUsuario',
          id     : id
        },
        success: function( resultado ) {
            let msj;
            if(resultado > 0) { 
                msj = 
                "<div class=\"alert alert-dismissible alert-success\">\n" +
                "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                "   <strong>Confirmación!</strong> Usuario eliminado con Exito.\n" +
                "</div>";
            } else {
                msj =
                "<div class=\"alert alert-dismissible alert-danger\">\n" +
                "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\">&times;</button>\n" +
                "   <strong>Error!</strong> Eliminando el usuario.\n" +
                "</div>";
            }

            $('#resultado-msj').html(msj);
            listarUsuarios();
        }
    });
    }
}