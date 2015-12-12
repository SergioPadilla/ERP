/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

/**
 *
 * @author Sergio
 */
public class DataEmployee {
    public int id_employee;
    public String name;
    public String dni;
    public String surname;
    //public int license;
    
    public DataEmployee(int id_employee, String name, String dni, String surname){ //add int license;
        this.id_employee = id_employee;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        //this.license = license;
    }
}
