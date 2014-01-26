/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.logic.collection;

import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
import java.util.Vector;
import org.doconline.logic.updater.ManejadorCarpeta;

/**
 *
 * @author Administrador
 */
public class CollectionCarpetas{

    public Vector getCarpetas() throws Exception {
        Vector<String> carpetas=new Vector();
        ManejadorCarpeta mc=new ManejadorCarpeta();
        DocumentListFeed feed = mc.getCarpetas();
        for (DocumentListEntry entry : feed.getEntries()) {
            carpetas.add(entry.getTitle().getPlainText());
        }
        return carpetas;
    }
    
}
