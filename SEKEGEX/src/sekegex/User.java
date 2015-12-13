/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sekegex;

import DataType.DataProduct;
import Utils.StatusTask;
import Utils.TypeClient;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Ivan Edited: SergioPadilla
 */
public class User {
    private static final User instance = new User();
    private boolean active;
    private int id_employee;
    private String dni;
    private String name;
    private String surname;
    //private int licence;
    
    private User(){
        active=false;
    }
    
    public static User getInstance(){
        return instance;
    }
    
    /**
    * Check if user and password are in the DB and, in this case, 
    * complete the atributes of the class and change active=true
    */
    public boolean login(String user, String pass){
        
        return false;
    }
    
    /**
    * Erase all atributes and change active=false
    */
    public void logOut(){
        
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
    protected void insertClient(TypeClient type, String name, String surname, String dni, String email){
        
    }
    
    /**
     * Modify client with the params specified
     */
    protected void modifyClient(int id_client, TypeClient type, String name, String surname, String dni, String email){
        
    }
    
    /**
     * Remove client
     */
    protected void removeClient(int id_client){
        
    }
    
    //"PRODUCTOS" table
    
    /**
     * Insert new product in the table
     */
    protected void insertProduct(String name, String description, int amount){
        
    }
    
    /**
     * Modify product
     */
    protected void modifyProduct(int id_product, String name, String description, int amount){
        
    }
    
    /**
     * Consult Product
     * @return Object with the data of a product
     */
    protected DataProduct consultProduct(int id_product){
        return new DataProduct(id_product,"","",1,1);
    }
    
    /**
     * Remove Product
     */
    protected void removeProduct(int id_product){
        
    }
    
    //"FACTURAS" table
    
    /**
     * Insert new bill in the table
     */
    protected void insertBill(int id_client){
        
    }
    
    /**
     * Modify bill
     */
    protected void modifyBill(int id_bill, int amount, int id_client){
    
    }
    
    
    //"SERVIDORES" table
    
    /**
     * Insert new server
     */
    protected void insertServer(int id_client, String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        
    }
    
    /**
     * Modify server
     */
    protected void modifyServer(int id_client, String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        
    }
    
    /**
     * Erase server
     */
    protected void removeServer(int id_server){
        
    }
    
    //"EMPLEADOS" table
    
    /**
     * Insert new employee
     */
    protected void insertEmployee(String dni, String name, String surname, int licence){
        
    }
    
    /**
     * Modify employee
     */
    protected void modifyEmployee(int id_employee, String dni, String name, String surname, int licence){
        
    }
    
    /**
     * Erase employee
     */
    protected void removeEmployee(int id_employee){
        
    }
    
    //"TAREAS" table
    
    /**
     * Insert new task
     */
    protected void insertTask(String title, String description, int hour, int minutes){
        
    }
    
    /**
     * Modify task
     */
    protected void modifyTask(int id_task, String title, String description, Time time_estimated, Date due_date, int id_task_father, int id_employee, StatusTask status){
        
    }
    
    /**
     * Erase task
     */
    protected void eraseTask(int id_task){
        
    }
    
    //"REGISTROS" table
    
    /**
     * Insert new register
     */
    protected void insertRegister(int id_employee, Time time_worked, String description, Date date){
        //description could be null
    }
    
    /**
     * Modify register
     */
    protected void modifyRegister(int id_employee, Time time_worked, String description, Date date){
        
    }
    
    /**
     * Erase register
     */
    protected void removeRegister(int id_register){
        
    }
    
    //"COMENTARIOS" table
    
    /**
     * Insert Comment
     */
    protected void insertComment(int id_tarea, String comment){
        
    }
    
    /**
     * Modify Comment
     */
    protected void modifyComment(int id_comment, int id_tarea, String comment){
        
    }
    
    /**
     * Erase Comment
     */
    protected void removeComment(int id_comment){
        
    }
}
