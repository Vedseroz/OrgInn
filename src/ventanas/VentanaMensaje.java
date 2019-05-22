package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyecto.Hotel;
import proyecto.Interfaz;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaMensaje extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String mensaje = null;
		Hotel hotel = new Hotel();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMensaje frame = new VentanaMensaje(hotel,mensaje);
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
	public VentanaMensaje(Hotel hotel,String mensaje) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblhuespedesIngresadosCon = new JLabel(mensaje);                                    //MUESTRA EL MENSAJE RECIBIDO.
		lblhuespedesIngresadosCon.setFont(new Font("Roboto Condensed Light", Font.BOLD, 18));
		lblhuespedesIngresadosCon.setBounds(53, 51, 312, 60);
		contentPane.add(lblhuespedesIngresadosCon);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Interfaz menu = null;
				try {
					menu = new Interfaz(hotel);													//LLAMA A LA INTERFAZ
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				setVisible(false);
				menu.setVisible(true);
				
				
			}
		});
		btnRegresar.setBounds(137, 124, 97, 25);
		contentPane.add(btnRegresar);
	}

}
