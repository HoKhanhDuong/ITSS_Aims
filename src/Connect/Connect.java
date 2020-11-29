package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	public Connect() throws SQLException {
		// TODO Auto-generated constructor stub
		String hostName = "localhost";
	     String sqlInstanceName = "SQLEXPRESS";
	     String database = "ITSS";
	     String userName = "SA";
	     String password = "123456";
	     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	 
	     Connection conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     Statement statement = conn.createStatement();
	     ResultSet rSet = statement.executeQuery("SELECT * FROM Users");
	     while(rSet.next()) {
	    	 System.out.println(rSet.getString("Email") + " " + rSet.getString("Pass") + " " + rSet.getString("isAdmin") );
	     }
	     System.out.println("Connect ok");
	}
	
	public static void main(String args[]) {
		try {
			Connect connect = new Connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
