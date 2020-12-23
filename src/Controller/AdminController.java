package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import Manager.AdminApplication;
import Object.Media;

public class AdminController{
	
	private AdminApplication adminApp;
	
	private String errors = "";
	
	private int add_media;
	private int id_tgia;
	
	public AdminController(AdminApplication adminApp) {
		this.adminApp=adminApp;
	}
	
	
	public void changePass(int idUser, String currentPass, String newPass, String confirmPass) {
		
		if (currentPass.isEmpty() || newPass.isEmpty() || confirmPass.isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Please enter your information", 
					"Change Password", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (newPass.length() < 8) {
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
		
		boolean change = adminApp.connect.changePassword(idUser, currentPass, newPass);
		
		if (change == false) {
			JOptionPane.showMessageDialog(null, "Current Password doen't exit", 
					"Change Password", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(null, "Changed Password", 
				"Change Password", 
				JOptionPane.INFORMATION_MESSAGE);
	
		adminApp.informationAddmin.setNullText();
		
		adminApp.switchPanel(adminApp.informationAddmin);
	}
	
	public boolean checkValidate(String[] validation) {
		
		String number = "\\d+?";
		
		for (int i = 0; i < validation.length; i++) {
			if (validation[i].isEmpty()) {
				errors += "Phải nhập và chọn đủ thông tin sản phẩm\n";
				return false;
			}
		}
		
		if ((!validation[1].matches(number) || !validation[2].matches(number))) {
			errors += "Giá trị phải nhập số\n";
			return false;
		}
		
		return true;
	}
	
	public boolean createMedia(String[] value) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
		Date currentDate = Calendar.getInstance().getTime();
		String dateString = simple.format(currentDate);
		
		Media media = adminApp.connect.getMedia(value[0]);
		
		if (media == null) {
			add_media = adminApp.connect.addMedia(value[0], value[3], value[1], 
					value[2], value[4], dateString);
		} else if(media != null && !media.getCategory().equals(value[3])) {
			add_media = adminApp.connect.addMedia(value[0], value[3], value[1], 
					value[2], value[4], dateString);
		} else {
			add_media = adminApp.connect.updateMedia(value[0], value[1], value[2], value[4], dateString);
		}
		
		if (add_media == -1) return false;
		
		return true;
	}
	
	public boolean createCD_LP(String[] value) {
		
		String type = ""; 
		
		int id_tloai = Integer.parseInt(value[8]);
		
		if (value[3].equals("2")) type = "CD";
		else if (value[3].equals("4")) {
			type = "LD";
		}
		
		boolean add_CD_LP = adminApp.connect.add_CD_LP(value[0], value[6], id_tloai, type);
		
		return add_CD_LP;
	}

	public boolean create_artists_sangtac(String[] value) {
		
		id_tgia = adminApp.connect.add_Artists(value[5]);
		
		return adminApp.connect.add_SangTac(add_media, id_tgia);
	}
	
	public boolean create_listTrack(String value) {
		
		String[] listTrack = value.trim().split("\\,\\s+");
		System.out.println(listTrack);
		
		int id[] = adminApp.connect.add_BaiHat(listTrack, id_tgia);
		
		return adminApp.connect.add_ListTrack(id, add_media);
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
	
	
}
