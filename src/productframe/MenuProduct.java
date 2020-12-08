package productframe;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.MediaController;
import Manager.Application;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuProduct extends JPanel {

	/**
	 * Create the panel.
	 */
	private JPanel contentPane;
	private JTextField searchTextField;
	
	private MediaController mediaControl;
	
	public Application application;
	public MenuProduct(Application application ) {
		this.application = application;
		
		setSize(1100, 600);
		setLayout(null);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(0, 0, 80, 70);
		add(logoPanel);
		logoPanel.setLayout(null);
		
		JButton logoButton = new JButton("S2");
		logoButton.setBackground(Color.WHITE);
		logoButton.setFont(new Font("Harrington", Font.BOLD, 40));
		logoButton.setBounds(0, 0, 80, 70);
		logoButton.setBorderPainted(false);
		logoPanel.add(logoButton);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(Color.WHITE);
		searchPanel.setBounds(80, 0, 400, 70);
		add(searchPanel);
		searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		searchTextField = new JTextField();
		searchTextField.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		searchPanel.add(searchTextField);
		searchTextField.setColumns(20);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBackground(Color.WHITE);
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchPanel.add(searchButton);
		
		JPanel homePanel = new JPanel();
		homePanel.setBackground(Color.WHITE);
		homePanel.setBounds(480, 0, 620, 70);
		add(homePanel);
        homePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 20));
		
		JButton homeButton = new JButton("HOME");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.home.setVisible(true);
			}
		});
		homeButton.setForeground(Color.BLACK);
		homeButton.setBackground(Color.WHITE);
		homeButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		homeButton.setBorderPainted(false);
		homePanel.add(homeButton);
		
		JButton shoppingButton = new JButton("SHOPPING");
		shoppingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediaControl = application.mediaControl;
				application.switchPanel(application.product);
			}
		});
		shoppingButton.setForeground(Color.BLACK);
		shoppingButton.setBackground(Color.WHITE);
		shoppingButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		shoppingButton.setBorderPainted(false);
		homePanel.add(shoppingButton);
		
		//int status = 0;
		//if(status == 0) {
		JMenuBar menuBar = new JMenuBar();
		homePanel.add(menuBar);
		
		JMenu account = new JMenu("ACCOUNT");
		account.setHorizontalAlignment(SwingConstants.CENTER);
		account.setBackground(Color.WHITE);
		account.setForeground(Color.BLACK);
		account.setBorderPainted(false);
		account.setFont(new Font("Times New Roman", Font.BOLD, 22));
		menuBar.add(account);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("T\u00E0i kho\u1EA3n c\u1EE7a t\u00F4i");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		account.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				application.switchPanel(application.information);
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Qu\u1EA3n l\u00FD \u0111\u01A1n h\u00E0ng");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		account.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				application.switchPanel(application.orderHisrory);
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u0110\u0103ng Xu\u1EA5t");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		account.add(mntmNewMenuItem_2);
		
		/*}else {

			JButton signInButton = new JButton("SIGN IN");
			signInButton.setForeground(Color.ORANGE);
			signInButton.setBackground(Color.WHITE);
			signInButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
			signInButton.setBorderPainted(false);
			homePanel.add(signInButton);
		}
		*/
		JButton cart = new JButton("CART");
		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.switchPanel(application.cart);
			}
		});
		cart.setBackground(Color.WHITE);
		cart.setForeground(Color.BLACK);
		cart.setFont(new Font("Times New Roman", Font.BOLD, 22));
		homePanel.add(cart);
		
		
	}
}
