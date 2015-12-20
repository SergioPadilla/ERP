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
    private User activeEmployee = User.getInstance();
    private static MySQLTools DB = MySQLTools.getInstance();
    private DataRegisters data;
    
    /**
     * Initialize with a calls to DB
     */
    public Register(int id_register){
        data = activeEmployee.consultRegister(id_register);
    }
    
    /**
     * Update the comment
     */
    public void update(){
        data=activeEmployee.consultRegister(getData().id_register);
    }
    
    /**
     * Modify register
     * @param id_employee
     * @param time_worked
     * @param descripcion
     */
    public void modifyRegister(int id_employee, Time time_worked, String description, Date date){
        if(activeEmployee.hasLicence(1002)){
            DB.modifyRegister(id_employee, id_employee, time_worked, description, date);
            update();
        }
    }
    
    /**
     * Erase register
     */
    public void removeRegister(int id_register){
        if (activeEmployee.hasLicence(1001)){
            DB.removeComment(getData().id_register);
            data=null;
        }
    }

    /**
     * @return the data
     */
    public DataRegisters getData() {
        return data;
    }
}

