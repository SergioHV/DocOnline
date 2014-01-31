/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.logic.updater;

import java.util.HashMap;
import java.util.Vector;
import org.doconline.domain.Empresa;
import org.doconline.logic.collection.CollectionEmpresas;
import org.doconline.logic.validator.ValidarEmpresa;

/**
 *
 * @author Administrador
 */
public class AbmEmpleado extends UpdaterManager implements UpdaterInterface{

    public void insert(HashMap hm) throws Exception {
        try{
            String campos="";
            String datos="";
            
            if((String)hm.get("txt_dni")!=""){
                campos+="dni";
                datos+="'"+(String)hm.get("txt_dni")+"'";
                campos+=", password";
                datos+=", '"+(String)hm.get("txt_dni")+"'";
                
            }
            if((String)hm.get("txt_apellido")!=""){
                campos+=" ,apellido";
                datos+=" ,'"+(String)hm.get("txt_apellido")+"'";
            }
            if((String)hm.get("txt_nombre")!=""){
                campos+=" ,nombre";
                datos+=" ,'"+(String)hm.get("txt_nombre")+"'";
            }
            if((String)hm.get("txt_fecha_nacimiento")!=""){
                campos+=" ,fecha_nacimiento";
                datos+=" ,'"+(String)hm.get("txt_fecha_nacimiento")+"'";
            }
            if((String)hm.get("txt_email")!=""){
                campos+=" ,email";
                datos+=" ,'"+(String)hm.get("txt_email")+"'";
            }
            if((String)hm.get("txt_cargo")!=""){
                campos+=" ,cargo";
                datos+=" ,'"+(String)hm.get("txt_cargo")+"'";
            }
            if((String)hm.get("cbo_empresas")!=""){
                CollectionEmpresas emp=new CollectionEmpresas();
                Vector<Empresa> vec=emp.select(hm);
                campos+=" ,empresa_cuit";
                datos+=" ,'"+vec.elementAt(0).getCuit()+"'";
            }
            String sql_insert="insert into empleado ("+campos+") values ("+datos+")";
            System.out.println("INSERT A EJECUTAR: " + sql_insert);
            execute(sql_insert);
        }catch(Exception exc){
           throw new Exception(exc.getMessage());
        }    
        
    }

    public void delete(HashMap hm) throws Exception {
        String sql_delete="delete from empleado where dni='"+hm.get("txt_dni")+"'";
        System.out.println("Consulta DELETE a ejecutar: " + sql_delete);
        execute(sql_delete);
    }

    public void update(HashMap parameters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
