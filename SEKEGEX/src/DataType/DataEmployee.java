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
    public String password;
    public String surname;
    public int role;
    
    public DataEmployee(int id_employee, String name, String dni, String password, String surname, int role){
        this.id_employee = id_employee;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }
}
