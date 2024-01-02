package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import demo.DemoStatements;
import model.ConexionDB;
import model.Persona;

public class Main {

	public static void main(String[] args) {
		DemoStatements demo = new DemoStatements();
//		demo.insertarStatement();
//		demo.insertarPreparedStatement();
//		Persona usuario0 = new Persona("Patricio", 24, "Delantero");
//		if(demo.insertarPersona(usuario0))
//			System.out.println("Se inserto correctamente");
//		else
//			System.out.println("No se insertó");
		for(Persona p: demo.obtenerTodos()) {
			System.out.println(p.getNombre());
		}
//	System.out.println(demo.buscarPersonaPorID(1).getNombre());
	}

}
