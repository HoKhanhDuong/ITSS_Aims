package Controller;

import javax.swing.JOptionPane;

import Manager.Application;
import Object.User;

public class UserController {

	public Application application;
	
	private User user;
	
	private String errors = "";;
	
	public UserController(Application application) {
		this.application = application;
	}
  
	public int Signin(String username, String password) {
		return application.connect.getUserId(username, password);
	}
	public int Signup(String username, String password, String name, String phone, String address, String confirmPass) {
		
		String _phone = "0+\\d{9}";
		String _email = "[a-zA-Z0-9]+\\@gmail\\.com";
		String _password = "[a-zA-Z0-9]{8,}";
		
		if (username.isEmpty()) {
			errors += "Email not null \n";
		} else if (!username.matches(_email)) {
			errors += "Email co dang abc@gmail.com \n";
		}
		if (password.isEmpty()) {
			errors += "Password not null \n";
		}else if (!password.matches(_password)) {
			errors += "Password phai nhieu hon 8 ky tu";
		}
		if (name.isEmpty()) {
			errors += "Name not null \n";
		}
		if (phone.isEmpty()) {
			errors += "Phone not null \n";
		} else if (!phone.matches(_phone)) {
			errors += "Phone co dang 0xxxxxxxxx \n";
		}
		if(address.isEmpty()) {
			errors += "Address not null \n";
		}
		if (confirmPass.isEmpty()) {
			errors += "Confirm password not null \n";
		}
		
		if (!password.isEmpty() && !confirmPass.isEmpty()) {
			if(!password.equals(confirmPass)) {
				errors += "Password va Confirm khong trung";
			}
		}
		
		if (!errors.isEmpty()) {
			return -2;
		}
		
		return application.connect.setUser(username, password, name, phone, address);
	}
	
	public void changePassword(int idUser, String currentPass, String newPass, String confirmPass) {
		
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
	
	public int changeInformation(int idUser,String address, String cardNumber) {
		
		String _card = "[1-9]{1}[0-9]{15}";
		
		String cart = cardNumber.replaceAll("\\s+", "");
		
		if (address.isEmpty()) {
			errors += "Address not null \n";
		}
		if (cardNumber.isEmpty()) {
			errors += "Card Number not null\n";
		} else if (cart.trim().length() < 16) {
			errors += "Card Number > 16 character \n";
		} else if(!cart.trim().matches(_card)) {
			errors += "Card number khong khop\n";
		}
		
		if (!errors.isEmpty()) {
			return 0;
		}
		
		application.connect.changeInformation(idUser, address, cardNumber);
		
		return 1;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}
	
	

}
