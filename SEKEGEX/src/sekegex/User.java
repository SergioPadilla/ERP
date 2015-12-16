/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.*;
import Utils.StatusTask;
import Utils.TypeClient;
import java.sql.Date;
import java.sql.Time;
import java.security.*;
import java.util.Arrays;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Ivan Edited: SergioPadilla
 * 
 */
public class User {
    private static final User instance = new User();
    private boolean active;
    private int id_employee;
    private String dni;
    private String name;
    private String surname;
    private Vector licence;
    private MySQLTools DB;
    
    private User(){
        active=false;
        DB = MySQLTools.getInstance();
    }
    
    //Encrypting functions
    
    private static String encrypt(String text) {
 
        String secretKey = "97f8c8e8a2802a"; //llave para encriptar datos
        String base64EncryptedString = "";
 
        try {
 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = text.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
}
    
    private static String toHexadecimal(byte[] digest){
        String hash = "";
        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }
    
    public static String encryptSHA(String message){
        byte[] digest = null;
        byte[] buffer = message.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }
        return toHexadecimal(digest);
    }

    //END Encrypting functions
    
    public static User getInstance(){
        return instance;
    }
    
    /**
    * Check if user and password are in the DB and, in this case, 
    * complete the atributes of the class and change active=true
    */
    public boolean login(String dni, String pass){
        DataEmployee employee=DB.consultEmployee(dni);
        if(encryptSHA(pass).equals(employee.password)){
            active=true;
            this.dni=dni;
            id_employee=employee.id_employee;
            name=employee.name;
            surname=employee.surname;
            licence=DB.consultRole(employee.role);
        } else {
        }
        return active;
    }
    
    /**
    * Erase all atributes and change active=false
    */
    public void logOut(){
        active=false;
        dni=null;
        id_employee=0;
        name=null;
        surname=null;
        licence=null;
    }
    public boolean hasLicence(int licence){
        return this.licence.contains(licence);
    }
    
    /**
    * @return if someone are login
    */
    public boolean isLogin(){
        return active;
    }
    
    public String getName(){
        if(active)
            return name;
        else
            return "User not register";
    }
    
    public String getSurname(){
        if(active)
            return surname;
        else
            return "User not register";
    }
    
    public int getId(){
        if(active)
            return id_employee;
        else
            return -1;
    }
    
    public String getDni(){
        if(active)
            return dni;
        else
            return "User not register";
    }
    
    /**
     * Insert new client in the table
     */
    public void insertClient(TypeClient type, String name, String surname, String dni, String email){
        if(licence.contains(300)){
            //insertar cliente
        }
    }
    
    /**
     * Get the data of the client with id specified
     * @param id_client
     * @return 
     */
    public DataClient consultClient(int id_client){
        DataClient res=null;
        if(licence.contains(303)){
            res=DB.consultClient(id_client);
        }
        return res;
    }
    
    public Vector listClients(){
        Vector res=null;
        if(licence.contains(303)){
            res=DB.listClients();
        }
        return res;
    }
    //"PRODUCTOS" table
    
    /**
     * Insert new product in the table
     */
    public void insertProduct(String name, String description, int amount){
        
    }
    
    /**
     * Consult Product
     * @return Object with the data of a product
     */
    public DataProduct consultProduct(int id_product){
        return new DataProduct(id_product,"","",1,1);
    }
    
    //"FACTURAS" table
    
    /**
     * Insert new bill in the table
     */
    public void insertBill(int id_client){
        
    }
    
    public DataBill consultBill(int id_client){
        return null;
    }
    
    //"SERVIDORES" table
    
    /**
     * Insert new server
     */
    public void insertServer(int id_client, String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        
    }
    
    
    //"EMPLEADOS" table
    
    /**
     * Insert new employee
     */
    public void insertEmployee(String dni, String name, String surname, int licence){
        
    }
    
    //"TAREAS" table
    
    /**
     * Insert new task
     */
    public void insertTask(String title, String description, int hour, int minutes){
        
    }
    
    //"REGISTROS" table
    
    /**
     * Insert new register
     */
    public void insertRegister(int id_employee, Time time_worked, String description, Date date){
        //description could be null
    }
    
    //"COMENTARIOS" table
    
    /**
     * Insert Comment
     */
    public void insertComment(int id_tarea, String comment){
        
    }
    
}
