/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;
import DataType.DataEmployee;

/**
 *
 * @author jopime
 */
public class Employee {
    
    private User activeEmployee = User.getInstance();
    private static MySQLTools DB = MySQLTools.getInstance();
    private DataEmployee data;
    
    public Employee(int id_Employee){
        data = activeEmployee.consultEmployee(id_Employee);
    }
    
     /**
     * Update the comment
     */
    public void update(){
        data=activeEmployee.consultEmployee(data.id_employee);
    }
    
    /**
     * Change the dni of the employee
     * @param dni 
     */
    public void modifyDni(String dni){
        if (activeEmployee.hasLicence(902)){
            data.dni = dni;
            update();
        }
    }    
    /**
     * Change the name of the employee
     * @param name 
     */
    public void modifyName(String name){
        if (activeEmployee.hasLicence(902)){
            DB.modifyEmployee(data.id_employee,data.dni, name, data.surname, data.role);
            update();
        }
    }        
    /**
     * Change the surname of the employee
     * @param surname 
     */
    public void modifySurname(String surname){
        if (activeEmployee.hasLicence(902)){
            DB.modifyEmployee(data.id_employee,data.dni, data.name, surname, data.role);
            update();
        }
    }
    /**
     * Change the role of the employee
     * @param rol 
     */
    public void modifyRole(int licence){
        if (activeEmployee.hasLicence(902)){
            DB.modifyEmployee(data.id_employee,data.dni, data.name, data.surname, licence);
            update();
        }
    }
    /**
     * Modify employee
     */
    public void modifyEmployee(String name, String surname, int licence){
        if (activeEmployee.hasLicence(902)){
            DB.modifyEmployee(data.id_employee,data.dni, name, surname, licence);
            update();
        }
    }
    
    /**
     * Erase employee
     */
    public void removeEmployee(int id_employee){
        if (activeEmployee.hasLicence(901)){
            DB.removeEmployee(data.id_employee);
            data=null;
        }        
    }
}
