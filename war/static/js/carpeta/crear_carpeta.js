function crearCarpeta(){
    var nombre_carpeta=$("#nombre_carpeta").val();
    var carpeta_padre=$("#cbo_combo_carpetas").val();
    var parametros={
		nombre_carpeta:nombre_carpeta,
		carpeta_padre:carpeta_padre,
                accion:'crear'
		}
    $.ajax({
      type: 'POST',
      url: 'crear.carpeta',
      data: parametros,
      success: function(data){
          Notifier.success("Operacion realizada con exito");
      }
   });
}
