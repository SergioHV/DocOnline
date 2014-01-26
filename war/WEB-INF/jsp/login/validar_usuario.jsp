<%@page import="org.doconline.domain.Empleado"%>
<%@page import="org.doconline.logic.validator.ValidarUsuario"%>
<%@page import="org.doconline.web.servlets.frontController"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ResourceBundle"%>
<%
    String txt_usuario  = request.getParameter("txt_usuario");
    String txt_password = request.getParameter("txt_password");

    String txt_mensaje = "";

    if (txt_usuario == null && txt_password == null || txt_usuario.equals("") && txt_password.equals("")) {
        txt_mensaje = "todo_incompleto";
    } else if (txt_usuario.equals(null) || txt_usuario.trim().equals("")) {
        txt_mensaje = "usuario_incompleto";
    } else if (txt_password.equals(null) || txt_password.trim().equals("")) {
        txt_mensaje = "password_incompleto";
    } else {
        Empleado empleado = new Empleado();
        int aux = Integer.parseInt(txt_password);
        empleado.setDni(aux);
        empleado.setNombre(txt_usuario);
        ValidarUsuario validarUsuario = new ValidarUsuario();

        if (validarUsuario.isUsuarioValido(empleado)) {
            //CREAR SESION
            request.getSession(false).setAttribute("empleado", empleado);
        }
        %><script>window.location.href = 'modulo.go?codPage=1000';</script><%
    }
%>