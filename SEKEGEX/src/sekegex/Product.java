/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.DataProduct;

/**
 *
 * @author Sergio
 */
public class Product {
    private DataProduct data;
    /**
     * Initialize with a calls to DB
     */
    public Product(int id_product){
        this.data = consultProduct(id_product);
    }
    
    /**
     * Call the DB
     */
    public DataProduct consultProduct(int id_product){
        return new DataProduct(id_product, "", "", 1, 1);
    }
    /**
     * Modify product
     */
    public void modifyProduct(int id_product, String name, String description, int amount){
        
    }
    
    /**
     * Remove Product
     */
    public void removeProduct(int id_product){
        
    }
}
