package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Manager.AdminApplication;

import javax.swing.JButton;
import java.awt.Color;

public class InformationAddmin extends AddminHome {
	private JTextField currentPass;
	private JTextField newpass;
	private JTextField confirmPass;

	private String currentPassStr;
	private String newPassStr;
	private String confirmPassStr;
	
	AdminApplication adminApplication;

	public InformationAddmin(AdminApplication adminApplication) {
		super(adminApplication);
		this.adminApplication = adminApplication;

		
		JPanel panel = new JPanel();
		panel.setBounds(250, 70, 850, 530);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(30, 30, 622, 30);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(30, 70, 620, 350);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Current Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 161, 30);
		panel_2.add(lblNewLabel_1);
		
		currentPass = new JTextField();
		currentPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		currentPass.setColumns(10);
		currentPass.setBounds(181, 10, 429, 30);
		panel_2.add(currentPass);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 50, 161, 30);
		panel_2.add(lblNewLabel_1_1);
		
		newpass = new JTextField();
		newpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		newpass.setColumns(10);
		newpass.setBounds(181, 50, 429, 30);
		panel_2.add(newpass);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 90, 161, 30);
		panel_2.add(lblNewLabel_1_1_1);
		
		confirmPass = new JTextField();
		confirmPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		confirmPass.setColumns(10);
		confirmPass.setBounds(181, 90, 429, 30);
		panel_2.add(confirmPass);
		
		JButton btnNewButton = new JButton("Save Changes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPassStr = currentPass.getText();
				newPassStr = newpass.getText();
				confirmPassStr = confirmPass.getText();
				
				adminApplication.adminController.changePass(adminApplication.getID(), currentPassStr, newPassStr, confirmPassStr); // can truyen idUSer
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(51, 51, 204));
		btnNewButton.setBounds(181, 130, 161, 30);
		panel_2.add(btnNewButton);

	}
	public void setNullText() {
		confirmPass.setText("");
		currentPass.setText("");
		newpass.setText("");
	}

}
