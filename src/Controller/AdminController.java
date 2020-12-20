package Controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Manager.AdminApplication;
import Object.User;

public class AdminController{
	private AdminApplication adminApp;
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
}
