/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.DataRegisters;
import java.sql.Date;
import java.sql.Time;
import java.sql.*;

/**
 *
 * @author jopime
 */
public class Register {
    private DataRegisters data;
    /**
     * Initialize with a calls to DB
     */
    public Register(int id_register){
        this.data = consultRegister(id_register);
    }
    
    /**
     * Call the DB
     */
    public DataRegisters consultRegister(int id_register){
        return data;
    }
    
    /**
     * Modify register
     */
    public void modifyRegister(int id_employee, Time time_worked, String description, Date date){
        
    }
    
    /**
     * Erase register
     */
    public void removeRegister(int id_register){
        
    }
}

