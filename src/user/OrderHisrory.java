package user;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderHisrory extends MyAccount {

	/**
	 * Create the panel.
	 */
	public OrderHisrory() {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(320, 70, 780, 530);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 0, 670, 530);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(25, 25, 615, 30);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 72, 650, 384);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("ID");
		btnNewButton.setBounds(0, 0, 85, 30);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("date buy");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(84, 0, 137, 30);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("product name");
		btnNewButton_2.setBounds(221, 0, 220, 30);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("total");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(439, 0, 91, 30);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("status");
		btnNewButton_4.setBounds(528, 0, 122, 30);
		panel_2.add(btnNewButton_4);

	}
}
