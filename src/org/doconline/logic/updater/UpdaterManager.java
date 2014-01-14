package org.doconline.logic.updater;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import org.doconline.logic.LogicManager;

/**
 *
 * @author jcafferata
 */
public class UpdaterManager extends LogicManager{
    public void execute(String sql_statement) throws Exception{
        try{
            create_connection();
            Statement statementInsercion = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            int resultado = statementInsercion.executeUpdate(sql_statement);  
        } catch(Exception exc){
            throw new Exception(exc.getMessage());
        }
        finally{
            try{
                close_connection();
            }
            catch(Exception exc){
                throw new Exception(exc.getMessage());
            }
        }   
    }    

}
