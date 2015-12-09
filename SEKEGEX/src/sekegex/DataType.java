/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sekegex;
import PLSQL.TypeClient;
import java.sql.Date;


/**
 *
 * @author Ivan
 */

public class DataClient {
    public int id;
    public TypeClient type;
    public String name;
    public String surname;
    public String dni;
    public String email;
    public Date registration;
    
    public DataClient(int id,TypeClient type, String name,String surname,String dni, String email, Date registration){
        this.id=id;
        this.type=type;
        this.name=name;
        this.surname=surname;
        this.dni=dni;
        this.email=email;
        this.registration=registration;
    }
    
}

public class DataProduct {
    public int id;
    public String name;
    public String description;
    public float amount;
    public int nSold;
    
    public DataProduct(int id,String name,String description,float amount,int nSold){
        this.id=id;
        this.name=name;
        this.description=description;
        this.amount=amount;
        this.nSold=nSold;
    }
    
}

public class DataBill {
    public int id_bill;
    public int id_client;
    public Date date;
    
    public DataBill(int id_bill,int id_client,Date date){
        this.id_bill=id_bill;
        this.id_client=id_client;
        this.date=date;
    }
    
}
public class DataBuy {
    public int id_bill;
    public int id_product;
    public float value;
    
    public DataBuy(int id_bill,int id_client,float value){
        this.id_bill=id_bill;
        this.id_product=id_product;
        this.value=value;
    }
    
}

public class DataServer {
    public int id_server;
    public int id_client;
    public String name;
    public String ip;
    public String user_ftp;
    public String pass_ftp;
    public String user_host;
    public String pass_host;
    
    public DataServer(int id_server,int id_client,String name,String ip,String user_ftp,String pass_ftp,String user_host,String pass_host){
        this.id_server=id_server;
        this.id_client=id_client;
        this.name=name;
        this.ip=ip;
        this.user_ftp=user_ftp;
        this.pass_ftp=pass_ftp;
        this.user_host=user_host;
        this.pass_host=pass_host;
    }
    
}

public class DataDomain {
    public int id_server;
    public int id_domain;
    public String name;
    
    public DataDomain(int id_server,int id_domain,String name){
        this.id_server=id_server;
        this.id_domain=id_domain;
        this.name=name;
    }
    
}

public class DataDomain {
    public int id_employee;
    public String name;
    public String dni;
    public String surname;
    //public int license;
    
    public DataDomain(int id_employee,String name,String dni,String surname){ //añadir int license;
        this.id_employee=id_employee;
        this.dni=dni;
        this.name=name;
        this.surname=surname;
        //this.license=license;
    }
    
}