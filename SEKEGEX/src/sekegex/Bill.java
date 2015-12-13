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
    private DataBill data;
    
    public Bill(int id){
        data = consultBill(id);
    }
    
    public DataBill consultBill(int id){
        return data;
    }
    
    public Vector listProducts(){
        Vector v=null;
        return v;
    }
}
