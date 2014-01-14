<%@page import="org.doconline.domain.Empleado"%>
<div style="background-image:url(static/images/portada.jpg); height: 100px;"></div> 

<div class="navbar">
    <div class="navbar-inner">
            <div class="container">
                <div class="span10">
                    <ul class="nav">
                        <li><a href="#">Inicio</a></li> 
                    </ul>
                </div>
                <div class="span2">      
                    <%
                        String nombre="";    
                        if(request.getSession(false).getAttribute("empleado")!=null){
                            Empleado empleado_sesion=new Empleado();
                            empleado_sesion=(Empleado)request.getSession(false).getAttribute("empleado");
                            if(empleado_sesion.getNombre()!=null){
                               nombre=empleado_sesion.getNombre();
                            }
                            %><p class="navbar-text navbar-right">Bienvenido: <b><%out.println(nombre);%></b><a style=" COLOR: #003399; TEXT-DECORATION: none" href="modulo.go?codPage=3001"> Logout</a></p><%
                        }
                    %>
                </div>
            </div>
    </div>
</div>


