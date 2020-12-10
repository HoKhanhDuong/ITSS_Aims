package Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.AddBook;
import admin.AddCD_LP;
import admin.AddDVD;
import admin.AddProduct;
import admin.AddminHome;
import admin.InformationAddmin;
import admin.ProductManagement;
import admin.UserManagement;
import productframe.Cart;
import productframe.DetailProduct;
import productframe.Home;
import productframe.Product;
import user.CancelOrder;
import user.ChangePassword;
import user.Information;
import user.OrderHisrory;
import user.Pay;

public class AdminApplication extends JFrame {

	public AddminHome adminHome;
	public AddBook addBook;
	public AddCD_LP addCD_LP;
	public AddDVD addDVD;
	public AddProduct addProduct;
	public InformationAddmin informationAddmin;
	public ProductManagement productManagement;
	public UserManagement userManagement;

	ArrayList<JPanel> list;
	public AdminApplication() {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 1100, 600);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		adminHome = new AddminHome(this);
		addBook = new AddBook(this);
		addCD_LP = new AddCD_LP(this);
		addDVD = new AddDVD(this);
		addProduct = new AddProduct(this);
		informationAddmin = new InformationAddmin(this);
		productManagement = new ProductManagement(this);
		userManagement = new UserManagement(this);
		
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

}
