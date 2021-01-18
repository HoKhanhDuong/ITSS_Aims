package admin;

import javax.swing.JPanel;

import Manager.AdminApplication;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;

import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class AddPromitions extends AddminHome {

	AdminApplication adminApplication;
	private JTextField nameTxt;

	JPanel promitionPanel;
	JComboBox startDay, startMonth, startYear, endDay, endMonth, endYear;
	
	public AddPromitions(AdminApplication adminApplication) {
		super(adminApplication);
		this.adminApplication = adminApplication;
		
		JPanel panel = new JPanel();
		panel.setBounds(250, 70, 850, 570);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAddPromotions = new JLabel("Add Promotions");
		lblAddPromotions.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAddPromotions.setBounds(10, 10, 830, 35);
		panel.add(lblAddPromotions);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 48, 830, 130);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 9, 76, 30);
		panel_1.add(lblNewLabel);
		
		nameTxt = new JTextField();
		nameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTxt.setBounds(96, 10, 304, 30);
		panel_1.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Month:");
		lblNewLabel_2_2.setBounds(357, 51, 67, 30);
		panel_1.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
				JLabel lblNewLabel_2 = new JLabel("Start time :");
				lblNewLabel_2.setBounds(10, 51, 80, 30);
				panel_1.add(lblNewLabel_2);
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				JLabel lblNewLabel_2_2_1 = new JLabel("Day :");
				lblNewLabel_2_2_1.setBounds(152, 51, 48, 30);
				panel_1.add(lblNewLabel_2_2_1);
				lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				startDay = new JComboBox();
				startDay.setBounds(246, 51, 74, 30);
				panel_1.add(startDay);
				startDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				startDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
				startDay.setBackground(Color.WHITE);
				
				startMonth = new JComboBox();
				startMonth.setBounds(452, 51, 74, 30);
				panel_1.add(startMonth);
				startMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
				startMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
				startMonth.setBackground(Color.WHITE);
				
				JLabel lblNewLabel_2_2_1_1 = new JLabel("Year :");
				lblNewLabel_2_2_1_1.setBounds(592, 51, 67, 30);
				panel_1.add(lblNewLabel_2_2_1_1);
				lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				startYear = new JComboBox();
				startYear.setBounds(669, 51, 74, 30);
				panel_1.add(startYear);
				startYear.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026"}));
				startYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
				startYear.setBackground(Color.WHITE);
				
				JLabel lblNewLabel_2_3 = new JLabel("End time :");
				lblNewLabel_2_3.setBounds(10, 90, 80, 30);
				panel_1.add(lblNewLabel_2_3);
				lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				JLabel lblNewLabel_2_2_1_2 = new JLabel("Day :");
				lblNewLabel_2_2_1_2.setBounds(152, 92, 67, 30);
				panel_1.add(lblNewLabel_2_2_1_2);
				lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				endDay = new JComboBox();
				endDay.setBounds(246, 90, 74, 30);
				panel_1.add(endDay);
				endDay.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				endDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
				endDay.setBackground(Color.WHITE);
				
				JLabel lblNewLabel_2_2_2 = new JLabel("Month:");
				lblNewLabel_2_2_2.setBounds(357, 90, 67, 30);
				panel_1.add(lblNewLabel_2_2_2);
				lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				endMonth = new JComboBox();
				endMonth.setBounds(452, 90, 74, 30);
				panel_1.add(endMonth);
				endMonth.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
				endMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
				endMonth.setBackground(Color.WHITE);
				
				JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Year :");
				lblNewLabel_2_2_1_1_1.setBounds(592, 90, 67, 30);
				panel_1.add(lblNewLabel_2_2_1_1_1);
				lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				endYear = new JComboBox();
				endYear.setBounds(669, 90, 74, 30);
				panel_1.add(endYear);
				endYear.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026"}));
				endYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
				endYear.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBounds(10, 179, 827, 282);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		promitionPanel = new JPanel();
		promitionPanel.setBackground(SystemColor.inactiveCaptionBorder);
		promitionPanel.setBounds(0, 10, 805, 244);
		promitionPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Product Groups");
		lblNewLabel_3.setBounds(10, 10, 134, 30);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		promitionPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Discount");
		lblNewLabel_3_1.setBounds(371, 11, 81, 30);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		promitionPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Name Product");
		lblNewLabel_3_2.setBounds(188, 11, 134, 30);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		promitionPanel.add(lblNewLabel_3_2);
		
		panel_2.add(promitionPanel);
		
		ArrayList<SaleMedia> saleList = new ArrayList<SaleMedia>();
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleMedia saleMedia = new SaleMedia(adminApplication, saleList.size(), saleList);
				promitionPanel.add(saleMedia);
				saleList.add(saleMedia);
				adminApplication.setBounds(100, 100, 1100, 600+saleList.size());
			}
		});
		addButton.setBounds(281, 472, 112, 33);
		panel.add(addButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i= saleList.size()-1; i>= 0; i--) {
					promitionPanel.remove(i+3);
					saleList.remove(i);
				}
			}
		});
		
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		cancelButton.setBounds(623, 475, 189, 30);
		panel.add(cancelButton);
		
		JButton saveButton = new JButton("SAVE");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				LocalDate starttime = LocalDate.of(Integer.parseInt((String)startYear.getSelectedItem()),
						Integer.parseInt((String)startMonth.getSelectedItem()),
						Integer.parseInt((String)startDay.getSelectedItem()));
				
				LocalDate endtime = LocalDate.of(Integer.parseInt((String) endYear.getSelectedItem()),
						Integer.parseInt((String)endMonth.getSelectedItem()),
						Integer.parseInt((String)endDay.getSelectedItem()));
				
				if(nameTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "Enter name of sale"
							,"",JOptionPane.ERROR_MESSAGE);
				}else if(saleList.size()==0){
					JOptionPane.showMessageDialog(new JFrame(), "Add Media to this sale"
							,"",JOptionPane.ERROR_MESSAGE);
				}else if(checkList(saleList)) {
					adminApplication.saleController.saveSale(nameTxt.getText(), starttime, endtime, saleList);
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Enter sale percent and sale Media"
							,"",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		saveButton.setBounds(418, 475, 189, 30);
		panel.add(saveButton);
		
//		JButton btnNewButton_1_1 = new JButton("Range");
//		btnNewButton_1_1.setBorder(null);
//		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnNewButton_1_1.setBounds(594, 10, 224, 30);
//		panel_2.add(btnNewButton_1_1);
//===============================================================HINH THUC KHUYEN MAI=============================================================================		
	   
		
		
		
//---------------------------------------------------------- giam gia theo hoa don---------------------------------------------------------
		/*
		panel_3.setLayout(null);
		JLabel lblNewLabel_3 = new JLabel("Total bill");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 10, 81, 30);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Discount");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(235, 10, 81, 30);
		panel_3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("From");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 45, 45, 30);
		panel_3.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(60, 45, 147, 30);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(231, 45, 105, 30);
		panel_3.add(textField_1);
		
		JButton btnVnd = new JButton("VND");
		btnVnd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVnd.setBorder(null);
		btnVnd.setBounds(350, 46, 50, 30);
		panel_3.add(btnVnd);
		
		JButton btnVnd_1 = new JButton("%");
		btnVnd_1.setBackground(SystemColor.textHighlight);
		btnVnd_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVnd_1.setBorder(null);
		btnVnd_1.setBounds(400, 45, 50, 30);
		panel_3.add(btnVnd_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("From");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(10, 85, 45, 30);
		panel_3.add(lblNewLabel_4_1);
		
		text2 = new JTextField();
		text2.setColumns(10);
	    text2.setBounds(60, 85, 147, 30);
    	panel_3.add(text2);
		
    	text3 = new JTextField();
		text3.setColumns(10);
		text3.setBounds(231, 85, 105, 30);
		panel_3.add(text3);
		
		JButton btnVnd_2 = new JButton("VND");
		btnVnd_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVnd_2.setBorder(null);
		btnVnd_2.setBounds(350, 86, 50, 30);
		panel_3.add(btnVnd_2);
		
		JButton btnVnd_1_1 = new JButton("%");
		btnVnd_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVnd_1_1.setBorder(null);
		btnVnd_1_1.setBackground(SystemColor.textHighlight);
		btnVnd_1_1.setBounds(400, 85, 50, 30);
		panel_3.add(btnVnd_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("From");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4_2.setBounds(10, 125, 45, 30);
		panel_3.add(lblNewLabel_4_2);
		
		text4 = new JTextField();
		text4.setColumns(10);
		text4.setBounds(60, 125, 147, 30);
		panel_3.add(text4);
		
		text5 = new JTextField();
		text5.setColumns(10);
		text5.setBounds(231, 125, 105, 30);
		panel_3.add(text5);
		
		JButton btnVnd_3 = new JButton("VND");
		btnVnd_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVnd_3.setBorder(null);
		btnVnd_3.setBounds(350, 126, 50, 30);
		panel_3.add(btnVnd_3);
		
		JButton btnVnd_1_2 = new JButton("%");
		btnVnd_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVnd_1_2.setBorder(null);
		btnVnd_1_2.setBackground(SystemColor.textHighlight);
		btnVnd_1_2.setBounds(400, 125, 50, 30);
		panel_3.add(btnVnd_1_2);
		
		JButton btnNewButton_2 = new JButton("More conditions");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(594, 132, 189, 30);
		panel_3.add(btnNewButton_2);
		
		*/
//----------------------------------------- Tang qua theo hoa don-----------------------------------------------------------
		/*
		panel_3.setLayout(null);
		JLabel lblNewLabel_3;
		totalbill = new JLabel("Total bill");
		totalbill.setFont(new Font("Tahoma", Font.BOLD, 14));
		totalbill.setBounds(10, 10, 81, 30);
		panel_3.add(totalbill);
		
		JLabel lblNewLabel_3_1;
		gift = new JLabel("Gift");
		gift.setFont(new Font("Tahoma", Font.BOLD, 14));
		gift.setBounds(235, 10, 81, 30);
		panel_3.add(gift);
		
		JLabel lblNewLabel_4;
		from1 = new JLabel("From");
		from1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		from1.setBounds(10, 45, 45, 30);
		panel_3.add(from1);
		
		textField = new JTextField();
		textField.setBounds(60, 45, 147, 30);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JComboBox sortComboBox_1_1;
		voucher1 = new JComboBox();
		voucher1.setModel(new DefaultComboBoxModel(new String[] {"Voucher giam gia 20% cho don hang sau", "Voucher giam gia 50% cho don hang sau"}));
		voucher1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		voucher1.setBackground(Color.WHITE);
		voucher1.setBounds(232, 45, 225, 30);
		panel_3.add(voucher1);
		
		JLabel lblNewLabel_4_1;
		from2 = new JLabel("From");
		from2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		from2.setBounds(10, 85, 45, 30);
		panel_3.add(from2);
		
		text2 = new JTextField();
		text2.setColumns(10);
		text2.setBounds(60, 85, 147, 30);
		panel_3.add(text2);
		
		JComboBox sortComboBox_1_1_1;
		voucher2 = new JComboBox();
		voucher2.setModel(new DefaultComboBoxModel(new String[] {"Voucher giam gia 20% cho don hang sau", "Voucher giam gia 50% cho don hang sau"}));
		voucher2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		voucher2.setBackground(Color.WHITE);
		voucher2.setBounds(232, 85, 225, 30);
		panel_3.add(voucher2);
		
		JLabel lblNewLabel_4_2;
		from3 = new JLabel("From");
		from3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		from3.setBounds(10, 125, 45, 30);
		panel_3.add(from3);
		
		text3 = new JTextField();
		text3.setColumns(10);
		text3.setBounds(60, 125, 147, 30);
		panel_3.add(text3);
		
		JComboBox sortComboBox_1_1_2;
		voucher3 = new JComboBox();
		voucher3.setModel(new DefaultComboBoxModel(new String[] {"Voucher giam gia 20% cho don hang sau", "Voucher giam gia 50% cho don hang sau"}));
		voucher3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		voucher3.setBackground(Color.WHITE);
		voucher3.setBounds(232, 125, 225, 30);
		panel_3.add(voucher3);
		
		JButton btnNewButton_2 = new JButton("More conditions");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(594, 132, 189, 30);
		panel_3.add(btnNewButton_2);
		
		
		*/
		
		
//------------------------------------------------------- giam gia theo san pham ----------------------------------------------------------------
		
		
		
		
		
//-----------------------------------------------------------------tang qua theo san pham----------------------------------------------------------		
        /*
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Product Groups");
		lblNewLabel_3.setBounds(10, 10, 134, 30);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gift");
		lblNewLabel_3_1.setBounds(371, 10, 81, 30);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNewLabel_3_1);
		
		JComboBox sortComboBox_2 = new JComboBox();
		sortComboBox_2.setBounds(10, 42, 128, 30);
		sortComboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Book", "CD", "DVD", "LD", "All Product"}));
		sortComboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2.setBackground(Color.WHITE);
		panel_3.add(sortComboBox_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Name Product");
		lblNewLabel_3_2.setBounds(188, 11, 134, 30);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNewLabel_3_2);
		
		JComboBox sortComboBox_2_1 = new JComboBox();
		sortComboBox_2_1.setBounds(185, 41, 128, 30);
		sortComboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"All ", "Cho toi xin 1 ve di tuoi tho", "Giet chet con chim nhai", "Co hai con meo ngoi ben cua so"}));
		sortComboBox_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_1.setBackground(Color.WHITE);
		panel_3.add(sortComboBox_2_1);
		
		JComboBox sortComboBox_2_2 = new JComboBox();
		sortComboBox_2_2.setModel(new DefaultComboBoxModel(new String[] {"Mua 1 tang 1", "Tang 10 quyen vo cua S2"}));
		sortComboBox_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_2.setBackground(Color.WHITE);
		sortComboBox_2_2.setBounds(370, 41, 128, 30);
		panel_3.add(sortComboBox_2_2);
		*/
//================================================HINH THUC KHUYEN MAI====================================================================================================		
		
//===============================================THOI GIAN AP DUNG========================================================================================================		
		/*
		JPanel timePanel = new JPanel();
		timePanel.setLayout(null);
		timePanel.setBackground(Color.WHITE);
		timePanel.setBounds(10, 51, 805, 221);
		panel_2.add(timePanel);
		timePanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Starting time :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 10, 140, 30);
		timePanel.add(lblNewLabel_2);
		
		JComboBox sortComboBox_2 = new JComboBox();
		sortComboBox_2.setBounds(10, 50, 74, 30);
		sortComboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0 ", "1 ", "2 ", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		sortComboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2.setBackground(Color.WHITE);
		timePanel.add(sortComboBox_2);
		
		JComboBox sortComboBox_2_1 = new JComboBox();
		sortComboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		sortComboBox_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_1.setBackground(Color.WHITE);
		sortComboBox_2_1.setBounds(105, 50, 74, 30);
		timePanel.add(sortComboBox_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(":");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(91, 51, 10, 30);
		timePanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Month:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(211, 51, 67, 30);
		timePanel.add(lblNewLabel_2_2);
		
		JComboBox sortComboBox_2_1_1 = new JComboBox();
		sortComboBox_2_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		sortComboBox_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_1_1.setBackground(Color.WHITE);
		sortComboBox_2_1_1.setBounds(278, 50, 74, 30);
		timePanel.add(sortComboBox_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Day :");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(380, 50, 67, 30);
		timePanel.add(lblNewLabel_2_2_1);
		
		JComboBox sortComboBox_2_1_1_1 = new JComboBox();
		sortComboBox_2_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		sortComboBox_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_1_1_1.setBackground(Color.WHITE);
		sortComboBox_2_1_1_1.setBounds(447, 50, 74, 30);
		timePanel.add(sortComboBox_2_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Year :");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1.setBounds(546, 50, 67, 30);
		timePanel.add(lblNewLabel_2_2_1_1);
		
		JComboBox sortComboBox_2_1_1_1_1 = new JComboBox();
		sortComboBox_2_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026"}));
		sortComboBox_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_1_1_1_1.setBackground(Color.WHITE);
		sortComboBox_2_1_1_1_1.setBounds(613, 50, 74, 30);
		timePanel.add(sortComboBox_2_1_1_1_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("End time :");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(7, 103, 140, 30);
		timePanel.add(lblNewLabel_2_3);
		
		JComboBox sortComboBox_2_2 = new JComboBox();
		sortComboBox_2_2.setModel(new DefaultComboBoxModel(new String[] {"0 ", "1 ", "2 ", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		sortComboBox_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_2.setBackground(Color.WHITE);
		sortComboBox_2_2.setBounds(10, 137, 74, 30);
		timePanel.add(sortComboBox_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel(":");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(91, 138, 10, 30);
		timePanel.add(lblNewLabel_2_1_1);
		
		JComboBox sortComboBox_2_1_2 = new JComboBox();
		sortComboBox_2_1_2.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		sortComboBox_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_1_2.setBackground(Color.WHITE);
		sortComboBox_2_1_2.setBounds(105, 137, 74, 30);
		timePanel.add(sortComboBox_2_1_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Month:");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(211, 138, 67, 30);
		timePanel.add(lblNewLabel_2_2_2);
		
		JComboBox sortComboBox_2_1_1_2 = new JComboBox();
		sortComboBox_2_1_1_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		sortComboBox_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_1_1_2.setBackground(Color.WHITE);
		sortComboBox_2_1_1_2.setBounds(278, 137, 74, 30);
		timePanel.add(sortComboBox_2_1_1_2);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Day :");
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_2.setBounds(380, 137, 67, 30);
		timePanel.add(lblNewLabel_2_2_1_2);
		
		JComboBox sortComboBox_2_1_1_1_2 = new JComboBox();
		sortComboBox_2_1_1_1_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		sortComboBox_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_1_1_1_2.setBackground(Color.WHITE);
		sortComboBox_2_1_1_1_2.setBounds(447, 137, 74, 30);
		timePanel.add(sortComboBox_2_1_1_1_2);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Year :");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1_1.setBounds(546, 137, 67, 30);
		timePanel.add(lblNewLabel_2_2_1_1_1);
		
		JComboBox sortComboBox_2_1_1_1_1_1 = new JComboBox();
		sortComboBox_2_1_1_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"2020", "2021", "2022", "2023", "2024", "2025", "2026"}));
		sortComboBox_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_2_1_1_1_1_1.setBackground(Color.WHITE);
		sortComboBox_2_1_1_1_1_1.setBounds(613, 137, 74, 30);
		timePanel.add(sortComboBox_2_1_1_1_1_1);
		
		*/

//====================================================THOI GIAN AP DUNG====================================================================================================

		
		
//===================================================PHAM VI AP DUNG =====================================================================================================
		/*
		JPanel rangePanel = new JPanel();
		rangePanel.setLayout(null);
		rangePanel.setBackground(Color.WHITE);
		rangePanel.setBounds(10, 51, 805, 221);
		panel_2.add(rangePanel);
		rangePanel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 102, 785, 2);
		rangePanel.add(separator);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("All system");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setForeground(Color.BLACK);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(77, 10, 154, 30);
		rangePanel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Branch stores");
		rdbtnNewRadioButton_1_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1_1.setBounds(77, 52, 154, 30);
		rangePanel.add(rdbtnNewRadioButton_1_1);
		
		// neu chon chi nhanh cua hang
		
//		JComboBox sortComboBox_1 = new JComboBox();
//		sortComboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Tran Phu, Ha Dong", "Hai Ba Trung", "Xa Dan", "Pham Ngoc Thach", "Truong Trinh"}));
//		sortComboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		sortComboBox_1.setBackground(Color.WHITE);
//		sortComboBox_1.setBounds(237, 52, 192, 30);
//		rangePanel.add(sortComboBox_1);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("All customers");
		rdbtnNewRadioButton_1_2.setForeground(Color.BLACK);
		rdbtnNewRadioButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1_2.setBounds(76, 122, 154, 30);
		rangePanel.add(rdbtnNewRadioButton_1_2);
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("Customer group");
		rdbtnNewRadioButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1_1_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1_1_1.setBounds(76, 164, 154, 30);
		rangePanel.add(rdbtnNewRadioButton_1_1_1);
		// Neu chon nhom khach hang
		
//		JComboBox sortComboBox_1_1 = new JComboBox();
//		sortComboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Tong san phm da mua tren 1tr", "Tong san phm da mua tren 5tr", "Tong san phm da mua tren 10tr"}));
//		sortComboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		sortComboBox_1_1.setBackground(Color.WHITE);
//		sortComboBox_1_1.setBounds(234, 163, 192, 30);
//		rangePanel.add(sortComboBox_1_1);
//		
		*/
//===================================================PHAM VI AP DUNG ====================================================================================================
		
	}
	
	public boolean checkList(ArrayList<SaleMedia> list) {
		
		System.out.println("sale:'"+list.get(0).sale.getText()+"'");
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).mediaid == 0) return false;
			if(!list.get(i).sale.getText().matches("(\\d+)?")) return false;
			System.out.println("ok");
			if(list.get(i).sale.getText().equals("")) return false;
			System.out.println("ok1");
			if(Integer.parseInt(list.get(i).sale.getText()) > 70) return false;
			System.out.println("ok2");
		}
		return true;
	}
	
}
