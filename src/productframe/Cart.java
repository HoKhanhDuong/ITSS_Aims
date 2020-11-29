package productframe;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Cart extends MenuProduct {

	/**
	 * Create the panel.
	 */
	public Cart() {
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(0, 70, 1100, 530);
		add(panel);
		panel.setLayout(null);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(100, 0, 900, 530);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 10, 900, 40);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CART");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 5, 73, 30);
		panel_2.add(lblNewLabel);
		
		int cart = 1;
		
		if(cart == 0) {
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 60, 880, 375);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("(0 product)");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(81, 10, 145, 22);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_1 = new JLabel("img");
		lblNewLabel_1.setIcon(new ImageIcon("img\\cart.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(311, 27, 229, 144);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Your shopping cart is empty!");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(229, 181, 396, 27);
		panel_3.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Continue shopping");
		btnNewButton.setBackground(new Color(255, 153, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(321, 218, 219, 36);
		panel_3.add(btnNewButton);
		
	    }else
	    {
		
		JLabel lblNewLabel_1 = new JLabel("(1 product)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(81, 10, 145, 22);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 60, 565, 220);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 10, 545, 200);
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("img");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(20, 28, 107, 133);
		panel_7.add(lblNewLabel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(137, 43, 203, 107);
		panel_7.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Name Product");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(0, 10, 150, 19);
		panel_8.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Author :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(0, 39, 55, 19);
		panel_8.add(lblNewLabel_9);
		
		JButton btnNewButton_2 = new JButton("Name Author");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_2.setForeground(new Color(0, 102, 204));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(35, 39, 168, 21);
		btnNewButton_2.setBorderPainted(false);
		panel_8.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setForeground(new Color(255, 0, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(-13, 68, 88, 19);
		panel_8.add(btnNewButton_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBox.setBounds(480, 52, 55, 26);
		panel_7.add(comboBox);
		
		JLabel lblNewLabel_11 = new JLabel("111.000 d");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(350, 52, 120, 30);
		panel_7.add(lblNewLabel_11);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_4.setBounds(575, 49, 325, 481);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 10, 305, 113);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Delivery address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 10, 122, 25);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nguyen Thi Thu Phuong");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 42, 285, 25);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Thanh Xuyen, Hoang Long, Phu Xuyen, Ha Noi");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 77, 285, 25);
		panel_5.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(210, 10, 85, 21);
		btnNewButton.setBorderPainted(false);
		panel_5.add(btnNewButton);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 133, 305, 91);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 10, 285, 25);
		panel_6.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" 111.000 d");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(10, 45, 285, 35);
		panel_6.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("ORDER");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(10, 234, 305, 35);
		panel_4.add(btnNewButton_1);
		
	    }
		

	}
}
