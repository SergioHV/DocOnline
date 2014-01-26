$(document).ready(function(){
    $(function() {
        $( "#txt_fecha_nacimiento" ).datepicker({ changeYear: true, yearRange: "1950:2020"  });
      });
    
});

function altaEmpleado(){
    var txt_nombre=$('#txt_nombre').val();
    var txt_apellido=$('#txt_apellido').val();
    var txt_dni=$('#txt_dni').val();
    var txt_fecha_nacimiento=arreglar_fecha($('#txt_fecha_nacimiento').val());
    var txt_email=$('#txt_email').val();
    var txt_cargo=$('#txt_cargo').val();
    var cbo_empresas=$('#cbo_empresas').val();
    
    var mensaje="";
    if(txt_nombre==''){mensaje+='* Falta agregar el nombre \n';}
    if(txt_apellido==''){mensaje+='* Falta agregar el apellido \n';}
    if(txt_dni==''){mensaje+='* Falta agregar el dni \n';}
    if(txt_fecha_nacimiento==''){mensaje+='* Falta agregar la fecha de nacimiento \n';}
    if(txt_email==''){mensaje+='* Falta agregar el email \n';}
    if(txt_cargo==''){mensaje+='* Falta agregar el cargo \n';}
    if(cbo_empresas==''){mensaje+='* Falta agregar la empresa a la que pertenece el empleado \n';}
    
    if(mensaje!=''){
        alert(mensaje);
        return false;
    }
    
    
    var parametros={
		txt_nombre:txt_nombre,
		txt_apellido:txt_apellido,
		txt_dni:txt_dni,
		txt_fecha_nacimiento:txt_fecha_nacimiento,
		txt_email:txt_email,
		txt_cargo:txt_cargo,
		cbo_empresas:cbo_empresas,
		accion:'alta'
	}
                
	$.ajax({
	  type: 'POST',
	  url: 'alta.empleado',
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
