package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.Habitaciones;
import proyecto.Hotel;
import proyecto.Persona;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ventana3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField incersion1;
	private JTextField incersion2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int c=0;
		Hotel hotel = new Hotel();
		ArrayList<Persona> persona = new ArrayList<Persona>();
		Habitaciones habitacion = new Habitaciones();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana3 frame = new Ventana3(persona,habitacion,hotel,c);
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
	public Ventana3(ArrayList<Persona> listahuespedes,Habitaciones habitacion, Hotel hotel,int c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 352);
		setTitle("Orginn");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Ingresar_nombre = new JLabel("Ingrese el nombre del huesped");
		Ingresar_nombre.setBounds(35, 13, 212, 22); 								
		contentPane.add(Ingresar_nombre);
		
		incersion1 = new JTextField();
		incersion1.setBounds(31, 48, 216, 22);
		contentPane.add(incersion1);										//SE INGRESA EL NOMBRE DEL HUESPED
		incersion1.setColumns(10);
		
		JLabel ingresar_Rut = new JLabel("Ingrese el rut del huesped");
		ingresar_Rut.setBounds(35, 96, 179, 16);
		contentPane.add(ingresar_Rut);
		
		incersion2 = new JTextField();
		incersion2.setBounds(31, 142, 216, 22);								//SE INGRESA EL RUT DEL HUESPED
		contentPane.add(incersion2);
		incersion2.setColumns(10);
		
		JButton botonañadirhuesped = new JButton("A\u00F1adir");
		botonañadirhuesped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(c<habitacion.getNp()) {
				
				String nombre = incersion1.getText();
				String rut = incersion2.getText();
																				
				Persona nuevapersona = new Persona(nombre,Integer.parseInt(rut));  //SE CREA LA PERSONA
				
				listahuespedes.add(nuevapersona);                      //SE AGREGA A LA LISTA AUXILIAR
				Ventana3 iteracion = new Ventana3(listahuespedes,habitacion,hotel,c+1);   // SE LLAMA A LA VENTANA 3 RECURSIVAMENTE
				setVisible(false);
				iteracion.setVisible(true);
				
				}
				
				habitacion.hospedar(listahuespedes);									//AL FINALIZAR, SE INGRESA LA LISTA AUXILIAR A LISTA DE HUESPEDES.
				
				String mensaje = "Huespedes ingresados con exito!";
				
				VentanaMensaje v = new VentanaMensaje(hotel,mensaje);
				
				setVisible(false);
				v.setVisible(true);	
				
				
			}
		});
		botonañadirhuesped.setBounds(35, 207, 202, 25);
		contentPane.add(botonañadirhuesped);
	}
}
