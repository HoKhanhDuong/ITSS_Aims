package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class User extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 5, 430, 0);
		contentPane.add(label);
		
		JLabel lblXemThngTin = new JLabel("Xem thông tin cá nhân");
		lblXemThngTin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblXemThngTin.setBounds(127, 5, 197, 28);
		contentPane.add(lblXemThngTin);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(45, 45, 112, 22);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(45, 89, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setBounds(45, 129, 70, 15);
		contentPane.add(lblPhone);
		
		JButton btnChangePassword = new JButton("Thay đổi thông tin");
		btnChangePassword.setBounds(61, 176, 177, 25);
		contentPane.add(btnChangePassword);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(264, 176, 117, 25);
		contentPane.add(btnCancel);
	}

}
