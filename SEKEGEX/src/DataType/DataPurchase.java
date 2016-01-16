/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

/**
 *
 * @author Sergio
 */
public class DataPurchase {
    public int id_bill;
    public int id_product;
    public float value;
    public int quantity;
    
    public DataPurchase(int id_bill,int id_product,float value,int quantity){
        this.id_bill = id_bill;
        this.id_product = id_product;
        this.value = value;
        this.quantity=quantity;
    }  
}
