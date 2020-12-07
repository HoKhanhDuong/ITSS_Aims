package productframe;


import java.util.ArrayList;



import javax.swing.JFrame;

import admin.AddProduct;
import admin.InformationAddmin;
import admin.ProductManagement;
import admin.UserManagement;
import user.CancelOrder;
import user.ChangePassword;
import user.Information;
import user.MyAccount;
import user.OrderHisrory;
import user.Pay;



public class main {
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 1100, 600);
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		/*
		Home home = new Home();
		mainFrame.add(home);
		mainFrame.setVisible(true);
		
		DetailProduct detailProduct = new DetailProduct();
		mainFrame.add(detailProduct);
		mainFrame.setVisible(true);
		
		
		Pay pay = new Pay();
        mainFrame.add(pay);
        mainFrame.setVisible(true);
		
		
		
		OrderHisrory order = new OrderHisrory();
		mainFrame.add(order);
		mainFrame.setVisible(true);
		
		Cart cart = new Cart();
		mainFrame.add(cart);
		mainFrame.setVisible(true);
		*/
//		ChangePassword changePassword = new ChangePassword();
//		mainFrame.add(changePassword);
//		mainFrame.setVisible(true);
		
//		MyAccount myAccount = new MyAccount();
//		mainFrame.add(myAccount);
//		mainFrame.setVisible(true);
//		
	
//		InformationAddmin informationAddmin = new InformationAddmin();
//		mainFrame.add(informationAddmin);
//		mainFrame.setVisible(true);

//		Information information = new Information();
//		mainFrame.add(information);
//		mainFrame.setVisible(true);
		

//		UserManagement userManagement = new UserManagement();
//		mainFrame.add(userManagement);
//		mainFrame.setVisible(true);

//		DetailProduct detailProduct = new DetailProduct();
//		mainFrame.add(detailProduct);
//		mainFrame.setVisible(true);
		
		Pay pay = new Pay();
		mainFrame.add(pay);
		mainFrame.setVisible(true);
        

		
//		ProductManagement productManagement = new ProductManagement();
//		mainFrame.add(productManagement);
//		mainFrame.setVisible(true);
		
        Product product = new Product();
        mainFrame.add(product);
        mainFrame.setVisible(true);
	}


}
