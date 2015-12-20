/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;
import DataType.DataDomain;
/**
 *
 * @author jopime
 */
public class Domain {
    private User activeEmployee = User.getInstance();
    private static MySQLTools DB = MySQLTools.getInstance();
    private DataDomain data;
    /**
     * Initialize with a calls to DB
     */
    public Domain(int id_domain){
        data = activeEmployee.consultDomain(id_domain);
    }
    
 
    /**
     * Update the domain
     */
    public void update(){
        data=activeEmployee.consultDomain(getData().id_domain);
    }
    
    /**
     * Erase the domain
     */
    public void removeDomain(){
        if (activeEmployee.hasLicence(801)){
            DB.removeDomain(getData().id_domain);
            data=null;
        }
    }

    /**
     * @return the data
     */
    public DataDomain getData() {
        return data;
    }
}
