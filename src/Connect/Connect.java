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
	     String password = "123456";
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
			case 4:{
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='LP'");
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
			case -4: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='LP' ORDER BY GiaCa ASC");
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
			case 4: {
				rSet = statement.executeQuery("SELECT Ten, GiaCa, TenLoai, IDMedia "
						+ "FROM Media join Loai ON Media.IDLoai=Loai.IDLoai "
						+ "WHERE Loai.TenLoai='LP' ORDER BY GiaCa DESC");
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
				media.setId(rSet.getInt("IDMedia"));
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
					+ "FROM Media join Book ON Media.IDMedia = Book.IDMedia "
					+ "WHERE Book.IDMedia = "+ id);
			if (rSet.next()) {
				book.setNameString(rSet.getString("Ten"));
				book.setNgayXBString(rSet.getString("NgayXB"));
				book.setNhaXBString(rSet.getString("NhaXB"));
				book.setSotrang(rSet.getInt("SoTrang"));
				book.setPriceFloat(rSet.getInt("GiaCa"));
				book.setImageString(rSet.getString("image"));
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
					+ "FROM Media join CD ON Media.IDMedia = CD.IDMedia"
					+ " WHERE CD.IDMedia ="+ id);
			
			if (rSet.next()) {
				cd.setNameString(rSet.getString("Ten"));
				cd.setPriceFloat(rSet.getInt("GiaCa"));
				cd.setImageString(rSet.getString("image"));
				cd.setHangGhiAmString(rSet.getString("HangGhiAm"));
			}
			
			rSet = statement.executeQuery("SELECT TheLoai.Ten "
					+ "FROM CD join TheLoai ON TheLoai.IDTheLoai = CD.IDTheLoai WHERE CD.IDMedia = " + id);
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
			cd.setTenNgheSyString(tacgiaString);
			
			rSet = statement.executeQuery("Select BaiHat.Ten FROM CD join DanhSachBaiHat\n"
					+ "ON DanhSachBaiHat.IDMedia = CD.IDMedia\n"
					+ "join BaiHat\n"
					+ "ON BaiHat.IDBaiHat = DanhSachBaiHat.IDBaiHat\n"
					+ "WHERE CD.IDMedia = "+id);
			
			String baihatString = "";
			while(rSet.next()) {
				baihatString = baihatString + rSet.getString("Ten") + ", ";
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
					+ "FROM Media join LD ON Media.IDMedia = LD.IDMedia "
					+ "WHERE LD.IDMedia = "+ id);
			
			if (rSet.next()) {
				cd.setNameString(rSet.getString("Ten"));
				cd.setPriceFloat(rSet.getInt("GiaCa"));
				cd.setImageString(rSet.getString("image"));
				cd.setHangGhiAmString(rSet.getString("HangGhiAm"));
			}
			
			rSet = statement.executeQuery("SELECT TheLoai.Ten "
					+ "FROM LD join TheLoai ON TheLoai.IDTheLoai=LD.IDTheLoai WHERE LD.IDMedia = " + id);
			if (rSet.next()) {
				cd.setTheLoaiString(rSet.getString("TheLoai.Ten"));
			}
			
			
			rSet = statement.executeQuery("Select TacGia.Ten \n"
					+ "FROM LD join SangTac ON SangTac.IDMedia = LD.IDMedia\n"
					+ "JOIN TacGia ON SangTac.IDTacGia = TacGia.IDTacGia\n"
					+ "WHERE LD.IDMedia ="+id);
			String tacgiaString = "";
			while(rSet.next()) {
				tacgiaString = tacgiaString + rSet.getString("TacGia.Ten") + ", ";
			}
			cd.setTenNgheSyString(tacgiaString);
			
			rSet = statement.executeQuery("Select BaiHat.Ten \n"
					+ "FROM LD join DanhSachBaiHat \n"
					+ "ON DanhSachBaiHat.IDMedia = LD.IDMedia\n"
					+ "JOIN BaiHat ON BaiHat.IDBaiHat = DanhSachBaiHat.IDBaiHat\n"
					+ "WHERE LD.IDMedia ="+id);
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
					+ "FROM Media join DVD ON Media.IDMedia=DVD.IDMedia "
					+ "WHERE DVD.IDMedia = "+ id);
			if (rSet.next()) {
				dvd.setNameString(rSet.getString("Ten"));
				dvd.setPriceFloat(rSet.getInt("GiaCa"));
				dvd.setImageString(rSet.getString("image"));
				dvd.setThoiLuong(rSet.getFloat("ThoiLuong"));
				dvd.setPhudeString(rSet.getString("PhuDe"));
				dvd.setStudioString(rSet.getString("Studio"));
			}
			
			rSet = statement.executeQuery("SELECT NgonNgu.Ten AS 'name_NN', TheLoai.Ten AS 'name_TL' \n"
					+ "FROM DVD join TheLoai ON TheLoai.IDTheLoai=LD.IDTheLoai \n"
					+ "JOIN NgonNgu ON DVD.IDNN = NgonNgu.IDNN\n"
					+ "WHERE LD.IDMedia =" + id);
			
			if (rSet.next()) {
				dvd.setTheLoaiString(rSet.getString("name_NN"));
				dvd.setNgonNguString(rSet.getString("name_TL"));
			}
			
			rSet = statement.executeQuery("Select TacGia.Ten \n"
					+ "FROM DVD join SangTac ON SangTac.IDMedia = DVD.IDMedia\n"
					+ "JOIN TacGia ON SangTac.IDTacGia = TacGia.IDTacGia\n"
					+ "WHERE DVD.IDMedia ="+id);
			if (rSet.next()) {
				dvd.setDaoDienString(rSet.getString("Ten"));
			}
			
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
	
	public int setUser(String username, String password, String name, String phone, String address) {
		try {
			int id = 0;
			
			statement = conn.createStatement();
			rSet = statement.executeQuery("SELECT * FROM Users Where Email = '"+username+"' AND Pass = '"+password +"'");
			if(!rSet.next()) {
				statement.execute("INSERT INTO Users(Email, Pass, isAdmin) VALUES ('"+username+"','"+password+"',0)");
				
				id = getUserId(username, password);
				
				statement.execute("insert into DiaChi (IDUser, Phone, Name, DiaChi) "
						+ "VALUES ("+id+",'"+phone+"',"+"N'"+name+"',N'"+address+"')");
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
}
