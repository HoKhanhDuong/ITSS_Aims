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
	String data[][] = { { "101", "Tran Van Minh", "6000" }, 
            { "102", "Phan Van Tai", "8000" }, 
            { "101", "Do Cao Hoc", "7000" } };
    String column[] = { "ID", "NAME", "SALARY" };
    private JTable table;
	public OrderHisrory() {
		
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
		
		JLabel lblNewLabel = new JLabel("My Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(25, 25, 615, 30);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setEnabled(false);
		scrollPane.setViewportBorder(new LineBorder(SystemColor.control));
		scrollPane.setBounds(10, 69, 650, 451);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"012345", "11/11/2020", "Hoa cuc dai, Toi thay hoa vang tren co xanh, Shin cau be but chi", "210.000", ""},
				{"064578", "09/11/2019", "Tuoi tre dang gia bao nhieu", "99.000", "cancel"},
			},
			new String[] {
				"ID", "Date purchase", "Product", "Total", "Status"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(262);
		table.getColumnModel().getColumn(3).setPreferredWidth(84);
		table.getColumnModel().getColumn(4).setPreferredWidth(125);
		scrollPane.setViewportView(table);

	}
}
