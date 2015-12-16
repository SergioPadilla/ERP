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
    private DataEmployee data;
    
    public Employee(int id_Employee){
        data = consultEmployee(id_Employee);
    }
    
     /**
     * Call the DB and consult the information for the task specified
     * @param id_Employee
     * @return Full atributes of task
     */
    public DataEmployee consultEmployee(int id_Employee){
        return data; //Esto va fuera, hay que llamar a la DB
    }
    
    /**
     * Change the dni of the employee
     * @param dni 
     */
    public void modifyDni(String dni){
        data.dni = dni;
        //LLamar al método de PLSQLTools para modificar el dni
    }
    /**
     * Change the name of the employee
     * @param name 
     */
    public void modifyName(String name){
        data.name = name;
        //LLamar al método de PLSQLTools para modificar el nombre
    }        
    /**
     * Change the surname of the employee
     * @param surname 
     */
    public void modifySurname(String surname){
        data.surname = surname;
        //LLamar al método de PLSQLTools para modificar el apellido
    }
    /**
     * Change the role of the employee
     * @param rol 
     */
    public void modifyName(int role){
        data.role = role;
        //LLamar al método de PLSQLTools para modificar el rol
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
}
