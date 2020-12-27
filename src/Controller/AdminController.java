package Controller;

import java.util.ArrayList;

import Manager.AdminApplication;
import Manager.Application;
import Object.User;

public class AdminController {
	private AdminApplication adminApplication;
	public AdminController(AdminApplication adminApplication) {
		this.adminApplication = adminApplication;
	}
	public ArrayList<User> getUsers() {
		adminApplication.switchPanel(adminApplication.userManagement);
		adminApplication.userManagement.setUsers(adminApplication.adminConnect.getfullUsers());
		//return adminApplication.adminConnect.getfullUsers();
		return null;
	}
	
	public void changeStatusUser(String iDUser, int status) {
		adminApplication.adminConnect.changeStatusUser(iDUser, status);
	}

}
