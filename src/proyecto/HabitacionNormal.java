package proyecto;

public class HabitacionNormal extends Habitaciones implements Operador{
	
	//------------------------------------------CONSTRUCTOR--------------------------------------------------
	
	public HabitacionNormal() {
		super();
	}
	
	public HabitacionNormal(int h, int c, int cl, double m, int e, boolean bpriv, int tel, int np) {
		super(h,c,cl,m,e,bpriv,tel,np);
	}

}
