<h3 align="center">Bienvenido al sistema de documentacion online</h3>
<br>
<br>
<form action="redirec.login?codPage=3002" name="form_login" id="form_login" method="post">
    <table border="0" align="center">                    
        <tbody>
            <tr>
                <td width="150px"><h5>Usuario</h5></td>
                <td width="240px">
                    <input style="height:100%;" type="text" maxlength="30" name="txt_usuario" id="txt_usuario" placeholder="nombre del empleado" required="true">
                </td>
            </tr>

            <tr>
                <td><h5>Contraseña</h5></td>
                <td>
                <input style="height:100%;" type="password" name="txt_password" id="txt_password" placeholder="dni del empleado" required="true">
                </td>
            </tr>

            <tr>
                <td>
                    <input class="btn  btn-primary" type="submit" name="btn_aceptar" value="Aceptar">
                </td>
                <td>
                    <input class="btn" type="reset" value="Cancelar" name="btn_cancelar" />
                </td>
            </tr>
            
        </tbody>
    </table>
</form>