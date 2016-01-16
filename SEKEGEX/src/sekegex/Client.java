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
    
    /**
     * Update the data of the client
     */
    public void update(){
        data=activeEmployee.consultClient(data.id);
    }
    
    /**
     * Modify client with the params specified
     */
    public int modifyClient(TypeClient type, String name, String surname, String dni, String email){
        int ok = 0;
        
        if(activeEmployee.hasLicence(302)){
            ok=DB.modifyClient(data.id, type, name, surname, dni, email);
            data = DB.consultClient(data.id);
        }
        else{
            ok = -1;
        }
        
        return ok;
    }
    
    /**
     * Remove client
     */
    public void removeClient(){
        if(activeEmployee.hasLicence(301)){
            DB.removeClient(data.id);
        }
    }
    
    /**
     * list the servers of the client
     * @return 
     */
    public Vector listServers(){
        Vector res=null;
        if(activeEmployee.hasLicence(702)){
           res= DB.listServers(data.id);
        }
        return res;
    }
    
    /**
     * list the bills of the client
     * @return 
     */
    public Vector listBills(){
        Vector res=null;
        if(activeEmployee.hasLicence(403)){
           res= DB.listBills(data.id);
        }
        return res;
    }
    
    /**
     * Insert new bill in the table
     */
    public void insertBill(Vector products){
        //disparador 1
        if(activeEmployee.hasLicence(400)){
            int Id_db=0;
            Id_db=DB.insertBill(data.id);
            for(int i=0;i<products.size();i++){
                DB.insertPurchase(Id_db,(int) products.elementAt(i));
            }
        }
        
    }
    
    /**
     * Insert new server
     */
    public boolean insertServer(String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        boolean res=false;
        if(activeEmployee.hasLicence(700)){
            res=DB.insertServer(data.id, name, access, user_ftp, password_ftp, user_host, password_host);
        }
        return res;

    }
}