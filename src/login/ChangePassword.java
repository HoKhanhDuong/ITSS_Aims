package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("Current Password: ");
		lblPassword.setBounds(34, 48, 154, 15);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("New password: ");
		lblNewLabel.setBounds(34, 118, 132, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm new password: ");
		lblNewLabel_1.setBounds(34, 183, 171, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(123, 75, 237, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 140, 237, 31);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 210, 237, 31);
		contentPane.add(textField_2);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblChangePassword.setBounds(108, 0, 201, 31);
		contentPane.add(lblChangePassword);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.setBounds(109, 255, 162, 25);
		contentPane.add(btnChangePassword);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(296, 255, 81, 25);
		contentPane.add(btnCancel);
	}

}
