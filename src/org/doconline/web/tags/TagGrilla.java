/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.web.tags;

import javax.servlet.jsp.JspException;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Administrador
 */
public class TagGrilla extends TagSupport{
    private String nombreGrilla="";
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("<table disabled class='table table-hover table-bordered table-condensed' id=\""+ getNombreGrilla() + "\"  name=\""+getNombreGrilla()+"\" >");

        } catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }
        return SKIP_BODY;
    }
    
    public int doEndTag() throws JspException {
	      try {
        	pageContext.getOut().print("</table>\n");
        } catch(Exception exc){
            exc.printStackTrace();
            throw new JspException(exc.getMessage());
        }
        return EVAL_PAGE;
    }

    /**
     * @return the nombreGrilla
     */
    public String getNombreGrilla() {
        return nombreGrilla;
    }

    /**
     * @param nombreGrilla the nombreGrilla to set
     */
    public void setNombreGrilla(String nombreGrilla) {
        this.nombreGrilla = nombreGrilla;
    }
    
}
