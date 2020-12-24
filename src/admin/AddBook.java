package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Manager.AdminApplication;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class AddBook extends AddProduct implements DocumentListener {
	private JTextField nametxt;
	private JTextField authortxt;
	private JTextField nxbtxt;
	private JTextField datetxt;
	private JTextField pagetxt;
	private JTextField theloaitxt;
	AdminApplication adminApplication;
	private JTextField valuetxt;
	private JTextField pricetxt;

	public AddBook(AdminApplication adminApplication) {
		super(adminApplication);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 120, 830, 400);
		addProductPanel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("1. ADD BOOK");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 206, 30);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 39, 810, 332);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Name ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 69, 30);
		panel_2.add(lblNewLabel_1);
		
		nametxt = new JTextField();
		nametxt.setForeground(Color.LIGHT_GRAY);
		nametxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nametxt.setColumns(10);
		nametxt.setBounds(146, 10, 256, 30);
		panel_2.add(nametxt);
		
		JLabel lblNewLabel_2 = new JLabel("Author");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 50, 110, 30);
		panel_2.add(lblNewLabel_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(676, 273, 124, 30);
		panel_2.add(btnAdd);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loai bia");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 90, 110, 30);
		panel_2.add(lblNewLabel_2_1);
		
		authortxt = new JTextField();
		authortxt.setForeground(Color.LIGHT_GRAY);
		authortxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		authortxt.setColumns(10);
		authortxt.setBounds(146, 50, 256, 30);
		panel_2.add(authortxt);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Paperback");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(146, 90, 118, 30);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnHardcover = new JRadioButton("Hardcover");
		rdbtnHardcover.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnHardcover.setBackground(Color.WHITE);
		rdbtnHardcover.setBounds(284, 90, 118, 30);
		panel_2.add(rdbtnHardcover);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Publisher");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 130, 110, 30);
		panel_2.add(lblNewLabel_2_1_1);
		
		nxbtxt = new JTextField();
		nxbtxt.setForeground(Color.LIGHT_GRAY);
		nxbtxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nxbtxt.setColumns(10);
		nxbtxt.setBounds(146, 126, 256, 30);
		panel_2.add(nxbtxt);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Publication Date");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 170, 124, 30);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		datetxt = new JTextField();
		datetxt.setText("mm/dd/yy");
		datetxt.setForeground(Color.LIGHT_GRAY);
		datetxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		datetxt.setColumns(10);
		datetxt.setBounds(146, 170, 256, 30);
		panel_2.add(datetxt);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Pages");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(146, 210, 61, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1);
		
		pagetxt = new JTextField();
		pagetxt.setText("pages");
		pagetxt.setForeground(Color.LIGHT_GRAY);
		pagetxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pagetxt.setColumns(10);
		pagetxt.setBounds(217, 210, 86, 30);
		panel_2.add(pagetxt);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Language");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_1.setBounds(340, 210, 86, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("The Loai");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(576, 210, 75, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1);
		
		theloaitxt = new JTextField();
		theloaitxt.setForeground(Color.LIGHT_GRAY);
		theloaitxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		theloaitxt.setColumns(10);
		theloaitxt.setBounds(661, 210, 139, 30);
		panel_2.add(theloaitxt);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Other");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_2.setBounds(10, 210, 124, 30);
		panel_2.add(lblNewLabel_2_1_1_1_2);
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancel_btn.setBounds(506, 273, 124, 30);
		panel_2.add(cancel_btn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(423, 214, 128, 30);
		panel_2.add(comboBox);
		
		valuetxt = new JTextField();
		valuetxt.setForeground(Color.LIGHT_GRAY);
		valuetxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		valuetxt.setColumns(10);
		valuetxt.setBounds(506, 46, 176, 30);
		panel_2.add(valuetxt);
		
		valuetxt.getDocument().addDocumentListener(this);
		
		JLabel valuelbl = new JLabel("Value");
		valuelbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		valuelbl.setBounds(423, 46, 69, 30);
		panel_2.add(valuelbl);
		
		JLabel pricelbl = new JLabel("Price");
		pricelbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pricelbl.setBounds(423, 101, 69, 30);
		panel_2.add(pricelbl);
		
		pricetxt = new JTextField();
		pricetxt.setEditable(false);
		pricetxt.setForeground(Color.LIGHT_GRAY);
		pricetxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pricetxt.setColumns(10);
		pricetxt.setBounds(506, 101, 176, 30);
		panel_2.add(pricetxt);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImage.setBounds(423, 10, 61, 20);
		panel_2.add(lblImage);
		
		JButton imgButton = new JButton("Choose Image");
		imgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(null);
				String string = fileChooser.getSelectedFile().toString();
				string = string.substring(string.indexOf("img"));
//				validation[4] = string;
			}
		});
		imgButton.setBounds(506, 10, 117, 29);
		panel_2.add(imgButton);

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		int value_int = (int) (Integer.parseInt(valuetxt.getText())*1.1);
		String valueString = String.valueOf(value_int); 
		pricetxt.setText(valueString);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		int value_int = (int) (Integer.parseInt(valuetxt.getText())*1.1);
		String valueString = String.valueOf(value_int); 
		pricetxt.setText(valueString);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
