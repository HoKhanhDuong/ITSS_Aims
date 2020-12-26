package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Manager.AdminApplication;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class AddBook extends AddProduct implements DocumentListener, ActionListener {
	
	private JTextField nametxt;
	private JTextField authortxt;
	private JTextField nxbtxt;
	private JTextField datetxt;
	private JTextField pagetxt;
	AdminApplication adminApplication;
	private JTextField valuetxt;
	private JTextField pricetxt;
	
	private String[] validation;
	private String image;
	private String theloai;
	private String id_bia = "";
	
	private String id_language = "";
	private String id_theloai = "";

	@SuppressWarnings("rawtypes")
	public AddBook(AdminApplication adminApplication) {
		super(adminApplication);
		
		validation = new String[12];
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 120, 830, 400);
		addProductPanel.add(panel_1);
		
		JLabel titlelbl = new JLabel("1. ADD BOOK");
		titlelbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		titlelbl.setBounds(10, 10, 206, 30);
		panel_1.add(titlelbl);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 39, 810, 332);
		panel_1.add(panel_2);
		
		JLabel namelbl = new JLabel("Name ");
		namelbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		namelbl.setBounds(10, 10, 69, 30);
		panel_2.add(namelbl);
		
		nametxt = new JTextField();
		nametxt.setForeground(Color.LIGHT_GRAY);
		nametxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nametxt.setColumns(10);
		nametxt.setBounds(146, 10, 256, 30);
		panel_2.add(nametxt);
		
		JLabel authorlbl = new JLabel("Author");
		authorlbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		authorlbl.setBounds(10, 50, 110, 30);
		panel_2.add(authorlbl);
		

		JButton btnAdd = new JButton("Next");

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.setThem(true);
				adminApplication.setSua(false);
				
				setValidation();
				
				boolean check = adminApplication.adminController.checkValidate(getValidation());
				
				if (check == false) {
					JOptionPane.showMessageDialog(null, adminApplication.adminController.getErrors(),
							"Add Product", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				boolean check_media = adminApplication.adminController.createMedia(getValidation());
				boolean check_insert = adminApplication.adminController.create_Book(getValidation());
				boolean check_artists = adminApplication.adminController.create_artists_sangtac(getValidation());
				
				if (!check_media || !check_artists || !check_insert) {
					JOptionPane.showMessageDialog(null, "Them khong thanh cong",
							"Add Product", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				adminApplication.setSua(true);
				
				adminApplication.switchPanel(adminApplication.productManagement);
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(676, 273, 124, 30);
		panel_2.add(btnAdd);
		
		JLabel bialbl = new JLabel("Loai bia");
		bialbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bialbl.setBounds(10, 90, 110, 30);
		panel_2.add(bialbl);
		
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
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnHardcover);
		
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnHardcover.addActionListener(this);
		
		JLabel publisherlbl = new JLabel("Publisher");
		publisherlbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		publisherlbl.setBounds(10, 130, 110, 30);
		panel_2.add(publisherlbl);
		
		nxbtxt = new JTextField();
		nxbtxt.setForeground(Color.LIGHT_GRAY);
		nxbtxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nxbtxt.setColumns(10);
		nxbtxt.setBounds(146, 126, 256, 30);
		panel_2.add(nxbtxt);
		
		JLabel datelbl = new JLabel("Publication Date");
		datelbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		datelbl.setBounds(10, 170, 124, 30);
		panel_2.add(datelbl);
		
		datetxt = new JTextField();
		datetxt.setText("mm/dd/yy");
		datetxt.setForeground(Color.LIGHT_GRAY);
		datetxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		datetxt.setColumns(10);
		datetxt.setBounds(146, 170, 256, 30);
		panel_2.add(datetxt);
		
		JLabel pagelbl = new JLabel("Pages");
		pagelbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pagelbl.setBounds(146, 210, 61, 30);
		panel_2.add(pagelbl);
		
		pagetxt = new JTextField();
		pagetxt.setText("pages");
		pagetxt.setForeground(Color.LIGHT_GRAY);
		pagetxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pagetxt.setColumns(10);
		pagetxt.setBounds(217, 210, 86, 30);
		panel_2.add(pagetxt);
		
		JLabel languagelbl = new JLabel("Language");
		languagelbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		languagelbl.setBounds(340, 210, 86, 30);
		panel_2.add(languagelbl);
		
		JLabel theloailbl = new JLabel("The Loai");
		theloailbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		theloailbl.setBounds(576, 210, 69, 30);
		panel_2.add(theloailbl);
		
		JLabel otherlbl = new JLabel("Other");
		otherlbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		otherlbl.setBounds(10, 210, 124, 30);
		panel_2.add(otherlbl);
		
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancel_btn.setBounds(506, 273, 124, 30);
		panel_2.add(cancel_btn);
		
		JComboBox combo_language = new JComboBox();
		
		combo_language.setBackground(Color.WHITE);
		combo_language.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combo_language.setModel(new DefaultComboBoxModel(new String[] {"C-POP", "K-POP", "US-UK"}));
		combo_language.setBounds(423, 214, 128, 30);
		panel_2.add(combo_language);
		
		combo_language.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = combo_language.getSelectedItem().toString();
				switch (value) {
					case "":
						id_language = "1";
						break;
					default:
						break;
				}
			}
		});
		
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
				if (fileChooser.getSelectedFile() != null) {
					String string = fileChooser.getSelectedFile().toString();
					string = string.substring(string.indexOf("img"));
					
					image = string;
				}
			}
		});
		imgButton.setBounds(506, 10, 117, 29);
		panel_2.add(imgButton);
		
		JComboBox comboBox_theloai = new JComboBox();
		comboBox_theloai.setBackground(Color.WHITE);
		comboBox_theloai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_theloai.setModel(new DefaultComboBoxModel(new String[] {"C-POP", "K-POP", "US-UK"}));
		comboBox_theloai.setBounds(657, 214, 116, 27);
		panel_2.add(comboBox_theloai);
		
		comboBox_theloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = comboBox_theloai.getSelectedItem().toString();
				switch (value) {
					case "":
						id_theloai = "1";
						break;
					default:
						break;
				}
			}
		});

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if (valuetxt.getText() != "") {
			int value_int = (int) (Integer.parseInt(valuetxt.getText())*1.1);
			String valueString = String.valueOf(value_int); 
			pricetxt.setText(valueString);
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if (valuetxt.getText() != "") {
			int value_int = (int) (Integer.parseInt(valuetxt.getText())*1.1);
			String valueString = String.valueOf(value_int); 
			pricetxt.setText(valueString);
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public String[] getValidation() {
		return validation;
	}

	public void setValidation() {
// media
		this.validation[0] = nametxt.getText();
		this.validation[1] = valuetxt.getText();
		this.validation[2] = pricetxt.getText();
		this.validation[3] = valuetxt.getText();
		this.validation[4] = image;
// book
		this.validation[5] = id_bia;
		this.validation[6] = nxbtxt.getText();
		this.validation[7] = datetxt.getText();
		this.validation[8] = pagetxt.getText();
		this.validation[9] = id_language;
		this.validation[10] = id_theloai;
// tac gia
		this.validation[11] = authortxt.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if ("CD".equals(e.getActionCommand())) {
			this.id_bia = "1";
		} else {
			this.id_bia = "2";
		}
		
	}
}
