package user;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Manager.Application;

import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class OrderHisrory extends MyAccount {

	/**
	 * Create the panel.
	 */
	String data[][] = { { "101", "Tran Van Minh", "6000" }, 
            { "102", "Phan Van Tai", "8000" }, 
            { "101", "Do Cao Hoc", "7000" } };
    String column[] = { "ID", "NAME", "SALARY" };
    private JTable table;
    private JTextField textField;
	public OrderHisrory( Application application) {
		super(application);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(320, 70, 780, 530);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(10, 0, 670, 530);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1. My Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(25, 25, 615, 30);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 65, 650, 336);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 10, 630, 305);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowHeight(table.getRowHeight() + 20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"122334", "Cho toi xin 1 ve di tuoi tho, Co hai con meo ngoi ben cua so", "100.000 d", "OK"},
				{"", "", null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, "", null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID ", "Product", "Price", "Status"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(420);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		JLabel lblDetailOrder = new JLabel("2. Detail Order");
		lblDetailOrder.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDetailOrder.setBounds(25, 404, 615, 30);
		panel_1.add(lblDetailOrder);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 445, 650, 75);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID Product :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 140, 30);
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(157, 10, 230, 30);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(418, 10, 101, 30);
		panel_3.add(btnNewButton);
		
		

	}
}
