package productframe;


import java.util.ArrayList;

import javax.swing.JFrame;

import user.Information;
import user.MyAccount;
import user.OrderHisrory;



public class main {
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 1100, 600);
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		/*
		Home home = new Home();
		mainFrame.add(home);
		mainFrame.setVisible(true);
		
		
		Product product = new Product();
		mainFrame.add(product);
		mainFrame.setVisible(true);
		
		
		DetailProduct detailProduct = new DetailProduct();
		mainFrame.add(detailProduct);
		mainFrame.setVisible(true);
		
		
		
		MyAccount myAccount = new MyAccount();
		mainFrame.add(myAccount);
		mainFrame.setVisible(true);
		
		
		Information information = new Information();
		mainFrame.add(information);
		mainFrame.setVisible(true);
		*/
		
		OrderHisrory order = new OrderHisrory();
		mainFrame.add(order);
		mainFrame.setVisible(true);
		
		
	}

}
