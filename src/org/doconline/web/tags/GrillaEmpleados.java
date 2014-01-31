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
import org.doconline.domain.Empleado;
import org.doconline.logic.collection.CollectionEmpleados;

/**
 *
 * @author Administrador
 */
public class GrillaEmpleados extends TagGrilla{
    private String nombreGrilla="";
    private String nombreEmpleado="";
    private String apellidoEmpleado="";
    private String dniEmpleado="";
    public int doStartTag() throws JspException {
        super.doStartTag();
        Vector<Empleado> vec_emp=new Vector();
        HashMap hm=new HashMap();
        hm.put("nombreEmpleado", nombreEmpleado);
        hm.put("apellidoEmpleado", apellidoEmpleado);
        hm.put("dniEmpleado", dniEmpleado);
        CollectionEmpleados empleados = new CollectionEmpleados();
        String tabla="";
        try {
            vec_emp = empleados.select(hm);
            if(vec_emp.size()==0){
                tabla+="<tr><td>No se encontro ningun registro con los criterios elegidos</td></tr>";
            }else if(getApellidoEmpleado().equals("")&&getNombreEmpleado().equals("")&&getDniEmpleado().equals("")){
                tabla+="<tr><td>Elija al menos 1 criterio para buscar al empleado</td></tr>";
                }else{
                    tabla+="<tr><td>Apellido</td><td>Nombre</td><td>DNI</td><td></td></tr>";
                    for(int i=0; i< vec_emp.size();i++){
                        tabla+="<tr>";
                        tabla+="<td>"+vec_emp.elementAt(i).getApellido()+"</td>";
                        tabla+="<td>"+vec_emp.elementAt(i).getNombre()+"</td>";
                        tabla+="<td>"+vec_emp.elementAt(i).getDni()+"</td>";
                        tabla+="<td><input type='button' class='btn btn-default' value='Eliminar' onclick='realizarBaja("+vec_emp.elementAt(i).getDni()+")'";
                        tabla+="</tr>";
                    }
                }
               
            pageContext.getOut().println(tabla);  
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

    /**
     * @return the nombreEmpleado
     */
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    /**
     * @param nombreEmpleado the nombreEmpleado to set
     */
    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    /**
     * @return the apellidoEmpleado
     */
    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    /**
     * @param apellidoEmpleado the apellidoEmpleado to set
     */
    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    /**
     * @return the dniEmpleado
     */
    public String getDniEmpleado() {
        return dniEmpleado;
    }

    /**
     * @param dniEmpleado the dniEmpleado to set
     */
    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }
    
}
