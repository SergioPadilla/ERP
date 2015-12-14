/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;
import DataType.DataClient;
import java.util.Vector;

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
    
    public Vector listServers(){
        Vector v=null;
        return v;
    }
    
    public Vector listBills(){
        Vector v=null;
        return v;
    }
}
