package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQL {

	public static Connection conexion = null;
	
	public SQL() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public Connection conectar() throws SQLException {
    	conexion = DriverManager.getConnection("jdbc:mysql://" + "dirección (ip o dominio) donde está hosteado la base de datos"
				 + "/"
				 + "nombre de la base de datos"
				 + "?useSSL=false",
				 "nombreDeUsuario",
				 "contraseña");
	}
	
	
}
