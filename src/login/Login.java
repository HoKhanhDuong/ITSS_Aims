package login;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Manager.Application;
import Manager.AdminApplication;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPasswordField;

public class Login extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private Application application;
	private JPasswordField txtPassword;
	
	public AdminApplication adminApplication;
	/**
	 * 
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Login(Application application) {

		setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.addKeyListener(this);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int iD = application.userController.Signin(txtUsername.getText(), txtPassword.getText());
				if(iD == -1){
					JOptionPane.showMessageDialog(new JFrame(), "Username or Password incorrected", "Inane error", JOptionPane.ERROR_MESSAGE);
					return;
				}else if (iD == -3) {
					String errors = application.userController.getErrors();
					
					JOptionPane.showMessageDialog(new JPanel(), errors, "Error Login", JOptionPane.ERROR_MESSAGE);
					application.userController.setErrors("");
					return;
				} else {
					if(iD > 0) {
						application.setID(iD);
						setVisible(false);
						dispose();
						application.switchPanel(application.home);
					}else if(iD == -2) {
						application.setAdmin(
								application.connect.getAdminID(txtUsername.getText().trim(), txtPassword.getText().trim())
						);
						dispose();
					}
					
				}
			}
		});
		btnLogin.setBounds(189, 207, 86, 25);
		contentPane.add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(189, 87, 187, 30);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Email:");
		lblUsername.setBounds(74, 86, 86, 30);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(74, 144, 86, 30);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(189, 146, 187, 30);
		contentPane.add(txtPassword);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblLogin.setBounds(189, 31, 96, 35);
		contentPane.add(lblLogin);
		
		JButton btnSignIn = new JButton("Sign up");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				Signin sigup = new Signin(application);
			}
		});
		btnSignIn.setBounds(290, 207, 86, 25);
		contentPane.add(btnSignIn);
		
		setVisible(true);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
	}

}
