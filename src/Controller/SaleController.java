package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Manager.AdminApplication;
import Object.Media;
import admin.SaleMedia;

public class SaleController {

	private AdminApplication adminApplication;
	public SaleController(AdminApplication adminApplication) {
		// TODO Auto-generated constructor stub
		this.adminApplication = adminApplication;
	}
	
	public ArrayList<Media> getListMedia(int category){
		
		return adminApplication.adminConnect.getListMedia(category);
		
	}
	
	public void saveSale(String name, LocalDate starttime, LocalDate endtime, ArrayList<SaleMedia> list) {
		if(starttime.compareTo(endtime) >= 0) {
			JOptionPane.showMessageDialog(new JFrame(), "Thoi gian bat dau phai truoc thoi gian ket thuc"
					,"",JOptionPane.ERROR_MESSAGE);
		}else {
			LocalDate myObj = LocalDate.now();
						
			if(starttime.compareTo(myObj) < 0) {
				JOptionPane.showMessageDialog(new JFrame(), "Thoi gian bat dau phai sau thoi gian hien tai"
						,"",JOptionPane.ERROR_MESSAGE);
			}else {
				adminApplication.adminConnect.saveSale(name, starttime.toString(), endtime.toString(), list);
			}
		}
       
	}

}
