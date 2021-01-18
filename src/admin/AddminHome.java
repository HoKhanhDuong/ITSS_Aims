package admin;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Manager.AdminApplication;
import Manager.Application;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddminHome extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public JPanel panel_3;

	private AdminApplication adminApplication;

	public AddminHome(AdminApplication adminApplication) {
		this.adminApplication = adminApplication;
		
		setSize(1100,600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1100, 70);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("S2");
		lblNewLabel.setBounds(0, 0, 201, 70);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(198, 0, 477, 70);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 25));
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		panel_1.add(textField);
		textField.setColumns(20);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		flowLayout.setVgap(25);
		flowLayout.setHgap(20);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(674, 0, 426, 70);
		panel.add(panel_2);
		
		JButton addminHome = new JButton("HOME");
		addminHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.setID(-1);
				adminApplication.switchPanel(adminApplication.informationAddmin);
			}
		});
		addminHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(addminHome);
		
		JButton myShop = new JButton("MY SHOP");
	
		myShop.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(myShop);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		panel_2.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("ACCOUNT");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem logout = new JMenuItem("Đăng xuất");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.setID(0);
				adminApplication.setUser();
			}
		});
		logout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mnNewMenu.add(logout);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 70, 250, 530);
		add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("ADMIN");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.setID(-1);
				adminApplication.switchPanel(adminApplication.informationAddmin);
			}
		});
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(10, 10, 230, 30);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("USER MANAGEMENT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.setID(-1);
				adminApplication.adminController.getUsers();
			}
		});
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBounds(10, 50, 230, 30);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("PRODUCT MANAGEMENT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.setID(-1);
				adminApplication.productManagement.setItems(
						adminApplication.connect.getList_Product_Physical()
				);
				adminApplication.productManagement.getIdmediatxt().setText("");
				adminApplication.productManagement.setTable();
				adminApplication.switchPanel(adminApplication.productManagement);
			}
		});
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_5.setBounds(10, 90, 230, 30);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("PROMOTIONS");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.adminController.getSale();
				adminApplication.switchPanel(adminApplication.promotions);
			}
		});
		btnNewButton_5_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_5_1.setBounds(10, 130, 230, 30);
		panel_3.add(btnNewButton_5_1);

	}
	 
}
