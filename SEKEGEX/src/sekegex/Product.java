/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import sekegex.DataType.java;
import PLSQL.PlSQLTools;

/**
 *
 * @author Sergio
 */
public class Product {
    private DataProduct data;
    /**
     * Initialize with a calls to DB
     */
    public Product(int id){
        data = consultProduct();
        //search in DB for the other values
    }
    
    /**
     * Call the DB
     */
    public DataProduct consultProduct(){
        
    }
}
