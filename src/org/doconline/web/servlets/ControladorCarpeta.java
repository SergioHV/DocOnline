/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.doconline.logic.updater.ManejadorCarpeta;

/**
 *
 * @author Administrador
 */
public class ControladorCarpeta extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
                doGet(request,response);
   
  }
   
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre_carpeta=request.getParameter("nombre_carpeta");
        String carpeta_padre=request.getParameter("carpeta_padre");
        String accion=request.getParameter("accion");
        String carpeta_borrar=request.getParameter("carpeta_borrar");
        
        if(nombre_carpeta==null){nombre_carpeta="";}
        if(carpeta_padre==null){carpeta_padre="";}
        if(accion==null){accion="";}
        if(carpeta_borrar==null){carpeta_borrar="";}
        
        if(accion.equals("crear")){
            try {
                ManejadorCarpeta mc= new ManejadorCarpeta();
                mc.crearCarpeta(nombre_carpeta, carpeta_padre);
            } catch (Exception exc) {
                System.out.println("Error controlador carpeta al crear carpeta");
            }     
        }
        
        if(accion.equals("borrar")){
            try {
                ManejadorCarpeta mc= new ManejadorCarpeta();
                mc.borrarCarpeta(carpeta_borrar);
            } catch (Exception exc) {
                System.out.println("Error controlador carpeta al borrar carpeta");
            }     
        }      
  } 
    
}
