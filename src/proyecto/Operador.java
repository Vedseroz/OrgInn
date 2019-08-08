package proyecto;

import java.util.ArrayList;

public interface Operador{
		
	public abstract void agregar(ArrayList<Persona> per);
	public abstract Object obtener();
	public abstract void eliminar();
	
}
