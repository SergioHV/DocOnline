/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.web.tags;

import java.util.HashMap;
import java.util.Vector;
import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import org.doconline.domain.Empresa;
import org.doconline.logic.collection.CollectionCarpetas;
import org.doconline.logic.collection.CollectionEmpresas;

/**
 *
 * @author Administrador
 */
public class ComboEmpresas extends TagCombo{
    public int doStartTag() throws JspException {
                super.doStartTag();
                HashMap hm=new HashMap();
                Vector<Empresa> vec_carp=new Vector();
		CollectionEmpresas empresas = new CollectionEmpresas();
                String nombre_empresa;
		try {
                    vec_carp = empresas.select(hm);
                    for(int i=0; i< vec_carp.size();i++){
                        nombre_empresa=vec_carp.elementAt(i).getRazon_social();
                        pageContext.getOut().println("<OPTION VALUE='"+nombre_empresa+"'>" + nombre_empresa + "</OPTION>");
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
}
