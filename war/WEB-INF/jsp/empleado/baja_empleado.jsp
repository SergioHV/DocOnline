<script type="text/javascript" src="static/js/empleado/baja_empleado.js"></script>
<%
String apellido=request.getParameter("apellido");
if(apellido==null){
    apellido="";
}
String nombre=request.getParameter("nombre");
if(nombre==null){
    nombre="";
}
String dni=request.getParameter("dni");
if(dni==null){
    dni="";
}
%>


<br>
<h4 align="center">Baja Empleado</h4>
<br>
<br>
<table align="center">
    <tr>
        <td><input type="text" id="txt_nombre" placeholder="nombre empleado"></td>
        <td><input type="text" id="txt_apellido" placeholder="apellido empleado"></td> 
        <td><input type="text" id="txt_dni" placeholder="dni empleado"></td> 
        <td><input type="button" class="btn btn-default" value="Buscar" onclick="buscarEmpleado()"></td>
    </tr>
</table>
<br>
    <%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
    <tag:GrillaEmpleados nombreGrilla="grilla_empleados" nombreEmpleado="<%=nombre%>" apellidoEmpleado="<%=apellido%>" dniEmpleado="<%=dni%>"/>

