package Manager;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Connect.AdminConnect;

import Connect.Connect;
import Controller.AdminController;
import Controller.SaleController;
import admin.AddBook;
import admin.AddCD_LP;
import admin.AddDVD;
import admin.AddProduct;
import admin.AddPromitions;
import admin.AddminHome;
import admin.InformationAddmin;
import admin.PhysicalProductManagement;
import admin.ProductManagement;
import admin.Promotions;
import admin.UserManagement;

public class AdminApplication extends JFrame {
	
	private int ID;
	private boolean them;
	private boolean sua;
	private int prod_up_de;
	
	public AddminHome adminHome;
	public AddBook addBook;
	public AddCD_LP addCD_LP;
	public AddDVD addDVD;
	public AddProduct addProduct;
	public InformationAddmin informationAddmin;
	public AdminController adminController;
	public ProductManagement productManagement;
	public UserManagement userManagement;
	public AddPromitions addPromitions;
	public Promotions promotions;
	
	public SaleController saleController;
	
	public PhysicalProductManagement physicalManagement;
	public Connect connect;
	public AdminConnect adminConnect;

	ArrayList<JPanel> list;
	public AdminApplication() throws SQLException {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 1100, 600);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		this.them = true;
		this.sua = true;
		
		connect = new Connect();
		
		adminController = new AdminController(this);
		
		adminHome = new AddminHome(this);
		addBook = new AddBook(this);
		addCD_LP = new AddCD_LP(this);
		addDVD = new AddDVD(this);
		addProduct = new AddProduct(this);
		informationAddmin = new InformationAddmin(this);
		productManagement = new ProductManagement(this);
		userManagement = new UserManagement(this);
		addPromitions = new AddPromitions(this);
		promotions = new Promotions(this);
		
		saleController = new SaleController(this);
		
		try {
			adminConnect = new AdminConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		physicalManagement = new PhysicalProductManagement(this);
		
		//add(home);
		list = new ArrayList<JPanel>();
		list.add(adminHome);
		list.add(addBook);
		list.add(addCD_LP);
		list.add(addDVD);
		list.add(addProduct);
		list.add(informationAddmin);
		list.add(productManagement);
		list.add(userManagement);
		list.add(physicalManagement);
		list.add(addPromitions);
		list.add(promotions);

		Iterator<JPanel> iterator = list.iterator();
		while(iterator.hasNext()) {
			add(iterator.next());
		}
		switchPanel(informationAddmin);
		setVisible(true);
	}
	public void switchPanel(JPanel jPanel) {
		Iterator<JPanel> iterator = list.iterator();
		while(iterator.hasNext()) {
			iterator.next().setVisible(false);
		}
		list.get(list.indexOf(jPanel)).setVisible(true);
	}
	
	public boolean isThem() {
		return them;
	}
	public void setThem(boolean them) {
		this.them = them;
	}
	public boolean isSua() {
		return sua;
	}
	public void setSua(boolean sua) {
		this.sua = sua;
	}
	public int getProd_up_de() {
		return prod_up_de;
	}
	public void setProd_up_de(int prod_up_de) {
		this.prod_up_de = prod_up_de;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		if (iD == -1) {
			ID = this.adminController.getID();
		} else {
			ID = iD;
		}
	}
	
	public void setUser() {
		Application application;
		try {
			application = new Application();
			application.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.dispose();
		
	}
	
}
