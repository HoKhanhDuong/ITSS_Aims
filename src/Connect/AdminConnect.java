package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Object.Media;
import Object.User;
import admin.SaleMedia;

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
//	     String password = "do@1230.com";
	     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	 
	     conn = DriverManager.getConnection(connectionURL, userName, password);
	     
	     statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}
	
	public ArrayList<User> getfullUsers(){
		ArrayList<User> list = new ArrayList<User>();
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT Users.IDUser, Phone, DiaChi, isBlock, Name FROM Users "
					+ " JOIN DiaChi ON Users.IDUser = DiaChi.IDUser "
					+ " WHERE DiaChi.isMain = 1 AND Users.isAdmin = 0");
			while(rSet.next()) {
				User user = new User(
						rSet.getString("Name"), 
						rSet.getString("Phone"), 
						rSet.getString("DiaChi"),
						null, null, 
						rSet.getInt("IDUser"), 
						rSet.getInt("isBlock")
					);
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
	
	public void insert_Physical(int id_media, String[] value) {
		
		int qtity = Integer.parseInt(value[1]);
		float mass = Float.parseFloat(value[5]);
		
		try {
			
			statement.executeUpdate("INSERT INTO Physical(IDMedia, Barcode, SoLuong, MoTa, NgayNhapKho, Size, KhoiLuong)\n"
					+"VALUES (" +id_media+", '"
					+value[0]+"', "+qtity+", '"+value[2]+"', '"+value[3]+"', '"+value[4]+"', "+mass+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getID() {
		
		try {
			rSet = statement.executeQuery("SELECT IDUser FROM Users WHERE isAdmin = 1 ");
			
			if (rSet.next()) {
				return rSet.getInt("IDUser");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public void insert_History(int id_media, int id_admin, int id_action, String date) {
		
		try {
			statement.executeUpdate("INSERT INTO History (IDMedia, IDUser, IDAction, date_action)\n"
					+ "VALUES ("+id_media+", "+id_admin+", "+id_action+", '"+date+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int id_loai(int id_media) {
		
		try {
			rSet = statement.executeQuery("SELECT IDLoai FROM Media WHERE IDMedia = "+id_media);
			
			if (rSet.next()) {
				return rSet.getInt("IDLoai");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
		
	}
	
	public void remove_product(int id_media, int id_loai) {
		
		try {
			statement.executeUpdate("delete from Media WHERE IDMedia = "+id_media);
			
			switch (id_loai) {
				
			case 1:
				statement.executeUpdate("delete from Book WHERE IDMedia = "+id_media);
				break;
			case 2:
				statement.executeUpdate("delete from CD WHERE IDMedia = "+id_media);
				break;
			case 3:
				statement.executeUpdate("delete from DVD WHERE IDMedia = "+id_media);
				break;
			case 4:
				statement.executeUpdate("delete from LD WHERE IDMedia = "+id_media);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Media> getListMedia(int category){
		ArrayList<Media> list = new ArrayList<Media>();
		
		try {
			rSet = statement.executeQuery("SELECT Ten, IDMedia FROM Media WHERE IDLoai = "+category);
			while(rSet.next()) {
				Media media = new Media();
				media.setId(rSet.getInt("IDMedia"));
				media.setNameString(rSet.getString("Ten"));
				list.add(media);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void saveSale(String name, String starttime, String endtime, ArrayList<SaleMedia> list) {
		try {
			statement.executeUpdate("INSERT INTO Sale VALUES('"+starttime+"','"+endtime+"','"+name+"')");
			rSet = statement.executeQuery("SELECT MAX(IDSale) AS IDSale FROM Sale ");
			rSet.next();
			int id = rSet.getInt("IDSale");
			for(int i=0; i<list.size(); i++) {
				statement.executeUpdate("INSERT INTO MediaSale VALUES ("+id+", "+list.get(i).mediaid+", "
						+(Float.parseFloat(list.get(i).sale.getText())/100)+")");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
