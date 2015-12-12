/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

/**
 *
 * @author Sergio
 */
public class DataDomain {
    public int id_server;
    public int id_domain;
    public String name;
    
    public DataDomain(int id_server,int id_domain,String name){
        this.id_server = id_server;
        this.id_domain = id_domain;
        this.name = name;
    }
}
