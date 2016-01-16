/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DataType.*;
import Utils.TypeClient;
import java.util.*;
import sekegex.*;



/**
 *
 * @author Sergio Padilla López
 * @author Iván Calle Gil
 * @author Marina Estévez Almenzar
 * @author Jose Pimentel Mesones
 *
 */
public class Sekegex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        User activeEmployee=User.getInstance();
        Scanner sc = new Scanner(System.in);
        String dni;
        String pass;
        String opc,opcC;
        while(true){
            while(!activeEmployee.isLogin()){
                System.out.print("Dni: ");
                dni = sc.nextLine();
                System.out.print("contraseña: ");
                pass = sc.nextLine();
                if(!activeEmployee.login(dni, pass)){
                    System.out.println("Error de autentificación");
                }
            }
            System.out.println("opciones: \nx-->desconectar\nc-->Clientes\np-->Productos\nw-->Workflow");
            System.out.print("opción: ");
            opc = sc.nextLine();
            if(opc.equals("x")){
                activeEmployee.logOut();
            }
            if(opc.equals("c")){
                Vector clients=activeEmployee.listClients();
                if(clients==null){
                    System.out.println("No tienes los permisos suficientes");
                }else{
                    for(int i=0; i<clients.size();i++){
                        DataClient clienti=(DataClient)clients.elementAt(i);
                        System.out.println(clienti.id+"-->"+clienti.name+" "+clienti.surname);
                    }
                }
                System.out.println("opciones de cliente: \ni-->Insertar\nm-->Modificar\nv-->Ver cliente");
                System.out.print("opción: ");
                opcC = sc.nextLine();
                if(opcC.equals("v")){
                    System.out.print("Id: ");
                    int Id = sc.nextInt();
                    sc.nextLine();
                    Client clientO= new Client(Id);
                    DataClient client=clientO.getData();
                    if(client==null){
                        System.out.println("No tienes los permisos suficientes");
                    }else{
                        System.out.println("Id: "+Id);
                        System.out.println("Nombre: "+client.name);
                        System.out.println("Apellidos: "+client.surname);
                        System.out.println("nif: "+client.dni);
                        if(client.type==TypeClient.BUSINESS){
                            System.out.println("tipo: Empresa");
                        }else{
                            System.out.println("tipo: Particular");
                        }
                        System.out.println("email: "+client.email);
                        System.out.println("fecha de alta: "+client.registration);
                        System.out.println("--->Lista de servidores<---" );
                        Vector servers=clientO.listServers();
                        if(servers==null){
                            System.out.println("no tiene permiso");
                        }else{
                            for(int i=0; i<servers.size();i++){
                                DataServer serveri=(DataServer)servers.elementAt(i);
                                System.out.println(serveri.id_server+"-->"+serveri.name);
                            }
                        }
                        System.out.println("--->Lista de facturas<---" );
                        Vector bills=clientO.listBills();
                        System.out.println("Crear factura" );
                        if(bills==null){
                            System.out.println("no tiene permiso");
                        }else{
                            for(int i=0; i<bills.size();i++){
                                DataBill billi=(DataBill)bills.elementAt(i);
                                System.out.println(billi.id_bill+"-->"+billi.date);
                            }
                        }
                    }
                    System.out.println("opciones de cliente: \nf-->Ver factura\ns-->Ver servidor\ni-->Insertar servidor\nif-->insertar factura(hecho y comprobado pero solo para la interfaz grafica)\nb-->Borrar cliente");
                    System.out.print("opción: ");
                    opcC = sc.nextLine();
                    if(opcC.equals("f")){
                            System.out.print("Id: ");
                            Id = sc.nextInt();
                            sc.nextLine();
                            Bill bill=new Bill(Id);
                            DataBill Dbill=bill.getData();
                            System.out.println("Id: "+Dbill.id_bill);
                            Vector products=bill.listProductsforbill();
                            for(int i=0; i<products.size();i++){
                                DataProduct producti=(DataProduct)products.elementAt(i);
                                System.out.println(producti.id+"-->"+producti.name+" "+producti.amount);
                            }
                            System.out.println("importe: "+Dbill.amount);
                            System.out.println("opciones de cliente: \nm-->Modificar(hecho y comprobado pero solo para la interfaz grafica)\nb-->Borrar");
                            System.out.print("opción: ");
                            opcC = sc.nextLine();
                            if(opcC.equals("m")){
                                bill.removeBill();
                                bill=null;
                            }
                    }else if(opcC.equals("s")){
                        System.out.print("Id: ");
                        Id = sc.nextInt();
                        sc.nextLine();
                        Server server=new Server(Id);
                            DataServer Dserver=server.getData();
                            System.out.println("Id: "+Dserver.id_server);
                            System.out.println("Ip: "+Dserver.ip);
                            System.out.println("nombre: "+Dserver.name);
                            System.out.println("user ftp: "+Dserver.user_ftp);
                            System.out.println("pass ftp: "+Dserver.pass_ftp);
                            System.out.println("user host: "+Dserver.user_host);
                            System.out.println("pass host: "+Dserver.pass_host);
                            System.out.println("--->Lista de dominios<---" );
                            Vector domains=server.listDomains();
                            for(int i=0; i<domains.size();i++){
                                DataDomain domaini=(DataDomain)domains.elementAt(i);
                                System.out.println(domaini.id_domain+"-->"+domaini.name);
                            }
                            System.out.println("opciones de servidor: \nm-->Modificar\nb-->Borrar\ni-->insertar dominio\nbd-->Borrar dominio");
                            System.out.print("opción: ");
                            opcC = sc.nextLine();
                            if(opcC.equals("m")){
                                System.out.print("Ip: ");
                                String ip=sc.nextLine();
                                System.out.print("nombre: ");
                                String name=sc.nextLine();
                                System.out.print("user ftp: ");
                                String user_ftp=sc.nextLine();
                                System.out.print("pass ftp: ");
                                String pass_ftp=sc.nextLine();
                                System.out.print("user host: ");
                                String user_host=sc.nextLine();
                                System.out.print("pass host: ");
                                String pass_host=sc.nextLine();
                                server.modifyServer(name, ip, user_ftp, pass_ftp, user_host, pass_host);
                            }else if(opcC.equals("i")){
                                System.out.print("web: ");
                                String web=sc.nextLine();
                                server.insertDomain(web);
                            }else if(opcC.equals("bd")){
                                System.out.print("Id: ");
                                int id=sc.nextInt();
                                sc.nextLine();
                                Domain D=new Domain(id);
                                D.removeDomain();
                            }else if(opcC.equals("b")){
                                server.removeServer();
                                server=null;
                            }
                    }else if(opcC.equals("i")){
                        System.out.print("Ip: ");
                        String ip=sc.nextLine();
                        System.out.print("nombre: ");
                        String name=sc.nextLine();
                        System.out.print("user ftp: ");
                        String user_ftp=sc.nextLine();
                        System.out.print("pass ftp: ");
                        String pass_ftp=sc.nextLine();
                        System.out.print("user host: ");
                        String user_host=sc.nextLine();
                        System.out.print("pass host: ");
                        String pass_host=sc.nextLine();
                        clientO.insertServer(name, ip, user_ftp, pass_ftp, user_host, pass_host);
                    }else if(opcC.equals("b")){
                        clientO.removeClient();
                        clientO=null;
                    }
                    
                }else if(opcC.equals("m") || opcC.equals("i")){
                    int Id=0;
                    if(opcC.equals("m")){
                        System.out.print("Id: ");
                        Id = sc.nextInt();
                        sc.nextLine();
                    }
                    System.out.print("nombre: ");
                    String name = sc.nextLine();
                    System.out.print("apellidos: ");
                    String surname = sc.nextLine();
                    System.out.print("tipo: 1-->Empresa, 2-->particular ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    System.out.print("nif: ");
                    String nif = sc.nextLine();
                    System.out.print("email: ");
                    String email = sc.nextLine();
                    if(opcC.equals("m")){
                        Client ClientO= new Client(Id);
                        if(type==1){
                            ClientO.modifyClient(TypeClient.BUSINESS, name, surname, nif, email);
                        }if(type==2){
                            ClientO.modifyClient(TypeClient.FREELANCE, name, surname, nif, email);
                        }else{
                            ClientO.modifyClient(null, name, surname, nif, email);
                        }

                    }else{
                        if(type==1){
                            activeEmployee.insertClient(TypeClient.BUSINESS, name, surname, nif, email);
                        }else{
                            activeEmployee.insertClient(TypeClient.FREELANCE, name, surname, nif, email);
                        }
                    }
                
                }
            }else if(opc.equals("p")){
                System.out.println("opciones de productos: \ni-->Insertar\nv-->Ver producto");
                System.out.println("--->Lista de dominios<---" );
                Vector products=activeEmployee.listProducts();
                for(int i=0; i<products.size();i++){
                    DataProduct producti=(DataProduct)products.elementAt(i);
                    System.out.println(producti.id+"-->"+producti.name);
                }
                System.out.print("opción: ");
                opcC = sc.nextLine();
                if(opcC.equals("v")){
                    System.out.print("Id: ");
                    int Id = sc.nextInt();
                    sc.nextLine();
                    Product product= new Product(Id);
                    DataProduct Dproduct=product.getData();
                    System.out.println("Id: "+Dproduct.id);
                    System.out.println("nombre: "+Dproduct.name);
                    System.out.println("descripción: "+Dproduct.description);
                    System.out.println("precio: "+Dproduct.amount);
                    System.out.println("opciones de productos: \nb-->Borrar\nm-->Modificar");
                    System.out.print("opción: ");
                    opcC = sc.nextLine();
                    if(opcC.equals("m")){
                        System.out.print("nombre: ");
                        String name = sc.nextLine();
                        System.out.print("descripción: ");
                        String description = sc.nextLine();
                        System.out.print("precio: ");
                        float amount = sc.nextFloat();
                        sc.nextLine();
                        product.modifyProduct(name, description, amount);
                    }else if(opcC.equals("b")){
                        product.removeProduct();
                        product=null;
                    }
                }else if(opcC.equals("i")){
                    System.out.print("nombre: ");
                    String name = sc.nextLine();
                    System.out.print("descripción: ");
                    String description = sc.nextLine();
                    System.out.print("precio: ");
                    float amount = sc.nextFloat();
                    sc.nextLine();
                    activeEmployee.insertProduct(name, description, amount);
                }
            }else if(opc.equals("w")){
                System.out.println("opciones de tareas: \ni-->Insertar\nv-->Ver tarea");
                System.out.print("opción: ");
                opcC = sc.nextLine();
                if(opcC.equals("v")){
                    System.out.print("Id: ");
                    int Id = sc.nextInt();
                    sc.nextLine();
                    Product product= new Product(Id);
                    DataProduct Dproduct=product.getData();
                    System.out.println("Id: "+Dproduct.id);
                    System.out.println("nombre: "+Dproduct.name);
                    System.out.println("descripción: "+Dproduct.description);
                    System.out.println("precio: "+Dproduct.amount);
                    System.out.println("opciones de productos: \nb-->Borrar\nm-->Modificar");
                    System.out.print("opción: ");
                    opcC = sc.nextLine();
                    if(opcC.equals("m")){
                        System.out.print("nombre: ");
                        String name = sc.nextLine();
                        System.out.print("descripción: ");
                        String description = sc.nextLine();
                        System.out.print("precio: ");
                        float amount = sc.nextFloat();
                        sc.nextLine();
                        product.modifyProduct(name, description, amount);
                    }else if(opcC.equals("b")){
                        product.removeProduct();
                        product=null;
                    }
                }else if(opcC.equals("i")){
                    System.out.print("nombre: ");
                    String name = sc.nextLine();
                    System.out.print("descripción: ");
                    String description = sc.nextLine();
                    System.out.print("precio: ");
                    float amount = sc.nextFloat();
                    sc.nextLine();
                    activeEmployee.insertProduct(name, description, amount);
                }
            }
            opc=null;
            opcC=null;
       }
    }
    
}
