package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Object.Media;

public class Connect {
	private Connection conn;
	public Connect() throws SQLException {
		// TODO Auto-generated constructor stub
		String hostName = "localhost";
	     String sqlInstanceName = "SQLEXPRESS";
	     String database = "ITSS";
	     String userName = "SA";
	     String password = "123456";
	     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	 
	     conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     Statement statement = conn.createStatement();
	     ResultSet rSet = statement.executeQuery("SELECT * FROM Users");
	     while(rSet.next()) {
	    	 System.out.println(rSet.getString("Email") + " " + rSet.getString("Pass") + " " + rSet.getString("isAdmin") );
	     }
	     System.out.println("Connect ok");
	}
	public List<Media> getListMedia() {
		List<Media> listMedia=new ArrayList<Media>();
		Media media;
		 Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai "
					+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai");
			while(rSet.next()) {
				media = new Media();
				media.setCategoryString(rSet.getString("TenLoai"));
				media.setNameString(rSet.getString("Ten"));
				media.setPriceFloat(rSet.getInt("GiaCa"));
				listMedia.add(media);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMedia;
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
