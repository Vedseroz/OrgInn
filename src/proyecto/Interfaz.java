package proyecto;

import ventanas.VentanaEliminar;
import ventanas.VentanaMostrar;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Button;


public class Interfaz extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz(hotel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	
	public Interfaz(Hotel hotel) throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 341);										//Esto delimita la ventana
		setTitle("Orginn");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));			//Se genera el panel absoluto y el layout
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textoUno = new JLabel("Bienvenido a OrgInn\u00A9");
		textoUno.setFont(new Font("Roboto Condensed", Font.BOLD, 24));  //mensaje de bienvenida
		textoUno.setBounds(41, 13, 227, 59);
		contentPane.add(textoUno);
		
		JButton botoningresar = new JButton("Ingresar Huespedes"); //BOTON INGRESAR HUESPEDES AL HOTEL
		botoningresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
					Ventana1 ingresar = new Ventana1(hotel);   //abre la ventana siguiente
					setVisible(false);
					ingresar.setVisible(true);
			}
		});
		
		botoningresar.setFont(new Font("Roboto Condensed Light", Font.PLAIN, 14));
		botoningresar.setBounds(41, 105, 174, 31);
		contentPane.add(botoningresar);
		
		JButton btnMostrarHabitaciones = new JButton("Mostrar Habitaciones");    //BOTON PARA MOSTRAR HABITACIONES EN LISTA
		btnMostrarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaMostrar vm = new VentanaMostrar(hotel);                  //se abre la ventana para mostrar las habitaciones.
				setVisible(false);
				vm.setVisible(true);	
				
			}
		});
		btnMostrarHabitaciones.setFont(new Font("Roboto Condensed Light", Font.PLAIN, 14));
		btnMostrarHabitaciones.setBounds(41, 149, 174, 31);
		contentPane.add(btnMostrarHabitaciones);
		
		JLabel lblVer = new JLabel("ver 0.2");
		lblVer.setBounds(12, 269, 56, 16);
		contentPane.add(lblVer);
		
		
		JButton btnSacarHuespedes = new JButton("Sacar Huespedes");   //BOTON ELIMINAR HUESPEDES DE LOS REGISTROS
		btnSacarHuespedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaEliminar ve = new VentanaEliminar(hotel);   //llama a la ventana de eliminacion
				setVisible(false);
				ve.setVisible(true);
				
				
			}
		});
		btnSacarHuespedes.setFont(new Font("Roboto Condensed Light", Font.PLAIN, 14));
		btnSacarHuespedes.setBounds(41, 193, 174, 31);
		contentPane.add(btnSacarHuespedes);
		
		JButton AgregarHabitaciones = new JButton("Agregar Habitaciones");
		AgregarHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		AgregarHabitaciones.setBounds(271, 105, 174, 29);
		contentPane.add(AgregarHabitaciones);
		
		JButton AgregarPisos = new JButton("Agregar Pisos");
		AgregarPisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AgregarPisos.setBounds(271, 149, 179, 29);
		contentPane.add(AgregarPisos);
	}
}
