package proyecto;

import java.sql.Connection;
import com.mysql.jdbc.jdbc2.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SQL{
	
	
	/**
	 * @return la conexion establecida con la base de datos
	 * @throws SQLException por si no se puede conextar a la base da datos.
	 */
	
	private Connection conexion;//memoria de la conexion
	private Statement stmt;
	private ResultSet rs;
	
	public SQL() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://167.114.113.28:3306/orginn?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
	        		"ravidi","fn2187");
	        stmt = conexion.createStatement();
	        System.out.println("La conexion a la base de datos a sido exitosa.");
			
		}catch(Exception error1) {
			System.out.println("Error:" + error1);
		}
}
	

	public void desconectar() throws SQLException{  							
		try {										
			conexion.close();													//Se desconecta de la base de datos
		}
		catch(SQLException e) {
			System.out.println("error al cierre de sesión"); 					//si no resulta se envia un mensaje de error a consola
		}
	}
	
	public void abstraer() {
		
		try {
			rs = stmt.executeQuery("SELECT * FROM habitaciones");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getInt(5));
				System.out.println(rs.getInt(6));
				System.out.println(rs.getInt(7));
				System.out.println(rs.getInt(8));
				System.out.println(rs.getString(9));
			}
		}
		
		catch (SQLException e) {
			System.out.println("error en la conexion");
			}
		
		}
	

}  	
	