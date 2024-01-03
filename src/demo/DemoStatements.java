package demo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Persona;
import repository.ConexionDB;

public class DemoStatements {
	
	private static String _sql = "jdbc:sqlite:prueba1.db";
	
	public boolean insertarPersona(Persona persona) {
		int rowCount = 0;
		try {
			Statement stm = ConexionDB.getInstance(_sql).getConnection().createStatement();
			String sqlInsert = "INSERT INTO usuarios(nombre,edad,dato) VALUES('" + persona.getNombre() + "'," + persona.getEdad() + ",'" + persona.getDato() + "')";        
			rowCount = stm.executeUpdate(sqlInsert);
			System.out.println("Se insertaron " + rowCount + "registros.");
		} catch (SQLException e) {
			System.out.println("Error al conectar" + e.getMessage());
		}
		return rowCount > 0;
	}
	public Persona buscarPersonaPorID(int id) {
		String sql = "SELECT * FROM usuarios WHERE id = " + "'" + id +"';";
		Persona persona = null;
		try {
			Statement stm = ConexionDB.getInstance(_sql).getConnection().createStatement();
			ResultSet rst = stm.executeQuery(sql);
			if(rst.next()) {
				persona = new Persona(rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("Error en la búsqueda" + e.getMessage());
		}
		return persona;
	}
	public ArrayList<Persona> obtenerTodos(){
		String sql = "SELECT * FROM usuarios";
		ArrayList<Persona> personasObtenidas = new ArrayList<>();
		try {
			Statement stm = ConexionDB.getInstance(_sql).getConnection().createStatement();
			ResultSet rst = stm.executeQuery(sql);
			while(rst.next()) {
				personasObtenidas.add(new Persona(rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getString(4)));
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta" + e.getMessage());
		}
		return personasObtenidas;
	}
}








/*	JDBC SQLite no implement PreparedStatement

public void insertarPreparedStatement() {
	String nombre = "Sergio";
	int edad = 28;
	String dato = "Arquero";
	String sqlInsert = "INSERT INTO usuarios(nombre,edad,dato) VALUES(?,?,?)";        
	try {
		PreparedStatement pstm = ConexionDB.getInstance("jdbc:sqlite:prueba1.db").getConnection().prepareStatement(sqlInsert);
		pstm.setString(1, nombre);
		pstm.setInt(2, edad);
		pstm.setString(3, dato);
		int rowCount = pstm.executeUpdate(sqlInsert);
		System.out.println("Se insertaron " + rowCount + "registros.");
	} catch (SQLException e) {
		System.out.println("Error Prepared statement" + e.getMessage());
	}
   
}*/
