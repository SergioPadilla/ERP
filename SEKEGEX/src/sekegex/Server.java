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
    private static String decrypt(String textEncrypted) throws Exception {
 
        String secretKey = "97f8c8e8a2802a"; 
        String base64EncryptedString = "";
 
        try {
            byte[] message = Base64.decodeBase64(textEncrypted.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            base64EncryptedString = new String(plainText, "UTF-8");
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
}
    
    private DataServer data;
    
    public Server(int id){
        data = consultServer(id);
    }
    
    public DataServer consultServer(int id){
        return data;
    }
    
    public Vector listDomains(){
        Vector v=null;
        return v;
    }
     /**
     * Modify server
     */
    public void modifyServer(int id_client, String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        
    }
    
    /**
     * Erase server
     */
    public void removeServer(int id_server){
        
    }
}
