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

public class OrderHisrory extends MyAccount {

	/**
	 * Create the panel.
	 */
	
    private String column[] = new String[] {
			"ID", "Product", "Total", "Status"
		};
    
    private String[][] objects;
    
    
    private JTable table;
    
	public OrderHisrory( Application application) {
		super(application);
		
//		objects = application.orderController.screenListOrder(application.connect.get_OrderDetail(2));
		
		objects = application.connect.get_OrderDetail(2);
		
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
		
		JLabel lblNewLabel = new JLabel("My Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(25, 25, 615, 30);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(new LineBorder(SystemColor.control));
		scrollPane.setBounds(10, 69, 737, 449);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(table.getRowHeight() + 20);
		table.setForeground(new Color(0, 0, 0));
		table.setCellSelectionEnabled(true);
		table.setBackground(new Color(255, 255, 255));
		table.setToolTipText("");
		table.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		table.setModel(new DefaultTableModel(
			objects,
			column
		));
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setMinWidth(350);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		scrollPane.setViewportView(table);

	}

	public String[][] getObjects() {
		return objects;
	}

	public void setObjects(String[][] objects) {
		this.objects = objects;
	}
	
	
	
	
}
