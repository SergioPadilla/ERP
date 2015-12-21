/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.DataServer;
import java.util.Vector;

/**
 *
 * @author Ivan
 */
public class Server {   
    private User activeEmployee = User.getInstance();
    private static MySQLTools DB = MySQLTools.getInstance();   
    private DataServer data;
    
    public Server(int id){
        data = activeEmployee.consultServer(id);
    }
    
    /**
    * Update the comment
    */
    public void update(){
        data=activeEmployee.consultServer(getData().id_server);
    }
     
    /**
     * List domains of this server
     */   
    public Vector listDomains(){
        Vector res=null;
        if(activeEmployee.hasLicence(702)){
            res=DB.listDomains(data.id_server);
        }
        return res;
    }
     /**
     * Modify server
     * @param name
     * @param access
     * @param user_ftp
     * @param password_ftp
     * @param user_host
     * @param password_host
     */
    public void modifyServer(String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        if(activeEmployee.hasLicence(702)){
            DB.modifyServer(data.id_server, name, access, user_ftp, password_ftp, user_host, password_host);
            update();
        }
    }
    
    /**
     * Erase server
     */
    public void removeServer(){
        if (activeEmployee.hasLicence(701)){
            DB.removeServer(data.id_server);
            data=null;
        }
    }

    /**
     * @return the data
     */
    public DataServer getData() {
        return data;
    }
    
     /**
     * Insert Domain
     */
    public void insertDomain(String web){
        if (activeEmployee.hasLicence(800)){
            DB.insertDomain(data.id_server, web);
        }
    }
}
