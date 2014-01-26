/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.web.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.doconline.logic.updater.AbmEmpleado;
import org.doconline.logic.validator.ValidarEmpresa;

/**
 *
 * @author Administrador
 */
public class ControladorEmpleado extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
                doGet(request,response);
   
  }
   
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("html/text");
        //  INICIO DE CAPTURA DE DATOS
        String txt_nombre=request.getParameter("txt_nombre");
        String txt_apellido=request.getParameter("txt_apellido");
        String txt_dni=request.getParameter("txt_dni");
        String txt_fecha_nacimiento=request.getParameter("txt_fecha_nacimiento");
        String txt_email=request.getParameter("txt_email");
        String txt_cargo=request.getParameter("txt_cargo");
        String cbo_empresas=request.getParameter("cbo_empresas");
        String accion=request.getParameter("accion");
        
        // INICIO DE VALIDACION X NULL
        if(txt_nombre==null){txt_nombre="";}
        if(txt_apellido==null){txt_apellido="";}
        if(txt_dni==null){txt_dni="";}
        if(txt_fecha_nacimiento==null){txt_fecha_nacimiento="";}
        if(txt_email==null){txt_email="";}
        if(txt_cargo==null){txt_cargo="";}
        if(cbo_empresas==null){cbo_empresas="";}
        if(accion==null){accion="";}

        // INICIO DE CREACION Y RELLENADO DE HASHMAP
        HashMap hm=new HashMap();
 	hm.put("txt_nombre",txt_nombre);
 	hm.put("txt_apellido",txt_apellido);
 	hm.put("txt_dni",txt_dni);
 	hm.put("txt_fecha_nacimiento",txt_fecha_nacimiento);
 	hm.put("txt_email",txt_email);
 	hm.put("txt_cargo",txt_cargo);
 	hm.put("cbo_empresas",cbo_empresas);
        
        // INICIO DE ACCIONES SEGUN LO PEDIDO
        AbmEmpleado abm_emp=new AbmEmpleado();
        if(accion.equals("alta")){
            try {
                ValidarEmpresa ve=new ValidarEmpresa();
                String mensaje=ve.existeEmpresa(cbo_empresas);
                if(mensaje.equals("")){
                    abm_emp.insert(hm);
                }else{
                        System.out.println("El mensaje es:" + mensaje);
                        response.getWriter().write("ERROR:"+mensaje);
                        return;
                }
               
            } catch (Exception ex) {
                Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
  }
}
