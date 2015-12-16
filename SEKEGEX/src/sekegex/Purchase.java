/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;
import DataType.DataPurchase;
/**
 *
 * @author jopime
 */
public class Purchase {
    private User activeEmployee = User.getInstance();
    private static MySQLTools DB = MySQLTools.getInstance();
    private DataPurchase data;
    
    public Purchase(int id_purchase){
        data = consultPurchase(id_purchase);
    }
    
     /**
     * Call the DB and consult the information for the purchase specified
     * @param id_purchase
     * @return Full atributes of purchase
     */
    public DataPurchase consultPurchase(int id_purchase){
        return getData(); //Esto va fuera, hay que llamar a la DB
    }

    /**
     * @return the data
     */
    public DataPurchase getData() {
        return data;
    }
}
