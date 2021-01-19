package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Manager.AdminApplication;
import Object.Book;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class AddBook extends AddProduct implements DocumentListener, ActionListener {
	
	private JTextField nametxt;
	private JTextField authortxt;
	private JTextField nxbtxt;
	private JTextField datetxt;
	private JTextField pagetxt;
	AdminApplication adminApplication;
	private JTextField valuetxt;
	private JTextField pricetxt;
	private JLabel lable_img;
	private JLabel titlelbl;
	
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnHardcover;
	private ButtonGroup group;
	
	private JComboBox combo_language;
	private JComboBox comboBox_theloai;
	
	private String[] validation;
	private String image;
//	private String theloai;
	private String id_bia = "";
	private int id_media;
	
	private HashMap<String, Integer> languages;
	private HashMap<String, Integer> categorys;
	
	private String id_language = "";
	private String id_theloai = "";

	@SuppressWarnings("rawtypes")
	public AddBook(AdminApplication adminApplication) {
		super(adminApplication);
		
		this.adminApplication = adminApplication;
		
		validation = new String[12];
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 120, 830, 400);
		addProductPanel.add(panel_1);
		
		if (adminApplication.isThem()) {
			titlelbl = new JLabel("1. ADD BOOK");
		}else if (adminApplication.isSua()) {
			titlelbl = new JLabel("1. EDIT BOOK");
		}
		
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
				
				if (adminApplication.isThem() == true && !adminApplication.isSua()) {
					adminApplication.setSua(false);
					
					setValidation();
					
					boolean check = adminApplication.adminController.checkValidate(getValidation());
					
					check = adminApplication.adminController.checkDate(getValidation()[7]);
					
					if (check == false) {
						JOptionPane.showMessageDialog(null, adminApplication.adminController.getErrors(),
								"Add Product", JOptionPane.ERROR_MESSAGE);
						adminApplication.adminController.setErrors("");
						return;
					}
					
					boolean check_media = adminApplication.adminController.createMedia(getValidation());
					boolean check_insert = adminApplication.adminController.create_Book(getValidation());
					boolean check_artists = adminApplication.adminController.create_artists_sangtac(getValidation()[11]);
					
					if (!check_media || !check_artists || !check_insert) {
						JOptionPane.showMessageDialog(null, "Them khong thanh cong",
								"Add Product", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					adminApplication.switchPanel(adminApplication.physicalManagement);
				} else  if (adminApplication.isSua() && !adminApplication.isThem()) {
					setValidation();
					
					boolean check = adminApplication.adminController.checkValidate(getValidation());
					
					if (check == false) {
						JOptionPane.showMessageDialog(null, adminApplication.adminController.getErrors(),
								"Add Product", JOptionPane.ERROR_MESSAGE);
						adminApplication.adminController.setErrors("");
						return;
					}
					
					long price = Long.parseLong(pricetxt.getText());
					int value = Integer.parseInt(valuetxt.getText());
					if (price < value*0.3 || price > value*1.5) {
						JOptionPane.showMessageDialog(null, 
								"Gia ca phai nam trong 30%-150% gia tri", 
								"Edit Message", 
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					adminApplication.adminController.update_book(getValidation(), id_media);
					
				}

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
		
		rdbtnNewRadioButton = new JRadioButton("Paperback");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(146, 90, 118, 30);
		panel_2.add(rdbtnNewRadioButton);
		
		rdbtnHardcover = new JRadioButton("Hardcover");
		rdbtnHardcover.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnHardcover.setBackground(Color.WHITE);
		rdbtnHardcover.setBounds(284, 90, 118, 30);
		panel_2.add(rdbtnHardcover);
		
		group = new ButtonGroup();
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
		datetxt.setText("yyyy-mm-dd");
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
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.setThem(true);
				adminApplication.setSua(true);
				
				clear_display();
				
				adminApplication.switchPanel(adminApplication.productManagement);
			}
		});
		cancel_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancel_btn.setBounds(506, 273, 124, 30);
		panel_2.add(cancel_btn);
		
		combo_language = new JComboBox();
		
		combo_language.setBackground(Color.WHITE);
		combo_language.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combo_language.setBounds(423, 214, 128, 30);
		panel_2.add(combo_language);
		
		combo_language.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = combo_language.getSelectedItem().toString();
				// lay key category
				id_language = Integer.toString(languages.get(value)).trim();
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
		
		lable_img = new JLabel();
		lable_img.setBounds(635, 11, 100, 30);
		panel_2.add(lable_img);
		
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
					lable_img.setText(string);
					image = string;
				}
			}
		});
		imgButton.setBounds(506, 10, 117, 29);
		panel_2.add(imgButton);
		
		comboBox_theloai = new JComboBox();
		comboBox_theloai.setBackground(Color.WHITE);
		comboBox_theloai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_theloai.setBounds(657, 214, 116, 27);
		panel_2.add(comboBox_theloai);
		
		
		comboBox_theloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = comboBox_theloai.getSelectedItem().toString();
				// lay key languages
				id_theloai = Integer.toString(categorys.get(value)).trim();
			}
		});

	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		String patern = "\\d+";
		if (!valuetxt.getText().isEmpty() && valuetxt.isEditable() && valuetxt.getText().matches(patern)) {
			long value_int = (long) (Integer.parseInt(valuetxt.getText())*1.1);
			String valueString = String.valueOf(value_int); 
			pricetxt.setText(valueString);
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Value is number\n");
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		String patern = "\\d+";
		if (!valuetxt.getText().isEmpty() && valuetxt.isEditable() && valuetxt.getText().matches(patern)) {
			long value_int = (long) (Integer.parseInt(valuetxt.getText())*1.1);
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
		this.validation[3] = "1";
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
		
		if ("Paperback".equals(e.getActionCommand())) {
			this.id_bia = "1";
		} else {
			this.id_bia = "2";
		}
		
	}
	
	public void setDisplay(HashMap<String, Integer> languageMap, HashMap<String, Integer> categoryMap) {
		
		languages = languageMap;
		categorys = categoryMap;
		
		int i = 0;
		String[] n_ngu = new String[languages.size()];
		String[] t_loai = new String[categorys.size()];
		
		for (String string : languages.keySet()) {
			n_ngu[i] = string;
			i++;
		}
		i = 0;
		for (String string : categorys.keySet()) {
			t_loai[i] = string;
			i++;
		}
		combo_language.setModel(new DefaultComboBoxModel(n_ngu));
		comboBox_theloai.setModel(new DefaultComboBoxModel(t_loai));
	}
	
	public void setDisplay_Edit(Book book) {
		
		id_media = book.getId();
		
		nametxt.setText(book.getNameString());
		image = book.getImage();
		valuetxt.setEditable(false);
		pricetxt.setEditable(true);
		valuetxt.setText(""+book.getValue());
		valuetxt.setEditable(false);
		pricetxt.setText(""+ book.getPriceFloat());
		lable_img.setText(book.getImage());
		authortxt.setText(book.getTacGiaString());
		nxbtxt.setText(book.getNhaXBString());
		datetxt.setText(book.getNgayXBString());
		pagetxt.setText("" +book.getSotrang());
		
		if ("Paperback".equals(book.getBiaString())) {
			this.id_bia = "1";
			rdbtnNewRadioButton.setSelected(true);
			rdbtnHardcover.setEnabled(false);
		} else {
			this.id_bia = "2";
			rdbtnHardcover.setEnabled(true);
			rdbtnNewRadioButton.setEnabled(false);
			rdbtnHardcover.setSelected(true);
		}
		
		setDisplay(
				adminApplication.adminConnect.getLanguages()
				, 
				adminApplication.adminConnect.getTheLoais(1)
		);
		
		combo_language.setSelectedItem(book.getNgonNguString());
		comboBox_theloai.setSelectedItem(book.getTheloaiString());
	}
	
	public void clear_display() {
		nametxt.setText("");
		image = "";
		lable_img.setText("");
		valuetxt.setText("");
		valuetxt.setEditable(true);
		pricetxt.setText("");
		pricetxt.setEditable(false);
		authortxt.setText("");
		nxbtxt.setText("");
		datetxt.setText("");
		pagetxt.setText("");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnHardcover.setEnabled(true);
		rdbtnNewRadioButton.setEnabled(true);
	}
	
}
