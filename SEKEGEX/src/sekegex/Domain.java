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
    private DataDomain data;
    /**
     * Initialize with a calls to DB
     */
    public Domain(int id_domain){
        this.data = consultDomain(id_domain);
    }
    
 
    /**
     * Call the DB and consult the information for the domain specified
     * @param id_domain
     * @return Full atributes of domain
     */
    public DataDomain consultDomain(int id_domain){
        return data; //Esto va fuera, hay que llamar a la DB
    }
}
