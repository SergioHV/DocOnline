package org.doconline.logic.updater;
import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.docs.DocumentEntry;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.util.ServiceException;
import org.doconline.logic.updater.UpdaterManager;
import java.util.HashMap;
import org.isft.logic.updater.UpdaterInterface;

/* IMPORTS DE GOOGLE */
import java.io.File;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
/* FIN DE IMPORT DE GOOGLE */
/**
 *
 * @author Administrador
 */
public class AbmArchivo extends UpdaterManager implements UpdaterInterface {
    
    public void insert(HashMap parameters) throws Exception, ServiceException {
        DocsService client = new DocsService("testappv3");
        client.setUserCredentials("isftwebapp@gmail.com", "nomeadivinas");
        File file = new File("c:/test.txt");
        URL url = new URL("https://docs.google.com/feeds/default/private/full/");
        String mimeType = DocumentListEntry.MediaType.fromFileName(file.getName()).getMimeType();
        DocumentEntry newDocument = new DocumentEntry();
        newDocument.setTitle(new PlainTextConstruct("test"));
        //newDocument.setMediaSource(new MediaFileSource(file, mimeType));
        newDocument.setFile(file, mimeType);
        newDocument = client.insert(url, newDocument);
    }

   
    public void delete(HashMap parameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(HashMap parameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
