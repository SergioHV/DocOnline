package org.doconline.web.servlets;

import com.google.gdata.util.ServiceException;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.doconline.logic.updater.ManejadorArchivo;


public class ControladorArchivo extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "C:/temp/";// NO AFECTA NADA ESO O.O
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                FileItem item=multiparts.get(0);
                String name = new File(item.getName()).getName();
                File archivo = new File(UPLOAD_DIRECTORY + File.separator + name);
                item.write( archivo);
                ManejadorArchivo ma= new ManejadorArchivo();
                String carpeta=multiparts.get(2).getString();
                ma.subirArchivo(archivo,carpeta);
            } catch (Exception ex) {
                System.out.println("No se recibio un archivo");
                doGet(request,response);
            }          
        //request.getRequestDispatcher("/index.jsp").forward(request, response);      
  }
   
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String nombre_archivo=request.getParameter("nombre_archivo");
      String accion=request.getParameter("accion");
      String email=request.getParameter("email");
      
      
      if(nombre_archivo==null){nombre_archivo="";}
      if(accion==null){accion="";}
      if(email==null){email="";}

      if(accion.equals("borrar")){
            try {
                ManejadorArchivo ma= new ManejadorArchivo();
                ma.borrarArchivo(nombre_archivo);
            } catch (ServiceException ex) {
                System.out.println("Error al borrar archivo");
            }
      }
      
      
      if(accion.equals("compartir")){
            try {
                ManejadorArchivo ma= new ManejadorArchivo();
                ma.agregarPermiso(email, ma.buscarArchivo(nombre_archivo));
            } catch (ServiceException ex) {
                System.out.println("Error al compartir archivo");
            }
      }
      
      
  } 
}
