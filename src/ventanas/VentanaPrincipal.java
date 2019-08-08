package ventanas;

import java.io.IOException;
import java.sql.SQLException;

import proyecto.Hotel;
import proyecto.Interfaz;
import proyecto.SQL;


public class VentanaPrincipal {
	
	public static void main (String args[]) throws IOException, SQLException {

		Hotel hotell= new Hotel();//se instancia el hotel y se leen los datos.
		SQL bd = new SQL();  	//instancia de conexion a la base de datos
		bd.abstraer();
		
		Interfaz ventanap = new Interfaz(hotell);
		ventanap.setVisible(true);
		
	}

}
