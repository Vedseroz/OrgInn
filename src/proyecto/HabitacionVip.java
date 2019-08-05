package proyecto;

import java.util.ArrayList;

public class HabitacionVip extends Habitaciones implements Operador {
	
	private boolean serviciohab;
	
	//---------------------------------------------------CONSTRUCTORES-------------------------------------
	public HabitacionVip() {
		super();
		setServicio(false);
		
	}
	
	public HabitacionVip(int h, int c, int cl, double m, int e, boolean bpriv, int tel, int np,boolean s) {
		super(h,c,cl,m,e,bpriv,tel,np);
		setServicio(s);
	}
	
	//--------------------------------------------------SETTER Y GETTER------------------------------------
	public void setServicio(boolean s) {
		serviciohab = s;
	}
	
	public boolean getServicio() {
		return serviciohab;
	}
	
	//------------------------------------------------METODOS------------------------------------------------
	
	public void agregar(ArrayList<Persona> per) {
		huespedes = per;
	}
	
	public ArrayList<Persona> obtener(){
		return huespedes;
	}
	
	
	public void eliminar() {
		setEstado(0);
		setNp(0);
		setTelefono(0);
		huespedes.clear();
	}
}
