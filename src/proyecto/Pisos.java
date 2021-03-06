package proyecto;
import java.util.*;
import java.util.ArrayList;


public class Pisos implements Operador{
	
	//Definir Variables
	private String encargado;
	private Map<Integer,Habitaciones> mapaPiezas = new HashMap<Integer,Habitaciones>();
	private String n_piezas; // numero de piezas por piso
	private String n_banospri; //numero de piezas con bano privado
	private String n_banoscom; //numero de piezas con bano compartido
	private String idPiso; //identificador del piso
	
	
	/*-------------------------CONSTRUCTOR, SETTER Y GETTERS--------------------------------------------------------------*/
	
	public Pisos() { //constructor default
		setEncargado(null);
		setN_piezas(null);   					
		setN_banospri(null);
		setN_banoscom(null);
		setId(null);
		
	}
	
	public Pisos(String e, String np, String nbp, String nbc,String id) {//constructor de incersion
		setEncargado(e);
		setN_piezas(np);
		setN_banospri(nbp);
		setN_banoscom(nbc);	
		setId(id);
	}
	
	public String getN_piezas() {
		return n_piezas;
	}
	public void setN_piezas(String n_piezas) {
		this.n_piezas = n_piezas;
	}
	public String getN_banospri() {
		return n_banospri;
	}
	public void setN_banospri(String n_banospri) {
		this.n_banospri = n_banospri;
	}
	public String getN_banoscom() {
		return n_banoscom;
	}
	public void setN_banoscom(String n_banoscom) {
		this.n_banoscom = n_banoscom;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
			
	public String getId() {
		return idPiso;
	}

	public void setId(String idPiso) {
		this.idPiso = idPiso;
	}
	/*-----------------------------------METODOS-------------------------------------------------------*/
	
	public void agregar(Habitaciones h){
		mapaPiezas.put(h.getN_habitacion(),h);	//agrega la habitacion y ocupa el numero de esta como key
		
	}
	
	
	public Habitaciones obtener(int cantidad, String type){
		Habitaciones h;
		if (type.equals("vip")) {
			h = new  HabitacionVip();
		}
		if (type.equals("normal")) {
			h = new HabitacionNormal();
		}
		
		Habitaciones[] buffer = new Habitaciones[mapaPiezas.size()];
		/*.values() crea una coleccion de Habitaciones, .toArray() lo convierte en un arreglo 
		  y new Habitaciones[0] setea ese arreglo como tipo Habitaciones*/
		buffer = mapaPiezas.values().toArray(new Habitaciones[0]);	
		
		for(int i=0;i<(mapaPiezas.size());i++){                //
			h = buffer[i];
			if(h.getN_camas() == cantidad)
				return h;
		}
		return null;
	}
	
	
	public Habitaciones getPieza(int hab){
		return mapaPiezas.get(hab);
	
	
	
	}

	
	public ArrayList<Habitaciones> obtenerHabitaciones(){
		ArrayList<Habitaciones> listaHabitaciones = new ArrayList<Habitaciones>();
		Habitaciones[] buffer; //se crea arreglo auxiliar
		buffer = mapaPiezas.values().toArray(new Habitaciones[0]); //se le pasa al arreglo la coleccion de habitaciones
		for(int i=0;i<mapaPiezas.size();i++){
			listaHabitaciones.add(buffer[i]);
		}
		return listaHabitaciones;
	}

	
	public void obtenerPersona(Persona person) {
		Habitaciones hab;
		ArrayList<Persona> array = new ArrayList<Persona>();
		for(int i = 0; i < mapaPiezas.size();i++) {
			hab = (Habitaciones)mapaPiezas.get(i);
			for(int j=0;j<hab.getNp();j++) {
				array = hab.obtener();
				person = array[j];
			}
		}
		
	}



}
