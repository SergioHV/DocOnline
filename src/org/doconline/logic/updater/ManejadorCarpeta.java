/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.logic.updater;

import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
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
                if(entry.getTitle().getPlainText().equals(nombre_carpeta)){
                    return entry;
                }
            }
        }catch(IOException exec){
            System.out.println("Error de IOException al buscar carpeta");
        }
        return null;
    }
}
