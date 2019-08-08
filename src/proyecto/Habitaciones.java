 
package proyecto;

import java.util.ArrayList;


public abstract class Habitaciones{
	
	protected int N_habitacion;
	protected int telefono;
	protected int N_camas;
	protected int np; //numero de personas.
	protected ArrayList<Persona> huespedes = new ArrayList<Persona>();
	protected double monto;
	protected int estado; // 0 = no habitado  1 = habitado  2 = en limpieza
	protected boolean banoprivado;
	
	/*--------------------------------------------------------------------------------------------------------*/
	
	public Habitaciones() {
		setN_habitacion(0);
		setN_camas(0);
		setMonto(0);
		setEstado(0);
		setBanoprivado(false);
		setTelefono(0);
		setNp(0);
	}
	
	public Habitaciones(int h, int c, int cl, double m, int e, boolean bpriv, int tel, int np) {
		setN_habitacion(h);
		setN_camas(c);
		setMonto(m);
		setEstado(e);
		setBanoprivado(bpriv);
		setTelefono(tel);
		setNp(np);
	}

	public int getN_habitacion() {
		return N_habitacion;
	}

	public void setN_habitacion(int n_habitacion) {
		N_habitacion = n_habitacion;
	}

	public int getN_camas() {
		return N_camas;
	}

	public void setN_camas(int n_camas) {
		N_camas = n_camas;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getNp() {
		return np;
	}

	public void setNp(int np) {
		this.np = np;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public boolean isBanoprivado() {
		return banoprivado;
	}

	public void setBanoprivado(boolean banoprivado) {
		this.banoprivado = banoprivado;
	}
	
	public int getTelefono() {
		return telefono;
	}

	public boolean setTelefono(int telefono) {
		if(telefono>1000000 && telefono<100000000) {
			this.telefono = telefono;
			return true;
		}
		return false;
	}
	
	/*-------------------------------------METODOS------------------------------------------------------------*/
	

	public ArrayList<Persona> obtener() {  //Metodo que retorna un arreglo con todas las personas de la habitacion. no se referencia para hacer el arreglo moldeable.
		ArrayList<Persona> array = new ArrayList<Persona>();
		for(int i=0;i<array.size();i++) {
			huespedes.add(array.get(i)); //esto genera una copia del arreglo de la clase y lo entrega.
		}
		return array;
	}
	
	
	public void eliminar() { //metodo que permite eliminar a todas las personas de la habitacion
		setEstado(0);
		setNp(0);
		setTelefono(0);
		huespedes.clear();
	}
	
	
	public void hospedar(ArrayList<Persona> personas) {
		Persona aux = new Persona();
		
    	huespedes = personas;
    	np = huespedes.size();
    	estado = 1;
    	
    	for(int i = 0;i<huespedes.size();i++) {
    		aux = (Persona)huespedes.get(i);
    		System.out.println(aux.getNombre() + "-" + aux.getRut());
    	}
    	
    }


	
	
}

