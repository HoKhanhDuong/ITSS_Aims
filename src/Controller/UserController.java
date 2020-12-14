package Controller;

import javax.swing.JOptionPane;

import Manager.Application;
import Object.User;

public class UserController {

	public Application application;
	
	private User user;
	
	public UserController(Application application) {
		this.application = application;
	}
  
	public int Signin(String username, String password) {
		return application.connect.getUserId(username, password);
	}
	public int Signup(String username, String password, String name, String phone, String address) {
		return application.connect.setUser(username, password, name, phone, address);
	}
	
	public void changePassword(int idUser, String currentPass, String newPass, String confirmPass) {
		
		if (newPass.length() < 8) {
			JOptionPane.showMessageDialog(null, "Length new password > 8", 
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
		
		boolean change = application.connect.changePassword(idUser, currentPass, newPass);
		
		if (change == false) {
			JOptionPane.showMessageDialog(null, "Current Password doen't exit", 
					"Change Password", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(null, "Changed Password", 
				"Change Password", 
				JOptionPane.INFORMATION_MESSAGE);
	
		application.changePassword.setNullText();
		
		application.switchPanel(application.information);
		
	}
	
	public void screenInfo (int idUser) {
		user = application.connect.InformationUser(idUser); // can truyen userID
		
		if(user == null) {
			JOptionPane.showMessageDialog(null, "User doesn't exit", 
					"Information User", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		application.information.setInformation(user);
		application.switchPanel(application.information);
	}
	
	public void changeInformation(int idUser,String address, String cardNumber) {
		if (cardNumber.trim().length() < 16) {
			JOptionPane.showMessageDialog(null, "Card Number < 16 character", 
					"Information User", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		application.connect.changeInformation(idUser, address, cardNumber);
		
		JOptionPane.showMessageDialog(null, "Changed Information", 
				"Information User", 
				JOptionPane.INFORMATION_MESSAGE);
	}

}
