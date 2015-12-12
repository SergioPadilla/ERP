/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;
import sekegex.TypeClient;
import java.sql.Date;
import sekegex.TypeClient;


/**
 *
 * @author Ivan
 */

public class DataClient {
    public int id;
    public TypeClient type;
    public String name;
    public String surname;
    public String dni;
    public String email;
    public Date registration;
    
    public DataClient(int id, TypeClient type, String name, String surname, String dni, String email, Date registration){
        this.id = id;
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.email = email;
        this.registration = registration;
    }   
}