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
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Promotions extends AddminHome {
	
	AdminApplication adminApplication;
	JComboBox saleCombo;
	JLabel start;
	JLabel end;
	JPanel panel_3;
	
	public Promotions(AdminApplication adminApplication) {
		super(adminApplication);
		this.adminApplication = adminApplication;
		
		JPanel panel = new JPanel();
		panel.setBounds(250, 70, 850, 530);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Promotions");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.switchPanel(adminApplication.addPromitions);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setBounds(556, 37, 269, 35);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(8, 134, 830, 376);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Start Time:");
		lblNewLabel.setBounds(10, 11, 100, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("End Time :");
		lblNewLabel_1.setBounds(10, 56, 100, 35);
		panel_1.add(lblNewLabel_1);
		
		panel_3 = new JPanel();
		panel_3.setBounds(10, 102, 810, 263);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		start = new JLabel("New label");
		start.setBounds(136, 11, 157, 26);
		panel_1.add(start);
		
		end = new JLabel("New label");
		end.setBounds(136, 56, 157, 35);
		panel_1.add(end);
		
		JLabel lblPromotions = new JLabel("Promotions");
		lblPromotions.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPromotions.setBounds(15, 13, 205, 35);
		panel.add(lblPromotions);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(19, 79, 807, 47);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		saleCombo = new JComboBox();
		saleCombo.setBounds(244, 5, 434, 30);
		panel_2.add(saleCombo);
		saleCombo.setBackground(Color.WHITE);
		saleCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saleCombo.setModel(new DefaultComboBoxModel());
		saleCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				adminApplication.adminController.getSaleMedia(saleCombo.getSelectedItem().toString());
			}
		});
		
		JLabel sortLabel = new JLabel("Choose promotions:");
		sortLabel.setBounds(0, 0, 199, 40);
		panel_2.add(sortLabel);
		sortLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		sortLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	}
	
	public void setComBo(ArrayList<String> list) {
		saleCombo.removeAllItems();
		for(int i=0; i<list.size(); i++) {
			saleCombo.addItem(list.get(i));
		}
	}
	
	public void setSale(ArrayList<MediaPanel> list, String startString, String endString) {
		start.setText(startString);
		end.setText(endString);
		panel_3.removeAll();
		panel_3.setBounds(10, 123, 810, 242);
		panel_3.setLayout(null);
		
		for(int i=0; i<list.size(); i++) {
			panel_3.add(list.get(i));
		}
	}
	
}
