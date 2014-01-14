<html>
    <head>
        <%@include file="jsp/includes/metas_inc.jsp" %>
       
        <title>ISFT 179</title>
    </head>
    <body onload="foco()">
        
       <!-- CABECERA DE LA PAGINA -->
       <div class="row-fluid">
            <div class="span12">
                <%@include file="jsp/includes/cabecera.jsp" %>
            </div>
            <a name="miancla"></a>
       </div>
        
       <!-- CUERPO DE LA PAGINA -->
       <div class="row-fluid" >
           <div class="span12" id="cuerpo_pagina">
               <%if(request.getSession(false).getAttribute("empleado")!=null){
                    %><script type='text/javascript'>('#cuerpo_pagina').load('modulo.go?codPage=4000');</script><%
               }else{
               %>
                <%@include file="jsp/login/login.jsp" %>
               <%}%> 
           </div>
       </div>
           
       <!-- PIE DE PAGINA -->      
       <%@include file="jsp/includes/pie_inc.jsp" %>
           
    </body>
</html>
