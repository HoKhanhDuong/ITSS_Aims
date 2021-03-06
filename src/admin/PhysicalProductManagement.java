package admin;

import javax.swing.JPanel;

import Manager.AdminApplication;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PhysicalProductManagement extends AddProduct {

	AdminApplication adminApplication;
	private JTextField barcode;
	private JTextField quantity;
	private JTextField grdate;
	private JTextField mass;
	private JTextField size;
	private JTextArea infomation;
	
	private String[] validations;
	private boolean status;
	private int id_media;
	private boolean check = true;
	
	public PhysicalProductManagement(AdminApplication adminApplication) {
		super(adminApplication);
		
		this.status = true;
		this.validations = new String[6];
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 121, 830, 399);
		addProductPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 10, 810, 379);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Barcode");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 21, 124, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(445, 21, 70, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Description");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 72, 124, 30);
		panel_1.add(lblNewLabel_1_2);
		
		infomation = new JTextArea();
		infomation.setToolTipText("Nhap mo ta");
		infomation.setBackground(SystemColor.control);
		infomation.setForeground(Color.BLACK);
		infomation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		infomation.setLineWrap(true);
		infomation.setText("information");
		infomation.setTabSize(4);
		infomation.setRows(2);
		infomation.setBounds(160, 72, 640, 90);
		panel_1.add(infomation);
		
		JLabel GRDate = new JLabel("Goods receipt date");
		GRDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GRDate.setBounds(10, 195, 145, 30);
		panel_1.add(GRDate);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Mass");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(10, 242, 145, 30);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		JButton cancelbtn = new JButton("Cancel");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), 
						"Please add products to stock\n", 
						"Add Media", 
						JOptionPane.WARNING_MESSAGE);
				return;
			}
		});
		cancelbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelbtn.setBounds(494, 315, 124, 30);
		panel_1.add(cancelbtn);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.setID(-1);
				
				setValidations();
				
				if (status) {
					check = adminApplication.adminController.add_Physical(getValidations(), status);
					if (check) {
						adminApplication.adminController.addHistory(-1, adminApplication.getID(), 1);
						
						JOptionPane.showMessageDialog(null, 
								"Them san pham thanh cong", 
								"Insert Media", 
								JOptionPane.INFORMATION_MESSAGE);
					}
					
				} else {
					check = adminApplication.adminController.add_Physical(getValidations(), status);
					if (check) {
						adminApplication.adminController.addHistory(id_media, adminApplication.getID(), 2);
						
						JOptionPane.showMessageDialog(null, 
								"Sua thong tin thanh cong", 
								"Edit Media", 
								JOptionPane.INFORMATION_MESSAGE);
						status = true;
						id_media = 0;
					}
				}
				if (check) {
					adminApplication.productManagement.setItems(
							adminApplication.connect.getList_Product_Physical()
					);
					adminApplication.productManagement.getIdmediatxt().setText("");
					adminApplication.productManagement.setTable();
					adminApplication.setSua(true);
					adminApplication.setThem(true);
					adminApplication.switchPanel(adminApplication.productManagement);
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(664, 315, 124, 30);
		panel_1.add(btnAdd);
		
		barcode = new JTextField();
		barcode.setForeground(Color.BLACK);
		barcode.setBounds(160, 25, 251, 30);
		panel_1.add(barcode);
		barcode.setColumns(10);
		
		quantity = new JTextField();
		quantity.setForeground(Color.BLACK);
		quantity.setToolTipText("nhap gia");
		quantity.setColumns(10);
		quantity.setBounds(537, 24, 251, 30);
		panel_1.add(quantity);
		
		grdate = new JTextField();
		grdate.setToolTipText("Ngay nhap hang");
		grdate.setColumns(10);
		grdate.setBounds(160, 195, 251, 30);
		panel_1.add(grdate);
		
		mass = new JTextField();
		mass.setToolTipText("Khối lượng sản phẩm");
		mass.setColumns(10);
		mass.setBounds(160, 242, 251, 30);
		panel_1.add(mass);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Size");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(445, 195, 70, 30);
		panel_1.add(lblNewLabel_1_1_1);
		
		size = new JTextField();
		size.setToolTipText("Kích thước sản phẩm");
		size.setColumns(10);
		size.setBounds(537, 198, 251, 30);
		panel_1.add(size);
	}

	public String[] getValidations() {
		return validations;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId_media() {
		return id_media;
	}

	public void setId_media(int id_media) {
		this.id_media = id_media;
	}

	public void setValidations() {
		
		this.validations[0] = barcode.getText().trim();
		this.validations[1] = quantity.getText().trim();
		this.validations[2] = infomation.getText().trim();
		this.validations[3] = grdate.getText().trim();
		this.validations[4] = size.getText().trim();
		this.validations[5] = mass.getText().trim();
		
	}
	
	public void display_edit(String[] value) {
		this.validations = new String[7];
		this.status = false;
		this.id_media = Integer.parseInt(value[6]);
		this.validations[6] = value[6];
		barcode.setText(value[0]);
		quantity.setText(value[1]);
		infomation.setText(value[2]);
		grdate.setText(value[3]);
		size.setText(value[4]);
		mass.setText(value[5]);
	}
	
	public void clear_display() {
		this.barcode.setText("");
		this.grdate.setText("");
		this.infomation.setText("");
		this.mass.setText("");
		this.size.setText("");
		this.quantity.setText("");
	}
	
}
