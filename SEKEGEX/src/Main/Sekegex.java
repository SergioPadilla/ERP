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
            System.out.println("opciones: \n "
                    + "x-->desconectar\n"
                    + "c-->Clientes");
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
                System.out.println("opciones de cliente: \n "
                    + "i-->Insertar\n"
                    + "m-->Modificar\n"
                    + "v-->Ver cliente\n"
                    + "b-->Borrar cliente (no implementado)");
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
                            ClientO.modifyClient("BUSINESS", name, surname, nif, email);
                        }if(type==2){
                            ClientO.modifyClient("FREELANCE", name, surname, nif, email);
                        }else{
                            ClientO.modifyClient("", name, surname, nif, email);
                        }

                    }else{
                        if(type==1){
                            activeEmployee.insertClient("BUSINESS", name, surname, nif, email);
                        }else{
                            activeEmployee.insertClient("FREELANCE", name, surname, nif, email);
                        }
                    }
                
                }
            }
            opc=null;
            opcC=null;
       }
    }
    
}
