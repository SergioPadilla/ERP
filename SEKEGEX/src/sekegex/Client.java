/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;
import DataType.DataClient;
import Utils.TypeClient;
import java.util.Vector;

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
    
    public void update(){
        data=consultClient(data.id);
    }
    
    /**
     * Modify client with the params specified
     */
    public void modifyClient(int id_client, TypeClient type, String name, String surname, String dni, String email){
        User U=User.getInstance();
        if(U.hasLicence(302)){
            //modificar cliente
        }
    }
    
    /**
     * Remove client
     */
    public void removeClient(int id_client){
        User U=User.getInstance();
        if(U.hasLicence(301)){
            //Borrar cliente
        }
    }
    
    public Vector listServers(int id){  //Le pasamos el id del cliente 
                                        //que tiene asociado a los servidores        
        return DB.listServers(id); 
    }
    
    public Vector listBills(int id){
        
        return DB.listBills(id);
    }
}