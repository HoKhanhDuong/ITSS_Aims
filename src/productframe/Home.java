package productframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Manager.Application;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class Home extends MenuProduct {
	Application application;
	public Home(Application application) {
		super(application);
		this.application = application;		
		
		setForeground(new Color(102, 204, 255));
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setBackground(Color.WHITE);
		imgPanel.setBounds(420, 140, 680, 380);
		add(imgPanel);
		imgPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon("img/home.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 680, 380);
		imgPanel.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(56, 140, 361, 380);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 40, 340, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SHOPPING");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Lucida Fax", Font.BOLD, 44));
		lblNewLabel_2.setBackground(new Color(0, 0, 204));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(0, 0, 340, 50);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 120, 361, 87);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("We are here to serve you!!!");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setForeground(SystemColor.textInactiveText);
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(0, 27, 361, 36);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Best Service, Right Time, Right People!\r\n\r\n");
		lblNewLabel_3.setForeground(SystemColor.textInactiveText);
		lblNewLabel_3.setFont(new Font("Monospaced", Font.PLAIN, 15));
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setBounds(0, 0, 361, 36);
		panel_2.add(lblNewLabel_3);
		
		JButton btnBuyNow = new JButton("BUY NOW ");
		btnBuyNow.setBackground(Color.WHITE);
		btnBuyNow.setForeground(Color.ORANGE);
		btnBuyNow.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnBuyNow.setBounds(198, 209, 124, 29);
		panel.add(btnBuyNow);
		
		
	}
}
