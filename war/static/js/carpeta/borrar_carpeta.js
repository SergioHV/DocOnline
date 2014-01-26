
function borrarCarpeta(){
    var carpeta_borrar=$('#txt_carpeta_borrar').val();
    var parametros={
		carpeta_borrar:carpeta_borrar,
                accion:'borrar'
		}		
	$.ajax({
	  type: 'POST',
	  url: 'borrar.carpeta',
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