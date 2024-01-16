 package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import repository.PersonaDAO;
import view.VentanaPersonas;
import model.ModeloTablaPersona;
import model.Persona;

public class Controller extends MouseAdapter{
	 private VentanaPersonas vista;
	 private ModeloTablaPersona modelo;
	 
	 public Controller(VentanaPersonas vista) {
		 this.vista = vista;
		 this.modelo = new ModeloTablaPersona();
		 this.vista.getTablaPersonas().setModel(modelo);
		 this.vista.getBtnCargar().addMouseListener(this);
		 this.vista.getBtnInsertar().addMouseListener(this);
	 }
	 @Override
	 public void mouseClicked(MouseEvent evento) 
	 {
		 if(evento.getSource() == this.vista.getBtnCargar()) {
		 	 eventoCargar();
	 	}
		 if(evento.getSource() == this.vista.getBtnInsertar()) {
			 eventoInsertar();
		 }
//		 if(evento.getSource() == this.vista.getBtnEliminar()) {
//		 	
//		 	 this.vista.getTablaPersonas().updateUI();
//	 	}
		 this.vista.limpiarCampos();
	 }
	private void eventoCargar() {
		 modelo.cargarDatos();
	 	 this.vista.getTablaPersonas().setModel(modelo);
	 	 this.vista.getTablaPersonas().updateUI();
	}
	private void eventoInsertar() {
		String nombre = this.vista.getTxtNombre();
		 int edad = this.vista.getTxtEdad();
		 String dato = this.vista.getTxtDato();
		 Persona<String> persona = new Persona<String>(modelo.getIdSiguiente(),nombre,edad,dato);
		 
		 if(this.modelo.agregarPersona(persona)) {
			 System.out.println("Se agrego correctamente");
			 this.vista.getTablaPersonas().updateUI();
		 }else 
			 System.out.println("Error al insertar en la base de datos.");
	}
}
