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
    private User activeEmployee = User.getInstance();
    private static MySQLTools DB = MySQLTools.getInstance();
    private DataProduct data;
    /**
     * Initialize with a calls to DB
     */
    public Product(int id_product){
        data = activeEmployee.consultProduct(id_product);
    }
    
     /**
     * Update Product
     */
    public void update(){
        data=activeEmployee.consultProduct(getData().id);
    }
     /**
     * Change date of Products
     * @param name 
     * @param description
     * @param amount
     */
    public void modifyProduct(String name, String description, float amount){
        if (activeEmployee.hasLicence(502)){
            DB.modifyProduct(getData().id, name,description, amount);
            update();
        } //consideramos que solo se puede modificar el texto no las id
    }
    /**
     * Remove Product
     */
    public void removeProduct(){
        if (activeEmployee.hasLicence(501)){
            DB.removeBill(getData().id);
            data=null;
        }
    }

    /**
     * @return the data
     */
    public DataProduct getData() {
        return data;
    }
}
