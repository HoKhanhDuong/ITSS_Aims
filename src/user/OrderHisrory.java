package user;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.UserController;
import Manager.Application;
import Object.User;

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
	
    private String column[] = new String[] {
			"ID", "Product", "Total", "Status"
		};
    
    private String[][] objects;
    
    
    private JTable table;
    private JTextField txt_id_order;
  
	public OrderHisrory( Application application) {
		super(application);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(320, 70, 780, 530);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(10, 0, 753, 524);
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
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(new LineBorder(SystemColor.control));
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowHeight(table.getRowHeight() + 20);
		setTable();
		table.getColumnModel().getColumn(1).setPreferredWidth(390);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);
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
		
		txt_id_order = new JTextField();
		txt_id_order.setBounds(157, 10, 230, 30);
		panel_3.add(txt_id_order);
		txt_id_order.setColumns(10);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(418, 10, 101, 30);
		panel_3.add(btnNewButton);
		
		

	}

	public String[][] getObjects() {
		return objects;
	}

	public void setObjects(String[][] objects) {
		this.objects = objects;
	}
	
	public void setTable() {
		if (application.getID() != 0) {
			objects = application.connect.get_OrderDetail(application.getID());
		}
		table.setModel(new DefaultTableModel(
				objects,
				column
			));
	}
	
	
}
