/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Vector;


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
        licence=new Vector();
    }
    
    
    public static User getInstance(){
        return instance;
    }
    
    /**
    * Check if user and password are in the DB and, in this case, 
    * complete the atributes of the class and change active=true
    */
    public boolean login(String dni, String pass){
        DataEmployee employee=DB.consultEmployee(dni);
        if(employee.password!=null && MySQLTools.encryptSHA(pass).equals(employee.password)){
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
    public boolean insertClient(String type, String name, String surname, String dni, String email){
        boolean res=false;
        if(licence.contains(300)){
            res=DB.insertClient(type, name, surname, dni, email);
        }
        return res;
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
    public void insertBill(int id_client,Vector products){
        //disparador 1
        if(licence.contains(303)){
            System.out.println("entra");
            int Id_db=0;
            Id_db=DB.insertBill(id_client);
            for(int i=0;i<products.size();i++){
                DB.insertPurchase(Id_db,(int) products.elementAt(i));
            }
        }
        
    }
    
    /**
     * Get the data of bill with id specified
     * @param id_bill
     * @return 
     */
    
    public DataBill consultBill(int id_bill){
        return null;
    }
    
    //"SERVIDORES" table
    
    /**
     * Insert new server
     */
    public void insertServer(int id_client, String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        
    }
    
    /**
     * Get the data of server with id specified
     * @param id_server
     * @return 
     */
    
    public DataServer consultServer(int id_server){
        return null;
    }
    
    
    //"EMPLEADOS" table
    
    /**
     * Insert new employee
     */
    public void insertEmployee(String dni, String name, String surname, int licence){
        
    }
    /**
     * Get the data of employee with id specified
     * @param id_employee
     * @return 
     */
    
    public DataEmployee consultEmployee(int id_employee){
        return null;
    }
    
    //"TAREAS" table
    
    /**
     * Insert new task
     */
    public void insertTask(String title, String description, int hour, int minutes){
        
    }
    /**
     * Get the data of task with id specified
     * @param id_task
     * @return 
     */
    
    public DataTask consultTask(int id_task){
        return null;
    }
    
    //"REGISTROS" table
    
    /**
     * Insert new register
     */
    public void insertRegister(int id_employee, Time time_worked, String description, Date date){
        //description could be null
    }
    
     /**
     * Get the data of register with id specified
     * @param id_register
     * @return 
     */
    
    public DataRegisters consultRegister(int id_register){
        return null;
    }
    
    //"COMENTARIOS" table
    
    /**
     * Insert Comment
     */
    public void insertComment(int id_tarea, String comment){
        
    }
    
    /**
     * Get the data of comment with id specified
     * @param id_comment
     * @return 
     */
    
    public DataComment consultComment(int id_comment){
        return null;
    }
    
    /**
     * Get the data of domain with id specified
     * @param id_domain
     * @return 
     */
    
    public DataDomain consultDomain(int id_domain){
        return null;
    }
    
}
