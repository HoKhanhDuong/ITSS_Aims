package admin;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ProductManagement extends AddminHome {
	private JTable table;
	private JTextField textField;



	/**
	 * Create the panel.
	 */
	public ProductManagement() {
		
		JPanel panel = new JPanel();
		panel.setBounds(250, 70, 850, 530);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblProductList = new JLabel("1. Product list");
		lblProductList.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblProductList.setBounds(20, 10, 622, 30);
		panel.add(lblProductList);
        
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 50, 830, 222);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 10, 810, 201);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setRowHeight(table.getRowHeight() + 20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"123456", "Cho toi xin 1 ve di tuoi tho", "100.000 d", "20"},
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
				"ID", "Name", "Price", "Quantity"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(329);
		table.getColumnModel().getColumn(2).setPreferredWidth(197);
		table.getColumnModel().getColumn(3).setPreferredWidth(52);
		scrollPane.setViewportView(table);
		
		JLabel lblRemoveUser = new JLabel("2.  Remove/Edit Product");
		lblRemoveUser.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRemoveUser.setBounds(10, 282, 622, 30);
		panel.add(lblRemoveUser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 322, 830, 93);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter product ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 131, 30);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(176, 10, 644, 30);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnBlockUser = new JButton("Edit Product");
		btnBlockUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBlockUser.setBounds(172, 50, 190, 30);
		panel_2.add(btnBlockUser);
		
		JButton btnNewButton_1_1 = new JButton("Remove Product");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(392, 50, 177, 30);
		panel_2.add(btnNewButton_1_1);
		
		JLabel lblAddProduct = new JLabel("3.  Add product");
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAddProduct.setBounds(10, 425, 622, 30);
		panel.add(lblAddProduct);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(10, 461, 830, 60);
		panel.add(panel_2_1);
		
		JLabel lblChooseTheType = new JLabel("Choose the type of product you want to add :");
		lblChooseTheType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChooseTheType.setBounds(10, 10, 353, 30);
		panel_2_1.add(lblChooseTheType);
		
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(349, 10, 85, 30);
		panel_2_1.add(btnNewButton);
		
		JButton btnCd = new JButton("CD");
		btnCd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCd.setBounds(459, 10, 85, 30);
		panel_2_1.add(btnCd);
		
		JButton btnDvd = new JButton("DVD");
		btnDvd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDvd.setBounds(569, 10, 85, 30);
		panel_2_1.add(btnDvd);

	}
}
