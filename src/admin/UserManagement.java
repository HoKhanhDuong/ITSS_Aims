package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class UserManagement extends AddminHome {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public UserManagement() {
		
		JPanel panel = new JPanel();
		panel.setBounds(250, 70, 850, 530);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblUserList = new JLabel("1. User list");
		lblUserList.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUserList.setBounds(20, 10, 622, 30);
		panel.add(lblUserList);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 50, 830, 290);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 10, 810, 267);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setRowHeight(table.getRowHeight() + 20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"123456", "Nguyen Thi Thu Phuong", "nguyenphuong4899@gmail.com", "ok"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Email", "Status"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(157);
		table.getColumnModel().getColumn(2).setPreferredWidth(197);
		table.getColumnModel().getColumn(3).setPreferredWidth(52);
		scrollPane.setViewportView(table);
		
		JLabel lblRemoveUser = new JLabel("2.  User management");
		lblRemoveUser.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRemoveUser.setBounds(20, 350, 622, 40);
		panel.add(lblRemoveUser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 400, 830, 120);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter user ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 131, 30);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(176, 10, 644, 30);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove User");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(176, 50, 162, 30);
		panel_2.add(btnNewButton);
		
		JButton btnBlockUser = new JButton("Block User");
		btnBlockUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBlockUser.setBounds(385, 50, 223, 30);
		panel_2.add(btnBlockUser);
		
		JButton btnNewButton_1_1 = new JButton("Unblock users");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(643, 50, 177, 30);
		panel_2.add(btnNewButton_1_1);

	}
}
