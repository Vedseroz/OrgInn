package proyecto;
 
import java.sql.*;
import java.io.*;  
import java.util.ArrayList;
import java.util.StringJoiner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

 
public class Hotel{
	
	/*-----------------------SQL--------------------------------------------------*/
	
	public static Connection conexion = null;
	
	public Hotel() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public void conectar() throws SQLException {
    	conexion = DriverManager.getConnection("jdbc:mysql://" + "dirección (ip o dominio) donde está hosteado la base de datos"
				 + "/"
				 + "nombre de la base de datos"
				 + "?useSSL=false",
				 "nombreDeUsuario",
				 "contraseña");
	}
	
	
	
    /*----------------------------------------------------------------------------*/
    private ArrayList<Pisos> pisito = new ArrayList<Pisos>();
    private String arch = "registro.csv";
    private String linea = null;
    
  
    
    public boolean leer() throws IOException{
       
        try{
        	
            FileReader lector = new FileReader(arch);
            BufferedReader buffer = new BufferedReader(lector);				//se prepara el lector
           
            String[] split;
           
            //pisos
            int piezas, nbp, nbc; //numero de piezas, numero de baños privados, numero de baños compartidos
            String encargado;
            Pisos piso = new Pisos();										//declaracion de variables auxiliares para la recopilacion de informacion
           
            //piezas
            int tipoP, nHabitacion, nCamas, nPersonas, estadoP, telefono; //P=pieza  N=numero
            double monto;   //costo de habitacion
            Boolean bp; //bano privado     
            ArrayList<Persona> personas = new ArrayList<Persona>();
            Habitaciones habitacion = new Habitaciones();
           
            //persona
            String nombre;
            int rut;
            Persona _persona = new Persona();
     
           
            while((linea = buffer.readLine()) != null){					//se lee una linea con la informacion de un piso
               
                split = linea.split(",");
                piezas = Integer.parseInt(split[0]);
                encargado = split[1];									//se extrae su informacion
                nbp = Integer.parseInt(split[2]);
                nbc = Integer.parseInt(split[3]);
               
                piso = new Pisos(encargado, piezas, nbp, nbc);
                       
                for(int pie = 0 ; pie < piezas ; pie++){				//se leen n habitaciones, correspondientes al numero de habitaciones en el piso
                	
                    linea = buffer.readLine();
                    split = linea.split(",");
                    personas = new ArrayList<Persona>();
       
                    estadoP = Integer.parseInt(split[0]);
                    nCamas = Integer.parseInt(split[1]);				//se extrae la informacion de la habitacion
                    bp = Boolean.parseBoolean(split[2]);
                    nHabitacion = Integer.parseInt(split[3]);
                    tipoP = Integer.parseInt(split[4]);
                    monto = Double.parseDouble(split[5]);
                    nPersonas = Integer.parseInt(split[6]);
                    telefono = Integer.parseInt(split[7]);
                    
                    for(int per = 8 ; per < (8 + (nPersonas*2)) ; per+=2){		//se lee la informacion de las personas
                       
                        nombre = split[per];
                        rut = Integer.parseInt(split[per+1]);
                       
                        _persona = new Persona(nombre, rut);					//se agregan a un arraylist temporal
                        personas.add(_persona);									
                    }
                   
                    habitacion = new Habitaciones(nHabitacion, nCamas, tipoP, monto, estadoP, bp, telefono, nPersonas);	//se arma la habitacion
                   
                    habitacion.obtenerPersonas(personas);								//se ingresan las personas
                   
                    piso.addHabitacion(habitacion);										//se agrega la habitacion al piso
                    //pieza armada
                }
               
                pisito.add(piso);												//se agrega el piso al hotel
                
                //piso armado              
            }
            buffer.close();
            return true;
        }
        catch(FileNotFoundException ex) {
            System.out.println("No existen registros");
            return false;
        }
        
        
        
    }
    
    
    public void printeo() {
    	
    	Pisos p = new Pisos();

    	System.out.println(Integer.toString(pisito.size()));
    	
    	for(int i=0;i<pisito.size();i++) {
    		
    		p =(Pisos)pisito.get(i);
    		
    		System.out.println("Encargado: " + p.getEncargado());
    		System.out.println("Numero de piezas: " + p.getN_piezas());
    		System.out.println("Numero de Baños privados: " + p.getN_banospri());
    	
    		
    	}
    	
    }
   
   
   
   /*-----------------------------------------------------------------------------------------------------------------*/   
   
