package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

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
	     String userName = "sa";
//	     String password = "123456";
	     String password = "do@1230.com";
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
	
	public void update_Physical(int id_media, String[] value) {
		
		int qtity = Integer.parseInt(value[1]);
		float mass = Float.parseFloat(value[5]);
		System.out.println(id_media);
		try {
			statement.executeUpdate("UPDATE Physical\n"
					+ "SET Barcode = '"+value[0]+"',\n"
					+ "    SoLuong = "+qtity+",\n"
					+ "    MoTa = '"+value[2]+"',\n"
					+ "    NgayNhapKho = '"+value[3]+"',\n"
					+ "    Size = '"+value[4]+"',\n"
					+ "    KhoiLuong = "+mass+"\n"
					+ "WHERE IDMedia = "+id_media);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] get_Physiscal(int id_media) {
		
		String[] values = new String[7];
		
		try {
			rSet = statement.executeQuery("select Barcode, SoLuong, MoTa, NgayNhapKho, Size, KhoiLuong \n"
					+ "from Physical join Media\n"
					+ "ON Physical.IDMedia = Media.IDMedia\n"
					+ "WHERE Media.IDMedia ="+id_media);
			if (rSet.next()) {
				values[0] = rSet.getString("Barcode");
				values[1] = ""+ rSet.getInt("SoLuong");
				values[2] = rSet.getString("MoTa");
				values[3] = rSet.getString("NgayNhapKho");
				values[4] = rSet.getString("Size");
				values[5] = "" + rSet.getFloat("KhoiLuong");
				values[6] = "" +id_media;
				
				return values;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
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
	
	public void update_status_media(int media_id) {
		try {
			statement.executeUpdate("UPDATE Media\n"
					+ "SET deleted = 1\n"
					+ "WHERE IDMedia ="+media_id);
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
	
	public HashMap<String, Integer> getLanguages() {
		HashMap<String, Integer> languages = new HashMap<String, Integer>();
		try {
			rSet = statement.executeQuery("SELECT * FROM NgonNgu");
			
			while(rSet.next()) {
				languages.put(rSet.getString("Ten"), rSet.getInt("IDNN"));
			}
			
			return languages;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public HashMap<String, Integer> getTheLoais(int id_loai) {
		HashMap<String, Integer> categorys = new HashMap<String, Integer>();
		
		try {
			rSet = statement.executeQuery("select * from TheLoai\n"
					+ "WHERE IDLoai = "+id_loai);
			
			while(rSet.next()) {
				categorys.put(rSet.getString("Ten"), rSet.getInt("IDTheLoai"));
			}
			
			return categorys;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int count_rm_edit(int status) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = Calendar.getInstance().getTime();
		String dateString = simple.format(currentDate);
		try {
			if (status == 0) {
			rSet = statement.executeQuery("select count(*) AS 'edit' from History\n"
					+ "WHERE IDAction = 3\n"
					+ "AND date_action BETWEEN '"+dateString+"'\n"
					+ "AND '"+dateString+"'");
			} else {
				rSet = statement.executeQuery("select count(*) AS 'edit' from History\n"
						+ "WHERE IDAction = 2\n"
						+ "AND date_action BETWEEN '"+dateString+"'\n"
						+ "AND '"+dateString+"'");
			}
			if (rSet.next()) {
				return rSet.getInt("edit");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public float check_edit(int id_media) {
		
		String date_sys = "";
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = Calendar.getInstance().getTime();
		String dateString = simple.format(currentDate);
		try {
			rSet = statement.executeQuery("select date_action from History\n"
					+ "where IDMedia = "+id_media+"\n"
					+ "  AND IDAction = 1");
			
			if (rSet.next()) {
				date_sys = rSet.getString("date_action");
				rSet = statement.executeQuery("select DATEDIFF(second , '"+date_sys+"', '"+dateString+"') AS 'hour'");
				
				if (rSet.next()) {
					return (float) rSet.getInt("hour")/3600;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
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
