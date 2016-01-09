/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.*;
import Utils.StatusTask;
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
    
    /**
     * Check if the user has the licence specified
     * @param licence
     * @return 
     */
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
    public String getIdtoString(){
        if(active)
            return ""+id_employee;
        else
            return "";
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
        System.out.println("as: "+res);
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
    public void insertProduct(String name, String description, float amount){
        if(licence.contains(500)){
            DB.insertProduct(name, description, amount);
        }
    }
    
    /**
     * Consult Product
     * @return Object with the data of a product
     */
    public DataProduct consultProduct(int id_product){
        DataProduct res=null;
        if(licence.contains(503)){
            res=DB.consultProduct(id_product);
        }
        return res;
    }
    
    //"FACTURAS" table
    
    /**
     * Get the data of bill with id specified
     * @param id_bill
     * @return 
     */
    
    public DataBill consultBill(int id_bill){
        DataBill res=null;
        if(licence.contains(403)){
            res=DB.consultBill(id_bill);
        }
        return res;
    }
    
    //"SERVIDORES" table
    
    /**
     * Get the data of server with id specified
     * @param id_server
     * @return 
     */
    
    public DataServer consultServer(int id_server){
        DataServer res=null;
        if(licence.contains(703)){
            res=DB.consultServer(id_server);
        }
        return res;
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
    
    /**
     * List names of the employees
     */
    public Vector listNamesEmployees(){
        Vector names = null;
        
        if(licence.contains(903)){
            names = DB.listNamesEmployees();
        }
        
        return names;
    }
    
    //"TAREAS" table
    
    /**
     * Insert new task
     */
    public Boolean insertTask(String title, String description, Time time_estimated){
        Boolean ok = true;
        
        if(licence.contains(100)){
            DB.insertTask(title, description, time_estimated);
        }
        else{
            ok = false;
        }
        return ok;
    }
    /**
     * Get the data of task with id specified
     * @param id_task
     * @return 
     */
    public DataTask consultTask(int id_task){
         DataTask task = null;
         
         if(licence.contains(103)){
            task = DB.consultTask(id_task); 
         }
         
         return task;       
    }
    
    public Vector listProducts(){
        Vector res = null;
         
        if(licence.contains(503)){
           res = DB.listProducts(); 
        }
         
        return res;  
    }
    
    /**
     * Get the title of all task
     * @return 
     */
    public Vector listTitleTasks(){
        Vector tasks = null;
        
        if(licence.contains(103)){
            tasks = DB.listTitleTasks();
        }
        
        return tasks;
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
     * Insert Domain
     */
    public DataDomain consultDomain(int id_domain){
        DataDomain res=null;
        if(licence.contains(803)){
            res=DB.consultDomain(id_domain);
        }
        return res;
    }
    
}
