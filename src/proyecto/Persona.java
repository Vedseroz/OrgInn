package proyecto;

public class Persona{
	
	//declaracion de atributos de la persona.
	
	private String nombre;
	private int rut;
	
	/*----------------------------------------------------------------------------------------------*/
	
	//constructor
	
	public Persona() {  //constructor por defecto
		setNombre(null);
		setRut(0);
	}
	
	public Persona(String n,int rut) {
		setNombre(n);
		setRut(rut);
	
	}
	
	//Setter y Getter
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getRut() {
		return rut;
	}
	
	public void setRut(int rut) {
			this.rut = rut;
	}
	
	/*-------------------------------------------METODOS--------------------------------------------*/
	
	
}
