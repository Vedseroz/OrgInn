package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.Habitaciones;
import proyecto.Hotel;
import proyecto.Persona;
import proyecto.Pisos;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ventana1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ingresocantidad;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 frame = new Ventana1(hotel);
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
	public Ventana1(Hotel hotel) {
		
		//se inicializa el hotel para la incersion de todas las habitaciones.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ingresocantidad = new JTextField();
		ingresocantidad.setBounds(91, 116, 129, 22);
		contentPane.add(ingresocantidad);
		ingresocantidad.setColumns(10);
		
		lblNewLabel = new JLabel("Ingresar cantidad de personas:");
		lblNewLabel.setFont(new Font("Roboto Condensed Light", Font.BOLD, 14));     //TEXTO
		lblNewLabel.setBounds(57, 58, 213, 29);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cantidadpersonas = Integer.parseInt(ingresocantidad.getText());
				
				boolean auxiliar;
				
				//comenzar la busqueda
				
				Habitaciones haux = new Habitaciones();//se crea una instancia de habitaciones
				ArrayList<Persona> aux = new ArrayList<Persona>();//se crea una instancia de arreglo de personas para pasarlo a la ventana siguiente
				
				auxiliar = hotel.obtenerCamasPedidas(cantidadpersonas);//esto retorna la primera habitacion disponible para las personas
				String msg = null;
				if(auxiliar==true) {
					haux = hotel.obtenerCamasPedidas(cantidadpersonas,aux);
					haux.setNp(cantidadpersonas);
					System.out.println(Integer.toString(haux.getNp()) +"-"+ Double.toString(haux.getMonto()) +"-"+ Integer.toString(haux.getEstado()));
					Ventana2 nuevaventana = new Ventana2(aux,haux,hotel,msg,cantidadpersonas);
					setVisible(false);
					nuevaventana.setVisible(true);
				}
				
				else{
					
					String error1 = "No se encontraron piezas";
					VentanaMensaje ech = new VentanaMensaje(hotel,error1);   //SI NO ENCUENTRA NADA, VA A LA VENTANA DE MENSAJE.
					
					setVisible(false);
					ech.setVisible(true);

				}
			
			}
		});
		
		btnNewButton.setBounds(110, 174, 97, 25);
		contentPane.add(btnNewButton);
	}
}
