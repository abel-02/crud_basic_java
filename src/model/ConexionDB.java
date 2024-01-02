package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
/*
 * Connection with data base (Singleton)
 */
public class ConexionDB 
{
	private String baseDatos;
	private static ConexionDB _instancia;
	public Connection conexion;
	
  private ConexionDB(String baseDatos) 
  {
	  this.baseDatos = baseDatos;
	  try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection(baseDatos);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
  }
  
  public static ConexionDB getInstance(String baseDatos) {
      if(_instancia == null)
    	  _instancia = new ConexionDB(baseDatos);
      else{
          System.out.println("Ya fué creada.");
      }
      return _instancia;
  }
  public Connection getConnection() {
      return conexion;
  }



  
  
}
