package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class AddBook extends AddProduct {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public AddBook() {
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 120, 830, 400);
		addProductPanel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("1. ADD BOOK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 206, 30);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 39, 810, 332);
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
		
		JLabel lblNewLabel_2 = new JLabel("Author");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 50, 110, 30);
		panel_2.add(lblNewLabel_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(676, 273, 124, 30);
		panel_2.add(btnAdd);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loai bia");
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Paperback");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(146, 90, 118, 30);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnHardcover = new JRadioButton("Hardcover");
		rdbtnHardcover.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnHardcover.setBackground(Color.WHITE);
		rdbtnHardcover.setBounds(284, 90, 118, 30);
		panel_2.add(rdbtnHardcover);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Publisher");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 130, 110, 30);
		panel_2.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setText("name");
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(146, 126, 654, 30);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Publication Date");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 170, 124, 30);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setText("mm/dd/yy");
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(146, 170, 654, 30);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Pages");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(146, 210, 61, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setText("pages");
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(217, 210, 86, 30);
		panel_2.add(textField_4);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Language");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_1.setBounds(340, 210, 86, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setText("pages");
		textField_5.setForeground(Color.LIGHT_GRAY);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(436, 210, 110, 30);
		panel_2.add(textField_5);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("The Loai");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(576, 210, 75, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setText("pages");
		textField_6.setForeground(Color.LIGHT_GRAY);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(661, 210, 139, 30);
		panel_2.add(textField_6);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Other");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_2.setBounds(10, 210, 124, 30);
		panel_2.add(lblNewLabel_2_1_1_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Cance");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(506, 273, 124, 30);
		panel_2.add(btnNewButton_1_1);

	}

}
