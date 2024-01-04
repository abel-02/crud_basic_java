package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Persona;

public class PersonaDAO implements InterfazDAO{
	
	private  String _sql;
	private int rowCount;
	
	public PersonaDAO() {
		this._sql = "jdbc:sqlite:prueba1.db";
		this.rowCount = 0;
	}
	
	@Override
	public boolean insertar(Object obj) throws SQLException {
		String sqlInsert = "INSERT INTO usuarios(nombre,edad,dato) VALUES('" + ((Persona)obj).getNombre() + "'," + ((Persona)obj).getEdad() + ",'" + ((Persona)obj).getDato() + "')"; 
		int rowCount = 0;
		Statement stm = ConexionDB.getInstance(_sql).getConnection().createStatement();       
		rowCount = stm.executeUpdate(sqlInsert);
		return rowCount > 0;
	}
	@Override
	public boolean update(Object obj) throws SQLException {
		String sqlUpdate = "UPDATE usuarios SET dato = '" + ((Persona)obj).getDato() + "' WHERE id = " + ((Persona)obj).getId() + ";";        
		int rowCount = 0;
		Statement stm = ConexionDB.getInstance(_sql).getConnection().createStatement();
		rowCount = stm.executeUpdate(sqlUpdate);
		return rowCount > 0;
	}

	@Override
	public boolean delete(String id) throws SQLException {
		String sqlDelete = "DELETE FROM usuarios WHERE id = " + id + ";";
		int rowCount = 0;
		Statement stm = ConexionDB.getInstance(_sql).getConnection().createStatement();       
		rowCount = stm.executeUpdate(sqlDelete);
		return rowCount > 0;
	}

	@Override
	public ArrayList obtenerTodo() throws SQLException {
		String sqlObtainAll = "SELECT * FROM usuarios";
		ArrayList<Persona> personasObtenidas = new ArrayList<>();
		try {
			Statement stm = ConexionDB.getInstance(_sql).getConnection().createStatement();
			ResultSet rst = stm.executeQuery(sqlObtainAll);
			while(rst.next()) {
				personasObtenidas.add(new Persona(rst.getInt(1), rst.getString(2), rst.getInt(3), rst.getString(4)));
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta" + e.getMessage());
		}
		return personasObtenidas;

	}

	@Override
	public Object buscarPorId(String id) throws SQLException {
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

}
