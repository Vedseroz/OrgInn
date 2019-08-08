package proyecto;

import java.util.ArrayList;

public class HabitacionNormal extends Habitaciones implements Operador{
	
	//------------------------------------------CONSTRUCTOR--------------------------------------------------
	
	public HabitacionNormal() {
		super();
	}
	
	public HabitacionNormal(int h, int c, int cl, double m, int e, boolean bpriv, int tel, int np) {
		super(h,c,cl,m,e,bpriv,tel,np);
	}

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
