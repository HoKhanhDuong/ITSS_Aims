package Manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Connect.Connect;
import productframe.Cart;
import productframe.DetailProduct;
import productframe.Home;
import productframe.MenuProduct;
import productframe.Product;
import user.CancelOrder;
import user.ChangePassword;
import user.Information;
import user.MyAccount;
import user.OrderHisrory;
import user.Pay;

public class Application extends JFrame {
	public Home home;
	public Cart cart;
	public DetailProduct detailProduct;
	public Product product;
	public CancelOrder cancelOrder;
	public ChangePassword changePassword;
	public Information information;
	public Pay pay;
	public OrderHisrory orderHisrory;
	public Connect connect;
	ArrayList<JPanel> list;
	public Application() throws SQLException {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 1100, 600);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		home = new Home(this);
		cart = new Cart(this);
		detailProduct = new DetailProduct(this);
		product = new Product(this);
		cancelOrder = new CancelOrder(this);
		changePassword = new ChangePassword(this);
		information = new Information(this);
		pay = new Pay();
		orderHisrory = new OrderHisrory(this);
		//connect = new Connect();
		//add(home);
		list = new ArrayList<JPanel>();
		list.add(home);
		list.add(cart);
		list.add(product);
		list.add(detailProduct);
		list.add(cancelOrder);
		list.add(changePassword);
		list.add(pay);
		list.add(information);
		list.add(orderHisrory);
		Iterator<JPanel> iterator = list.iterator();
		while(iterator.hasNext()) {
			add(iterator.next());
		}
		switchPanel(home);
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
