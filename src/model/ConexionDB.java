package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class ConexionDB {
	private static final String DB_URL = "jdbc:sqlite:C:/Users/abel0/Desktop/SQL Dalto/dbPrueba1/prueba1.db";
	
	public ConexionDB() {

	}
			
			/* try {
		            // Establecer conexión con SQLite
		            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/abel0/Desktop/SQL Dalto/dbPrueba1/prueba1.db");

		            Statement statement = connection.createStatement();
		            ResultSet resultSet = statement.executeQuery("SELECT nombre, edad, dato FROM usuarios");

		            // Crear un modelo de tabla
		            DefaultTableModel modeloTabla = new DefaultTableModel();
		            tablaUsuarios.setModel(modeloTabla);

		            // Agregar columnas a la tabla
		            modeloTabla.addColumn("Nombre");
		            modeloTabla.addColumn("Edad");
		            modeloTabla.addColumn("Dato");

		            // Llenar la tabla con los datos de la base de datos
		            while (resultSet.next()) {
		                Object[] fila = new Object[3]; // 3 columnas
		                fila[0] = resultSet.getString("nombre");
		                fila[1] = resultSet.getInt("edad");
		                fila[2] = resultSet.getString("dato");
		                modeloTabla.addRow(fila);
		            }

		            connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
*/
}
