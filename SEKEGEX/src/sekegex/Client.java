/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sekegex;
import DataType.DataClient;

/**
 *
 * @author Ivan
 */
public class Client {
    
    private DataClient data;
    
    public Client(int id){
        data = consultClient(id);
    }
    
    public DataClient consultClient(int id){
        return data;
    }
}
