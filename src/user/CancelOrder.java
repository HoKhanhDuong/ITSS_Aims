package user;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class CancelOrder extends MyAccount {
	private JTable table;
	private JTextField textField;

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
		panel_6.setBackground(SystemColor.control);
		panel_6.setBounds(10, 226, 660, 304);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(10, 111, 640, 119);
		panel_6.add(panel_9);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(283, 0, 357, 101);
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
		lblNewLabel_10.setBounds(204, 10, 138, 20);
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
		lblNewLabel_10_1.setBounds(204, 40, 138, 20);
		panel_10.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("67.000 d");
		lblNewLabel_10_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_10_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10_1_1.setBounds(204, 70, 138, 20);
		panel_10.add(lblNewLabel_10_1_1);
		
		JButton btnNewButton = new JButton("Cancel order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(255, 204, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(504, 250, 146, 32);
		panel_6.add(btnNewButton);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 10, 640, 95);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
//		table = new JTable();
//		table.setColumnSelectionAllowed(true);
//		table.setSurrendersFocusOnKeystroke(true);
//		table.setCellSelectionEnabled(true);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"asdfg", "asdfg", "asdfg", "asdfg", "asdfg"},
//			},
//			new String[] {
//				"Product", "Price", "Quantity", "Discount", "Into Money"
//			}
//		));
//		table.getColumnModel().getColumn(0).setPreferredWidth(240);
//		table.getColumnModel().getColumn(1).setPreferredWidth(90);
//		table.getColumnModel().getColumn(3).setPreferredWidth(110);
//		table.getColumnModel().getColumn(4).setPreferredWidth(103);
//		table.setBounds(0, 0, 640, 100);
//		panel_7.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setViewportBorder(new LineBorder(new Color(240, 240, 240)));
		scrollPane.setBounds(0, 0, 640, 96);
		panel_7.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		table.setShowVerticalLines(false);
		table.setRowHeight(table.getRowHeight() + 20);
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(255, 255, 255));
		table.setToolTipText("");
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));

		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Toi thay hoa vang tren co xanh", "65.000 d", "1", "0", "65.000 d"},
				{"Co hai con meo ngoi ben cua so", "120.000 d", "1", "0", "120.000 d"},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Product", "Price", "Quantity", "Discount", "Into Money"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(212);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setMinWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(71);
		table.getColumnModel().getColumn(3).setPreferredWidth(84);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(103, 250, 379, 30);
		panel_6.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("REASON :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(12, 250, 81, 30);
		panel_6.add(lblNewLabel_4);

	}
}
