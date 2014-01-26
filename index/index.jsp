<html style="height: 100%;">
    <head style="height: 100%;">
        <%@include file="jsp/includes/metas_inc.jsp" %>
       
        <title>ISFT 179</title>
    </head>
    <body onload="foco()">
        
       <!-- CABECERA DE LA PAGINA -->
       <div class="row-fluid" style="height: 20%;">
            <div class="span1"></div>
            <div class="span10">
                <%@include file="jsp/includes/cabecera.jsp" %>
            </div>
            <div class="span1"></div>
       </div>
       
       <!-- CUERPO DE LA PAGINA -->
       <div class="row-fluid" style="min-height:400px;">
           <div class="span1" ></div>
           <div class="span10" id="cuerpo_pagina">
                <%@include file="jsp/login/login.jsp" %>
           </div>
          <div class="span1"></div>
       </div>
           
       <!-- PIE DE PAGINA    -->
       <div class="row-fluid">
           <div class="span1"></div>
           <div class="span10" id="pie_pagina">
               <%@include file="jsp/includes/pie_inc.jsp" %>
           </div>
           <div class="span1"></div>
       </div>
 
    </body>
</html>
