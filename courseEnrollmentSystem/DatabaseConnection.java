	package courseEnrollmentSystem;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	
	public class DatabaseConnection {
	
			private static final String URL="jdbc:mysql://localhost:3306/javadb";
			private static final String USERNAME = "root";
			private static final String PASSWORD="root";
			
			public static Connection  connect() throws ClassNotFoundException, SQLException {
				Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection(URL,USERNAME, PASSWORD);
			}
	
	}
