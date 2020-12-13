package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Manager.Application;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Signin extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField name;
	private JTextField phone;
	private JPasswordField password;
	private JTextField address;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Signin(Application application) {
		setBounds(400, 150, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		email = new JTextField();
		email.setBounds(165, 84, 231, 27);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(46, 90, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Password: ");
		lblNewLabel.setBounds(46, 211, 96, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone: ");
		lblNewLabel_1.setBounds(46, 271, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(46, 148, 70, 15);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(165, 142, 231, 27);
		contentPane.add(name);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(165, 265, 231, 27);
		contentPane.add(phone);
		
		password = new JPasswordField();
		password.setBounds(165, 205, 231, 26);
		contentPane.add(password);
		
		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setBounds(46, 326, 70, 15);
		contentPane.add(lblAddress);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(165, 320, 231, 27);
		contentPane.add(address);
		
		JLabel lblSignIn = new JLabel("Sign Up");
		lblSignIn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblSignIn.setBounds(187, 24, 89, 27);
		contentPane.add(lblSignIn);
		
		JButton btnSignIn = new JButton("Sign Up");
		btnSignIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int iD = application.userController.Signup(email.getText(), password.getText(), name.getText(), phone.getText(), address.getText());
				if( iD == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Email or Password havent", "Inane error", JOptionPane.ERROR_MESSAGE);
				} else {
					setVisible(false);
					dispose();
					
					application.setID(iD);
					
					application.switchPanel(application.home);
				}
			}
		});
		btnSignIn.setBounds(213, 397, 89, 25);
		contentPane.add(btnSignIn);
		setVisible(true);
	}
}
