package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Object.Address;
import Object.Book;
import Object.CD;
import Object.DVD;
import Object.LD;
import Object.User;
import productframe.ProductPaneInCart;
import Object.Media;
import Object.OrderObject;

public class Connect {
  
	private Connection conn;
	private ResultSet rSet;
	private List<Media> listMedia;
	private Media media;
	private Statement statement;
	
	private DecimalFormat format;
	
  private final int SIZE = 10000;
  
	public Connect() throws SQLException {
		// TODO Auto-generated constructor stub
		 String hostName = "localhost";
	     String sqlInstanceName = "SQLEXPRESS";
	     String database = "ITSS";


// 	     String userName = "sa";
// 	     String password = "123456";

 	     String userName = "SA";
 	     String password = "123456";

	     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	 
	     conn = DriverManager.getConnection(connectionURL, userName, password);
	     
	     statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

	}

// phần user 
	public boolean checkAdmin(int idUser) {
		try {
			rSet = statement.executeQuery("SELECT isAdmin FROM Users WHERE IDUser = "+idUser);
			
			if (!rSet.next() || rSet.getInt("isAdmin")==0) {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
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
			
			rSet = statement.executeQuery("SELECT Phone, Name, DiaChi, Email, CardNumber, Users.IDUser, isBlock "
					+ "FROM DiaChi JOIN Users ON DiaChi.IDUser = Users.IDUser "
					+ "WHERE Users.IDUser = "+idUser);
			if (rSet.next()) {
				user = new User(rSet.getString("Name"), rSet.getString("Phone"), rSet.getString("DiaChi"), 
						rSet.getString("Email"), rSet.getString("CardNumber"), rSet.getInt("IDUser"), rSet.getInt("isBlock"));
				
				return user;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void changeInformation(int idUser, String address, String cardNumber) {
		String[] address_arr = address.split("[,-]");
		try {
			address = address_arr[2] +"<>"+ address_arr[1] +"<>"+ address_arr[0];
			statement.executeUpdate("UPDATE DiaChi SET DiaChi = N'"+address+"' WHERE IDUser="+idUser);
			statement.executeUpdate("UPDATE Users SET CardNumber ='"+cardNumber+"' WHERE IDUser="+idUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String[][] get_OrderDetail(int idUser) {
	
		String[][] data_Order = new String[SIZE][5];
		int id_order = 0;
		int i = 0;
		float total = 0;
		
		try {
			rSet = statement.executeQuery("SELECT O.IDDonHang, TT.SoLuong, M.Ten, O.TrangThai, TT.Gia\n"
					+ "FROM ThongTinDonHang AS TT JOIN DonHang AS O\n"
					+ "ON O.IDDonHang = TT.IDDonHang JOIN Media AS M\n"
					+ "ON M.IDMedia = TT.IDMedia\n"
					+ "WHERE O.IDUser ="+idUser+ "\n"
					+ "group by O.IDDonHang, M.Ten, O.TrangThai, TT.Gia, TT.SoLuong");
			
			if (rSet.next()) {
				id_order = rSet.getInt("IDDonHang");
				rSet.absolute(rSet.getRow()-1);
			}
			
			while(rSet.next()) {
				total = rSet.getInt("SoLuong")*Float.parseFloat(rSet.getString("Gia"));
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
						total = 0;
						i++;
						break;
					}
				}
			}
			if (total != 0.0) {
				data_Order[i][2] = "" + total;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
			return data_Order;
	}
//	public List<Media> getListMedia(int type, int offset) {
//		listMedia = new ArrayList<Media>();
//		try {
//			statement = conn.createStatement();
//			switch (type) {
//			case 1: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='Book'\r\n" + 
//						"ORDER BY IDMedia\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case 2: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='CD'\r\n" + 
//						"ORDER BY IDMedia\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case 3: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='DVD'\r\n" + 
//						"ORDER BY IDMedia\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case 4:{
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='LP'\r\n" + 
//						"ORDER BY IDMedia\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			default:
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0\r\n" + 
//						"ORDER BY IDMedia\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			
//			while(rSet.next()) {
//
//
//				media = new Media(rSet.getString("Ten"), 
//						rSet.getInt("GiaCa"), 
//						rSet.getString("TenLoai"), 
//						rSet.getString("image"),
//						rSet.getInt("IDMedia"));
//				listMedia.add(media);
//				
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return listMedia;
//	}
//	public List<Media> getListMediaSort(int type, int offset) {
//		listMedia = new ArrayList<Media>();
//		try {
//			statement = conn.createStatement();
//			switch (type) {
//			case -1: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='Book'\r\n" + 
//						"ORDER BY GiaCa ASC\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case -2: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='CD'\r\n" + 
//						"ORDER BY GiaCa ASC\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case -3: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='DVD'\r\n" + 
//						"ORDER BY GiaCa ASC\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case -4: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='LP'\r\n" + 
//						"ORDER BY GiaCa ASC\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case 7: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0\r\n" + 
//						"ORDER BY GiaCa ASC\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case 1: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='Book'\r\n" + 
//						"ORDER BY GiaCa DESC\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case 2: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='CD'\r\n" + 
//						"ORDER BY GiaCa DESC\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case 3: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='DVD'\r\n" + 
//						"ORDER BY GiaCa DESC\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			case 4: {
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0 AND Loai.TenLoai='LP'\r\n" + 
//						"ORDER BY GiaCa DESC\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			default:
//
//				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
//						"join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
//						"WHERE IDMedia > 0\r\n" + 
//						"ORDER BY GiaCa DESC\r\n" + 
//						"OFFSET "+offset+" ROWS\r\n" + 
//						"FETCH NEXT 20 ROWS ONLY;");
//				break;
//			}
//			
//			while(rSet.next()) {
//				media = new Media();
//				media.setCategory(rSet.getString("TenLoai"));
//				media.setNameString(rSet.getString("Ten"));
//				media.setPriceFloat(rSet.getInt("GiaCa"));
//				media.setId(rSet.getInt("IDMedia"));
//
//				media.setImage(rSet.getString("image"));
//				listMedia.add(media);
//			}
//			
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return listMedia;
//	}
	
	public int checkSale() {
		
		LocalDate date = LocalDate.now();
		
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT IDSale FROM Sale WHERE StartTime <= '"+date+"' AND EndTime >= '"+date+"'");
			if(rSet.next()) return rSet.getInt("IDSale");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	public List<Media> getListMediaSale(int type, int offset, int idsale) {
		listMedia = new ArrayList<Media>();
		try {
			statement = conn.createStatement();
			switch (type) {
			case 1: {


				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='Book' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.IDMedia\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");

				break;
			}
			case 2: {


				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='CD' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.IDMedia\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 3: {


				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='DVD' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.IDMedia\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 4:{

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='LP' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.IDMedia\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			default:

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.IDMedia\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");

				break;
			}
			
			while(rSet.next()) {


				media = new Media(rSet.getString("Ten"), 
						rSet.getInt("GiaCa"), 
						rSet.getString("TenLoai"), 
						rSet.getString("image"),
						rSet.getInt("IDMedia"),
						rSet.getFloat("sale"));
				listMedia.add(media);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMedia;
	}
	public List<Media> getListMediaSaleSort(int type, int offset, int idsale) {
		listMedia = new ArrayList<Media>();
		try {
			statement = conn.createStatement();
			switch (type) {
			case -1: {


				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='Book' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  ASC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");

				break;
			}
			case -2: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='CD' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  ASC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case -3: {
				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='DVD' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  ASC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case -4: {
				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='LP' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  ASC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 7: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  ASC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 1: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='Book' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  DESC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 2: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='CD' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  DESC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");

				break;
			}
			case 3: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='DVD' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  DESC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");

				break;
			}
			case 4: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='LP' AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  DESC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");

				break;
			}
			default:

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND MediaSale.IDSale = "+idsale+" \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  DESC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");

				break;
			}
			
			while(rSet.next()) {
				media = new Media();
				media.setCategory(rSet.getString("TenLoai"));
				media.setNameString(rSet.getString("Ten"));
				media.setPriceFloat(rSet.getInt("GiaCa"));
				media.setId(rSet.getInt("IDMedia"));
				media.setImage(rSet.getString("image"));
				media.setSale(rSet.getFloat("sale"));
				listMedia.add(media);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMedia;
	}
	
	public List<Media> getListMedia(int type, int offset) {
		listMedia = new ArrayList<Media>();
		try {
			statement = conn.createStatement();
			switch (type) {
			case 1: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
			//			"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='Book' \r\n" + 
						"ORDER BY Media.IDMedia\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 2: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
			//			"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='CD' \r\n" + 
						"ORDER BY Media.IDMedia\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 3: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
			//			"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='DVD' \r\n" + 
						"ORDER BY Media.IDMedia\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 4:{

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
			//			"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='LP' \r\n" + 
						"ORDER BY Media.IDMedia\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			default:

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
			//			"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0\r\n" + 
						"ORDER BY Media.IDMedia\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			
			while(rSet.next()) {

				media = new Media(rSet.getString("Ten"), 
						rSet.getInt("GiaCa"), 
						rSet.getString("TenLoai"), 
						rSet.getString("image"),
						rSet.getInt("IDMedia"),
						0);
				listMedia.add(media);
			}
			
			int idsale = checkSale();
			if(idsale > 0) {
				rSet = statement.executeQuery("SELECT IDMedia, sale FROM MediaSale WHERE IDSale = "+idsale);
				while(rSet.next()) {
					for(int i=0; i<listMedia.size(); i++) {
						if(listMedia.get(i).getId() == rSet.getInt("IDMedia")) {
							listMedia.get(i).setSale(rSet.getFloat("sale"));
							break;
						}
						if(listMedia.get(i).getId() > rSet.getInt("IDMedia")) break;
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMedia;
	}
	public List<Media> getListMediaSort(int type, int offset) {
		listMedia = new ArrayList<Media>();
		try {
			statement = conn.createStatement();
			switch (type) {
			case -1: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='Book' \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  ASC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case -2: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='CD' \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  ASC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case -3: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='DVD' \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  ASC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case -4: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='LP' \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  ASC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 7: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  ASC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 1: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='Book' \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  DESC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 2: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='CD' \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  DESC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 3: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='DVD' \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  DESC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			case 4: {

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 AND Loai.TenLoai='LP' \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  DESC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			default:

				rSet = statement.executeQuery("SELECT * FROM Media\r\n" + 
						"inner join Loai on Media.IDLoai = Loai.IDLoai\r\n" + 
						"inner join MediaSale on Media.IDMedia = MediaSale.IDMedia\r\n" + 
						"WHERE Media.IDMedia > 0 \r\n" + 
						"ORDER BY Media.GiaCa*(1-MediaSale.sale)  DESC\r\n" + 
						"OFFSET "+offset+"ROWS\r\n" + 
						"FETCH NEXT 20 ROWS ONLY;");
				break;
			}
			
			while(rSet.next()) {
				media = new Media();
				media.setCategory(rSet.getString("TenLoai"));
				media.setNameString(rSet.getString("Ten"));
				media.setPriceFloat(rSet.getInt("GiaCa"));
				media.setId(rSet.getInt("IDMedia"));
				media.setImage(rSet.getString("image"));
				media.setSale(rSet.getFloat("sale"));
				listMedia.add(media);
			}
			
			int idsale = checkSale();
			if(idsale > 0) {
				rSet = statement.executeQuery("SELECT IDMedia, sale FROM MediaSale WHERE IDSale = "+idsale);
				while(rSet.next()) {
					for(int i=0; i<listMedia.size(); i++) {
						if(listMedia.get(i).getId() == rSet.getInt("IDMedia")) {
							listMedia.get(i).setSale(rSet.getFloat("sale"));
							break;
						}
						if(listMedia.get(i).getId() > rSet.getInt("IDMedia")) break;
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMedia;
	}
	public void setBook(String name, String NgayXB, String NhaXB, int soTrang, int Price, int Value, String image) throws SQLException {
		Book book = new Book();
		rSet = statement.executeQuery("SELECT IDLoai "
				+ "FROM Loai WHERE TenLoai = 'Book'");
		int idLoai = rSet.getInt("IDLoai");
		statement.execute("INSERT INTO Media VALUES ('"+name+"',"+idLoai +"',0)");
		
		
	}
	public Book getBook(int id) {
		Book book = new Book();
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * "
					+ "FROM Media join Book ON Media.IDMedia = Book.IDMedia "
					+ "WHERE Book.IDMedia = "+ id);
			if (rSet.next()) {
				book.setId(rSet.getInt("IDMedia"));
				book.setNameString(rSet.getString("Ten"));
				book.setNgayXBString(rSet.getString("NgayXB"));
				book.setNhaXBString(rSet.getString("NhaXB"));
				book.setSotrang(rSet.getInt("SoTrang"));
				book.setPriceFloat(rSet.getInt("GiaCa"));
				book.setValue((long)rSet.getInt("GiaTri"));
				book.setImage(rSet.getString("image"));
			}
			
			rSet = statement.executeQuery("SELECT LoaiBia, NgonNgu.Ten AS 'name_NN', TheLoai.Ten AS 'name_TL'\n"
					+ "FROM Book join TheLoai\n"
					+ "ON TheLoai.IDTheLoai=Book.IDTheLoai\n"
					+ "JOIN NgonNgu ON NgonNgu.IDNN = Book.IDNN\n"
					+ "JOIN Bia ON Bia.IDBia = Book.IDBia\n"
					+ "WHERE Book.IDMedia = " + id);
			if (rSet.next()) {
				book.setBiaString(rSet.getString("LoaiBia"));
				book.setNgonNguString(rSet.getString("name_NN"));
				book.setTheloaiString(rSet.getString("name_TL"));
			}
			
			
			rSet = statement.executeQuery("Select TacGia.Ten FROM Book join SangTac\n"
					+ "ON SangTac.IDMedia = Book.IDMedia\n"
					+ "JOIN TacGia ON SangTac.IDTacGia = TacGia.IDTacGia\n"
					+ "WHERE Book.IDMedia = "+id);
			String tacgiaString = "";
			while(rSet.next()) {
				tacgiaString = tacgiaString + rSet.getString("Ten") + ", ";
			}
			if (!tacgiaString.isEmpty()) tacgiaString = tacgiaString.trim().substring(0, tacgiaString.length()-2);
			book.setTacGiaString(tacgiaString);
			
			int idsale = checkSale();
			if(idsale > 0) {
				rSet = statement.executeQuery("SELECT sale FROM MediaSale WHERE IDSale = "+idsale);
				if(rSet.next()) {
					book.setSale(book.getPriceFloat()*(1-rSet.getFloat("sale")));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return book;
		
	}
	
	public void setDVD(String name, String thoiLuong, String studio, int Price, int Value, String image) throws SQLException {
		DVD DVD = new DVD();
		rSet = statement.executeQuery("SELECT IDLoai "
				+ "FROM Loai WHERE TenLoai = 'DVD'");
		int idLoai = rSet.getInt("IDLoai");
		statement.execute("INSERT INTO Media VALUES ('"+name+"',"+idLoai +"',0)");
		
		
	}
	
	public CD getCd(int id) {
		
		CD cd = new CD();
		try {
			statement = conn.createStatement();
			
			rSet = statement.executeQuery("SELECT * "
					+ "FROM Media join CD ON Media.IDMedia = CD.IDMedia"
					+ " WHERE CD.IDMedia ="+ id);
			
			if (rSet.next()) {
				cd.setId(rSet.getInt("IDMedia"));
				cd.setNameString(rSet.getString("Ten"));
				cd.setPriceFloat(rSet.getInt("GiaCa"));
				cd.setValue((long) rSet.getInt("GiaTri"));
				cd.setImage(rSet.getString("image"));
				cd.setHangGhiAmString(rSet.getString("HangGhiAm"));
			}
			
			rSet = statement.executeQuery("SELECT TheLoai.Ten "
					+ "FROM CD join TheLoai ON TheLoai.IDTheLoai = CD.IDTheLoai \n"
					+ "WHERE CD.IDMedia = " + id);
			if (rSet.next()) {
				cd.setTheLoaiString(rSet.getString("Ten"));
			}
			
			
			rSet = statement.executeQuery("Select TacGia.Ten FROM CD join SangTac \n"
					+ "ON SangTac.IDMedia = CD.IDMedia\n"
					+ "join TacGia ON SangTac.IDTacGia = TacGia.IDTacGia\n"
					+ "WHERE CD.IDMedia = "+id);
			
			String tacgiaString = "";
			
			while(rSet.next()) {
				tacgiaString = tacgiaString + rSet.getString("Ten") + ", ";
			}
			if (!tacgiaString.isEmpty()) tacgiaString = tacgiaString.trim().substring(0, tacgiaString.length()-2);
			cd.setTenNgheSyString(tacgiaString);
			
			rSet = statement.executeQuery("Select BaiHat.Ten FROM CD join DanhSachBaiHat\n"
					+ "ON DanhSachBaiHat.IDMedia = CD.IDMedia\n"
					+ "join BaiHat\n"
					+ "ON BaiHat.IDBaiHat = DanhSachBaiHat.IDBaiHat\n"
					+ "WHERE CD.IDMedia = "+id+"\n"
					+ "AND DanhSachBaiHat.deleted = 0");
			
			String baihatString = "";
			while(rSet.next()) {
				baihatString = baihatString + rSet.getString("Ten") + ", ";
			}
			if (!baihatString.isEmpty()) baihatString = baihatString.trim().substring(0, baihatString.length()-2);
			cd.setBaihatString(baihatString);
			
			int idsale = checkSale();
			if(idsale > 0) {
				rSet = statement.executeQuery("SELECT sale FROM MediaSale WHERE IDSale = "+idsale);
				if(rSet.next()) {
					cd.setSale(cd.getPriceFloat()*(1-rSet.getFloat("sale")));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cd;
	}
	
	public LD getlD(int id) {
		LD cd = new LD();
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * "
					+ "FROM Media join LD ON Media.IDMedia = LD.IDMedia "
					+ "WHERE LD.IDMedia = "+ id);
			
			if (rSet.next()) {
				cd.setId(rSet.getInt("IDMedia"));
				cd.setNameString(rSet.getString("Ten"));
				cd.setPriceFloat(rSet.getInt("GiaCa"));
				cd.setValue((long) rSet.getInt("GiaTri"));
				cd.setImage(rSet.getString("image"));
				cd.setHangGhiAmString(rSet.getString("HangGhiAm"));
			}
			
			rSet = statement.executeQuery("SELECT TheLoai.Ten "
					+ "FROM LD join TheLoai ON TheLoai.IDTheLoai=LD.IDTheLoai WHERE LD.IDMedia = " + id);
			if (rSet.next()) {
				cd.setTheLoaiString(rSet.getString("Ten"));
			}
			
			
			rSet = statement.executeQuery("Select TacGia.Ten \n"
					+ "FROM LD join SangTac ON SangTac.IDMedia = LD.IDMedia\n"
					+ "JOIN TacGia ON SangTac.IDTacGia = TacGia.IDTacGia\n"
					+ "WHERE LD.IDMedia ="+id);
			String tacgiaString = "";
			while(rSet.next()) {
				tacgiaString = tacgiaString + rSet.getString("Ten") + ", ";
			}
			if (!tacgiaString.isEmpty()) tacgiaString = tacgiaString.trim().substring(0, tacgiaString.length()-2);
			cd.setTenNgheSyString(tacgiaString);
			
			rSet = statement.executeQuery("Select BaiHat.Ten FROM LD join DanhSachBaiHat\n"
					+ "ON DanhSachBaiHat.IDMedia = LD.IDMedia\n"
					+ "join BaiHat\n"
					+ "ON BaiHat.IDBaiHat = DanhSachBaiHat.IDBaiHat\n"
					+ "WHERE LD.IDMedia = "+id+"\n"
					+ "AND DanhSachBaiHat.deleted = 0");
			String baihatString = "";
			while(rSet.next()) {
				baihatString = baihatString + rSet.getString("Ten") + ", ";
			}
			if (!baihatString.isEmpty()) baihatString = baihatString.trim().substring(0, baihatString.length()-2);
			cd.setBaihatString(baihatString);
			
			int idsale = checkSale();
			if(idsale > 0) {
				rSet = statement.executeQuery("SELECT sale FROM MediaSale WHERE IDSale = "+idsale);
				if(rSet.next()) {
					cd.setSale(cd.getPriceFloat()*(1-rSet.getFloat("sale")));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cd;
	}
	
	public DVD getDvd(int id) {
		DVD dvd = new DVD();
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * "
					+ "FROM Media join DVD ON Media.IDMedia=DVD.IDMedia "
					+ "WHERE DVD.IDMedia = "+ id);
			if (rSet.next()) {
				dvd.setId(rSet.getInt("IDMedia"));
				dvd.setNameString(rSet.getString("Ten"));
				dvd.setPriceFloat(rSet.getInt("GiaCa"));
				dvd.setValue((long) rSet.getInt("GiaTri"));
				dvd.setImage(rSet.getString("image"));
				dvd.setThoiLuong(rSet.getFloat("ThoiLuong"));
				dvd.setPhudeString(rSet.getString("PhuDe"));
				dvd.setStudioString(rSet.getString("Studio"));
			}
			
			rSet = statement.executeQuery("SELECT NgonNgu.Ten AS 'name_NN', TheLoai.Ten AS 'name_TL' \n"
					+ "FROM DVD join TheLoai ON TheLoai.IDTheLoai = DVD.IDTheLoai \n"
					+ "JOIN NgonNgu ON DVD.IDNN = NgonNgu.IDNN\n"
					+ "WHERE DVD.IDMedia =" + id);
			
			if (rSet.next()) {
				dvd.setTheLoaiString(rSet.getString("name_TL"));
				dvd.setNgonNguString(rSet.getString("name_NN"));
			}
			
			rSet = statement.executeQuery("Select TacGia.Ten \n"
					+ "FROM DVD join SangTac ON SangTac.IDMedia = DVD.IDMedia\n"
					+ "JOIN TacGia ON SangTac.IDTacGia = TacGia.IDTacGia\n"
					+ "WHERE DVD.IDMedia ="+id);
			if (rSet.next()) {
				dvd.setDaoDienString(rSet.getString("Ten"));
			}
			
			rSet = statement.executeQuery("select LoaiDia from LoaiDia join DVD\n"
					+ "ON DVD.IDDia = LoaiDia.IDDia\n"
					+ "WHERE DVD.IDMedia ="+id);
			
			if (rSet.next()) {
				dvd.setKieuDia(rSet.getString("LoaiDia"));
			}
			int idsale = checkSale();
			if(idsale > 0) {
				rSet = statement.executeQuery("SELECT sale FROM MediaSale WHERE IDSale = "+idsale);
				if(rSet.next()) {
					dvd.setSale(dvd.getPriceFloat()*(1-rSet.getFloat("sale")));
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dvd;
	}
	
	public int getUserId(String username, String password) {
		
		try {
			rSet = statement.executeQuery("SELECT * FROM Users Where Email = '"+username+"' AND Pass = '"+password +"'");
			if(rSet.next()) {
				if(rSet.getBoolean("isAdmin") == false) {
					return rSet.getInt("IDUser");
				} else return -2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int setUser(String username, String password, Address address) {
		try {
			int id = 0;
			
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * FROM Users Where Email = '"+username+"' AND Pass = '"+password +"'");
			if(!rSet.next()) {
				statement.execute("INSERT INTO Users(Email, Pass, isAdmin) VALUES ('"+username+"','"+password+"',0)");
				
				id = getUserId(username, password);
//<<<<<<< HEAD
//				if (id > 0) {
//					statement.execute("insert into DiaChi (IDUser, Phone, Name, DiaChi) "
//							+ "VALUES ("+id+",'"+phone+"',"+"N'"+name+"',N'"+address+"')");
//					return id;
//				}
				if (id > 0) {
					String addressString = address.getAddress()+"<>"+address.getDistrict()+"<>"+address.getCity();
					
					statement.execute("insert into DiaChi (IDUser, Phone, Name, DiaChi, isMain) "
							+ "VALUES ("+id+",'"+address.getPhone()+"',"+"N'"+address.getName()+"',N'"+addressString+"', 1)");
					return id;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	

	public int searchCart(int IDUser, int IDMedia) {
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * FROM Cart WHERE IDMedia = "+IDMedia+" AND IDUser = "+IDUser);
			if(rSet.next()) {
				return rSet.getInt("SoLuong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public void addCart(int IDUser, int IDMedia, int soluong) {
		try {
			statement = conn.createStatement();
			statement.executeUpdate("INSERT INTO Cart VALUES ("+IDMedia+","+IDUser+","+soluong+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCart(int IDUser, int IDMedia, int soluong) {
		try {
			statement = conn.createStatement();
			statement.executeUpdate("UPDATE Cart SET SoLuong = "+soluong+" WHERE IDUser = "+IDUser+" AND IDMedia = "+IDMedia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getSLKho(int IDMedia) {
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT SoLuong FROM Physical WHERE IDMedia = "+IDMedia);
			
			if (rSet.next()) {
				return rSet.getInt("SoLuong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<ProductPaneInCart> getMediaInCart(int IDUser){
		ArrayList<ProductPaneInCart> list = new ArrayList<ProductPaneInCart>();
		try {
			
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * FROM Cart JOIN Media ON Cart.IDMedia = Media.IDMedia "
					+ " WHERE IDUser = "+IDUser);
			int i=0;
			while(rSet.next()) {

				ProductPaneInCart media = new ProductPaneInCart(rSet.getString("Ten"), rSet.getString("image"), rSet.getInt("IDMedia"), rSet.getInt("GiaCa"), rSet.getInt("SoLuong"), i);
				i++;
				list.add(media);
			}
			
			int idsale = checkSale();
			if(idsale > 0) {
				for(int index=0; index< list.size(); index++) {
					rSet = statement.executeQuery("SELECT sale, GiaCa FROM MediaSale JOIN Media ON MediaSale.IDMEdia = Media.IDMedia"
							+" WHERE Media.IDMedia = "+list.get(index).id);
					if(rSet.next()) {
						list.get(index).priceLabel.setText(rSet.getFloat("GiaCa")*(1-rSet.getFloat("sale"))+"");
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void removeInCart(int IDUser, int IDMedia) {
		try {
			statement = conn.createStatement();
			statement.executeUpdate("DELETE FROM Cart WHERE IDMedia ="+IDMedia+" AND IDUser ="+IDUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int deleteAdd(int IDAddress) {
		try {
			statement = conn.createStatement();
			statement.executeUpdate("DELETE FROM DiaChi WHERE IDAddress ="+IDAddress);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	public void addAdd(Address address) {
		try {
			String diachiString = address.getAddress() + "<>" + address.getDistrict() + "<>" +address.getCity();
			statement = conn.createStatement();
			statement.executeUpdate("INSERT INTO DiaChi VALUES ("+address.getIDUser()+",'"+address.getPhone()
									+"','"+address.getName()+"','"+diachiString+"',0)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Address> getAddresses(int IDUser){
		ArrayList<Address> list = new ArrayList<Address>();
		
			try {
				statement = conn.createStatement();
				rSet = statement.executeQuery("SELECT * FROM DiaChi WHERE IDUser = "+IDUser);
				while(rSet.next()) {
					String diachi = rSet.getString("Diachi");
					String[] city = diachi.split("<>");
					Address address = new Address(rSet.getString("Name"), rSet.getString("Phone"), city[2], city[1], city[0], IDUser);
					address.setID(rSet.getInt("IDAddress"));
					list.add(address);
				}
				
				return list;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

	public List<Media> searchMedia(String search) {
		listMedia = new ArrayList<Media>();
		try {
			rSet = statement.executeQuery("select * "
					+ "from Media join Loai\n"
					+ "ON Media.IDLoai = Loai.IDLoai\n"
					+ "where Ten LIKE '%"+search+"%' AND deleted = 0");
			
			
			while(rSet.next()) {
				media = new Media();
				media.setCategory(rSet.getString("TenLoai"));
				media.setNameString(rSet.getString("Ten"));
				media.setPriceFloat(rSet.getInt("GiaCa"));
				media.setId(rSet.getInt("IDMedia"));
				media.setImage(rSet.getString("image"));
				listMedia.add(media);
			}
			
			return listMedia;
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
// them san pham ben admin
	public int addMedia(String name, String id_loai, String value, 
			String price, String image, String date) {
		
		int loai = Integer.parseInt(id_loai);
		long value_p = Integer.parseInt(value);
		long price_p = Integer.parseInt(price);
		
		try {
			statement.executeUpdate("insert into Media(Ten, IDLoai, GiaTri, GiaCa, image, ngay_nhap)\n"
					+ "VALUES ('"+name+"', "+loai+", "+value_p+", "
					+price_p+", '"+image+"', '"+date+"')");
			
			rSet = statement.executeQuery("SELECT IDMedia FROM Media WHERE Ten = '"+name+"'");
			if (rSet.next()) return rSet.getInt("IDMedia");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		return -1;
	}
	
	public int updateMedia(String name, String value, 
			String price, String image, String date) {
		long value_p = Integer.parseInt(value);
		long price_p = Integer.parseInt(price);
		
		try {
			statement.executeUpdate("UPDATE Media\n"
					+ "SET GiaTri = "+value_p+",\n"
					+ "GiaCa = "+price_p+",\n"
					+ "image = '"+image+"',\n"
					+ "ngay_nhap = '"+date+"'\n"
					+ "WHERE Ten = '"+name+"'");
			
			rSet = statement.executeQuery("SELECT IDMedia FROM Media WHERE Ten = '"+name+"'");
			
			if (rSet.next()) {
				return rSet.getInt("IDMedia");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		return 1;
		
	}
	
	public void update_Media_by_id(int id_media, String name, String value, 
			String price, String image) {
		long value_p = Integer.parseInt(value);
		long price_p = Integer.parseInt(price);
		
		try {
			statement.executeUpdate("UPDATE Media\n"
					+ "SET GiaTri = "+value_p+",\n"
					+ "GiaCa = "+price_p+",\n"
					+ "image = '"+image+"',\n"
					+ "Ten = '"+name+"'\n"
					+ "WHERE IDMedia = "+id_media+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertBook(
			int id_media, int id_bia, 
			String nxb, String date, 
			int page, int id_nn, int id_theloai) {
		
		try {
			rSet = statement.executeQuery("SELECT * FROM Book WHERE IDMedia = "+id_media);
			
			if (rSet.next() == false) {
				statement.executeUpdate("INSERT INTO Book\n"
						+ "VALUES("+id_media+", "+id_bia+", '"+nxb+"',"
						+ "'"+date+"', "+page+", "+id_nn+", "+id_theloai+")");
			} else {
				statement.executeUpdate("UPDATE Book \n"
						+ "SET IDBia="+id_bia+",\n"
						+ "NhaXB = '"+nxb+"', \n"
						+ "NgayXB = '"+date+"',\n"
						+ "SoTrang = "+page+",\n"
						+ "IDNN = "+id_nn+",\n"
						+ "IDTheLoai = "+id_theloai+"\n"
						+ "WHERE IDMedia = "+id_media);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean insertDVD(
			int id_media, int id_dia, 
			float thoiLuong, String studio, 
			String phuDe, int id_nn, int id_theloai) {
		
		try {
			rSet = statement.executeQuery("SELECT * FROM DVD WHERE IDMedia = "+id_media);
			
			if (rSet.next() == false) {
				statement.executeUpdate("INSERT INTO DVD\n"
						+ "VALUES("+id_media+", "+id_theloai+", "+thoiLuong+","
						+ "'"+studio+"', "+id_nn+", '"+phuDe+"', "+id_dia+")");
			} else {
				statement.executeUpdate("UPDATE DVD \n"
						+ "SET IDDia="+id_dia+",\n"
						+ "ThoiLuong = '"+thoiLuong+"', \n"
						+ "Studio = '"+studio+"',\n"
						+ "PhuDe = '"+phuDe+"',\n"
						+ "IDNN = "+id_nn+",\n"
						+ "IDTheLoai = "+id_theloai+"\n"
						+ "WHERE IDMedia = "+id_media);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean add_CD_LP(int id_media, String record, int id_tloai, String type) {
		
		try {
			rSet = statement.executeQuery("SELECT IDMedia FROM Media WHERE IDMedia = "+id_media+"");
			
			if (rSet.next()) {
				id_media = rSet.getInt("IDMedia");
				rSet = statement.executeQuery("SELECT * FROM "+type+" WHERE IDMedia = "+id_media);
				if (rSet.next() == false) {
					statement.executeUpdate("insert into "+type+" \n"
							+ "values ("+id_media+", '"+record+"', "+id_tloai+")");
				} else {
					statement.executeUpdate("UPDATE "+type+"\n"
							+ "SET HangGhiAm ='"+record+"'\n"
							+ "WHERE IDMedia = "+id_media);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public int add_Artists(String tacgia) {
		
		try {
			rSet = statement.executeQuery("SELECT * FROM TacGia WHERE Ten = '"+tacgia+"'");
			
			if (rSet.next() == false) {
				statement.executeUpdate("INSERT INTO TacGia \n"
						+ "VALUES ('"+tacgia+"')");
				
				rSet = statement.executeQuery("SELECT IDTacGia FROM TacGia WHERE Ten = '"+tacgia+"'");
				
				if (rSet.next()) {
					return rSet.getInt("IDTacGia");
				}
			} else return rSet.getInt("IDTacGia");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return -1;
	}
	
	public boolean add_SangTac(int id_media, int id_tg) {
		
		try {
			rSet = statement.executeQuery("SELECT * FROM SangTac WHERE IDMedia = "+id_media);
			if (!rSet.next()) {
				statement.executeUpdate("INSERT INTO SangTac\n"
						+ "VALUES ("+id_tg+", "+id_media+")");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public int[] add_BaiHat(String[] value, int id_tgia) {
		
		int[] id_bh = new int[value.length];
		
		for (int i = 0; i < value.length; i++) {
			try {
				statement.executeUpdate("INSERT INTO BaiHat\n"
						+ "VALUES ('"+value[i]+"', "+id_tgia+")");
				
				rSet = statement.executeQuery("SELECT IDBaiHat FROM BaiHat WHERE Ten = '"+value[i]+"'");
				if (rSet.next()) {
					id_bh[i]= rSet.getInt("IDBaiHat"); 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		return id_bh;
	}
	
	public int[] update_BaiHat(String[] value, int id_tacgia) {
		int[] id_bh = new int[value.length];
		
		for (int i = 0; i < value.length; i++) {
			try {
				rSet = statement.executeQuery("SELECT IDBaiHat FROM BaiHat WHERE Ten = '"+value[i]+"'");
				
				if (rSet.next()) {
					id_bh[i]= rSet.getInt("IDBaiHat"); 
				} else if (!rSet.next()) {
					statement.executeUpdate("INSERT INTO BaiHat\n"
							+ "VALUES ('"+value[i]+"', "+id_tacgia+")");
					
					rSet = statement.executeQuery("SELECT IDBaiHat FROM BaiHat WHERE Ten = '"+value[i]+"'");
					if (rSet.next()) {
						id_bh[i]= rSet.getInt("IDBaiHat"); 
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				return null;
			}
		}
		
		return id_bh;
	}
	
	public boolean add_ListTrack(int[] id, int id_media) {
		
		for (int i = 0; i < id.length; i++) {
			try {
				statement.executeUpdate("INSERT INTO DanhSachBaiHat\n"
						+ "VALUES ("+id_media+", "+id[i]+")");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}
	
	public boolean update_list_track(int[] id, int id_media) {
		
		try {
			statement.executeUpdate("update DanhSachBaiHat\n"
					+ "SET deleted = 1\n"
					+ "WHERE IDMedia = "+id_media);
			
			for (int i = 0; i < id.length; i++) {
				rSet = statement.executeQuery("SELECT * FROM DanhSachBaiHat\n"
						+ "WHERE IDMedia = "+id_media+" AND IDBaiHat = "+id[i]);
				if (rSet.next()) {
					statement.executeUpdate("update DanhSachBaiHat\n"
							+ "SET deleted = 0\n"
							+ "WHERE IDMedia = "+id_media+" AND IDBaiHat = "+id[i]);
				} else {
					statement.executeUpdate("INSERT INTO DanhSachBaiHat (IDMedia, IDBaiHat)\n"
							+ "VALUES ("+id_media+", "+id[i]+")");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public Media getMedia(String name, int id_media) {
		Media media = new Media();
		try {
			if (name != null && id_media == 0) {
				rSet = statement.executeQuery("SELECT * FROM Media \n"
						+ "WHERE Ten = '"+name+"' AND deleted = 0");
			} else if (name == null && id_media != 0) {
				rSet = statement.executeQuery("SELECT * FROM Media \n"
						+ "WHERE IDMedia = "+id_media+" AND deleted = 0");
			}
			
			
			if (rSet.next()) {
				media.setId(rSet.getInt("IDMedia"));
				media.setNameString(rSet.getString("Ten"));
				media.setPriceFloat(rSet.getInt("GiaCa"));
				media.setDate(rSet.getString("ngay_nhap"));
				media.setCategory(""+rSet.getInt("IDLoai"));
				media.setValue((long) rSet.getInt("GiaTri"));
				return media;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String[][] getList_Product_Physical() {
		int i = 0;
		int count = 0;
		format = new DecimalFormat("###,###,###");
		
		try {
			
			rSet = statement.executeQuery("SELECT COUNT(Media.IDMedia) AS count FROM Physical "
					+ "JOIN Media ON Media.IDMedia = Physical.IDMedia "
					+ "WHERE deleted = 0");
			
			if (rSet.next()) {
				count = rSet.getInt("count");
			}
			
			rSet = statement.executeQuery("select Media.IDMedia, Media.Ten, Media.GiaCa, "
					+ "SoLuong, NgayNhapKho, Barcode\n"
					+ "from Media JOIN Physical\n"
					+ "ON Media.IDMedia = Physical.IDMedia\n"
					+ "WHERE deleted = 0");
			
			
			String[][] products = new String[count][6];
			
			while (rSet.next()) {
				products[i][0] = ""+ rSet.getInt("IDMedia");
				products[i][1] = ""+ rSet.getString("Ten");
				products[i][2] = format.format(rSet.getInt("GiaCa"))+" VND";
				products[i][3] = ""+ rSet.getInt("SoLuong");
				products[i][4] = ""+ rSet.getString("NgayNhapKho");
				products[i][5] = ""+ rSet.getString("Barcode");
				i++;
			}
			
			return products;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
		
	}

	public float getKg(int IDUser) {
		float kg = 0;
		try {
			rSet = statement.executeQuery("SELECT MAX(KhoiLuong) AS KhoiLuong FROM Physical "
					+" JOIN Cart ON Cart.IDMedia = Physical.IDMedia "
					+" WHERE Cart.IDUser = "+IDUser);
			rSet.next();
			kg = rSet.getFloat("KhoiLuong");
			return kg;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kg;
	}
	public void saveOrder(OrderObject order, int IDUser, List<ProductPaneInCart> list) {
		try {
			statement.executeUpdate("INSERT INTO DonHang VALUES("+IDUser+","+order.address.getID()+",'Cho','',"+order.total+")");

			rSet = statement.executeQuery("SELECT MAX(IDDonHang) AS IDDonHang FROM DonHang");
			rSet.next();
			int iddh = rSet.getInt("IDDonHang");
			for(int i=0; i<= list.size() -1; i++) {
				statement.executeUpdate("INSERT INTO ThongTinDonHang VALUES ("+iddh+","+list.get(i).id+","
				   +Integer.parseInt(list.get(i).SoLuong.getText())+","+Integer.parseInt(list.get(i).priceLabel.getText())+")");

			}
			
			statement.executeUpdate("DELETE FROM Cart WHERE IDUser = "+IDUser);
			
			statement.executeUpdate("INSERT INTO LichSuThanhToan VALUES ("+iddh+", 'Thanh toan hoa don')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancelOrder(OrderObject orderObject, String lydo) {
		try {
			statement.executeUpdate("UPDATE DonHang SET TrangThai = 'da huy' WHERE IDDonHang = "+orderObject.iddh);
			statement.executeUpdate("INSERT INTO LichSuThanhToan VALUES ("+orderObject.iddh+", 'Huy hang vi : "+lydo+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public float getprice(int iddh) {
		float price = 0;
		try {
			rSet = statement.executeQuery("SELECT SoLuong, Gia FROM ThongTinDonHang WHERE IDDonHang = "+iddh);
			while(rSet.next()) {
				price += rSet.getFloat("Gia")*rSet.getInt("SoLuong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
	
	public OrderObject getOrder(int iddh) {
		try {
			rSet = statement.executeQuery("SELECT * FROM DonHang JOIN DiaChi ON DonHang.IDAddress = DiaChi.IDAddress "
					+" WHERE IDDonHang = "+iddh);
			if(rSet.next()) {
				String[] dc = rSet.getString("DiaChi").split("<>");
				Address address = new Address(rSet.getString("Name"), rSet.getString("Phone"), dc[2], dc[1], dc[0], 0);
				OrderObject orderObject = new OrderObject(address, getprice(iddh), 0);
				orderObject.iddh = iddh;
				return orderObject;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String[][] getListMediaInOrder(int iddh){
		try {
			
			rSet = statement.executeQuery("SELECT COUNT(*) AS count FROM ThongTinDonHang WHERE IDDonHang = "+iddh);
			
			int soluong = 0;
			if(rSet.next()) {
				soluong = rSet.getInt("count");
			}
			System.out.println(soluong);
			
			rSet = statement.executeQuery("SELECT Ten, Gia, SoLuong FROM ThongTinDonHang JOIN Media ON Media.IDMedia = ThongTinDonHang.IDMedia"
					+" WHERE IDDonHang = "+iddh);
			
			String[][] list = new String[soluong][4];
			
			for(int i=0; i<soluong; i++) {
				list[i][0] = rSet.getString("Ten");
				list[i][1] = rSet.getString("Gia");
				list[i][2] = rSet.getString("SoLuong");
				list[i][3] = rSet.getInt("SoLuong")*rSet.getFloat("Gia") + "";
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
