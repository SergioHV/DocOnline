
function buscarEmpleado(){
    var txt_nombre_empleado=$('#txt_nombre').val();
    var txt_apellido=$('#txt_apellido').val();
    var txt_dni=$('#txt_dni').val();
    $("#cuerpo_pagina").load("modulo.go?codPage=7001&nombre="+txt_nombre_empleado+"&apellido="+txt_apellido+"&dni="+txt_dni);
}

function realizarBaja(dni){
    var parametros={
		txt_dni:dni,
		accion:'baja'
	}
                
	$.ajax({
	  type: 'POST',
	  url: 'baja.empleado',
	  data: parametros,
	  success: function(response){
                if(response.substring(0,5)=='ERROR'){
                    Notifier.warning(response.substring(6));
                }else{
                    Notifier.success(response);
                }
                $("#cuerpo_pagina").load("modulo.go?codPage=7001");
	  },
	  error: function(response){
	  	Notifier.error(response);	
	  }
	}); 
}