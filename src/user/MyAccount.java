package user;

import javax.swing.JPanel;

import productframe.MenuProduct;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import Manager.Application;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyAccount extends MenuProduct {
	private JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public MyAccount( Application application) {
		super(application);		
		JPanel accountPanel = new JPanel();
		accountPanel.setBackground(Color.LIGHT_GRAY);
		accountPanel.setBounds(100, 70, 220, 530);
		add(accountPanel);
		accountPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Basic Information");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.userController.screenInfo(2);
				application.switchPanel(application.information);
			}
		});
		btnNewButton.setBounds(10, 25, 200, 35);
		accountPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change Password");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.switchPanel(application.changePassword);
			}
		});
		
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 70, 200, 35);
		accountPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Order History");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.switchPanel(application.orderHisrory);
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(10, 112, 200, 35);
		accountPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Address");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(10, 157, 200, 35);
		accountPanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log out");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(10, 202, 200, 35);
		accountPanel.add(btnNewButton_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 70, 100, 530);
		add(panel);

	}
}
