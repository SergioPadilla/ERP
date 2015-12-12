/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Sergio
 */
public class DataRegisters {
    public int id_register;
    public int id_employee;
    public Time time_worked;
    public String description;
    public Date date;
    
    public DataRegisters(int id_register, int id_employee, Time time_worked, String description, Date date){
        this.id_register = id_register;
        this.id_employee = id_employee;
        this.time_worked = time_worked;
        this.description = description;
        this.date = date;
    }
}