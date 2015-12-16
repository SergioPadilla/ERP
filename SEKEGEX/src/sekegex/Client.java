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
    private User activeEmployee = User.getInstance();
    private static MySQLTools DB = MySQLTools.getInstance();
    
    private DataClient data;
    
    public Client(int id){
        data = activeEmployee.consultClient(id);
    }
    
    public DataClient getData(){
        return data;
    }
    
    public void update(){
        data=activeEmployee.consultClient(data.id);
    }
    
    /**
     * Modify client with the params specified
     */
    public void modifyClient(String type, String name, String surname, String dni, String email){
        if(activeEmployee.hasLicence(302)){
            DB.modifyClient(data.id, type, name, surname, dni, email);
        }
    }
    
    /**
     * Remove client
     */
    public void removeClient(int id_client){
        if(activeEmployee.hasLicence(301)){
            //Borrar cliente
        }
    }
    
    public Vector listServers(){
        Vector res=null;
        if(activeEmployee.hasLicence(702)){
           res= DB.listServers(data.id);
        }
        return res;
    }
    
    public Vector listBills(){
        Vector res=null;
        if(activeEmployee.hasLicence(403)){
           res= DB.listBills(data.id);
        }
        return res;
    }
}