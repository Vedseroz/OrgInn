package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.Habitaciones;
import proyecto.Hotel;
import proyecto.Persona;
import ventanas.Ventana3;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ventana2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ingresenombre;
	private JTextField ingresrut;
	private JTextField telefonotitular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int c=0;
		String msg = null;
		Hotel hotel = new Hotel();
		Habitaciones habitacion = new Habitaciones();
		ArrayList<Persona> aux = new ArrayList<Persona>();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana2 frame = new Ventana2(aux,habitacion,hotel,msg,c);
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
	public Ventana2(ArrayList<Persona> aux,Habitaciones habitacion, Hotel hotel,String msg,int c) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*---------------------------------LABEL------------------------------------*/
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre del Huesped:");
		lblIngreseElNombre.setFont(new Font("Roboto Condensed Light", Font.BOLD, 15));
		lblIngreseElNombre.setBounds(76, 13, 254, 33);
		contentPane.add(lblIngreseElNombre);
		 
		/*---------------------------------Insersion de texto------------------------------------*/
		ingresenombre = new JTextField();
		ingresenombre.setBounds(76, 59, 254, 22);      							// SE INGRESA EL NOMBRE DEL TITULAR	
		contentPane.add(ingresenombre);
		ingresenombre.setColumns(10);
		
		/*---------------------------------LABEL------------------------------------*/
		JLabel lblIngreseElRut = new JLabel("Ingrese el rut del Huesped (sin digito verificador):");
		lblIngreseElRut.setFont(new Font("Roboto Condensed Light", Font.BOLD, 15));
		lblIngreseElRut.setBounds(76, 111, 337, 22);
		contentPane.add(lblIngreseElRut);
		
		/*---------------------------------Insersion de texto------------------------------------*/o
		ingresrut = new JTextField();
		ingresrut.setBounds(76, 159, 254, 22);
		contentPane.add(ingresrut);												//RUT DEL TITULAR
		ingresrut.setColumns(10);
		
		// boton de ingresar
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String nombretit = ingresenombre.getText();
				int rutit = Integer.parseInt(ingresrut.getText());
				int ttitular = Integer.parseInt(telefonotitular.getText());
			
				if(rutit>1000000 && rutit<100000000) {   								//comprueba si el rut ingresado no es erroneo
				 
					Persona pt = new Persona(nombretit,rutit);							//crea a la persona
					habitacion.setTelefono(ttitular);									//asigna a la habitacion el telefono del titular
					aux.add(pt);
					
					Ventana3 v3 = new Ventana3(aux,habitacion, hotel,c);   //LLAMA A LA VENTANA 3
					
					setVisible(false);
					v3.setVisible(true);
				}
				
				else {
					Ventana2 newv = new Ventana2(aux,habitacion,hotel,"ingrese los datos nuevamente",c);  		//LLAMA RECURSIVAMENTE A LA VENTANA 2 PARA REINGRESAR DATOS
					setVisible(false);
					newv.setVisible(true);
				}
				
					
			}
		});
		btnIngresar.setFont(new Font("Roboto Condensed Light", Font.BOLD, 14));
		btnIngresar.setBounds(76, 302, 97, 25);
		contentPane.add(btnIngresar);
		
		/*---------------------------------LABEL------------------------------------*/
		JLabel lblIngreseElTelefono = new JLabel("Ingrese el telefono del titular:");         
		lblIngreseElTelefono.setFont(new Font("Roboto Condensed Light", Font.BOLD, 15));
		lblIngreseElTelefono.setBounds(76, 208, 254, 16);
		contentPane.add(lblIngreseElTelefono);
		
		/*---------------------------------Insersion de texto------------------------------------*/
		telefonotitular = new JTextField();
		telefonotitular.setBounds(76, 248, 254, 22);
		contentPane.add(telefonotitular);
		telefonotitular.setColumns(10);
		
		/*---------------------------------LABEL------------------------------------*/
		JLabel lblNewLabel = new JLabel(msg);										//label dinamico el cual recibe un string 
		lblNewLabel.setBounds(225, 350, 230, 16);
		contentPane.add(lblNewLabel);
	
	}
}
