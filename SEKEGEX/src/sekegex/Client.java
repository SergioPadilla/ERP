/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;
import DataType.DataClient;
import java.util.Vector;
import MySQL.MySQLTools;

/**
 *
 * @author Ivan
 */
public class Client {
    MySQLTools DB = MySQLTools.getInstance();
    
    private DataClient data;
    
    public Client(int id){
        data = consultClient(id);
    }
    
    public DataClient consultClient(int id){
       return DB.consultClient(id);  
    }
    
    public Vector listServers(int id){  //Le pasamos el id del cliente 
                                        //que tiene asociado a los servidores        
        return DB.listServers(id); 
    }
    
    public Vector listBills(int id){
        
        return DB.listBills(id);
    }
}