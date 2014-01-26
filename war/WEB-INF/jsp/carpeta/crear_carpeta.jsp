<script type="text/javascript" src="static/js/carpeta/crear_carpeta.js"></script>
<h4 align="center">Crear Carpeta</h4>
<br>
<br>
    <table align="center">
        <tr>
            <td width="150px"><h5>Nombre Carpeta</h5></td>
            <td width="250px">
                <input type="text" id="nombre_carpeta">
            </td>
        </tr>
        <tr>
            <td width="150px"><h5>Sub-Directorio de</h5></td>
            <td width="250px">
                <%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
                <tag:ComboCarpetas nombreCombo="cbo_combo_carpetas" />
            </td>
        </tr>
        <tr>
            <td width="150px"></td>
            <td width="250px">                    
                    <input type="button" value="Crear" onclick="crearCarpeta()" class="btn btn-default">
            </td>
        </tr>
    </table>
