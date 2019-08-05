package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.Habitaciones;
import proyecto.Hotel;
import proyecto.Interfaz;

import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class VentanaMostrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_habitaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMostrar frame = new VentanaMostrar(hotel);
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
	public VentanaMostrar(Hotel hotel) {
		
		ArrayList<Habitaciones> habitaciones = new ArrayList<Habitaciones>(); 
		habitaciones = hotel.obtenerHabitaciones();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 451);
		setTitle("Orginn");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Habitaciones.");
		lblNewLabel.setFont(new Font("Roboto Condensed Light", Font.BOLD, 14));
		lblNewLabel.setBounds(27, 13, 222, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Interfaz inter = new Interfaz(hotel);
					setVisible(false);
					inter.setVisible(true);
				} catch (IOException e) {                                    //LLAMA A LA INTERFAZ
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(27, 366, 97, 25);
		contentPane.add(btnNewButton);
		
		
		
		//------------------------------------------------------TABLA DE DATOS---------------------------------------------------
		Object n_columnas[] = {"Habitacion","Estado"}; 
		
		table_habitaciones = new JTable();         //TABLA CON LOS DATOS
		table_habitaciones.setBounds(27, 55, 667, 295);
		contentPane.add(table_habitaciones);
		
		JScrollPane scrollPane = new JScrollPane(table_habitaciones);   //SCROLLABLE PANEL 
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		scrollPane.setBounds(23, 54, 667, 299);
		contentPane.add(scrollPane);
	
			
		
	}
}
