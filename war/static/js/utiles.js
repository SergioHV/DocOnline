function arreglar_fecha(fecha){
    var dia_alta=fecha.substring(0,2);
    var mes_alta=fecha.substring(3,5);
    var anio_alta=fecha.substring(6,10);
    
    fecha=anio_alta+"/"+mes_alta+"/"+dia_alta;
    return fecha;
}