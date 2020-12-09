package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddDVD extends AddProduct {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public AddDVD() {
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 120, 830, 369);
		addProductPanel.add(panel_1);
		
		JLabel lblAddDvd = new JLabel("3. ADD DVD");
		lblAddDvd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddDvd.setBounds(10, 10, 206, 30);
		panel_1.add(lblAddDvd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 50, 810, 275);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Name ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 79, 30);
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("name");
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(99, 10, 324, 30);
		panel_2.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Disk Type");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(446, 10, 93, 30);
		panel_2.add(lblNewLabel_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(676, 219, 124, 30);
		panel_2.add(btnAdd);
		
		JLabel lblNewLabel_2_1 = new JLabel("Director");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 50, 79, 30);
		panel_2.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setText("name");
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(546, 10, 254, 30);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Runtime");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 90, 79, 30);
		panel_2.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setText("name");
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(99, 50, 324, 30);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("The loai");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(445, 130, 93, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setText("pages");
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(99, 170, 324, 30);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Ngay Ph");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_2.setBounds(10, 170, 79, 30);
		panel_2.add(lblNewLabel_2_1_1_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Cance");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(481, 219, 124, 30);
		panel_2.add(btnNewButton_1_1);
		
		textField_5 = new JTextField();
		textField_5.setText("name");
		textField_5.setForeground(Color.LIGHT_GRAY);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(99, 90, 324, 30);
		panel_2.add(textField_5);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Studio");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(446, 50, 93, 30);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setText("name");
		textField_6.setForeground(Color.LIGHT_GRAY);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(546, 50, 254, 30);
		panel_2.add(textField_6);
		
		JLabel lblNewLabel_2_1_1_1_3 = new JLabel("Language");
		lblNewLabel_2_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_3.setBounds(10, 130, 79, 30);
		panel_2.add(lblNewLabel_2_1_1_1_3);
		
		textField_4 = new JTextField();
		textField_4.setText("pages");
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(546, 90, 254, 30);
		panel_2.add(textField_4);
		
		textField_7 = new JTextField();
		textField_7.setText("pages");
		textField_7.setForeground(Color.LIGHT_GRAY);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_7.setColumns(10);
		textField_7.setBounds(99, 130, 324, 30);
		panel_2.add(textField_7);
		
		JLabel lblNewLabel_2_1_1_1_4 = new JLabel("Subtitles");
		lblNewLabel_2_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_4.setBounds(446, 90, 93, 30);
		panel_2.add(lblNewLabel_2_1_1_1_4);
		
		textField_8 = new JTextField();
		textField_8.setText("pages");
		textField_8.setForeground(Color.LIGHT_GRAY);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_8.setColumns(10);
		textField_8.setBounds(546, 130, 254, 30);
		panel_2.add(textField_8);

	}

}
