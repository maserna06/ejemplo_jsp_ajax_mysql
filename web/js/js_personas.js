//$(function() {
    // indicar con jquery que se esta usando el evento submit del formulario
    $('#frmPersona').submit(function(event) {
        // prevenir que el formulario recargue la pagina
        event.preventDefault();

        datosPersonas();
    });

    function datosPersonas() {
        console.log('Datos Personas');

        // capturar los valores de los campos de texto
        let nombres = $('#txtNombres').val();
        let apellidos = $('#txtApellidos').val();
        
        // usar ajax para obtener el resultado de la operacion que se hace el ServletPersona
        $.ajax({
            method: 'post',
            url: "ServletPersona", // url del archivo donde se procesa la peticion ajax
            data: { // parametros que enviamos
              nombres : nombres,
              apellidos : apellidos
            },
            success: function( result ) {
              console.log('result:', result);
              // mostrar el resultado en el div con id resultado
              $('#resultado').html(result);

              // limpiar los campos
              $('#txtNombres').val('');
              $('#txtApellidos').val('');
            }
        });
    }
//});