package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Object.User;
import Object.Media;

public class Connect {
  
	private Connection conn;
	private ResultSet rSet;
	private List<Media> listMedia;
	private Media media;
	private Statement statement;
  private final int SIZE = 10000;
  
	public Connect() throws SQLException {
		// TODO Auto-generated constructor stub
		String hostName = "localhost";
	     String sqlInstanceName = "SQLEXPRESS";
	     String database = "ITSS";
	     String userName = "SA";
	     String password = "do@1230.com";
	     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	 
	     conn = DriverManager.getConnection(connectionURL, userName, password);
	     
	     statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	     
	     
//	     statement.executeUpdate("UPDATE Users SET Pass ='1234567' WHERE IDUser = 1");  
//	     System.out.println(rSet.next());
	     
//	     while(rSet.next()) {
//	    	 System.out.println(rSet.getString("Email") + " " + rSet.getString("Pass") + " " + rSet.getString("isAdmin") );
//	     }
	     System.out.println("Connect ok");
	}
	
	public boolean changePassword(int idUser, String currentPass, String newPass) {
		
		try {
			rSet = statement.executeQuery("SELECT * FROM Users WHERE IDUser = "+idUser+"AND Pass='"+currentPass+"'");
			
			if (!rSet.next()) {
				return false;
			}
			
			statement.executeUpdate("UPDATE Users SET Pass ='"+newPass+"' WHERE IDUser="+idUser);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public User InformationUser(int idUser) {
		User user = null;
		
		try {
			
			rSet = statement.executeQuery("SELECT Phone, Name, DiaChi, Email, CardNumber, Users.IDUser "
					+ "FROM DiaChi JOIN Users ON DiaChi.IDUser = Users.IDUser "
					+ "WHERE DiaChi.IDUser = "+idUser);
			if (rSet.next() == true) {
				user = new User(rSet.getString("Name"), rSet.getString("Phone"), rSet.getString("DiaChi"), 
						rSet.getString("Email"), rSet.getString("CardNumber"), rSet.getInt("IDUser"));
				
				return user;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void changeInformation(Integer idUser, String address, String cardNumber) {
		
		try {
			statement.executeUpdate("UPDATE DiaChi SET DiaChi = N'"+address+"' WHERE IDUser="+idUser);
			statement.executeUpdate("UPDATE Users SET CardNumber ='"+cardNumber+"' WHERE IDUser="+idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String[][] get_OrderDetail(int idUser) {
	
		String[][] data_Order = new String[SIZE][SIZE];
		
		int id_order = 0;
		
		int i = 0;
		
		
		try {
			rSet = statement.executeQuery("SELECT O.IDDonHang, TT.SoLuong, M.Ten, O.TrangThai, TT.Gia\n"
					+ "FROM ThongTinDonHang AS TT JOIN DonHang AS O\n"
					+ "ON O.IDDonHang = TT.IDDonHang JOIN Media AS M\n"
					+ "ON M.IDMedia = TT.IDMedia\n"
					+ "WHERE O.IDUser ="+idUser+ "\n"
					+ "group by O.IDDonHang, M.Ten, O.TrangThai, TT.Gia, TT.SoLuong");
			
			rSet.afterLast();
			
			int last = rSet.getRow();
			
			rSet.beforeFirst();
			if (rSet.next()) {
				id_order = rSet.getInt("IDDonHang");
			}
			
			rSet.absolute(rSet.getRow()-1);
			
			while(rSet.next()) {
				float total = rSet.getInt("SoLuong")*Float.parseFloat(rSet.getString("Gia"));
				data_Order[i][0] = ""+ ((int)rSet.getInt("IDDonHang") + 100000);
				data_Order[i][1] = rSet.getString("Ten");
				data_Order[i][3] = rSet.getString("TrangThai");
				while(rSet.next()) {
					if(id_order == rSet.getInt("IDDonHang")) {
						
						data_Order[i][1] += ", " + rSet.getString("Ten");
						total += rSet.getInt("SoLuong")*Float.parseFloat(rSet.getString("Gia"));
						data_Order[i][2] = "" + total;
					} else {
						
						id_order = rSet.getInt("IDDonHang");
						rSet.absolute(rSet.getRow()-1);
						i++;
						break;
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
			return data_Order;
	}
	public List<Media> getListMedia(int type) {
		listMedia = new ArrayList<Media>();
		try {
			statement = conn.createStatement();
			switch (type) {
			case 1: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='Book'");
				break;
			}
			case 2: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='CD'");
				break;
			}
			case 3: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='DVD'");
				break;
			}
			default:
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai");
				break;
			}
			
			while(rSet.next()) {
				media = new Media();
				media.setCategoryString(rSet.getString("TenLoai"));
				media.setNameString(rSet.getString("Ten"));
				media.setPriceFloat(rSet.getInt("GiaCa"));
				media.setIDMedia(rSet.getInt("IDMedia"));
				listMedia.add(media);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMedia;
	}
	public List<Media> getListMediaSort(int type) {
		listMedia = new ArrayList<Media>();
		try {
			statement = conn.createStatement();
			switch (type) {
			case -1: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='Book' ORDER BY GiaCa ASC");
				break;
			}
			case -2: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='CD' ORDER BY GiaCa ASC");
				break;
			}
			case -3: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='DVD' ORDER BY GiaCa ASC");
				break;
			}
			case 0: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ " ORDER BY GiaCa ASC");
				break;
			}
			case 1: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='Book' ORDER BY GiaCa DESC");
				break;
			}
			case 2: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='CD' ORDER BY GiaCa DESC");
				break;
			}
			case 3: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='DVD' ORDER BY GiaCa DESC");
				break;
			}
			default:
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ " ORDER BY GiaCa DESC");
				break;
			}
			
			while(rSet.next()) {
				media = new Media();
				media.setCategoryString(rSet.getString("TenLoai"));
				media.setNameString(rSet.getString("Ten"));
				media.setPriceFloat(rSet.getInt("GiaCa"));
				media.setIDMedia(rSet.getInt("IDMedia"));
				listMedia.add(media);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMedia;
	}
	
}
