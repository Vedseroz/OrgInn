package proyecto;
import java.util.*;
import java.util.ArrayList;

public class Pisos{
	
	//Definir Variables
	private String encargado;
	private Map<Integer,Habitaciones> mapaPiezas = new HashMap<Integer,Habitaciones>();
	private int n_piezas; // numero de piezas por piso
	private int n_banospri; //numero de piezas con bano privado
	private int n_banoscom; //numero de piezas con bano compartido
	
	
	/*-------------------------CONSTRUCTOR, SETTER Y GETTERS--------------------------------------------------------------*/
	
	public Pisos() { //constructor default
		setEncargado(null);
		setN_piezas(0);
		setN_banospri(0);
		setN_banoscom(0);
	}
	
	public Pisos(String e, int np, int nbp, int nbc) {//constructor de incersion
		setEncargado(e);
		setN_piezas(np);
		setN_banospri(nbp);
		setN_banoscom(nbc);		
	}
	
	public int getN_piezas() {
		return n_piezas;
	}
	public void setN_piezas(int n_piezas) {
		this.n_piezas = n_piezas;
	}
	public int getN_banospri() {
		return n_banospri;
	}
	public void setN_banospri(int n_banospri) {
		this.n_banospri = n_banospri;
	}
	public int getN_banoscom() {
		return n_banoscom;
	}
	public void setN_banoscom(int n_banoscom) {
		this.n_banoscom = n_banoscom;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	
	/*-----------------------------------METODOS-------------------------------------------------------*/
	
	public void addHabitacion(Habitaciones h){
		mapaPiezas.put(h.getN_habitacion(),h);	//agrega la habitacion y ocupa el numero de esta como key
		
	}
	
	
	public Habitaciones obtenerCamasPedidas(int cantidad){
		Habitaciones h = new  Habitaciones();
		Habitaciones[] buffer = new Habitaciones[mapaPiezas.size()];
		/*.values() crea una coleccion de Habitaciones, .toArray() lo convierte en un arreglo 
		  y new Habitaciones[0] setea ese arreglo como tipo Habitaciones*/
		buffer = mapaPiezas.values().toArray(new Habitaciones[0]);	
		
		for(int i=0;i<(mapaPiezas.size());i++){
			h =(Habitaciones) buffer[i];
			if(h.getN_camas() == cantidad)
				return h;
		}
		return null;
	}
	
	
	public Habitaciones getPieza(int hab){
		return mapaPiezas.get(hab);
		
	}

	
	public ArrayList<Habitaciones> obtenerHabitaciones(){
		ArrayList<habitaciones> listaHabitaciones = new ArrayList<habitaciones>();
		Habitaciones[] buffer = new Hbitaciones(mapaPiezas.size()); //se crea arreglo auxiliar
		buffer = MapaPiezas.values().toArray(new Habitaciones[0]); //se le pasa al arreglo la coleccion de habitaciones
		for(int i=0;i<mapaPiezas.size();i++){
			listaHabitaciones.add(buffer[i]);
		}
		return listaHabitaciones;
	}

	
	public void obtenerPersona(Persona person) {
		Habitaciones hab;
		for(int i = 0; i < piezas.size();i++) {
			hab = (Habitaciones)piezas.get(i);
			for(int j=0;j<hab.getNp();j++) {
				person = hab.getPersona(j);
			}
		}
		
	}
	
	

}
