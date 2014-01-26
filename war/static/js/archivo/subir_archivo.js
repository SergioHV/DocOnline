function subirArchivo(){
    var formElement = $("[name='form_subir_archivo']")[0];
    var fd = new FormData(formElement); 
    var fileInput = $("[name='path_archivo']")[0];
    fd.append('file', fileInput.files[0] );
    fd.append('carpeta', $("#cbo_combo_carpetas").val());

    $.ajax({
      type: 'POST',
      url: 'enviar.archivo',
      data: fd,
      contentType: false,
      processData: false,
      
      success: function(fd){
          Notifier.success("Operacion realizada con exito");
        console.log(fd);
      }
   });
}

