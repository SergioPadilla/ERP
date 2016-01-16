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
import java.util.Vector;


/**
 *
 * @author Ivan and SergioPadilla
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
    public int insertClient(TypeClient type, String name, String surname, String dni, String email){
        int res=0;
        if(licence.contains(300)){
            res=DB.insertClient(type, name, surname, dni, email);
        }
        else{
            res=-1;
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
    public int insertBill(int id_client){
        int res=0;
        if(licence.contains(400)){
            res=DB.insertBill(id_client);
        }
        else{
            res=-1;
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

    public void insertEmployee(String dni, String name, String pass, String surname, int rol){
        if(licence.contains(900)){
            DB.insertEmployee(dni, name, pass, surname, rol);
        }
    }
    /**
     * Get the data of employee with id specified
     * @param id_employee
     * @return
     */

    public DataEmployee consultEmployee(int id_employee){
        DataEmployee employee = null;

        if(licence.contains(903)){
            employee = DB.consultEmployee(id_employee);
        }

        return employee;
    }

    /**
     * List names of the employees
     */
    public Vector listEmployees(){
        Vector names = null;

        if(licence.contains(903)){
            names = DB.listEmployees();
        }

        return names;
    }

    //"TAREAS" table

    /**
     * Insert new task
     */
    public Boolean insertTask(String title, String description, Date date,int id_employee){
        Boolean ok = true;

        if(licence.contains(100))
            DB.insertTask(title, description, date,id_employee);
        else
            ok = false;

        return ok;
    }

    /**
     * Insert new SubTask
     */
    public Boolean insertSubTask(String title, String description, Date date,int id_employee, int id_task_father){
        Boolean ok = true;

        if(licence.contains(100))
            DB.insertSubTask(title, description, date,id_employee,id_task_father);
        else
            ok = false;

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
     * Get tasks
     * @return
     */
    public Vector listTasks(){
        Vector tasks = null;

        if(licence.contains(103)){
            tasks = DB.listTasks();
        }

        return tasks;
    }

    /**
     * Get Subtasks
     * @return
     */
    public Vector listSubTasks(int id_task_father){
        Vector tasks = null;

        if(licence.contains(103)){
            tasks = DB.listSubTasks(id_task_father);
        }

        return tasks;
    }

    //"COMENTARIOS" table

    /**
     * Insert Comment
     */
    public Boolean insertComment(int id_tarea, String comment){
        Boolean ok = true;

        if(licence.contains(200))
            DB.insertComment(id_tarea,comment);
        else
            ok = false;

        return ok;
    }
    
    /**
     * 
     * @param id_comment
     * @param id_task
     * @param comment 
     */
    public Boolean modifyComment(int id_comment, int id_task, String comment){
        Boolean ok = true;

        if(licence.contains(202))
            DB.modifyComment(id_comment,id_task,comment);
        else
            ok = false;

        return ok;
    }
    
    /**
     * 
     * @param id_tarea
     * @return 
     */
    public Vector listComments(int id_task){
        Vector comments = null;

        if(licence.contains(203)){
            comments = DB.listSubTasks(id_task);
        }

        return comments;
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
