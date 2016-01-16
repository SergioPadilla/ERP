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
        this.id_server = id_server;
        this.id_client = id_client;
        this.name = name;
        this.ip = ip;
        this.user_ftp = user_ftp;
        this.pass_ftp = pass_ftp;
        this.user_host = user_host;
        this.pass_host = pass_host;
    }
}
