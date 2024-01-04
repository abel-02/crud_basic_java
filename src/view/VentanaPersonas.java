package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnEditar;
	private JButton btnEliminar;

	private PersonaDAO personaDAO;
	private JTable table;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPersonas window = new VentanaPersonas();
					window.frame.setVisible(true);
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
		try {
			cargarDatos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		textField = new JTextField();
		textField.setBounds(89, 24, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(25, 27, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Edad");
		lblNewLabel_1.setBounds(25, 75, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dato");
		lblNewLabel_2.setBounds(25, 126, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(89, 72, 96, 19);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(89, 123, 96, 19);
		frame.getContentPane().add(textField_2);
		
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
		
		table = new JTable();
		table.setBounds(248, 49, 297, 184);
		frame.getContentPane().add(table);
		
		textField_3 = new JTextField();
		textField_3.setBounds(281, 10, 57, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Id");
		lblNewLabel_3.setBounds(259, 13, 23, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(399, 9, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		
	}
	
	 private void cargarDatos() throws SQLException 
	 {
	        List<Persona> listaPersonas = personaDAO.obtenerTodo();
	        String[] columnas = {"Id","Nombre", "Edad", "Dato"};

	        DefaultTableModel model = new DefaultTableModel(columnas, 0);
	        for (Persona persona : listaPersonas) {
	            Object[] fila = {persona.getId(),persona.getNombre(),persona.getEdad(),persona.getDato()};
	            model.addRow(fila);
	        }
	        table.setModel(model);
	        table.repaint();
	        table.revalidate();
	    }
}
