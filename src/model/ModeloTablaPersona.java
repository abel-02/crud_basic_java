package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import repository.PersonaDAO;

public class ModeloTablaPersona implements TableModel
{
	private static final int COLUMAS = 4;
	private ArrayList<Persona> personas;
	private PersonaDAO pDAO;
	
	public ModeloTablaPersona() 
	{
		this.personas = new ArrayList<>();
		pDAO = new PersonaDAO();
	}
	public ModeloTablaPersona(ArrayList<Persona> personas) 
	{
		this.personas = personas;
		pDAO = new PersonaDAO();
	}
	
	public <T> void registrarPersona(int id, String nombre, Integer edad, T dato)
	{
		Persona persona = new Persona(id,nombre,edad,dato);
		personas.add(persona.getId(), persona);
	}
	public <T> void editarPersona(Integer id, T dato)
	{
		personas.get(id).setDato(dato);
	}
	public <T> void eliminarPersona(Integer id)
	{
		personas.remove(id);
	}

	@Override
	public int getRowCount() 
	{
		return personas.size();
	}
	@Override
	public int getColumnCount() 
	{
		return this.COLUMAS;
	}
	@Override
	public String getColumnName(int columnIndex) 
	{
		switch(columnIndex) {
			case 0:
				return "Id";
			case 1:
				return "Nombre";
			case 2:
				return "Edad";
			case 3:	
				return "Dato";
		}
		return null;
	}
	@Override
	public Class<?> getColumnClass(int rowIndex) 
	{
		switch(rowIndex) {
			case 0:
				return int.class;
			case 1:
				return String.class;
			case 2:
				return int.class;
			case 3:	
				return String.class;
		}
		return null;
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) 
	{
		return true;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		Persona tmp = personas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return tmp.getId();
		case 1:
			return tmp.getNombre();
		case 2:
			return tmp.getEdad();
		case 3:
			return tmp.getDato();
			
		}
		return null;
	}
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) 
	{
		switch(columnIndex) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			personas.get(rowIndex).setDato((String)value);
			break;
		}
	}
	@Override
	public void addTableModelListener(TableModelListener l) 
	{		}
	@Override
	public void removeTableModelListener(TableModelListener l) 
	{		}
	public void cargarDatos() 
	{
		try {
			personas = pDAO.obtenerTodo();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public boolean agregarPersona(Persona persona)
	{
		try {
			if(this.pDAO.insertar(persona))
				personas.add(persona);
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public int getIdSiguiente() {
		return this.personas.size();
	}
	
}
