/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLSQL;

import sekegex.TypeClient;
import java.sql.Date;
import sekegex.StatusTask;
import sekegex.DataProduct;
/**
 *
 * @author Sergio
 * 
 * Class to work with PLSQL and Database
 */
public class PlSQLTools {
    
    protected PlSQLTools() {
    
    }
    
    //"CLIENTES" table
    
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
    
    /**
     * Remove bill
     */
    protected void removeBill(int id_bill){
        
    }
    
    //"COMPRAS" table
    
    /**
     * Insert new bill in the table
     */
    protected void insertPurchase(int id_bill, int id_product){
        
    }
    
    /**
     * Erase a product of a purchase
     */
    protected void removeProductOfPurchase(int id_bill, int id_product){
        
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
    protected void modifyTask(int id_task, String title, String description, Date time_estimated, Date date_to_finish, int id_task_father, int id_employee, StatusTask status){
        
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
    protected void insertRegister(int id_employee, Date time_worker, String description, Date date){
        //description could be null
    }
    
    /**
     * Modify register
     */
    protected void modifyRegister(int id_employee, Date time_worker, String description, Date date){
        
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
