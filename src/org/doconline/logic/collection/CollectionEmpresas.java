/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.logic.collection;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import org.doconline.domain.Empresa;
import org.doconline.logic.AccessInterface;
import org.doconline.logic.AccessManager;

/**
 *
 * @author Administrador
 */
public class CollectionEmpresas extends AccessManager implements AccessInterface{

    public Vector select(HashMap hm) throws Exception {
        Vector<Empresa> vec_empresas = new Vector();
        String sql="select *\n" +
                   "from empresa";
        if((String)hm.get("cbo_empresas")!=""&&(String)hm.get("cbo_empresas")!=null){
            sql+="\n where razon_social='"+(String)hm.get("cbo_empresas")+"'";
        }
        System.out.println("CONSULTA A EJECUTAR: "+ sql);
        ResultSet rst = execute(sql);   
        while(rst.next()){
             Empresa emp=new Empresa();
             emp.setCuit(Integer.parseInt(rst.getString("cuit")));
             emp.setJefe(rst.getString("jefe"));
             emp.setNoticia(rst.getString("noticia"));
             emp.setRazon_social(rst.getString("razon_social"));
             emp.setFecha_inicio_actividades(rst.getDate("inicio_actividades"));
             vec_empresas.add(emp);
         }
        return vec_empresas;
    }
     
}
