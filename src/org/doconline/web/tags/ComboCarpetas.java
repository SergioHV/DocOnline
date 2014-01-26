/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.web.tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;
import org.doconline.logic.collection.CollectionCarpetas;

/**
 *
 * @author Administrador
 */
public class ComboCarpetas extends TagCombo {
    private String nombre_carpeta="";
    public int doStartTag() throws JspException {
                super.doStartTag();
                Vector<String> vec_carp=new Vector();
		CollectionCarpetas examenes = new CollectionCarpetas();
		try {
                    vec_carp = examenes.getCarpetas();
                    for(int i=0; i< vec_carp.size();i++){
                        nombre_carpeta=vec_carp.elementAt(i).toString();
                        pageContext.getOut().println("<OPTION VALUE='"+nombre_carpeta+"'>" + nombre_carpeta + "</OPTION>");
                    }     
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
            super.doEndTag();
            return EVAL_PAGE;
        }

    /**
     * @return the nombre_carpeta
     */
    public String getNombre_carpeta() {
        return nombre_carpeta;
    }

    /**
     * @param nombre_carpeta the nombre_carpeta to set
     */
    public void setNombre_carpeta(String nombre_carpeta) {
        this.nombre_carpeta = nombre_carpeta;
    }
    
  
}