    public void escribir(){
           
        try {
            FileWriter escritor = new FileWriter("registro.csv", false);			//mismo procedimiento a la funcion leer pero al revez
            BufferedWriter registro = new BufferedWriter(escritor);
           
            Pisos piso = new Pisos();
            Habitaciones habitacion = new Habitaciones();
            Persona persona = new Persona();
           
            String linea;
            StringJoiner joiner = new StringJoiner(",");
            
            
            for(int p = 0 ; p < pisito.size() ; p++) {
                piso = (Pisos) pisito.get(p);
                
                joiner = new StringJoiner(",");
                
                joiner.add(Integer.toString(piso.getN_piezas()));
                joiner.add(piso.getEncargado());
                joiner.add(Integer.toString(piso.getN_banospri()));
                joiner.add(Integer.toString(piso.getN_banoscom()));
               
                linea = joiner.toString();
                registro.write(linea,0,linea.length());
                registro.newLine();
               
                for(int hab = 0 ; hab < piso.getN_piezas() ; hab++){
                    habitacion = piso.getPieza(hab);
                    joiner = new StringJoiner(",");
                    joiner.add(Integer.toString(habitacion.getEstado()));
                    joiner.add(Integer.toString(habitacion.getN_camas()));
                    joiner.add(Boolean.toString(habitacion.isBanoprivado()));
                    joiner.add(Integer.toString(habitacion.getN_habitacion()));
                    joiner.add(Integer.toString(habitacion.getClase()));
                    joiner.add(Double.toString(habitacion.getMonto()));
                    joiner.add(Integer.toString(habitacion.getNp()));
                    joiner.add(Integer.toString(habitacion.getTelefono()));
                   
                    for(int pers = 0 ; pers < habitacion.getNp() ; pers++) {
                        persona = habitacion.getPersona(pers);
                        joiner.add(persona.getNombre());
                        joiner.add(Integer.toString(persona.getRut()));
                       
                    }
                    linea = joiner.toString();
                   
                    registro.write(linea,0,linea.length());
                    registro.newLine();
                }
            }
            registro.close();
         }
         catch (IOException e) {
             e.printStackTrace();
         }
    }
   
   
   
    public Habitaciones obtenerCamasPedidas(int cantidad, ArrayList<Persona> personas){  //funcion para alojar personas al hotel
    	
        Pisos p = new Pisos();
        Habitaciones h = new Habitaciones();
        for(int i = 0;i<pisito.size();i++) {
            p =(Pisos)pisito.get(i);
            h = p.obtenerCamasPedidas(cantidad);  
        }
        
        if(h==null) {
            return null; //si no encuentra nada retorna null
        }
        
        return h;
    }
    
    public boolean obtenerCamasPedidas(int cantidad){ //funcion para verificar si hay habitacion disponible
        Pisos p;
        Habitaciones h = new Habitaciones();
        for(int i = 0;i<pisito.size();i++) {
            p =(Pisos)pisito.get(i);
            h = p.obtenerCamasPedidas(cantidad);  
        }
        if(h==null) {
            return false;
        }
        return true;
    }
   
    public boolean desalojar(int rut) {
        Pisos piso;
        Habitaciones habitacion;
        Persona titular;
       
        for(int p = 0; p < pisito.size() ; p++) {
            piso = (Pisos) pisito.get(p);
           
            for(int hab = 0 ; hab < piso.getN_piezas() ; hab++) {
                habitacion = piso.getPieza(hab);
                if(habitacion.getNp()>0) {
                    titular = habitacion.getPersona(0);
                    if(rut == titular.getRut()){
                        habitacion.vaciar();
                        return true;
                    }
                }
            }
        }
        return false;
    }
   
    public void alojar(ArrayList<Persona> personas, Habitaciones pieza) {
        pieza.hospedar(personas);
    }
    
public String verRegistros(int index, int nivel) { // 0 = pieza, 1 = piso
		
		String linea;
		StringJoiner joiner = new StringJoiner(",");
		
		switch(nivel) {
			case 0 : 
				Habitaciones habitacion = obtenerHabitacion(index);
				Persona persona;
								
				joiner.add(Integer.toString(habitacion.getEstado()));
                joiner.add(Integer.toString(habitacion.getN_camas()));
                joiner.add(Boolean.toString(habitacion.isBanoprivado()));
                joiner.add(Integer.toString(habitacion.getN_habitacion()));
                joiner.add(Integer.toString(habitacion.getClase()));
                joiner.add(Double.toString(habitacion.getMonto()));
                joiner.add(Integer.toString(habitacion.getNp()));
                joiner.add(Integer.toString(habitacion.getTelefono()));
               
                for(int pers = 0 ; pers < habitacion.getNp() ; pers++) {
                    persona = habitacion.getPersona(pers);
                    joiner.add(persona.getNombre());
                    joiner.add(Integer.toString(persona.getRut()));
                   
                }
                linea = joiner.toString();
                
                return linea;
			
			case 1:
				Pisos piso = pisito.get(index);
				
				joiner.add(Integer.toString(piso.getN_piezas()));
	            joiner.add(piso.getEncargado());
	            joiner.add(Integer.toString(piso.getN_banospri()));
	            joiner.add(Integer.toString(piso.getN_banoscom()));
	           
	            linea = joiner.toString();
				
	            return linea;				
		}
		return null;
	}

	public Habitaciones obtenerHabitacion(int nPieza){
		Pisos p;
		Habitaciones pieza;
		for(int i = 0;i<pisito.size();i++) {
			p =(Pisos)pisito.get(i);
			for (int j = 0 ; j < p.getN_piezas() ; j++) {
				pieza = p.getPieza(j);
				if(pieza.getN_habitacion() == nPieza) {
					return pieza;
				}
			}
		}
		return null;		
}
	
	public ArrayList<Habitaciones> obtenerHabitaciones() {
		
		ArrayList<Habitaciones> hab = new ArrayList<Habitaciones>();
		ArrayList<Habitaciones> hh = new ArrayList<Habitaciones>();
		Pisos pp;
		for (int i=0;i<pisito.size();i++) {
			pp = (Pisos)pisito.get(i);
			hab = pp.obtenerHabitaciones();
			for(int j=0;i<hab.size();j++) {
				hh.add(hab.get(j));
			}
		}
	return hh;
	}
	
	
	
	
	
	
}

	
      
