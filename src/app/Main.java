package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controller;
import demo.DemoStatements;
import model.Persona;
import repository.ConexionDB;
import repository.PersonaDAO;
import view.VentanaPersonas;

public class Main {

	public static void main(String[] args) throws SQLException {	
		VentanaPersonas vista = new VentanaPersonas();
		Controller controlador = new Controller(vista);
	
	
	
	
	
	}
	

}
