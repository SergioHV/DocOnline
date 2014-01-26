<script type="text/javascript" src="static/js/empleado/alta_empleado.js"></script>
<script type="text/javascript" src="static/js/jquery.ui.datepicker-es.js"></script>
<h4 align="center">Alta Empleado</h4>
<br>
<br>
<table align="center">
    <tr>
        <td>Nombre</td>
        <td><input type="text" id="txt_nombre"></td>
        <td>Apellido</td>
        <td><input type="text" id="txt_apellido"></td>
    </tr>
    <tr>
        <td>DNI</td>
        <td><input type="text" id="txt_dni"></td>
        <td>Fecha Nacimiento</td>
        <td><input type="text"  id="txt_fecha_nacimiento" placeholder="click para seleccionar fecha"></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><input type="text" id="txt_email"></td>
        <td>Cargo</td>
        <td><input type="text" id="txt_cargo"></td>
    </tr>
    <tr>
        <td>Empresa</td>
        <td>
            <%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
            <tag:ComboEmpresas nombreCombo="cbo_empresas"/>
        </td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td colspan="4"><input type="button" class="btn btn-default" value="Registrar" onclick="altaEmpleado()"></td>
    </tr>
</table>