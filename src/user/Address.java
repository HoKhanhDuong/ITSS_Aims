package user;

import javax.swing.JPanel;

import Manager.Application;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

public class Address extends MyAccount {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Address(Application application) {
		super(application);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setLayout(null);
		panel_5.setBounds(336, 139, 665, 366);
		add(panel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Name");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(10, 10, 85, 30);
		panel_5.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(139, 10, 511, 30);
		panel_5.add(textField);
		
		JLabel lblNewLabel_8 = new JLabel("Phone\r\n");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(10, 50, 85, 30);
		panel_5.add(lblNewLabel_8);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(139, 50, 511, 30);
		panel_5.add(textField_1);
		
		JLabel lblNewLabel_9 = new JLabel("City");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(10, 90, 85, 30);
		panel_5.add(lblNewLabel_9);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ha Noi", "Ho Chi Minh", "Da Nang ", "Other"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(139, 90, 511, 30);
		panel_5.add(comboBox);
		
		JLabel lblNewLabel_10 = new JLabel("District");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(10, 130, 100, 30);
		panel_5.add(lblNewLabel_10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 130, 511, 30);
		panel_5.add(textField_2);
		
		JLabel lblNewLabel_11 = new JLabel("Ward");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(10, 170, 85, 30);
		panel_5.add(lblNewLabel_11);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(139, 170, 511, 30);
		panel_5.add(textField_3);
		
		JLabel lblNewLabel_12 = new JLabel("Address");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_12.setBounds(10, 210, 100, 30);
		panel_5.add(lblNewLabel_12);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setBounds(139, 215, 511, 76);
		panel_5.add(textArea);
		
		JButton btnNewButton_4 = new JButton("Cancel");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBackground(SystemColor.controlHighlight);
		btnNewButton_4.setBounds(139, 313, 237, 30);
		panel_5.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Ship to this address");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_5.setBackground(new Color(51, 51, 204));
		btnNewButton_5.setBounds(407, 313, 243, 30);
		panel_5.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("My Address");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(350, 100, 316, 26);
		add(lblNewLabel);

	}

}
