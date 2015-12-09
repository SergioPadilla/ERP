/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLSQL;

import PLSQL.TypeClient;
import java.sql.Date;
import sekegex.StatusTask;
/**
 *
 * @author Sergio
 * 
 * Class to work with PLSQL and Database
 */
public class PlSQLTools {
    
    public PlSQLTools() {
    
    }
    
    //"CLIENTES" table
    
    /**
     * Insert new client in the table
     */
    public void insertClient(TypeClient type, String name, String surname, String dni, String email){
        
    }
    
    /**
     * Modify client with the params specified
     */
    public void modifyClient(int id_client, TypeClient type, String name, String surname, String dni, String email){
        
    }
    
    /**
     * Remove client
     */
    public void removeClient(int id_client){
        
    }
    
    //"PRODUCTOS" table
    
    /**
     * Insert new product in the table
     */
    public void insertProduct(String name, String description, int amount){
        
    }
    
    /**
     * Modify product
     */
    public void modifyProduct(int id_product, String name, String description, int amount){
        
    }
    
    /**
     * Remove Product
     */
    public void removeProduct(int id_product){
        
    }
    
    //"FACTURAS" table
    
    /**
     * Insert new bill in the table
     */
    public void insertBill(int id_client){
        
    }
    
    /**
     * Modify bill
     */
    public void modifyBill(int id_bill, int amount, int id_client){
    
    }
    
    /**
     * Remove bill
     */
    public void removeBill(int id_bill){
        
    }
    
    //"COMPRAS" table
    
    /**
     * Insert new bill in the table
     */
    public void insertPurchase(int id_bill, int id_product){
        
    }
    
    /**
     * Erase a product of a purchase
     */
    public void removeProductOfPurchase(int id_bill, int id_product){
        
    }
    
    //"SERVIDORES" table
    
    /**
     * Insert new server
     */
    public void insertServer(int id_client, String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        
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
    
    //"EMPLEADOS" table
    
    /**
     * Insert new employee
     */
    public void insertEmployee(String dni, String name, String surname, int licence){
        
    }
    
    /**
     * Modify employee
     */
    public void modifyEmployee(int id_employee, String dni, String name, String surname, int licence){
        
    }
    
    /**
     * Erase employee
     */
    public void removeEmployee(int id_employee){
        
    }
    
    //"TAREAS" table
    
    /**
     * Insert new task
     */
    public void insertTask(String title, String description, int hour, int minutes){
        
    }
    
    /**
     * Modify task
     */
    public void modifyTask(int id_task, String title, String description, Date time_estimated, Date date_to_finish, int id_task_father, int id_employee, StatusTask status){
        
    }
    
    /**
     * Erase task
     */
    public void eraseTask(int id_task){
        
    }
    
    //"REGISTROS" table
    
    /**
     * Insert new register
     */
    public void insertRegister(int id_employee, Date time_worker, String description, Date date){
        //description could be null
    }
    
    /**
     * Modify register
     */
    public void modifyRegister(int id_employee, Date time_worker, String description, Date date){
        
    }
    
    /**
     * Erase register
     */
    public void removeRegister(int id_register){
        
    }
    
    //"COMENTARIOS" table
    
    /**
     * Insert Comment
     */
    public void insertComment(int id_tarea, String comment){
        
    }
    
    /**
     * Modify Comment
     */
    public void modifyComment(int id_comment, int id_tarea, String comment){
        
    }
    
    /**
     * Erase Comment
     */
    public void removeComment(int id_comment){
        
    }
}
