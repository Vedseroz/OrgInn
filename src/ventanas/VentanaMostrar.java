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

public class VentanaMostrar extends JFrame {

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(27, 53, 669, 304);
		contentPane.add(scrollPane);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(675, 53, 21, 316);
		contentPane.add(scrollbar);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(27, 53, 642, 289);
		contentPane.add(lblNewLabel_1);
	}
}
