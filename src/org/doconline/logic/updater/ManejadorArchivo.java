/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.logic.updater;

import com.google.api.services.drive.model.ParentReference;
import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.Person;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.acl.AclEntry;
import com.google.gdata.data.acl.AclRole;
import com.google.gdata.data.acl.AclScope;
import com.google.gdata.data.docs.DocumentEntry;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

/**
 *
 * @author Administrador
 */
public class ManejadorArchivo {
   
    
    public void subirArchivo(File archivo, String carpeta_cbo) throws AuthenticationException, MalformedURLException, IOException, ServiceException{
        DocsService client = new DocsService("testappv3");
        client.setUserCredentials("isftwebapp@gmail.com", "nomeadivinas");
        URL url ;
        if(carpeta_cbo!=null&&!carpeta_cbo.equals("")){
            client.setProtocolVersion(DocsService.Versions.V2);
            ManejadorCarpeta mc=new ManejadorCarpeta();
            DocumentListEntry carpeta= mc.buscarCarpeta(carpeta_cbo);
            url=new URL("https://docs.google.com/feeds/folders/private/full/" + carpeta.getResourceId());
        }else{            
            url = new URL("https://docs.google.com/feeds/default/private/full/");
        }
        String mimeType = DocumentListEntry.MediaType.fromFileName(archivo.getName()).getMimeType();
        DocumentEntry newDocument = new DocumentEntry();
        // SE HACE UN REPLACE YA QUE NO SE PUEDE HACER UN SPLIT POR "." 
        String aux1=archivo.getName().replace(".", "-");
        String[] aux2=aux1.split("-");
        String nombre_archivo=aux2[0];
        newDocument.setTitle(new PlainTextConstruct(nombre_archivo));
        newDocument.setFile(archivo, mimeType);
        System.out.println(url);
        client.insert(url, newDocument);
    }
    
    public void borrarArchivo(String nombre) throws IOException, ServiceException{
        if(buscarArchivo(nombre)==null){
            System.out.println("No se encontro el archivo");
        }else{
           DocumentListEntry archivo=buscarArchivo(nombre);
           archivo.delete();
        }
    }
    
    public void agregarPermiso(String email, DocumentListEntry file) throws AuthenticationException, MalformedURLException, IOException, ServiceException{
        DocsService client = new DocsService("yourCo-yourAppName-v1");
        client.setProtocolVersion(DocsService.Versions.V2);
        client.setUserCredentials("isftwebapp@gmail.com", "nomeadivinas");
       
        AclRole role = new AclRole("writer");
        AclScope scope = new AclScope(AclScope.Type.USER, email);
        AclEntry entry = new AclEntry();
        entry.setRole(role);
        entry.setScope(scope);
        URL url = new URL("https://docs.google.com/feeds/acl/private/full/" + file.getResourceId());
        client.insert(url, entry);
    }
    
    public void actualizarArchivo(DocumentListEntry archivo) throws IOException, ServiceException{
        // ESTE NO LO PROBE AUN PERO CAPAS SIRVA DPS
        
        DocsService client = new DocsService("testappv3");
        client.getRequestFactory().setHeader("If-Match", "*");
        archivo.setTitle(new PlainTextConstruct("Updated Title"));
        DocumentListEntry updatedEntry = archivo.update();
        System.out.println(updatedEntry.getTitle().getPlainText());
    }
    
    public DocumentListEntry buscarArchivo(String nombre_archivo) throws IOException, ServiceException{
            // SE LE PASA EL NOMBRE DE UN ARCHIVO Y SI LO ENCUENTRA TE DEVUELVE EL ARCHIVO Y SI NO UN NULL
        try{
            DocsService client = new DocsService("yourCo-yourAppName-v1");
            client.setProtocolVersion(DocsService.Versions.V2);
            client.setUserCredentials("isftwebapp@gmail.com", "nomeadivinas");
            URL feedUri = new URL("https://docs.google.com/feeds/documents/private/full/");
            DocumentListFeed feed = client.getFeed(feedUri, DocumentListFeed.class);
            for (DocumentListEntry entry : feed.getEntries()) {
                if(entry.getTitle().getPlainText().equals(nombre_archivo)){
                    return entry;
                }
            }
        }catch(IOException exec){
            System.out.println("Error de IOException al buscar archivo");
        }
        return null;
    }
    
    public void moverArchivo(String nombre_archivo, String nombre_carpeta) throws IOException, ServiceException{
        // COPIA ARCHIVO A DESTINO PERO NO BORRA EL ORIGEN
        // SI SE BORRA EL ARCHIVO POR OTRO METODO SE BORRA EL ARCHIVO DE AMBOS LADOS YA QUE
        // LA LOGICA DE GOOGLE DOCS ES QUE AL COPIAR EL ARCHIVO SE LE AGREGA LA REFERENCIA A LA OTRA CARPETA NO SE CREA UN
        // NUEVO ARCHIVO
        ManejadorCarpeta mc= new ManejadorCarpeta();
        if(buscarArchivo(nombre_archivo)==null){
            System.out.println("El archivo no existe");
        }else if(mc.buscarCarpeta(nombre_carpeta)==null){
            System.out.println("La carpeta no existe");
        }else{
            DocsService client = new DocsService("yourCo-yourAppName-v1");
            client.setProtocolVersion(DocsService.Versions.V2);
            client.setUserCredentials("isftwebapp@gmail.com", "nomeadivinas");
            DocumentListEntry archivo= buscarArchivo(nombre_archivo);
            DocumentListEntry carpeta= mc.buscarCarpeta(nombre_carpeta);
            DocumentEntry aux = new DocumentEntry();
            System.out.println("NOMBRE DE LA CARPETA "+ carpeta.getResourceId());
            URL url = new URL("https://docs.google.com/feeds/folders/private/full/" + carpeta.getResourceId());
            System.out.println("LA URL ES: "+ url);
            aux.setId(archivo.getId());
            client.update(url, archivo);

        }
    } 
    
}
