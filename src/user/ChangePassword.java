package user;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import Manager.Application;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends MyAccount {
	private JTextField txtCurrentPass;
	private JTextField txtNewPass;
	private JTextField txtConfirmPass;

	private String currentPass;
	private String newPass;
	private String confirmPass;
	
	/**
	 * Create the panel.
	 */

	public ChangePassword(Application application) {

		super(application);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(320, 70, 780, 530);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 670, 530);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(25, 25, 622, 30);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(25, 65, 620, 350);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Current Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 161, 30);
		panel_2.add(lblNewLabel_1);
		
		txtCurrentPass = new JTextField();
		txtCurrentPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCurrentPass.setBounds(181, 10, 429, 30);
		panel_2.add(txtCurrentPass);
		txtCurrentPass.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 50, 161, 30);
		panel_2.add(lblNewLabel_1_1);
		
		txtNewPass = new JTextField();
		txtNewPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNewPass.setColumns(10);
		txtNewPass.setBounds(181, 50, 429, 30);
		panel_2.add(txtNewPass);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(10, 90, 161, 30);
		panel_2.add(lblNewLabel_1_1_1);
		
		txtConfirmPass = new JTextField();
		txtConfirmPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtConfirmPass.setColumns(10);
		txtConfirmPass.setBounds(181, 90, 429, 30);
		panel_2.add(txtConfirmPass);
		
		JButton btnNewButton = new JButton("Save Changes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPass = txtCurrentPass.getText();
				newPass = txtNewPass.getText();
				confirmPass = txtConfirmPass.getText();
				
				application.userController.changePassword(1, currentPass, newPass, confirmPass); // can truyen idUSer
			}
		});
		btnNewButton.setBackground(new Color(51, 51, 204));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(181, 130, 161, 30);
		panel_2.add(btnNewButton);

	}
	
	
	public void setNullText() {
		txtConfirmPass.setText("");
		txtCurrentPass.setText("");
		txtNewPass.setText("");
	}
	
}
