package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Manager.AdminApplication;
import Object.User;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserManagement extends AddminHome {
	
	private JTable table;
	private JTextField user_idtxt;
	AdminApplication adminApplication;

	public UserManagement(AdminApplication adminApplication) {
		super(adminApplication);
		
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
		table.setRowHeight(table.getRowHeight() + 15);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"123456", "Nguyen Thi Thu Phuong", "nguyenphuong4899@gmail.com", "ok"},
			},
			new String[] {
				"ID", "Name", "Phone","Address", "Status"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(52);
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
		
		user_idtxt = new JTextField();
		user_idtxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		user_idtxt.setBounds(176, 10, 644, 30);
		panel_2.add(user_idtxt);
		user_idtxt.setColumns(10);
		
		JButton btnBlockUser = new JButton("Block User");
		btnBlockUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.adminController.changeStatusUser(user_idtxt.getText(), 1);
			}
		});
		btnBlockUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBlockUser.setBounds(385, 50, 223, 30);
		panel_2.add(btnBlockUser);
		
		JButton btnUnblockButton = new JButton("Unblock users");
		btnUnblockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.adminController.changeStatusUser(user_idtxt.getText(), 0);
			}
		});
		btnUnblockButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUnblockButton.setBounds(643, 50, 177, 30);
		panel_2.add(btnUnblockButton);
	}
	
	
	
	public JTextField getUser_idtxt() {
		return user_idtxt;
	}



	public void setUser_idtxt(JTextField user_idtxt) {
		this.user_idtxt = user_idtxt;
	}



	public void setUsers(ArrayList<User> list) {

		DefaultTableModel dModel = (DefaultTableModel) table.getModel();
		int rowCount = dModel.getRowCount();
		for(int i=rowCount-1; i>=0 ; i--) {
			dModel.removeRow(i);
		}
		
		
		for(int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			String[] row = {user.getId()+"", user.getName(), user.getPhone(),user.getAddress(), user.isblock+"" };
			dModel.addRow(row);
 		}
	}
}
