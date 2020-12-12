package Manager;

import java.sql.SQLException;

import javax.swing.JFrame;

import productframe.Home;

public class Main extends JFrame {

	public Main() {
		// TODO Auto-generated constructor stub
	}
    public static void main(String[] args) throws SQLException {
		  int a = 1;
		  if(a == 1) {
		    Application application = new Application();
		  }else {
		    AdminApplication adminApplication = new AdminApplication();
		}
	}
}
