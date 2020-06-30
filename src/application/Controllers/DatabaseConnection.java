
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
public  Connection startConnection() {		
		try {
			String dbName="spms";
			String userName="root";
			String password="";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,userName,password);
			
			return conn;
		} 
		catch (SQLException e) {
			System.out.println("Error"+e);
			return null;
		}
		catch (ClassNotFoundException e) {	
			System.out.println("Error"+e);			
			return null;
		} 
	}
}


