package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Manager.Application;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Signin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Application application;

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
		
		textField = new JTextField();
		textField.setBounds(165, 84, 231, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 142, 231, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 205, 231, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 265, 231, 27);
		contentPane.add(textField_3);
		
		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblSignIn.setBounds(187, 24, 89, 27);
		contentPane.add(lblSignIn);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(228, 321, 89, 25);
		contentPane.add(btnSignIn);
		setVisible(true);
	}

}
