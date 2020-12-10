package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Manager.AdminApplication;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class AddCD_LP extends AddProduct {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_3;

	AdminApplication adminApplication;

	public AddCD_LP(AdminApplication adminApplication) {
		
		super(adminApplication);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 120, 830, 400);
		addProductPanel.add(panel_1);
		
		JLabel lblAddCd = new JLabel("2. ADD CD/LP");
		lblAddCd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddCd.setBounds(10, 10, 206, 30);
		panel_1.add(lblAddCd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 61, 810, 275);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Name ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 124, 30);
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("name");
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(146, 10, 654, 30);
		panel_2.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Artists");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 50, 110, 30);
		panel_2.add(lblNewLabel_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(676, 219, 124, 30);
		panel_2.add(btnAdd);
		
		JLabel lblNewLabel_2_1 = new JLabel("Record label");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 90, 110, 30);
		panel_2.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setText("name");
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(146, 50, 654, 30);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tracklist");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 130, 110, 30);
		panel_2.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setText("name");
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(146, 90, 654, 30);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Release date ");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(146, 170, 111, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setText("pages");
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(267, 170, 129, 30);
		panel_2.add(textField_4);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("The loai");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_1.setBounds(506, 170, 86, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setText("pages");
		textField_6.setForeground(Color.LIGHT_GRAY);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(602, 170, 165, 30);
		panel_2.add(textField_6);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Other");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_2.setBounds(10, 170, 124, 30);
		panel_2.add(lblNewLabel_2_1_1_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Cance");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(481, 219, 124, 30);
		panel_2.add(btnNewButton_1_1);
		
		textField_3 = new JTextField();
		textField_3.setText("name");
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(146, 130, 654, 30);
		panel_2.add(textField_3);

	}

}
