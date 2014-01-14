/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.logic.validator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;
import org.doconline.domain.Empleado;
import org.doconline.jdbc.DataBase;
import org.doconline.logic.AccessManager;
import org.doconline.logic.AccessInterface;


public class ValidarUsuario extends AccessManager implements AccessInterface {
    public ValidarUsuario(){};
	 public Vector select (HashMap param) throws Exception {
            Vector aa = new Vector();
            return aa;
	 }
    public boolean isUsuarioValido(Empleado emp) throws Exception {
		boolean result = false;
        try {
            String sql = "";
            
            sql += "SELECT * FROM empleado WHERE nombre='"+emp.getNombre()+"' AND dni='"+emp.getDni()+"'";
            System.out.println("CONSULTA A EJECUTAR: \n "+sql+"\n");
            ResultSet rst = execute(sql);
            
            while(rst.next()){
                result = true;
            }
		} catch (Exception exc) {
            throw new Exception(exc);
        } finally {
            try {
                close_connection();
            } catch (Exception exc) {
                throw new Exception(exc.getMessage());
            }
        }
		return result;
    }   
}