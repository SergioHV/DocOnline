
function compartirArchivo(){
    var nombre_archivo=$('#txt_archivo_compartir').val();
    var email=$('#txt_email').val();
    
    var parametros={
		nombre_archivo:nombre_archivo,
                email:email,
		accion:'compartir'
		}		
	$.ajax({
	  type: 'POST',
	  url: 'compartir.archivo',
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