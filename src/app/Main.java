package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import demo.DemoStatements;
import model.Persona;
import repository.ConexionDB;
import repository.PersonaDAO;

public class Main {

	public static void main(String[] args) throws SQLException {
//		DemoStatements demo = new DemoStatements();
//		demo.insertarStatement();
//		demo.insertarPreparedStatement();
//		Persona usuario0 = new Persona("Patricio", 24, "Delantero");
//		if(demo.insertarPersona(usuario0))
//			System.out.println("Se inserto correctamente");
//		else
//			System.out.println("No se insertó");
//		for(Persona p: demo.obtenerTodos()) {
//			System.out.println(p.getNombre());
//		}
//	System.out.println(demo.buscarPersonaPorID(1).getNombre());
		// Test update e insertar
//		PersonaDAO personaDAO = new PersonaDAO();
//		Persona personaEjemplo = new Persona(6,"Maximiliano", 19, "Mediocampista");
//		try {
////			personaDAO.insertar(personaEjemplo);
//			if(personaDAO.update(personaEjemplo))
//				System.out.println("Se actualizó correctamente el registro");
//			else
//				System.out.println("No se actualizo el registro");
//		} catch (SQLException e) {
//			System.out.println("Error al insertar");
//		}
		// Test ObtenerTodo
//		PersonaDAO personaDAO = new PersonaDAO();
//		ArrayList<Persona> personas = personaDAO.obtenerTodo();
//		for(Persona p: personas) {
//			System.out.println(p.getNombre());
//		}
		// Test buscarPorID
		PersonaDAO personaDAO = new PersonaDAO();
		System.out.println(((Persona)personaDAO.buscarPorId(10+"")).getNombre());
	}

}
