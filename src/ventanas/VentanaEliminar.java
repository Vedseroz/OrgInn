package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.Hotel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEliminar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rutingr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Hotel hotel = new Hotel();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEliminar frame = new VentanaEliminar(hotel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEliminar(Hotel hotel) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 276);
		setTitle("Orginn");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*---------------------------------Insersion de texto------------------------------------*/
		rutingr = new JTextField();
		rutingr.setBounds(43, 98, 211, 22);
		contentPane.add(rutingr);
		rutingr.setColumns(10);
		
		/*----------------------------------LABEL-----------------------------------*/
		
		JLabel lblIngreseElRut = new JLabel("Ingrese el Rut del titular");
		lblIngreseElRut.setFont(new Font("Roboto Condensed Light", Font.BOLD, 14));
		lblIngreseElRut.setBounds(43, 40, 170, 16);
		contentPane.add(lblIngreseElRut);
		
		/*-------------------------BOTON------------------------------------*/
		JButton botoneliminar = new JButton("Eliminar");
		botoneliminar.addActionListener(new ActionListener() { 									
			public void actionPerformed(ActionEvent arg0) {
			try {
				
				int ruttitular = Integer.parseInt(rutingr.getText());//se le asigna a una instancia el texto ingresado convertido en un integer
				
				hotel.eliminar(ruttitular);
				
				
				String mensaje = "Personas desalojadas con exito.";        //se crea un string
				VentanaMensaje men = new VentanaMensaje(hotel,mensaje);    //se crea una instancia de ventana mensaje, y se pasa el string a la ventana mensaje
				
				setVisible(false);                                         //visibilidad
				men.setVisible(true);
			}
			
			catch(InputNullException e) {
				String s = "Intente nuevamente";
				VentanaMensaje maux = new VentanaMensaje(hotel,s);
			}
				
			}
		});
		botoneliminar.setBounds(106, 152, 97, 25);
		contentPane.add(botoneliminar); 
	}
}
