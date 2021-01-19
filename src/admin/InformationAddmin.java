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
import javax.swing.JPasswordField;

public class InformationAddmin extends AddminHome {

	private String currentPassStr;
	private String newPassStr;
	private String confirmPassStr;
	
	AdminApplication adminApplication;
	private JPasswordField current;
	private JPasswordField new_pass;
	private JPasswordField confirm_pass;

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
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 50, 161, 30);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 90, 161, 30);
		panel_2.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Save Changes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPassStr = current.getText();
				newPassStr = new_pass.getText();
				confirmPassStr = confirm_pass.getText();
				
				System.out.println(adminApplication.getID());
				
				adminApplication.adminController.changePass(
						adminApplication.getID(), 
						currentPassStr, newPassStr, 
						confirmPassStr); // can truyen idUSer
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(51, 51, 204));
		btnNewButton.setBounds(181, 130, 161, 30);
		panel_2.add(btnNewButton);
		
		current = new JPasswordField();
		current.setBounds(183, 13, 430, 30);
		panel_2.add(current);
		
		new_pass = new JPasswordField();
		new_pass.setBounds(183, 53, 430, 30);
		panel_2.add(new_pass);
		
		confirm_pass = new JPasswordField();
		confirm_pass.setBounds(183, 93, 430, 30);
		panel_2.add(confirm_pass);

	}
	public void setNullText() {
		confirm_pass.setText("");
		current.setText("");
		new_pass.setText("");
	}
}
