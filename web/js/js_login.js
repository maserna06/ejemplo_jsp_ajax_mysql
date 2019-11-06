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
          email       : email,
          contrasenia : contrasenia
        },
        success: function( result ) {
          $('#resultado').html(result);
        }
    });
}