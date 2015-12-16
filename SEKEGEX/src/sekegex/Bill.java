/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.DataBill;
import java.util.Vector;

/**
 *
 * @author Ivan
 */
public class Bill {
    private User activeEmployee = User.getInstance();
    private static MySQLTools DB = MySQLTools.getInstance();
    private DataBill data;
    
    public Bill(int id_bill){
        data = activeEmployee.consultBill(id_bill);
    }
    
    public void update(){
        data=activeEmployee.consultBill(data.id_bill);
    }
    
    public Vector listProducts(){
        Vector v=null;
        return v;
    }
    /**
     * Change the amount and the id_client of the bill
     * @param id_client
     * @param amount
     * @param id_client 
     */
    public void modifyBill(int amount, int id_client){
        if(activeEmployee.hasLicence(402)){
            DB.modifyBill(data.id_bill, amount, id_client);
        }
    }
     /**
     * Erase the comment
     * @param id_comment 
     */
    public void removeBill(int id_comment){
        if (activeEmployee.hasLicence(401)){
            DB.removeBill(id_comment);
        }
    }
}
