/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;

import DataType.DataServer;
import java.util.Vector;

/**
 *
 * @author Ivan
 */
public class Server {
    private DataServer data;
    
    public Server(int id){
        data = consultServer(id);
    }
    
    public DataServer consultServer(int id){
        return data;
    }
    
    public Vector listDomains(){
        Vector v=null;
        return v;
    }
}
