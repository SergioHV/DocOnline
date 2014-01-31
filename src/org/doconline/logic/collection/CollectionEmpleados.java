/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.logic.collection;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import org.doconline.domain.Empleado;
import org.doconline.logic.AccessInterface;
import org.doconline.logic.AccessManager;

/**
 *
 * @author Administrador
 */
public class CollectionEmpleados extends AccessManager implements AccessInterface{

    public Vector select(HashMap hm) throws Exception {
        Vector<Empleado> vec_empleados = new Vector();
        String sql="select *\n" +
                   "from empleado\n"+
                   "where dni>0" ;
        if((String)hm.get("nombreEmpleado")!=""&&(String)hm.get("nombreEmpleado")!=null){
            sql+="\n and nombre='"+(String)hm.get("nombreEmpleado")+"'";
        }
        if((String)hm.get("apellidoEmpleado")!=""&&(String)hm.get("apellidoEmpleado")!=null){
            sql+="\n and apellido='"+(String)hm.get("apellidoEmpleado")+"'";
        }
        if((String)hm.get("dniEmpleado")!=""&&(String)hm.get("dniEmpleado")!=null){
            sql+="\n and dni='"+(String)hm.get("dniEmpleado")+"'";
        }
        
        System.out.println("CONSULTA A EJECUTAR: "+ sql);
        ResultSet rst = execute(sql);   
        while(rst.next()){
             Empleado emp=new Empleado();
             emp.setApellido(rst.getString("apellido"));
             emp.setNombre(rst.getString("nombre"));
             emp.setEmail(rst.getString("email"));
             emp.setCargo(rst.getString("cargo"));
             emp.setDni(Integer.parseInt(rst.getString("dni")));
             emp.setEmpresa_cuit(Integer.parseInt(rst.getString("empresa_cuit")));
             emp.setFecha_nacimiento(rst.getDate("fecha_nacimiento"));
             vec_empleados.add(emp);
         }
        return vec_empleados;
    }
    
}
