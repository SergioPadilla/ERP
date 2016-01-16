/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import java.sql.Date;

/**
 *
 * @author Sergio
 */
public class DataBill {
    public int id_bill;
    public int id_client;
    public Date date;
    public float amount;
    
    public DataBill(int id_bill,int id_client,Date date,float amount){
        this.id_bill = id_bill;
        this.id_client = id_client;
        this.date = date;
        this.amount=amount;
    } 
}
