/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.logic.updater;

import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
import com.google.gdata.data.docs.FolderEntry;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Administrador
 */
public class ManejadorCarpeta {
    public DocumentListEntry buscarCarpeta(String nombre_carpeta) throws IOException, ServiceException{
            // SE LE PASA EL NOMBRE DE UN ARCHIVO Y SI LO ENCUENTRA TE DEVUELVE EL ARCHIVO Y SI NO UN NULL
        try{
            DocsService client = new DocsService("yourCo-yourAppName-v1");
            client.setProtocolVersion(DocsService.Versions.V2);
            client.setUserCredentials("isftwebapp@gmail.com", "nomeadivinas");
            URL feedUri = new URL("https://docs.google.com/feeds/documents/private/full/-/folder?showfolders=true");
            DocumentListFeed feed = client.getFeed(feedUri, DocumentListFeed.class);
            for (DocumentListEntry entry : feed.getEntries()) {
                System.out.println(entry.getTitle().getPlainText());
                if(entry.getTitle().getPlainText().equals(nombre_carpeta)){
                    return entry;
                }
            }
        }catch(IOException exec){
            System.out.println("Error de IOException al buscar carpeta");
        }
        return null;
    }
    
    public DocumentListFeed getCarpetas() throws ServiceException{
        DocumentListFeed feed=null;
        try{
            DocsService client = new DocsService("yourCo-yourAppName-v1");
            client.setProtocolVersion(DocsService.Versions.V2);
            client.setUserCredentials("isftwebapp@gmail.com", "nomeadivinas");
            URL feedUri = new URL("https://docs.google.com/feeds/documents/private/full/-/folder?showfolders=true");
            feed=client.getFeed(feedUri, DocumentListFeed.class);
            
        }catch(IOException exec){
                System.out.println("Error de IOException al getCarpetas");
        }
        return feed;
        
    }
    
    public void crearCarpeta(String nombre_carpeta, String nombre_carpeta_padre) throws AuthenticationException, ServiceException{
        try{
            DocsService client = new DocsService("yourCo-yourAppName-v1");
            client.setProtocolVersion(DocsService.Versions.V2);
            client.setUserCredentials("isftwebapp@gmail.com", "nomeadivinas");
            URL url ;
            if(nombre_carpeta_padre!=null&&!nombre_carpeta_padre.equals("")){
                ManejadorCarpeta mc=new ManejadorCarpeta();
                DocumentListEntry carpeta= mc.buscarCarpeta(nombre_carpeta_padre);
                url=new URL("https://docs.google.com/feeds/folders/private/full/" + carpeta.getResourceId());
            }else{            
                url = new URL("https://docs.google.com/feeds/documents/private/full/");
            }
            //URL url = new URL("https://docs.google.com/feeds/documents/private/full/");
            
            
            DocumentListEntry newEntry = new FolderEntry();
            newEntry.setTitle(new PlainTextConstruct(nombre_carpeta));
            client.insert(url, newEntry);
            
        }catch(IOException exec){
                System.out.println("Error de IOException al getCarpetas");
        }
    }

    public void borrarCarpeta(String carpeta_borrar) throws IOException, ServiceException {
            if(buscarCarpeta(carpeta_borrar)==null){
                System.out.println("No se encontro el archivo");
            }else{
               DocumentListEntry carpeta=buscarCarpeta(carpeta_borrar);
               carpeta.delete();
            }
    }
}
