
function borrarArchivo(){
    var nombre_archivo=$('#txt_archivo_borrar').val();
    var parametros={
		nombre_archivo:nombre_archivo,
		accion:'borrar'
		}		
	$.ajax({
	  type: 'POST',
	  url: 'borrar.archivo',
	  data: parametros,
	  success: function(response){
                if(response.substring(0,5)=='ERROR'){
                    Notifier.warning(response.substring(6));
                }else{
                    Notifier.success(response);
                }
	  },
	  error: function(response){
	  	Notifier.error(response);	
	  }
	});
}
