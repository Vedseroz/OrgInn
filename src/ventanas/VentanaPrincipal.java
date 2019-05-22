package ventanas;

import java.io.IOException;

import proyecto.Hotel;
import proyecto.Interfaz;

public class VentanaPrincipal {
	
	public static void main ( String args[]) throws IOException {

		Hotel hotelcito = new Hotel();//se instancia el hotel y se leen los datos.
		hotelcito.leer();		
		hotelcito.printeo();
		
		Interfaz ventanap = new Interfaz(hotelcito);
		ventanap.setVisible(true);
		
	}

}
