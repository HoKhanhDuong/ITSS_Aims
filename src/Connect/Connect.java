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
	private ResultSet rSet;
	private List<Media> listMedia;
	private Media media;
	private Statement statement;
	public Connect() throws SQLException {
		// TODO Auto-generated constructor stub
		String hostName = "localhost";
	     String sqlInstanceName = "SQLEXPRESS";
	     String database = "ITSS";
	     String userName = "sa";
	     String password = "123456";
	     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	 
	     conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     Statement statement = conn.createStatement();
//	     ResultSet rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai "
//	    		 + "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai");
//	     while(rSet.next()) {
//	    	 System.out.println(rSet.getString("Ten") + " " + rSet.getString("GiaCa") + " " + rSet.getString("TenLoai") );
//	     }
	     System.out.println("Connect ok");
	}
	public List<Media> getListMedia() {
		listMedia=new ArrayList<Media>();
//		Media media;
//		Statement statement;
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai "
					+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai");
			int i = 0;
			while(i<5) {
				media = new Media();
				media.setCategoryString("TenLoai");
				media.setNameString("Ten");
				media.setPriceFloat(i);
				listMedia.add(media);
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMedia;
	}
//	public static void main(String args[]) {
//		try {
//			Connect connect = new Connect();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
