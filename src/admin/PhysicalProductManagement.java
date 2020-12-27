package admin;

import javax.swing.JPanel;

import Manager.AdminApplication;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;

public class PhysicalProductManagement extends AddProduct {

	AdminApplication adminApplication;
	public PhysicalProductManagement(AdminApplication adminApplication) {
		super(adminApplication);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 121, 830, 399);
		addProductPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 10, 810, 379);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Barcode");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 21, 124, 30);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(158, 21, 207, 30);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(445, 21, 124, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(583, 21, 217, 30);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Description");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 72, 124, 30);
		panel_1.add(lblNewLabel_1_2);
		
		JTextArea txtrInformation = new JTextArea();
		txtrInformation.setBackground(SystemColor.control);
		txtrInformation.setForeground(SystemColor.desktop);
		txtrInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtrInformation.setLineWrap(true);
		txtrInformation.setText("information");
		txtrInformation.setTabSize(4);
		txtrInformation.setRows(2);
		txtrInformation.setBounds(160, 72, 640, 99);
		panel_1.add(txtrInformation);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Goods receipt date");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(10, 195, 157, 30);
		panel_1.add(lblNewLabel_1_2_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(159, 192, 252, 30);
		panel_1.add(panel_2_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Product dimensions");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(10, 242, 157, 30);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setBounds(159, 239, 252, 30);
		panel_1.add(panel_2_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Cance");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(494, 315, 124, 30);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(664, 315, 124, 30);
		panel_1.add(btnAdd);
	}
}
