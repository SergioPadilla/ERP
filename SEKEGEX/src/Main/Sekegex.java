/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DataType.*;
import Utils.StatusTask;
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
                    + "c-->Clientes\n"
                    + "w-->Workflow\n"
                    + "p-->Productos\n");
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
            if(opc.equals("p")){
                Vector products=activeEmployee.listProducts();
                System.out.println(activeEmployee.listProducts().toString());
                if(products==null){
                    System.out.println("No tienes los permisos suficientes");
                }else{
                    for(int i=0; i<products.size();i++){
                        DataProduct producti=(DataProduct)products.elementAt(i);
                        System.out.println(producti.id+"-->"+producti.name+" "+producti.description);
                    }
                }
                System.out.println("opciones de producto: \n "
                    + "i-->Insertar\n"
                    + "m-->Modificar\n"
                    + "v-->Ver producto\n"
                    + "b-->Borrar producto (no implementado)");
                System.out.print("opción: ");
                opcC = sc.nextLine();
                if(opcC.equals("v")){
                    System.out.print("Id: ");
                    int Id = sc.nextInt();
                    sc.nextLine();
                    Product product0= new Product(Id);
                    DataProduct product=product0.getData();
                    if(product==null){
                        System.out.println("No tienes los permisos suficientes");
                    }else{
                        System.out.println("Id: "+Id);
                        System.out.println("Nombre: "+product.name);
                        System.out.println("Descripcion: "+product.description);
                        System.out.println("Importe: "+product.amount);
                        System.out.println("Ventas: "+product.nSold);
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
                    System.out.print("descripcion: ");
                    String description = sc.nextLine();
                    System.out.print("Importe: ");
                    float amount = sc.nextFloat();
                    System.out.print("Ventas: ");
                    int sold = sc.nextInt();
                    sc.nextLine();
                    if(opcC.equals("m")){
                        Product Product0= new Product(Id);
                        Product0.modifyProduct(name, description, amount);
                        }

                    else{
                        activeEmployee.insertProduct(name, description, sold);
                        }
                    }
                }

            if(opc.equals("w")){
                Vector tasks=activeEmployee.listTasks();
                if(tasks==null){
                    System.out.println("No tienes los permisos suficientes");
                }else{
                    for(int i=0; i<tasks.size();i++){
                        DataTask taski=(DataTask)tasks.elementAt(i);
                        System.out.println(taski.id_task+"-->"+taski.title+" "+taski.description);
                    }
                }
                System.out.println("opciones de WorkFlow: \n "
                    + "i-->Insertar\n"
                    + "m-->Modificar\n"
                    + "v-->Ver WorkFlow\n"
                    + "b-->Borrar WorkFlow (no implementado)");
                System.out.print("opción: ");
                opcC = sc.nextLine();
                if(opcC.equals("v")){
                    System.out.print("Id: ");
                    int Id = sc.nextInt();
                    sc.nextLine();
                    Task task0= new Task(Id);
                    DataTask task=task0.getData();
                    if(task==null){
                        System.out.println("No tienes los permisos suficientes");
                    }else{
                        System.out.println("Id: "+Id);
                        System.out.println("Nombre: "+task.title);
                        System.out.println("Descripcion: "+task.description);
                        System.out.println("Fecha: "+task.due_date);
                        System.out.println("Id_tarea_padre: "+task.id_task_father);
                        System.out.println("Horas estimadas: "+task.time_estimated);
                        System.out.println("Empleado asignado: "+task.id_employee);
                        if(task.status==StatusTask.DEVELOPMENT){
                            System.out.println("Estado: En desarrollo");
                        }else{
                            if(task.status==StatusTask.TO_DO){
                                System.out.println("Estado: Asignable");
                            }
                            else{
                                System.out.println("Estado: Hecho");
                            }   
                        }

                    }
                }
                /*
                else if(opcC.equals("m") || opcC.equals("i")){
                    int Id=0;
                    if(opcC.equals("m")){
                        System.out.print("Id: ");
                        Id = sc.nextInt();
                        sc.nextLine();
                    }
                    System.out.print("titulo: ");
                    String title = sc.nextLine();
                    //System.out.print("fecha: ");        pasar los string de fechas a date
                    //Date date = sc.n();
                    //System.out.print("horas estimadas: ");
                    //Date date = sc.n();
                    System.out.print("tipo: 1-->En desarrollo, 2-->Asignable, 3-->Hecho ");
                    int type = sc.nextInt();
                    sc.nextLine();
                    System.out.print("id tarea padre: ");
                    int id_father_task = sc.nextInt();
                    sc.nextLine();
                    System.out.print("id tarea padre: ");
                    int id_empleado = sc.nextInt();
                    sc.nextLine();
                    System.out.print("descripcion: ");
                    String description = sc.nextLine();
                    if(opcC.equals("m")){
                        Task Task0= new Task(Id);
                        if(type==1){
                            Task0.modifyTask(title, description, time_estimated, due_date, StatusTask.TO_DO);
                        }if(type==2){
                            Task0.modifyTask(title, description, time_estimated, due_date, StatusTask.TO_DO);
                        }if(type==2){
                            Task0.modifyTask(title, description, time_estimated, due_date, StatusTask.TO_DO);
                        }else{
                            Task0.modifyTask(title, description, time_estimated, due_date, StatusTask.TO_DO);
                        }

                    }else{
                        if(type==1){
                            activeEmployee.insertTask(title, description, type, type);
                        }else{
                            activeEmployee.insertClient("FREELANCE", name, surname, nif, email);
                        }
                    }
                
                }
                */
                }   
            opc=null;
            opcC=null;
       }
    }
    
}