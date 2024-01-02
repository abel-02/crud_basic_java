package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller 
{
	private HashMap<Integer,Persona> personas;
	
	public Controller() 
	{
		personas = new HashMap<>();
	}
	
	public <T> void registrarPersona(int id, String nombre, Integer edad, T dato)
	{
		Persona persona = new Persona(id,nombre,edad,dato);
		personas.put(persona.getId(), persona);
	}
	public <T> void editarPersona(Integer id, T dato){
		personas.get(id).setDato(dato);
	}
	public <T> void eliminarPersona(Integer id){
		personas.remove(id);
	}
}
