package proyecto;

import java.util.ArrayList;

public interface Operador{

	public abstract void agregar(Object o);
	public abstract ArrayList<Persona> obtener();
	public abstract void eliminar();
	
}
