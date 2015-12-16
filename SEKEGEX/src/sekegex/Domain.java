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
     * Update the comment
     */
    public void update(){
        data=activeEmployee.consultDomain(data.id_domain);
    }
    
    /**
     * Erase the comment
     */
    public void removeComment(){
        if (activeEmployee.hasLicence(801)){
            DB.removeDomain(data.id_domain);
            data=null;
        }
    }
}
