/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.DataServer;
import java.util.Vector;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

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
        return DB.listDomains(getData().id_server);
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
        if (activeEmployee.hasLicence(702)){
            DB.modifyServer(getData().id_client, getData().id_client, name, access, user_ftp, password_ftp, user_host, password_host);
            update();
        }
    }
    
    /**
     * Erase server
     */
    public void removeServer(){
        if (activeEmployee.hasLicence(701)){
            DB.removeComment(getData().id_server);
            data=null;
        }
    }

    /**
     * @return the data
     */
    public DataServer getData() {
        return data;
    }
}
