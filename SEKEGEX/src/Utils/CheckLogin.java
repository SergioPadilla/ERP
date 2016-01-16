/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Vector;
import sekegex.MySQLTools;

/**
 *
 * @author Sergio
 */
public class CheckLogin {
    private String dni;
    private String password;
    private MySQLTools DB;
    
    public CheckLogin(String dni, String password){
        this.dni = dni;
        this.password = password;
        DB = MySQLTools.getInstance();
    }
    
    public Boolean isDniInDB(){
        Vector dnis = new Vector();
        dnis = DB.listDniEmployees();
        
        return dnis.contains(dni);
    }
}
