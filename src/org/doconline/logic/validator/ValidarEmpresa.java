/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.logic.validator;

import java.sql.ResultSet;
import java.util.HashMap;
import org.doconline.logic.AccessManager;

/**
 *
 * @author Administrador
 */
public class ValidarEmpresa extends AccessManager{
    public String existeEmpresa(String nombre) throws Exception{
		String sql="select *\n" +
                        "from empresa\n"+
                        "where razon_social='"+nombre+"'";
                System.out.println("CONSULTA A EJECUTAR: "+ sql);
                ResultSet rst = execute(sql);  
                while(rst.next()){
                    return "";
                }
                return "No se encontro la empresa";
	 }
    
}
