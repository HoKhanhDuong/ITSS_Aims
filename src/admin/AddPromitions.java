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

	private JTextField txtDonNhaDon;
	private JTextField text2;
	private JTextField textField_6;
	private JTextField text3;
	private JTextField text1;
	private JTextField text4;
	private JTextField text5;
	private JLabel totalbill;
	private JLabel gift;
	private JLabel from1;
	private JLabel from2;
	private JLabel from3;
	private JComboBox voucher1;
	private JComboBox voucher2;
	private JComboBox voucher3;
	private JTextField textField;
	private JTextField textField_1;

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
		
				JLabel lblstart = new JLabel("Start time :");
				lblstart.setBounds(10, 51, 109, 30);
				panel_1.add(lblstart);
				lblstart.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
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
		
		JLabel lblNewLabel_3_1 = new JLabel("Discount");
		lblNewLabel_3_1.setBounds(371, 11, 81, 30);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		promitionPanel.add(lblNewLabel_3_1);
		
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
		
		
		JLabel lblNewLabel_2 = new JLabel("Promotion according to ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 10, 179, 30);
		promitionPanel.add(lblNewLabel_2);
		
		JComboBox sortComboBox = new JComboBox();
		sortComboBox.setBounds(192, 9, 128, 30);
		promitionPanel.add(sortComboBox);
		sortComboBox.setBackground(Color.WHITE);
		sortComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Product"}));
		
		JLabel lblNewLabel_2_1 = new JLabel("Form\r\n");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(397, 10, 92, 30);
		promitionPanel.add(lblNewLabel_2_1);
		
		JComboBox sortComboBox_1 = new JComboBox();
		sortComboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Discount"}));
		sortComboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox_1.setBackground(Color.WHITE);
		sortComboBox_1.setBounds(504, 9, 128, 30);
		promitionPanel.add(sortComboBox_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 52, 804, 170);
		promitionPanel.add(panel_3);


		
		

		
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Product Groups");
		lblNewLabel_3.setBounds(10, 10, 134, 30);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel_3_2 = new JLabel("Name Product");
		lblNewLabel_3_2.setBounds(173, 10, 134, 30);
		panel_3.add(lblNewLabel_3_2);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
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
