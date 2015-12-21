/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.*;
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
        data=activeEmployee.consultBill(data.id_bill);
    }
    
    public Vector listProductsforbill(){
       Vector res=null;
        if(activeEmployee.hasLicence(503)){
            res=DB.listProductsforbill(data.id_bill);
        }
        return res;
    }
    /**
     * Change the amount of the bill
     * @param amount
     */
    public void modifyBill(Vector add,Vector remove,int id_cliente){
        if(activeEmployee.hasLicence(402)){
            for(int i=0; i<add.size();i++){
                DB.insertPurchase(data.id_bill,(int) add.elementAt(i));
            }
            for(int i=0; i<remove.size();i++){
                DB.removePurchase(data.id_bill,(int) remove.elementAt(i));
            }
            if(id_cliente!=0){
                DB.modifyBill(data.id_bill, id_cliente);
            }
            update();
        }
    }

    /**
     * @return the data
     */
    public DataBill getData() {
        return data;
    }
}
