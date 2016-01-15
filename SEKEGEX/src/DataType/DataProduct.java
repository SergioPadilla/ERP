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
public class DataProduct {
    public int id;
    public String name;
    public String description;
    public float amount;
    public int nSold;
    
    public DataProduct(int id, String name, String description, float amount, int nSold){
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.nSold = nSold;
    }
}
