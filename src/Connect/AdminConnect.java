package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Object.User;

public class AdminConnect {
	private Connection conn;
	private ResultSet rSet;
	private Statement statement;
	public AdminConnect() throws SQLException {
		// TODO Auto-generated constructor stub
		String hostName = "localhost";
	     String sqlInstanceName = "SQLEXPRESS";
	     String database = "ITSS";
	     String userName = "SA";
	     String password = "123456";
	     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	 
	     conn = DriverManager.getConnection(connectionURL, userName, password);
	     
	     statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}
	
	public ArrayList<User> getfullUsers(){
		ArrayList<User> list = new ArrayList<User>();
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT Users.IDUser, Phone, isBlock, Name FROM Users "
					+ " JOIN DiaChi ON Users.IDUser = DiaChi.IDUser "
					+ " WHERE DiaChi.isMain = 1 AND Users.isAdmin = 0");
			while(rSet.next()) {
				User user = new User(rSet.getString("Name"), rSet.getString("Phone"), null, null, null, rSet.getInt("IDUser"), rSet.getInt("isBlock"));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void changeStatusUser(String iDUser, int status) {
		try {
			statement.executeUpdate("UPDATE Users SET isBlock = "+status
					+ " WHERE IDUser = "+iDUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
