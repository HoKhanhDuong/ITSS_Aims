package Controller;

import Manager.Application;

public class UserController {
	private Application application;
	public UserController(Application application) {
		// TODO Auto-generated constructor stub
		this.application = application;
	}
	public int Signin(String username, String password) {
		return application.connect.getUserId(username, password);
	}
	public int Signup(String username, String password, String name, String phone) {
		return application.connect.setUser(username, password, name, phone);
	}
}
