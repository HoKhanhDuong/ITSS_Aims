package user;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

//import javax.swing.SwingConstants;

import Manager.Application;
import Object.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Information extends MyAccount {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField txtName;
	protected JTextField txtPhone;
	protected JTextField txtEmail;
	protected JTextField txtCard;
	private JTextField txtAddress;

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
		txtName.setBounds(115, 10, 450, 30);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 50, 85, 30);
		panel.add(lblNewLabel_2);
		
		txtPhone = new JTextField();
		txtPhone.setEnabled(false);
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone.setBounds(115, 50, 450, 30);
		panel.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 90, 85, 35);
		panel.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setBounds(115, 90, 450, 30);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblCard = new JLabel("Card");
		lblCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCard.setBounds(10, 137, 93, 35);
		panel.add(lblCard);
		
		txtCard = new JTextField();
		txtCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCard.setColumns(10);
		txtCard.setBounds(115, 137, 450, 35);
		panel.add(txtCard);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(10, 184, 93, 35);
		panel.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(115, 184, 450, 35);
		panel.add(txtAddress);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 670, 530);
		InformationPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Information");
		lblNewLabel.setBounds(25, 25, 615, 30);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.userController.changeInformation(application.getID(),txtAddress.getText(), txtCard.getText());
				application.userController.screenInfo(application.getID());
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(201, 250, 124, 35);
		panel.add(btnUpdate);

	}
	
	public void setInformation(User user) {
		txtCard.setText(user.getCard_number());
		txtEmail.setText(user.getEmail());
		txtName.setText(user.getName());
		txtPhone.setText(user.getPhone());
		txtAddress.setText(user.getAddress());
	}
}
