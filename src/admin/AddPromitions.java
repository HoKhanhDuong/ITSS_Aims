package admin;

import javax.swing.JPanel;

import Manager.AdminApplication;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JSeparator;

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
		panel_1.setBounds(10, 50, 830, 120);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 9, 76, 30);
		panel_1.add(lblNewLabel);
		
		txtDonNhaDon = new JTextField();
		txtDonNhaDon.setText("Don nha don tet");
		txtDonNhaDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDonNhaDon.setBounds(96, 10, 304, 30);
		panel_1.add(txtDonNhaDon);
		txtDonNhaDon.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Note :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(463, 9, 141, 30);
		panel_1.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.menu);
		//textArea.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		textArea.setLineWrap(true);
		textArea.setEditable(true);
		textArea.setText("");
		textArea.setBounds(463, 40, 357, 70);
		panel_1.add(textArea);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatus.setBounds(10, 70, 76, 30);
		panel_1.add(lblStatus);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Activate");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(96, 70, 103, 30);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNotApplicableYet = new JRadioButton("Not Activate");
		rdbtnNotApplicableYet.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNotApplicableYet.setBounds(246, 70, 159, 30);
		panel_1.add(rdbtnNotApplicableYet);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.control);
		panel_2.setBounds(10, 179, 827, 282);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Promotion Form");
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 10, 224, 30);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Time");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(310, 10, 224, 30);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Range");
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(594, 10, 224, 30);
		panel_2.add(btnNewButton_1_1);
//===============================================================HINH THUC KHUYEN MAI=============================================================================		
	   
		
		JPanel promitionPanel = new JPanel();
		promitionPanel.setBackground(SystemColor.inactiveCaptionBorder);
		promitionPanel.setBounds(10, 51, 805, 221);
		panel_2.add(promitionPanel);
		promitionPanel.setLayout(null);
		
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
		
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Product Groups");
		lblNewLabel_3.setBounds(10, 10, 134, 30);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Discount");
		lblNewLabel_3_1.setBounds(371, 4, 81, 30);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(372, 42, 105, 30);
		textField_1.setColumns(10);
		panel_3.add(textField_1);
		
		JButton btnVnd = new JButton("VND");
		btnVnd.setBounds(491, 43, 50, 30);
		btnVnd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVnd.setBorder(null);
		panel_3.add(btnVnd);
		
		JButton btnVnd_1 = new JButton("%");
		btnVnd_1.setBounds(541, 42, 50, 30);
		btnVnd_1.setBackground(SystemColor.textHighlight);
		btnVnd_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVnd_1.setBorder(null);
		panel_3.add(btnVnd_1);
		
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
		
		
		JButton btnNewButton_2_1 = new JButton("SAVE");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1.setBounds(418, 475, 189, 30);
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Cancel");
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_2.setBounds(623, 475, 189, 30);
		panel.add(btnNewButton_2_2);
		
	}
}
