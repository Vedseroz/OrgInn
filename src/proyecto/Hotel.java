package proyecto;
 
import java.sql.*;
import java.io.*;  
import java.util.ArrayList;
import java.util.StringJoiner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

 
public class Hotel implements Operador{
		
    /*----------------------------------------------------------------------------*/
    private ArrayList<Pisos> pisito = new ArrayList<Pisos>();
  
   
    public Habitaciones obtenerCamasPedidas(int cantidad, ArrayList<Persona> personas){  //funcion para alojar personas al hotel
    	
        Pisos p = new Pisos();
        Habitaciones h = new Habitaciones();
        for(int i = 0;i<pisito.size();i++) {
            p =(Pisos)pisito.get(i);
            h = p.obtenerCamasPedidas(cantidad);  
        }
        
        if(h==null) {
            return null; //si no encuentra nada retorna null
        }
        
        return h;
    }
    
    public boolean obtenerCamasPedidas(int cantidad){ //funcion para verificar si hay habitacion disponible
        Pisos p;
        Habitaciones h = new Habitaciones();
        for(int i = 0;i<pisito.size();i++) {
            p =(Pisos)pisito.get(i);
            h = p.obtenerCamasPedidas(cantidad);  
        }
        if(h==null) {
            return false;
        }
        return true;
    }
   
    public boolean desalojar(int rut) {
        Pisos piso;
        Habitaciones habitacion;
        Persona titular;
       
        for(int p = 0; p < pisito.size() ; p++) {
            piso = (Pisos) pisito.get(p);
           
            for(int hab = 0 ; hab < piso.getN_piezas() ; hab++) {
                habitacion = piso.getPieza(hab);
                if(habitacion.getNp()>0) {
                    titular = habitacion.getPersona(0);
                    if(rut == titular.getRut()){
                        habitacion.vaciar();
                        return true;
                    }
                }
            }
        }
        return false;
    }
   
    public void alojar(ArrayList<Persona> personas, Habitaciones pieza) {
        pieza.hospedar(personas);
    }
    

	public Habitaciones obtenerHabitacion(int nPieza){
		Pisos p;
		Habitaciones pieza;
		for(int i = 0;i<pisito.size();i++) {
			p =(Pisos)pisito.get(i);
			for (int j = 0 ; j < p.getN_piezas() ; j++) {
				pieza = p.getPieza(j);
				if(pieza.getN_habitacion() == nPieza) {
					return pieza;
				}
			}
		}
		return null;		
}
	
	public ArrayList<Habitaciones> obtenerHabitaciones() {
		
		ArrayList<Habitaciones> hab = new ArrayList<Habitaciones>();
		ArrayList<Habitaciones> hh = new ArrayList<Habitaciones>();
		Pisos pp;
		for (int i=0;i<pisito.size();i++) {
			pp = (Pisos)pisito.get(i);
			hab = pp.obtenerHabitaciones();
			for(int j=0;i<hab.size();j++) {
				hh.add(hab.get(j));
			}
		}
	return hh;
	}
	
	
	
	
	
	
}

	
      
