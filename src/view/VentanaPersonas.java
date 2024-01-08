package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Persona;
import repository.PersonaDAO;

public class VentanaPersonas {

	private JFrame frame;
	private JTextField txtEdad;
	private JTextField txtDato;
	private JButton btnEditar;
	private JButton btnEliminar;

	private PersonaDAO personaDAO;
	private JTable tablaPersonas;
	private JButton btnCargar;

	  private void inicializarVentana() {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	/**
	 * Create the application.
	 */
	public VentanaPersonas() {
		initialize();
		inicializarVentana();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		this.personaDAO = new PersonaDAO();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 591, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(89, 24, 96, 19);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(25, 27, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Edad");
		lblNewLabel_1.setBounds(25, 75, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dato");
		lblNewLabel_2.setBounds(25, 126, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(89, 72, 96, 19);
		frame.getContentPane().add(txtEdad);
		
		txtDato = new JTextField();
		txtDato.setColumns(10);
		txtDato.setBounds(89, 123, 96, 19);
		frame.getContentPane().add(txtDato);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnInsertar.setBounds(10, 195, 85, 21);
		frame.getContentPane().add(btnInsertar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(100, 195, 85, 21);
		frame.getContentPane().add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(57, 226, 85, 21);
		frame.getContentPane().add(btnEliminar);
		
		tablaPersonas = new JTable();
		tablaPersonas.setBounds(248, 41, 297, 206);
		frame.getContentPane().add(tablaPersonas);
		
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCargar.setBounds(355, 10, 85, 21);
		frame.getContentPane().add(btnCargar);	
	}
	
	public JButton getBtnCargar() {
		return this.btnCargar;
	}
	
	
	/*
	 * OJO CON ESTE
	 */
//	 private void cargarDatos() throws SQLException 
//	 {
//	        List<Persona> listaPersonas = personaDAO.obtenerTodo();
//	        String[] columnas = {"Id","Nombre", "Edad", "Dato"};
//
//	        DefaultTableModel model = new DefaultTableModel(columnas, 0);
//	        for (Persona persona : listaPersonas) {
//	            Object[] fila = {persona.getId(),persona.getNombre(),persona.getEdad(),persona.getDato()};
//	            model.addRow(fila);
//	        }
//	        tablaPersonas.setModel(model);
//	        tablaPersonas.repaint();
//	        tablaPersonas.revalidate();
//	    }
	 /*
	  * 
	  */
	 private void actualizarTabla() {
		 
	 }

	public JTable getTablaPersonas() {
		// TODO Auto-generated method stub
		return this.tablaPersonas;
	}
}
