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
    
     /**
     * Update Bill
     */
    public void update(){
        data=activeEmployee.consultBill(getData().id_bill);
    }
    
    public Vector listProducts(){
        Vector v=null;
        return v;
    }
    /**
     * Change the amount of the bill
     * @param amount
     */
    public void modifyBill(int amount){
        if(activeEmployee.hasLicence(402)){
            DB.modifyBill(getData().id_bill, amount, getData().id_client);
            update();
        }
    }
    
     /**
     * Erase the Bill
     */
    public void removeBill(){
        if (activeEmployee.hasLicence(401)){
            DB.removeBill(getData().id_bill);
            data=null;
        }
    }

    /**
     * @return the data
     */
    public DataBill getData() {
        return data;
    }
}
