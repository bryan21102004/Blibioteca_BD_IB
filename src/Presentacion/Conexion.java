
package Presentacion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
  //Datos
  private String baseDeDatos="database=Lab_5;";
  private String usuario="user=UserBIB;";
  private String contraseña="password=1234554321;";

  private String url="jdbc:sqlserver://localhost:1433;"+baseDeDatos+"encrypt=true;"
          +"trustServerCertificate=true;"+usuario+contraseña;//url de conexion
  private Connection conexion;//Conexion
  
    public Conexion() {
    }
   
    //Comandos para conectarse/desconectarse
   public Connection conectar(){
      try {
          conexion = DriverManager.getConnection(url);
          System.out.println("Se conecto con exito");
      } catch (SQLException ex) {
          //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println("No se pudo conectar: " + ex);
      }
      return conexion;
   }
   
   public void desconectar(){
       try {
           conexion.close();
           System.out.println("Se desconectó");
       } catch (SQLException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("No se pudo desconectar");
       }
   }
   
   public static void main(String[]args){
       Conexion cx = new Conexion();
       cx.conectar();
   }
   
}
