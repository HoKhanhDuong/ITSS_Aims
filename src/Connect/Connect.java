package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Object.Book;
import Object.CD;
import Object.DVD;
import Object.LD;
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
			default:
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai");
				break;
			}
			
			while(rSet.next()) {
				media = new Media(rSet.getString("Ten"), rSet.getInt("GiaCa"), rSet.getString("TenLoai"), rSet.getInt("IDMedia"));
				listMedia.add(media);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMedia;
	}
	
	public Book getBook(int id) {
		Book book = new Book();
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * "
					+ "FROM Media join Book ON Media.IDMedia=Book.IDMedia ");
			book.setNameString(rSet.getString("Ten"));
			book.setNgayXBString(rSet.getString("NgayXB"));
			book.setNhaXBString(rSet.getString("NhaXB"));
			book.setSotrang(rSet.getInt("SoTrang"));
			book.setPriceFloat(rSet.getInt("GiaCa"));
			book.setImageString(rSet.getString("image"));
			
			rSet = statement.executeQuery("SELECT LoaiBia, NgonNgu.Ten, TheLoai.Ten "
					+ "FROM Book join TheLoai, NgonNgu, Bia  ON TheLoai.IDTheLoai=Book.IDTheLoai "
					+ "AND NgonNgu.IDNN = Book.IDNN AND Bia.IDBia = Book.IDBia WHERE Book.IDMedia = " + id);
			book.setBiaString(rSet.getString("LoaiBia"));
			book.setNgonNguString(rSet.getString("NgonNgu.Ten"));
			book.setTheloaiString(rSet.getString("TheLoai.Ten"));
			
			rSet = statement.executeQuery("Select TacGia.Ten "
					+ "FROM Book join TacGia, SangTac ON SangTac.IDMedia = Book.IDMedia"
					+ "AND SangTac.IDTacGia = TacGia.IDTacGia"
					+ "WHERE Book.IDMedia =  "+id);
			String tacgiaString = "";
			while(rSet.next()) {
				tacgiaString = tacgiaString + rSet.getString("TacGia.Ten") + ", ";
			}
			book.setTacGiaString(tacgiaString);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	public CD getCd(int id) {
		CD cd = new CD();
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * "
					+ "FROM Media join CD ON Media.IDMedia=CD.IDMedia ");
			cd.setNameString(rSet.getString("Ten"));
			cd.setPriceFloat(rSet.getInt("GiaCa"));
			cd.setImageString(rSet.getString("image"));
			cd.setHangGhiAmString(rSet.getString("HangGhiAm"));
			
			rSet = statement.executeQuery("SELECT  TheLoai.Ten "
					+ "FROM CD join TheLoai ON TheLoai.IDTheLoai=CD.IDTheLoai WHERE CD.IDMedia = " + id);
			cd.setTheLoaiString(rSet.getString("TheLoai.Ten"));
			
			rSet = statement.executeQuery("Select TacGia.Ten "
					+ "FROM CD join TacGia, SangTac ON SangTac.IDMedia = CD.IDMedia"
					+ "AND SangTac.IDTacGia = TacGia.IDTacGia"
					+ "WHERE CD.IDMedia =  "+id);
			String tacgiaString = "";
			while(rSet.next()) {
				tacgiaString = tacgiaString + rSet.getString("TacGia.Ten") + ", ";
			}
			cd.setTenNgheSyString(tacgiaString);
			
			rSet = statement.executeQuery("Select BaiHat.Ten "
					+ "FROM CD join BaiHat, DanhSachBaiHat ON DanhSachBaiHat.IDMedia = CD.IDMedia"
					+ "AND BaiHat.IDBaiHat = DanhSachBaiHat.IDBaiHat"
					+ "WHERE CD.IDMedia =  "+id);
			String baihatString = "";
			while(rSet.next()) {
				baihatString = baihatString + rSet.getString("BaiHat.Ten") + ", ";
			}
			cd.setBaihatString(baihatString);
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
					+ "FROM Media join LD ON Media.IDMedia=LD.IDMedia ");
			cd.setNameString(rSet.getString("Ten"));
			cd.setPriceFloat(rSet.getInt("GiaCa"));
			cd.setImageString(rSet.getString("image"));
			cd.setHangGhiAmString(rSet.getString("HangGhiAm"));
			rSet = statement.executeQuery("SELECT  TheLoai.Ten "
					+ "FROM LD join TheLoai ON TheLoai.IDTheLoai=LD.IDTheLoai WHERE LD.IDMedia = " + id);
			cd.setTheLoaiString(rSet.getString("TheLoai.Ten"));
			
			rSet = statement.executeQuery("Select TacGia.Ten "
					+ "FROM LD join TacGia, SangTac ON SangTac.IDMedia = LD.IDMedia"
					+ "AND SangTac.IDTacGia = TacGia.IDTacGia"
					+ "WHERE LD.IDMedia =  "+id);
			String tacgiaString = "";
			while(rSet.next()) {
				tacgiaString = tacgiaString + rSet.getString("TacGia.Ten") + ", ";
			}
			cd.setTenNgheSyString(tacgiaString);
			
			rSet = statement.executeQuery("Select BaiHat.Ten "
					+ "FROM LD join BaiHat, DanhSachBaiHat ON DanhSachBaiHat.IDMedia = LD.IDMedia"
					+ "AND BaiHat.IDBaiHat = DanhSachBaiHat.IDBaiHat"
					+ "WHERE LD.IDMedia =  "+id);
			String baihatString = "";
			while(rSet.next()) {
				baihatString = baihatString + rSet.getString("BaiHat.Ten") + ", ";
			}
			cd.setBaihatString(baihatString);
			
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
					+ "FROM Media join DVD ON Media.IDMedia=DVD.IDMedia ");
			dvd.setNameString(rSet.getString("Ten"));
			dvd.setPriceFloat(rSet.getInt("GiaCa"));
			dvd.setImageString(rSet.getString("image"));
			dvd.setThoiLuong(rSet.getFloat("ThoiLuong"));
			dvd.setPhudeString(rSet.getString("PhuDe"));
			dvd.setStudioString(rSet.getString("Studio"));
			
			rSet = statement.executeQuery("SELECT NgonNgu.Ten, TheLoai.Ten "
					+ "FROM DVD join TheLoai, NgonNgu ON TheLoai.IDTheLoai=LD.IDTheLoai AND DVD.IDNN = NgonNgu.IDNN"
					+ "WHERE LD.IDMedia = " + id);
			dvd.setTheLoaiString(rSet.getString("TheLoai.Ten"));
			dvd.setNgonNguString(rSet.getString("NgonNgu.Ten"));
			
			rSet = statement.executeQuery("Select TacGia.Ten "
					+ "FROM DVD join TacGia, SangTac ON SangTac.IDMedia = DVD.IDMedia"
					+ "AND SangTac.IDTacGia = TacGia.IDTacGia"
					+ "WHERE DVD.IDMedia =  "+id);
			dvd.setDaoDienString(rSet.getString("TacGia.Ten"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dvd;
	}
	
	public int getUserId(String username, String password) {
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * FROM Users Where Email = '"+username+"' AND Pass = '"+password +"'");
			if(rSet.next()) return rSet.getInt("IDUser");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int setUser(String username, String password, String name, String phone) {
		try {
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * FROM Users Where Email = '"+username+"' AND Pass = '"+password +"'");
			if(!rSet.next()) {
				statement.executeUpdate("INSERT INTO Users VALUES ('"+username+"','"+password+"',0)");
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
}
