package application.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	
	public static Connection startConnection() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sm?characterEncoding=UTF-8&useSSL=false", "root", "");
			return conn;
		} 
		catch (SQLException e) {
			System.out.println("Error");
			return null;
		}
		catch (ClassNotFoundException e) {	
			System.out.println("Error");			
			return null;
		} 
	}
}
