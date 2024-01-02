package model;

public class Persona<T> 
{
	private Integer id;
	private String nombre;
	private Integer edad;
	private T dato;
	
	public Persona(int id, String nombre, Integer edad, T dato) 
	{
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.dato = dato;
		
	}
	
	public Integer getId() 
	{
		return id;
	}
	public String getNombre() 
	{
		return nombre;
	}
	public Integer getEdad() 
	{
		return edad;
	}
	public T getDato() 
	{
		return dato;
	}
	public void setDato(T dato) 
	{
		this.dato = dato;
	}
	
	

}

