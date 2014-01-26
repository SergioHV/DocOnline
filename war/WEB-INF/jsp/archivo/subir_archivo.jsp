<script type="text/javascript" src="static/js/archivo/subir_archivo.js"></script>
<h4 align="center">Subir Archivo</h4>
<br>
<br>
    <table align="center">
        <tr>
            <td width="150px"><h5>Archivo a subir</h5></td>
            <td width="250px">
                <form method="post" action="enviar.archivo" id="form_subir_archivo" name="form_subir_archivo" >
                    <input type="file" id='path_archivo' value='Seleccion Archivo...' id="path_archivo" name="path_archivo">
                </form>
            </td>
        </tr>
        <tr>
            <td width="150px"><h5>En carpeta</h5></td>
            <td width="250px">
                <%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="tag" %>
                <tag:ComboCarpetas nombreCombo="cbo_combo_carpetas" />
            </td>
        </tr>
        <tr>
            <td width="150px"></td>
            <td width="250px">                    
                    <input type="button" value="Subir" onclick="subirArchivo()" class="btn btn-default">
            </td>
        </tr>
    </table>
            


