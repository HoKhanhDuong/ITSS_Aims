package Controller;


import java.util.ArrayList;

import Manager.AdminApplication;
import Object.User;
import admin.MediaPanel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

import Object.Book;
import Object.CD;
import Object.DVD;
import Object.LD;
import Object.Media;




public class AdminController{
	
	private String errors = "";
	
	private int id_media;
	private int id_tgia;
	
	public Media media;
	
	private AdminApplication adminApplication;

	public ArrayList<User> getUsers() {
		adminApplication.switchPanel(adminApplication.userManagement);
		adminApplication.userManagement.setUsers(adminApplication.adminConnect.getfullUsers());
		return null;
	}
	
	public int getID() {
		return adminApplication.adminConnect.getID();
	}
	
	public void changeStatusUser(String iDUser, int status) {
		adminApplication.adminConnect.changeStatusUser(iDUser, status);
		adminApplication.userManagement.getUser_idtxt().setText("");
		adminApplication.userManagement.setUsers(adminApplication.adminConnect.getfullUsers());
	}

	
	public AdminController(AdminApplication adminApp) {
		this.adminApplication = adminApp;
		media = new Media();
	}
	
	
	public void changePass(int idUser, String currentPass, String newPass, String confirmPass) {
		
		if (currentPass.isEmpty() || newPass.isEmpty() || confirmPass.isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Please enter your information", 
					"Change Password", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (newPass.trim().length() < 8) {
			JOptionPane.showMessageDialog(null, "Length new password > 8 character", 
					"Change Password", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (!newPass.equals(confirmPass)) {
			JOptionPane.showMessageDialog(null, "New password and different password confirmation.", 
					"Change Password", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		boolean change = adminApplication.connect.changePassword(idUser, currentPass, newPass);
		
		if (change == false) {
			JOptionPane.showMessageDialog(null, "Current Password doen't exit", 
					"Change Password", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(null, "Changed Password", 
				"Change Password", 
				JOptionPane.INFORMATION_MESSAGE);
	
		adminApplication.informationAddmin.setNullText();
		
		adminApplication.switchPanel(adminApplication.informationAddmin);
	}
	
	public boolean checkValidate(String[] validation) {
		
		String number = "\\d+?";
		
		for (int i = 0; i < validation.length; i++) {
			if (validation[i].isEmpty() || validation[i] == null) {

				errors += "Ph蘯｣i nh蘯ｭp vﾃ� ch盻肱 ﾄ黛ｻｧ thﾃｴng tin s蘯｣n ph蘯ｩm\n";

				return false;
			}
		}
		
		if ((!validation[1].matches(number) || !validation[2].matches(number))) {

			errors += "Giﾃ｡ tr盻� ph蘯｣i nh蘯ｭp s盻曾n";

			return false;
		}
		
		return true;
	}
	
	public boolean createMedia(String[] value) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date currentDate = Calendar.getInstance().getTime();
		String dateString = simple.format(currentDate);
		
		media = adminApplication.connect.getMedia(value[0], 0);
		
		if (media == null) {
			id_media = adminApplication.connect.addMedia(value[0], value[3], value[1], 
					value[2], value[4], dateString);
		} else if(media != null && !media.getCategory().equals(value[3])) {
			id_media = adminApplication.connect.addMedia(value[0], value[3], value[1], 
					value[2], value[4], dateString);
		} else if (media != null && media.getCategory().equals(value[3])) {
			id_media = adminApplication.connect.updateMedia(value[0], value[1], value[2], value[4], dateString);
		}
		
		if (id_media == -1) return false;
		
		media = adminApplication.connect.getMedia(value[0], 0);
		return true;
	}
	
	public boolean create_Book(String[] value) {
		
		int id_language = Integer.parseInt(value[9]);
		int id_theloai = Integer.parseInt(value[10]);
		int id_dia = Integer.parseInt(value[5]);
		int page = Integer.parseInt(value[8]);
		
		boolean add_Book = adminApplication.connect.insertBook(
				id_media, id_dia, value[6], 
				value[7], page, 
				id_language, id_theloai
				);
		
		return add_Book;
	}
	
	public boolean create_DVD(String[] value) {
		
		int id_language = Integer.parseInt(value[8]);
		int id_theloai = Integer.parseInt(value[9]);
		int id_dia = Integer.parseInt(value[5]);
		float thoiLuong = Float.parseFloat(value[6]);
		
		boolean add_DVD = adminApplication.connect.insertDVD(id_media, id_dia, thoiLuong, value[7], value[10], id_language, id_theloai);
		
		return add_DVD;
	}
	
	public boolean createCD_LP(String[] value) {
		
		String type = ""; 
		
		int id_tloai = Integer.parseInt(value[8]);
		
		if (value[3].equals("2")) type = "CD";
		else if (value[3].equals("4")) {
			type = "LD";
		}
		System.out.println(id_media);
		boolean add_CD_LP = adminApplication.connect.add_CD_LP(id_media, value[6], id_tloai, type);
		
		return add_CD_LP;
	}

	public boolean create_artists_sangtac(String value) {
		
		id_media = media.getId();
		
		id_tgia = adminApplication.connect.add_Artists(value);
		
		return adminApplication.connect.add_SangTac(id_media, id_tgia);
	}
	
	public boolean create_listTrack(String value) {
		
		id_media = media.getId();
		
		String[] listTrack = value.trim().split("\\,\\s+");
		
		int id[] = adminApplication.connect.add_BaiHat(listTrack, id_tgia);
		
		return adminApplication.connect.add_ListTrack(id, id_media);
	}

	public String getErrors() {
		return errors;
	}


	public void setErrors(String errors) {
		this.errors = errors;
	}
	
	
	public boolean checkTime(String time) {
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		try {
			java.util.Date date_1 = simple.parse(time);
			
			long check = (date.getTime() - date_1.getTime())/(60*60*1000);
			
			if (check > 2) {
				return false;
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	public boolean add_Physical(String[] value, boolean status) {
		
		String format_date = "\\d{4}-\\d{2}-\\d{2}";
		String format_bcode = "\\d{10,12}";
		String format_qtyti = "\\d+";
		String format_size = "\\d+\\*\\d+\\*\\d+";
		String format_mass = "\\d+\\.{0,1}\\d*";
		
		if (!value[0].trim().matches(format_bcode)) {
			errors += "Barcode co tu 10-12 ky tu so\n"; 
		}
		if (!value[1].trim().matches(format_qtyti)) {
			errors += "Quantity phai la so\n";
		} 
		if (!value[3].trim().matches(format_date)) {
			errors += "Ngay thang nhap phai co dang: yyyy-mm-dd\n";
		}
		if (!value[4].trim().matches(format_size)) {
			errors += "Kích thước có dạng: dai*rong*cao\n";
		}
		if (!value[5].trim().matches(format_mass)) {
			errors += "Khoi luong phai dinh dang: 123 hoac 12.3\n";
		}
		
		if (!errors.isEmpty()) {
			JOptionPane.showMessageDialog(null, errors, "Physical information", JOptionPane.ERROR_MESSAGE);
			errors = "";
			return false;
		}
		
		if (status == true) {
			adminApplication.adminConnect.insert_Physical(id_media, value);
			adminApplication.physicalManagement.clear_display();
		} else {
			id_media = Integer.parseInt(value[6]);
			adminApplication.adminConnect.update_Physical(id_media, value);
			adminApplication.physicalManagement.clear_display();
		}
		
		return true;
		
	}
	
	public void addHistory(int media,int id_admin, int id_action) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = Calendar.getInstance().getTime();
		String date = simple.format(currentDate);
		
		if (media == -1) {
			System.out.println(id_media);
			adminApplication.adminConnect.insert_History(id_media, id_admin, id_action, date);
		} else {
			int id_loai = adminApplication.adminConnect.id_loai(media);
			
			if (id_loai == -1) {
				JOptionPane.showMessageDialog(null, "San pham khong ton tai", "Remove Product", JOptionPane.ERROR_MESSAGE);
				return;
			}
			adminApplication.adminConnect.insert_History(media, id_admin, id_action, date);
			if (id_action == 3) {
				adminApplication.adminConnect.update_status_media(media);
			}
		}
	}
	
	public HashMap<String, Integer> getLanguage()
	{
		HashMap<String, Integer> languages = new HashMap<String, Integer>();
		languages = adminApplication.adminConnect.getLanguages();
		return languages;
	}
	
	public HashMap<String, Integer> getCategorys(int id_loai) {
		HashMap<String, Integer> categorys = new HashMap<String, Integer>();
		categorys = adminApplication.adminConnect.getTheLoais(id_loai);
		return categorys;
	}
	
	public void display_media_for_category(int id_loai) {
		switch (id_loai) {
		case 1:
			adminApplication.addBook.setDisplay(getLanguage(), getCategorys(id_loai));
			break;
		case 2:
			adminApplication.addDVD.display(getLanguage(), getCategorys(id_loai));
			break;
		case 3:
		case 4:
			adminApplication.addCD_LP.display(getCategorys(id_loai));
			break;
		}
	}
	
	public void display_edit_media(int id_media) {
		if (adminApplication.adminConnect.count_rm_edit(1) <= 30) {
			
			if (adminApplication.adminConnect.check_edit(id_media) <= 2.0) {
				int id_loai = adminApplication.adminConnect.id_loai(id_media);
				
				if (media != null) {
					media = null;
				}
			
				switch (id_loai) {
				case 1:
					// book
					Book book = new Book();
					book = adminApplication.connect.getBook(id_media);
					adminApplication.addBook.setDisplay_Edit(book);
					adminApplication.switchPanel(adminApplication.addBook);
					break;
				case 2:
					// dvd
					DVD dvd = new DVD();
					dvd = adminApplication.connect.getDvd(id_media);
					adminApplication.addDVD.display_edit(dvd);
					adminApplication.switchPanel(adminApplication.addDVD);
					break;
				case 3:
					// cd
					CD cd = new CD();
					cd = adminApplication.connect.getCd(id_media);
					adminApplication.addCD_LP.display_edit_cd(cd);
					adminApplication.switchPanel(adminApplication.addCD_LP);
					break;
				case 4:
					// lp
					LD lp = new LD();
					lp = adminApplication.connect.getlD(id_media);
					adminApplication.addCD_LP.display_edit_lp(lp);
					adminApplication.switchPanel(adminApplication.addCD_LP);
					break;
				default:
					break;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Da qua 2 gio so voi khi them", 
						"Edit Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Da cap nhat tren 30 san pham", 
					"Edit Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
	}
	
	public void update_cd(String[] values, int media_id) {
		boolean check = true;
		int theloai = Integer.parseInt(values[8].trim());
		String[] value = new String[7];
		
		adminApplication.connect.update_Media_by_id(media_id, values[0], values[1], values[2], values[4]);
		check = adminApplication.connect.add_CD_LP(media_id, values[6], theloai, "CD");
		
		id_tgia = adminApplication.connect.add_Artists(values[5]);
		check = adminApplication.connect.add_SangTac(media_id, id_tgia);
		
		String[] listTrack = values[7].trim().split("\\,\\s+");

		int id[] = adminApplication.connect.update_BaiHat(listTrack, id_tgia);
		
		check = adminApplication.connect.update_list_track(id, media_id);

		if (check == false) {
			JOptionPane.showMessageDialog(null, "Khong cap nhat duoc", "Edit Message", JOptionPane.ERROR_MESSAGE);
			return;
		}

		value = adminApplication.adminConnect.get_Physiscal(media_id);
		
		if (value == null) {
			JOptionPane.showMessageDialog(null, "San pham chua phai la san pham vat ly\n"
					+ "Hay them vao kho san pham vat ly", 
					"Edit Product", 
					JOptionPane.WARNING_MESSAGE);
			id_media = media_id;
			adminApplication.switchPanel(adminApplication.physicalManagement);
			return;
		}
		
		adminApplication.physicalManagement.display_edit(value);
		adminApplication.addCD_LP.clear_display();
		adminApplication.switchPanel(adminApplication.physicalManagement);
	}
	
	public void update_lp(String[] values, int media_id) {
		boolean check = true;
		int theloai = Integer.parseInt(values[8].trim());
		String value[] = new String[7];
		adminApplication.connect.update_Media_by_id(media_id, values[0], values[1], values[2], values[4]);
		check = adminApplication.connect.add_CD_LP(media_id, values[6], theloai, "LD");
		
		id_tgia = adminApplication.connect.add_Artists(values[5]);
		check = adminApplication.connect.add_SangTac(media_id, id_tgia);
		
		String[] listTrack = values[7].trim().split("\\,\\s+");

		int id[] = adminApplication.connect.update_BaiHat(listTrack, id_tgia);
		
		check = adminApplication.connect.update_list_track(id, media_id);

		if (check == false) {
			JOptionPane.showMessageDialog(null, "Khong cap nhat duoc", "Edit Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		value = adminApplication.adminConnect.get_Physiscal(media_id);
		
		if (value == null) {
			JOptionPane.showMessageDialog(null, "San pham chua phai la san pham vat ly\n"
					+ "Hay them vao kho san pham vat ly", 
					"Edit Product", 
					JOptionPane.WARNING_MESSAGE);
			id_media = media_id;
			adminApplication.switchPanel(adminApplication.physicalManagement);
			return;
		}
		
		adminApplication.physicalManagement.display_edit(value);
		adminApplication.addCD_LP.clear_display();
		adminApplication.switchPanel(adminApplication.physicalManagement);
	}
	
	public void update_book(String[] values, int media_id) {
		
		boolean check = true;
		String value[] = new String[7];
		int id_language = Integer.parseInt(values[9]);
		int id_theloai = Integer.parseInt(values[10]);
		int id_bia = Integer.parseInt(values[5]);
		int page = Integer.parseInt(values[8]);
		
		adminApplication.connect.update_Media_by_id(media_id, values[0], values[1], values[2], values[4]);
		
		check = adminApplication.connect.insertBook(
				media_id, 
				id_bia, 
				values[6], 
				values[7], page, 
				id_language, id_theloai);
		
		id_tgia = adminApplication.connect.add_Artists(values[11]);
		check = adminApplication.connect.add_SangTac(media_id, id_tgia);
		
		if (check == false) {
			JOptionPane.showMessageDialog(null, "Khong cap nhat duoc", "Edit Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		value = adminApplication.adminConnect.get_Physiscal(media_id);
		
		if (value == null) {
			JOptionPane.showMessageDialog(null, "San pham chua phai la san pham vat ly\n"
					+ "Hay them vao kho san pham vat ly", 
					"Edit Product", 
					JOptionPane.WARNING_MESSAGE);
			id_media = media_id;
			adminApplication.switchPanel(adminApplication.physicalManagement);
			return;
		}
		
		adminApplication.physicalManagement.display_edit(value);
		adminApplication.addBook.clear_display();
		adminApplication.switchPanel(adminApplication.physicalManagement);
	}
	
	public void update_dvd(String[] values, int media_id) {
		boolean check = true;
		String value[] = new String[6];
		int id_language = Integer.parseInt(values[8]);
		int id_theloai = Integer.parseInt(values[9]);
		int id_dia = Integer.parseInt(values[5]);
		float thoiLuong = Float.parseFloat(values[6]);
		
		adminApplication.connect.update_Media_by_id(media_id, values[0], values[1], values[2], values[4]);
		
		check = adminApplication.connect.insertDVD(media_id, 
				id_dia, thoiLuong,
				values[7], values[10], 
				id_language, id_theloai);
		id_tgia = adminApplication.connect.add_Artists(values[11]);
		check = adminApplication.connect.add_SangTac(media_id, id_tgia);
		
		if (check == false) {
			JOptionPane.showMessageDialog(null, "Khong cap nhat duoc", "Edit Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		value = adminApplication.adminConnect.get_Physiscal(media_id);
		
		if (value == null) {
			JOptionPane.showMessageDialog(null, "San pham chua phai la san pham vat ly\n"
					+ "Hay them vao kho san pham vat ly", 
					"Edit Product", 
					JOptionPane.WARNING_MESSAGE);
			id_media = media_id;
			adminApplication.switchPanel(adminApplication.physicalManagement);
			return;
		}
		
		adminApplication.physicalManagement.display_edit(value);
		adminApplication.addDVD.clear_display();
		adminApplication.switchPanel(adminApplication.physicalManagement);
	}
	
	public void getSale() {
		adminApplication.promotions.setComBo(adminApplication.adminConnect.getListSale());
	}
	
	public void getSaleMedia(String sale) {
		String[] timeStrings = adminApplication.adminConnect.getSaleTime(sale);
		adminApplication.promotions.setSale(adminApplication.adminConnect.getListMediaSale(sale),timeStrings[0], timeStrings[1]);
	}
	
}
