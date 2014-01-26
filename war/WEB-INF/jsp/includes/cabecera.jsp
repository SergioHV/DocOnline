<%@page import="org.doconline.domain.Empleado"%>

<div style="height: 70%;">
    <img src="static/images/portada.jpg" style="height:100%; width:100%;">
</div> 

<div style="height:30%;">
<div class="navbar">
    <div class="navbar-inner">
            <div class="container">
                <div class="span10">
                    <ul class="nav">
                        <li><a href="javascript:goPage(3000)">Inicio</a></li> 
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Archivo<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="javascript:goPage(4000)">Subir</a></li>
                          <li><a href="javascript:goPage(4001)">Borrar</a></li>
                          <li><a href="javascript:goPage(4002)">Compartir</a></li>
                        </ul>
                    </li>   
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Carpeta<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="javascript:goPage(5000)">Crear</a></li>
                          <li><a href="javascript:goPage(5001)">Borrar</a></li>
                        </ul>
                    </li> 
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Empleado<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="javascript:goPage(7000)">Alta</a></li>
                          <li><a href="#">Baja</a></li>
                          <li><a href="#">Modificacion</a></li>
                          <li><a href="#">Consulta</a></li>
                        </ul>
                    </li> 
                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Empresa<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="#">Alta</a></li>
                          <li><a href="#">Baja</a></li>
                          <li><a href="#">Modificacion</a></li>
                          <li><a href="#">Consulta</a></li>
                        </ul>
                    </li> 
                    
                    
                    
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
</div>