package proyecto;
 
import java.sql.*;
import java.io.*;  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

 
public class Hotel implements Operador{
		
    /*----------------------------------------------------------------------------*/
    private ArrayList<Pisos> pisito = new ArrayList<Pisos>();
  
    //---------------------------------METODOS--------------------------------------------------
    
   
    
    public HabitacionNormal hospedarPersonas(int cantidad, String type, ArrayList<Persona> personas){  //este metodo recibe la cantidad de personas y la lista referenciando a las personas
    																			// además retorna una habitacion de tipo normal.
    	ArrayList<Habitaciones> arreglohab = new ArrayList<Habitaciones>();
    	Pisos p = new Pisos();
        Habitaciones h = new HabitacionVip();
        for(int i = 0;i<pisito.size();i++) {
            p =(Pisos)pisito.get(i);
            arreglohab = p.obtenerHabitaciones(); //obtener una copia del arreglo con las habitaciones 
            
            for(int j = 0;i<arreglohab.size();j++) {
            	h = (HabitacionVip)arreglohab.get(j);
           
            	}
            }
        
        }
        
    }
   
    public boolean eliminar(int rut) {
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
	
	public ArrayList<Habitaciones> obtenerHabitaciones() {                         //este metodo retorna una lista con TODAS las habitaciones del hotel.
		ArrayList<Habitaciones> hab = new ArrayList<Habitaciones>();
		ArrayList<Habitaciones> hh = new ArrayList<Habitaciones>();
		Pisos pp;
		for (int i=0;i < pisito.size();i++) {
			pp = (Pisos)pisito.get(i);
			hab = pp.obtenerHabitaciones();
			for(int j=0;i<hab.size();j++) {
				hh.add(hab.get(j));
			}
		}
	return hh;
	}
	
	 public void agregar(Pisos p) { //metodo para agregar pisos nuevos al hotel.
    	pisito.add(p);
    }
	
	
}

	
      
