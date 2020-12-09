package user;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Manager.Application;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Information extends MyAccount {

	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtMail;
	private JTextField txtCard;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Information(Application application) {
		super(application);
		JPanel InformationPanel = new JPanel();
		InformationPanel.setBackground(Color.WHITE);
		InformationPanel.setBounds(320, 70, 780, 530);
		add(InformationPanel);
		InformationPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(35, 75, 620, 332);
		InformationPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 85, 30);
		panel.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setText("Nguyen Phuong");
		txtName.setBounds(115, 10, 450, 30);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 50, 85, 30);
		panel.add(lblNewLabel_2);
		
		txtPhone = new JTextField();
		txtPhone.setEnabled(false);
		txtPhone.setText("0382140588");
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone.setBounds(115, 50, 450, 30);
		panel.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 90, 85, 35);
		panel.add(lblNewLabel_3);
		
		txtMail = new JTextField();
		txtMail.setEnabled(false);
		txtMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMail.setText("nguyenphuong4899@gmail.com");
		txtMail.setBounds(115, 90, 450, 30);
		panel.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 135, 85, 35);
		panel.add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(115, 126, 93, 44);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(228, 126, 93, 44);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Date of birth");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 180, 93, 35);
		panel.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setToolTipText("");
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(115, 180, 90, 30);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2", "1", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(215, 180, 90, 30);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBounds(315, 180, 90, 30);
		panel.add(comboBox_2);
		
		JLabel lblCard = new JLabel("Card");
		lblCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCard.setBounds(10, 10, 85, 30);
		panel.add(lblCard);
		
		txtCard = new JTextField();
		txtCard.setEnabled(true);
		txtCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCard.setText("abcbabcajbsjb");
		txtCard.setBounds(115, 90, 450, 30);
		panel.add(txtCard);
		txtCard.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(115, 287, 124, 35);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("CARD");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(10, 225, 93, 35);
		panel.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setText("111110000011111");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(115, 225, 450, 35);
		panel.add(textField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 670, 530);
		InformationPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Information");
		lblNewLabel.setBounds(25, 25, 615, 30);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));

	}
}
