package user;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;

public class CancelOrder extends MyAccount {

	/**
	 * Create the panel.
	 */
	public CancelOrder() {
		
		JPanel panel = new JPanel();
		panel.setBounds(320, 70, 780, 530);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 680, 530);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order detail #431256");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 660, 30);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 50, 660, 166);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 310, 149);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("RECEIVER'S ADDRESS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 290, 25);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 39, 310, 100);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nguyen Thi Thu Phuong");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 10, 290, 20);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address : Thanh Xuyen, Hoang Long, Phu Xuyen, Ha Noi");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 40, 290, 20);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Phone : 0382140588");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_1.setBounds(10, 64, 290, 20);
		panel_5.add(lblNewLabel_3_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(330, 10, 320, 149);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("RECEIVER'S ADDRESS");
		lblNewLabel_1_1.setBounds(10, 10, 300, 20);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_1_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setLayout(null);
		panel_5_1.setBounds(0, 40, 320, 99);
		panel_4.add(panel_5_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Free Ship");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2.setBounds(10, 10, 300, 20);
		panel_5_1.add(lblNewLabel_3_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 226, 660, 294);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 10, 640, 50);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Product");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 10, 227, 30);
		panel_7.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(247, 10, 79, 30);
		panel_7.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Quantity");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(336, 10, 74, 30);
		panel_7.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Discount");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(420, 10, 85, 30);
		panel_7.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Into money");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(515, 10, 115, 30);
		panel_7.add(lblNewLabel_8);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 70, 640, 50);
		panel_6.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("Cho toi xi 1 ve di tuoi tho");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(10, 10, 220, 30);
		panel_8.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel(" 67.000 d");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(240, 10, 78, 30);
		panel_8.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("1");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_1.setBounds(328, 10, 74, 30);
		panel_8.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("0 d");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(412, 10, 85, 30);
		panel_8.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("67.000 d");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8_1.setBounds(507, 10, 123, 30);
		panel_8.add(lblNewLabel_8_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(10, 120, 640, 122);
		panel_6.add(panel_9);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(288, 10, 352, 101);
		panel_9.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Into money");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(10, 10, 129, 20);
		panel_10.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("67.000 d");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(149, 10, 193, 20);
		panel_10.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9_1 = new JLabel("Transport fee");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9_1.setBounds(10, 40, 129, 20);
		panel_10.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Total");
		lblNewLabel_9_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9_1_1.setBounds(10, 70, 129, 20);
		panel_10.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("0 d");
		lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10_1.setBounds(149, 40, 193, 20);
		panel_10.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("67.000 d");
		lblNewLabel_10_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_10_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10_1_1.setBounds(149, 70, 193, 20);
		panel_10.add(lblNewLabel_10_1_1);
		
		JButton btnNewButton = new JButton("Cancel order");
		btnNewButton.setBackground(new Color(255, 204, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(456, 252, 176, 32);
		panel_6.add(btnNewButton);

	}
}
