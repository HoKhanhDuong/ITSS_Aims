package admin;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import Manager.AdminApplication;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductManagement extends AddminHome {
	
	private JTable table;
	private JTextField idmediatxt;
	AdminApplication adminApplication;
	
	private String[][] items;

	public ProductManagement(AdminApplication adminApplication) {
		super(adminApplication);
		
		items = adminApplication.connect.getList_Product_Physical();
		
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
		table.setRowHeight(table.getRowHeight() + 15);
		setTable();
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(230);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getColumnModel().getColumn(3).setPreferredWidth(55);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
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
		
		idmediatxt = new JTextField();
		idmediatxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idmediatxt.setBounds(176, 10, 644, 30);
		panel_2.add(idmediatxt);
		idmediatxt.setColumns(10);
		
		JButton btnEdit = new JButton("Edit Product");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(adminApplication.getID());
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBounds(172, 50, 190, 30);
		panel_2.add(btnEdit);
		
		JButton btnRemove = new JButton("Remove Product");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//tùy chỉnh văn bản cho nút lệnh
				Object[] options = {"Yes, please", "No, thanks"};
				
				
				int n = JOptionPane.showOptionDialog(null, 
						"Ban muon xoa khong?", 
						"Xoa san pham", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE,
						null, options, 
						options[1]);
				
				if (n == JOptionPane.YES_OPTION) {
					int id_media = Integer.parseInt(idmediatxt.getText().trim());
					
					adminApplication.adminController.addHistory(id_media, adminApplication.getID(), 3);
					adminApplication.adminController.removeProduct(id_media);
					
					adminApplication.productManagement.setItems(
							adminApplication.connect.getList_Product_Physical()
					);
					adminApplication.productManagement.setTable();
					
					adminApplication.productManagement.idmediatxt.setText("");
					
					adminApplication.switchPanel(adminApplication.productManagement);
				}
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemove.setBounds(392, 50, 177, 30);
		panel_2.add(btnRemove);
		
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 adminApplication.switchPanel(adminApplication.addBook);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(349, 10, 85, 30);
		panel_2_1.add(btnNewButton);
		
		JButton btnCd = new JButton("CD/LP");
		btnCd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 adminApplication.switchPanel(adminApplication.addCD_LP);
			}
		});
		btnCd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCd.setBounds(459, 10, 85, 30);
		panel_2_1.add(btnCd);
		
		JButton btnDvd = new JButton("DVD");
		btnDvd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 adminApplication.switchPanel(adminApplication.addDVD);
			}
		});
		btnDvd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDvd.setBounds(569, 10, 85, 30);
		panel_2_1.add(btnDvd);

	}

	public String[][] getItems() {
		return items;
	}

	public void setItems(String[][] items) {
		this.items = items;
	}
	
	public void setTable() {
		
		table.setModel(new DefaultTableModel(
			getItems()
			,
			new String[] {
				"ID", "Name", "Price", "Quantity", "Input day", "Barcode"
			}
		));
		
	}
	
}
