package admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class AddProduct extends AddminHome {
	  
	public JPanel addProductPanel;

	/**
	 * Create the panel.
	 */
	public AddProduct() {
		addProductPanel = new JPanel();
		addProductPanel.setBounds(250, 70, 850, 530);
		add(addProductPanel);
		addProductPanel.setLayout(null);
		
		JLabel lblAddProduct = new JLabel("Add product");
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAddProduct.setBounds(10, 10, 622, 30);
		addProductPanel.add(lblAddProduct);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(10, 50, 830, 60);
		addProductPanel.add(panel_2_1);
		
		JLabel lblChooseTheType = new JLabel("Choose the type of product you want to add :");
		lblChooseTheType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChooseTheType.setBounds(10, 10, 353, 30);
		panel_2_1.add(lblChooseTheType);
		
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(349, 10, 85, 30);
		panel_2_1.add(btnNewButton);
		
		JButton btnCd = new JButton("CD/LP");
		btnCd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCd.setBounds(459, 10, 85, 30);
		panel_2_1.add(btnCd);
		
		JButton btnDvd = new JButton("DVD");
		btnDvd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDvd.setBounds(569, 10, 85, 30);
		panel_2_1.add(btnDvd);

	}
}
