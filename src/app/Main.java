package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.ConexionDB;

public class Main {

	public static void main(String[] args) {
		Connection conexion = null;

		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:prueba1.db");
			Statement stm = conexion.createStatement();
			ResultSet rst = stm.executeQuery("SELECT * FROM usuarios;");
			// Index start in 1
			while(rst.next()) {
				System.out.println(rst.getString(1) + " " + rst.getString(2) + " " + rst.getString(3) + " " + rst.getString(4)); 
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
