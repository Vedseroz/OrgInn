package proyecto;

import java.util.ArrayList;


public class Pisos{
	
	//Definir Variables
	private String encargado;
	private ArrayList<Habitaciones> piezas = new ArrayList<Habitaciones>();
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
	
	public void addHabitacion(Habitaciones h) {
		piezas.add(h);  // agrega el elemento al final de la lista.
	}
	
	public Habitaciones obtenerCamasPedidas(int cantidad){ // obtiene si hay espacio para las personas a ser ingresadas
		
		Habitaciones h = new Habitaciones(); //intancia
		
		for(int i=0;i<piezas.size();i++) {
			h = (Habitaciones)piezas.get(i);
			if(h.getN_camas()==cantidad) {
				return h;
			}
		 }
		return null; 
	}
	
	public Habitaciones getPieza(int hab) {
		return piezas.get(hab);
	}
	
	public ArrayList<Habitaciones> obtenerHabitaciones(){
		ArrayList<Habitaciones> auxhab = new ArrayList<Habitaciones>();
		for (int i=0;i<piezas.size();i++) {
			auxhab.add(piezas.get(i));
		}
		return auxhab;
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
