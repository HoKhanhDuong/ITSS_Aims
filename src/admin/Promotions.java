package admin;

import javax.swing.JPanel;

import Manager.AdminApplication;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Promotions extends AddminHome {
	private JTable table;
	
	AdminApplication adminApplication;
	public Promotions(AdminApplication adminApplication) {
		super(adminApplication);
		this.adminApplication = adminApplication;
		
		JPanel panel = new JPanel();
		panel.setBounds(250, 70, 850, 530);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Promotions");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setBounds(556, 37, 269, 35);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(8, 134, 830, 376);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 10, 810, 398);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setRowHeight(table.getRowHeight() + 20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Don nha don tet ", "21-12-2020", "10-12-2020", "Giam gia", "Kich hoat"},
				{null, null, null, null, null, null},
				{null, "", "", null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, "", null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, "", null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Start day", "End day", "Promotion form", "Status"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(66);
		table.getColumnModel().getColumn(1).setPreferredWidth(152);
		table.getColumnModel().getColumn(2).setPreferredWidth(74);
		table.getColumnModel().getColumn(3).setPreferredWidth(74);
		table.getColumnModel().getColumn(4).setPreferredWidth(190);
		scrollPane.setViewportView(table);
		
		JLabel lblPromotions = new JLabel("Promotions");
		lblPromotions.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPromotions.setBounds(15, 13, 205, 35);
		panel.add(lblPromotions);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(19, 79, 807, 47);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox sortComboBox = new JComboBox();
		sortComboBox.setBounds(670, 10, 128, 30);
		panel_2.add(sortComboBox);
		sortComboBox.setBackground(Color.WHITE);
		sortComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Fetured", "Price : Low to High", "Price : High to Low"}));
		
		JLabel sortLabel = new JLabel("Sort by :");
		sortLabel.setBounds(546, 6, 100, 40);
		panel_2.add(sortLabel);
		sortLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		sortLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	}
}
