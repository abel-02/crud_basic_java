 package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import repository.PersonaDAO;
import view.VentanaPersonas;
import model.ModeloTablaPersona;

public class Controller extends MouseAdapter{
	 private VentanaPersonas vista;
	 private ModeloTablaPersona modelo;
	 
	 public Controller(VentanaPersonas vista) {
		 this.vista = vista;
		 this.vista.getBtnCargar().addMouseListener(this);
	 }
	 @Override
	 public void mouseClicked(MouseEvent evento) {
		 if(evento.getSource() == this.vista.getBtnCargar())
			 modelo = new ModeloTablaPersona();
		 	 modelo.cargarDatos();
		 	 this.vista.getTablaPersonas().setModel(modelo);
		 	this.vista.getTablaPersonas().updateUI();
	 }
	 
}
