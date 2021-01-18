package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Manager.Application;
import Object.Address;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class Signin extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField name;
	private JTextField phone;
	private JPasswordField password;
	private JPasswordField confirm_password;
	private JTextField address;
	private JTextField district;
	
	String cityString = "Ha Noi";
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
		email.setToolTipText("abc@gmail.com");
		email.setBounds(165, 84, 231, 27);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(46, 90, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Password: ");
		lblNewLabel.setBounds(46, 156, 96, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone: ");
		lblNewLabel_1.setBounds(46, 219, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(46, 123, 70, 15);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(165, 117, 231, 27);
		contentPane.add(name);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(165, 213, 231, 27);
		contentPane.add(phone);
		
		password = new JPasswordField();
		password.setBounds(165, 150, 231, 26);
		contentPane.add(password);
		
		JLabel lblSignIn = new JLabel("Sign Up");
		lblSignIn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblSignIn.setBounds(187, 24, 89, 27);
		contentPane.add(lblSignIn);
		
		JButton btnSignIn = new JButton("Sign Up");
		btnSignIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				Address add = new Address(name.getText(), phone.getText(), cityString, district.getText(), address.getText(), 0);
				
				int iD = application.userController.Signup(email.getText(), password.getText(), add, confirm_password.getText());
				if( iD == -1) {
					JOptionPane.showMessageDialog(new JFrame(), "Email or Password havent", "Inane error", JOptionPane.ERROR_MESSAGE);
				} else if (iD == -2) {
					String errors = application.userController.getErrors();
					
					JOptionPane.showMessageDialog(new JPanel(), errors, "Error Signup", JOptionPane.ERROR_MESSAGE);
					application.userController.setErrors("");
				} 
				else {
					setVisible(false);
					dispose();
					
					application.setID(iD);
					
					application.switchPanel(application.home);
				}
			}
		});
		btnSignIn.setBounds(187, 363, 89, 25);
		contentPane.add(btnSignIn);
		
		JLabel lblConfirmPassword = new JLabel("Confirm: ");
		lblConfirmPassword.setBounds(46, 187, 96, 15);
		contentPane.add(lblConfirmPassword);
		
		confirm_password = new JPasswordField();
		confirm_password.setBounds(165, 181, 231, 26);
		contentPane.add(confirm_password);
		
		JLabel lblNewLabel_2 = new JLabel("City:");
		lblNewLabel_2.setBounds(46, 255, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("District:");
		lblNewLabel_3.setBounds(46, 295, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setBounds(46, 334, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		address = new JTextField();
		address.setToolTipText("Dia chi chi tiet");
		address.setBounds(165, 331, 231, 20);
		contentPane.add(address);
		address.setColumns(10);
		
		district = new JTextField();
		district.setToolTipText("Quan/Huyen");
		district.setBounds(165, 292, 231, 20);
		contentPane.add(district);
		district.setColumns(10);
		
		JComboBox city = new JComboBox();
		city.setBounds(165, 251, 231, 22);
		city.setModel(new DefaultComboBoxModel(new String[] {"Ha Noi", "Ho Chi Minh", "Other city"}));
		city.addActionListener (new ActionListener () {
		       public void actionPerformed(ActionEvent e) {
		    	   cityString = city.getSelectedItem().toString();
		    	   if(cityString == "Other city") {
		    		   cityString = (String)JOptionPane.showInputDialog(new JFrame(), "Enter your city :", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, "");
		    	   }
		       }
      });
		contentPane.add(city);
		setVisible(true);
	}
}
