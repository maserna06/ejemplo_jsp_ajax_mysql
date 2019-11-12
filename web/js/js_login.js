$('#frmLogin').submit(function(event) {
    event.preventDefault();

    login();
});

function login() {
    let email       = $('#txtEmail').val();
    let contrasenia = $('#txtContrasenia').val();

    $.ajax({
        method : 'post',
        url    : "ServletLogin",
        data   : {
          accion      : 'login',
          email       : email,
          contrasenia : contrasenia
        },
        success: function( resultado ) {
          if(resultado > 0) {
            location.href = "?";
          } else {
            $( '#resultado').html(
            '<div class="alert alert-dismissible alert-danger">'+
                '<button type="button" class="close" data-dismiss="alert">&times;</button>'+
                '<strong>Error!</strong> Email o Contraseña incorrectos.'+
            '</div>');
          }
        }
    });
}

$('#logout').click(function(event) {
    event.preventDefault();
    
    logout();
});

function logout() {
    if(confirm("ESTA SEGURO QUE CERRAR SESIÓN?")) {
        $.ajax({
            method : 'post',
            url    : "ServletLogin",
            data   : {
              accion : 'logout'
            },
            success: function( resultado ) {
                if(resultado > 0) {
                    location.href = "?";
                }
            }
        });
    }
}