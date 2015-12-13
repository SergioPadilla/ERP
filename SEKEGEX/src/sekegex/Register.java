/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sekegex;

import DataType.DataRegisters;
import PLSQL.PLSQLTools;

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
        return new DataRegisters(id_register, 1, "", "", 1, 1);
    }
}
