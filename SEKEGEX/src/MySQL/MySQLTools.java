/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import Utils.TypeClient;
import java.sql.Date;
import Utils.StatusTask;
import DataType.DataProduct;
import java.sql.*;
/**
 *
 * @author Sergio
 * 
 * Class to work with MySQL
 */
public class MySQLTools {
    
    //"CLIENTES" table
    
    /**
     * Insert new client in the table
     */
    protected void insertClient(TypeClient type, String name, String surname, String dni, String email){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO clientes (tipo, nombre, apellido, nif, email) VALUES(?,?,?,?,?);");
           
           stmt.setObject(1, type);
           stmt.setString(2, name);
           stmt.setString(3, surname);
           stmt.setString(4, dni);
           stmt.setString(5, email);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify client with the params specified
     */
    protected void modifyClient(int id_client, TypeClient type, String name, String surname, String dni, String email){
        
    }
    
    /**
     * Remove client
     */
    protected void removeClient(int id_client){
        
    }
    
    //"PRODUCTOS" table
    
    /**
     * Insert new product in the table
     */
    protected void insertProduct(String name, String description, int amount){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO produtos (nombre, descripcion, importe) VALUES(?,?,?);");
           
           stmt.setString(1, name);
           stmt.setString(2, description);
           stmt.setInt(3, amount);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify product
     */
    protected void modifyProduct(int id_product, String name, String description, int amount){
        
    }
    
    /**
     * Consult Product
     * @return Object with the data of a product
     */
    protected DataProduct consultProduct(int id_product){
        return new DataProduct(id_product,"","",1,1);
    }
    
    /**
     * Remove Product
     */
    protected void removeProduct(int id_product){
        
    }
    
    //"FACTURAS" table
    
    /**
     * Insert new bill in the table
     */
    protected void insertBill(int id_client){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO facturas (id_cliente) VALUES(?);");
           
           stmt.setInt(1, id_client);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify bill
     */
    protected void modifyBill(int id_bill, int amount, int id_client){
    
    }
    
    /**
     * Remove bill
     */
    protected void removeBill(int id_bill){
        
    }
    
    //"COMPRAS" table
    
    /**
     * Insert new bill in the table
     */
    protected void insertPurchase(int id_bill, int id_product){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO compras (id_factura, id_producto) VALUES(?,?);");
           
           stmt.setInt(1, id_bill);
           stmt.setInt(2, id_product);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Erase a product of a purchase
     */
    protected void removeProductOfPurchase(int id_bill, int id_product){
        
    }
    
    //"SERVIDORES" table
    
    /**
     * Insert new server
     */
    protected void insertServer(int id_client, String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO servidores (id_cliente, nombre, ruta_de_acceso, usuario_ftp, password_ftp, usuario_host, password_host) VALUES(?,?,?,?,?,?,?);");
           
           stmt.setInt(1, id_client);
           stmt.setString(2, name);
           stmt.setString(3, access);
           stmt.setString(4, user_ftp);
           stmt.setString(5, password_ftp);
           stmt.setString(6, user_host);
           stmt.setString(7, password_host);
           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify server
     */
    protected void modifyServer(int id_client, String name, String access, String user_ftp, String password_ftp, String user_host, String password_host){
        
    }
    
    /**
     * Erase server
     */
    protected void removeServer(int id_server){
        
    }
    
    //"EMPLEADOS" table
    
    /**
     * Insert new employee
     */
    protected void insertEmployee(String dni, String name, String surname, int role){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO empleados (dni, nombre, apellidos, rol) VALUES(?,?,?,?);");
           
           stmt.setString(1, dni);
           stmt.setString(2, name);
           stmt.setString(3, surname);
           stmt.setInt(4, role);


           
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify employee
     */
    protected void modifyEmployee(int id_employee, String dni, String name, String surname, int role){
        
    }
    
    /**
     * Erase employee
     */
    protected void removeEmployee(int id_employee){
        
    }
    
    //"TAREAS" table
    
    /**
     * Insert new task
     */
    protected void insertTask(String title, String description, Time time_estimated){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO tareas (titulo, descripcion, horas_estimadas) VALUES(?,?,?);");
           
           stmt.setString(1, title);
           stmt.setString(2, description);
           stmt.setTime(3, time_estimated);
       
           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify task
     */
    protected void modifyTask(int id_task, String title, String description, Time time_estimated, Date due_date, int id_task_father, int id_employee, StatusTask status){
        
    }
    
    /**
     * Erase task
     */
    protected void eraseTask(int id_task){
        
    }
    
    //"REGISTROS" table
    
    /**
     * Insert new register
     */
    protected void insertRegister(int id_employee, Time time_worked, String description, Date date){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO registros (id_empleado, horas_trabajadas, descripcion, fecha) VALUES(?,?,?,?);");
           
           stmt.setInt(1, id_employee);
           stmt.setTime(2, time_worked);
           stmt.setString(3, description);
           stmt.setDate(4, date);

           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify register
     */
    protected void modifyRegister(int id_employee, Time time_worked, String description, Date date){
        
    }
    
    /**
     * Erase register
     */
    protected void removeRegister(int id_register){
        
    }
    
    //"COMENTARIOS" table
    
    /**
     * Insert Comment
     */
    protected void insertComment(int id_tarea, String comment){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO registros (id_empleado, horas_trabajadas, descripcion, fecha) VALUES(?,?,?,?);");
           
           stmt.setInt(1, id_employee);
           stmt.setTime(2, time_worked);
           stmt.setString(3, description);
           stmt.setDate(4, date);

           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify Comment
     */
    protected void modifyComment(int id_comment, int id_tarea, String comment){
        
    }
    
    /**
     * Erase Comment
     */
    protected void removeComment(int id_comment){
        
    }
    
    // "ROLES" table
    
    /**
     * Insert Role
     */
    protected void insertRole(int rol, int licence){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO roles (rol, permiso) VALUES(?,?);");
           
           stmt.setInt(1, rol);
           stmt.setInt(2, licence);

           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Modify Role
     */
    protected void modifyRole(int rol, int licence){
        
    }
    
    /**
     * Erase Role
     */
    protected void removeRole(int rol){
        
    }
    
    //"DOMINIOS" table
    
    /**
     * Insert domain
     */
    protected void insertDomain(int id_server, String web){
        Connection con = null;
        PreparedStatement stmt = null;

        String sDriver = "com.mysql.jdbc.Driver";
        String sURL = "jdbc:mysql://85.10.205.173:3306/erpseke";

        try{
           Class.forName(sDriver).newInstance();    
           con = DriverManager.getConnection(sURL,"sekegex","sekegex");
           
           stmt = con.prepareStatement("INSERT INTO dominios (id_servidor, web) VALUES(?,?);");
           
           stmt.setInt(1, id_server);
           stmt.setString(2, web);

           stmt.executeUpdate();

        } catch (SQLException sqle){
           System.out.println("SQLState: " + sqle.getSQLState());
           System.out.println("SQLErrorCode: " + sqle.getErrorCode());
           sqle.printStackTrace();
        } catch (Exception e){
           e.printStackTrace();
        } finally {
           if (con != null) {
              try{
                 stmt.close();
                 con.close();
              } catch(Exception e){
                 e.printStackTrace();
              }
           }
        }
    }
    
    /**
     * Erase domain
     */
    protected void removeDomain(int id_domain){
        
    }
}
