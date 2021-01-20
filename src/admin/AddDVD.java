package admin;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Manager.AdminApplication;
import Object.DVD;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class AddDVD extends AddProduct implements DocumentListener, ActionListener {
	private JTextField nametxt;
	private JTextField directortxt;
	private JTextField runtimetxt;
	private JTextField studiotxt;
	private JTextField subtitletxt;
	AdminApplication adminApplication;
	private JTextField valuetxt;
	private JTextField pricetxt;
	private JLabel lblAddDvd;
	private JLabel lblImg;
	
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnHardcover;
	private ButtonGroup group;
	
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	
	private HashMap<String, Integer> languages;
	private HashMap<String, Integer> categorys;

	private String[] validation;
	private String image;
	private String id_theloai = "";
	private String id_language = "";
	private String id_dia = "";
	
	private int media_id;
	
	public AddDVD(AdminApplication adminApplication) {
		
		super(adminApplication);
		this.adminApplication = adminApplication;
		
		validation = new String[12];
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 120, 830, 369);
		addProductPanel.add(panel_1);
		
		if (adminApplication.isThem()) {
			lblAddDvd = new JLabel("3. ADD DVD");
		}else if (adminApplication.isSua()) {
			lblAddDvd = new JLabel("3. EDIT DVD");
		}
		
		lblAddDvd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddDvd.setBounds(10, 10, 206, 30);
		panel_1.add(lblAddDvd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 50, 814, 313);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Name ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 79, 30);
		panel_2.add(lblNewLabel_1);
		
		nametxt = new JTextField();
		nametxt.setForeground(Color.LIGHT_GRAY);
		nametxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nametxt.setColumns(10);
		nametxt.setBounds(99, 10, 324, 30);
		panel_2.add(nametxt);
		
		JLabel dialbl = new JLabel("Disk type");
		dialbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dialbl.setBounds(446, 49, 110, 30);
		panel_2.add(dialbl);
		
		rdbtnNewRadioButton = new JRadioButton("Blu-ray");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(545, 49, 118, 30);
		panel_2.add(rdbtnNewRadioButton);
		
		rdbtnHardcover = new JRadioButton("HD-DVD");
		rdbtnHardcover.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnHardcover.setBackground(Color.WHITE);
		rdbtnHardcover.setBounds(673, 49, 118, 30);
		panel_2.add(rdbtnHardcover);
		
		group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnHardcover);
		
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnHardcover.addActionListener(this);
		
		JButton btnAdd = new JButton("Next");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adminApplication.isThem() == true && !adminApplication.isSua()) {
					adminApplication.setSua(false);
					
					setValidation();
					
					boolean check = adminApplication.adminController.checkValidate(getValidation());
					
					if (check == false) {
						JOptionPane.showMessageDialog(null, adminApplication.adminController.getErrors(),
								"Add Product", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					boolean check_media = adminApplication.adminController.createMedia(getValidation());
					boolean check_insert = adminApplication.adminController.create_DVD(getValidation());
					boolean check_artists = adminApplication.adminController.create_artists_sangtac(getValidation()[11]);
					
					if (!check_media || !check_artists || !check_insert) {
						JOptionPane.showMessageDialog(null, "Them khong thanh cong",
								"Add Product", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					adminApplication.switchPanel(adminApplication.physicalManagement);
				} else if (adminApplication.isSua() && !adminApplication.isThem()) {
					setValidation();
					
					boolean check = adminApplication.adminController.checkValidate(getValidation());
					
					if (check == false) {
						JOptionPane.showMessageDialog(null, adminApplication.adminController.getErrors(),
								"Add Product", JOptionPane.ERROR_MESSAGE);
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
					
					adminApplication.adminController.update_dvd(getValidation(), media_id);
		
					
				}
				
//				{
//					JOptionPane.showMessageDialog(null, 
//							"He thong dang trong trang thai sua\n", 
//							"Trang thai", 
//							JOptionPane.ERROR_MESSAGE);
//				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(676, 277, 124, 30);
		panel_2.add(btnAdd);
		
		JLabel lblNewLabel_2_1 = new JLabel("Director");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 50, 79, 30);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Runtime");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 90, 79, 30);
		panel_2.add(lblNewLabel_2_1_1);
		
		directortxt = new JTextField();
		directortxt.setForeground(Color.LIGHT_GRAY);
		directortxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		directortxt.setColumns(10);
		directortxt.setBounds(99, 50, 324, 30);
		panel_2.add(directortxt);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Category");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(10, 172, 79, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1);
		
		JButton cancelbtn = new JButton("Cancel");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.setThem(true);
				adminApplication.setSua(true);
				
				adminApplication.switchPanel(adminApplication.productManagement);
			}
		});
		cancelbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelbtn.setBounds(540, 277, 124, 30);
		panel_2.add(cancelbtn);
		
		runtimetxt = new JTextField();
		runtimetxt.setForeground(Color.LIGHT_GRAY);
		runtimetxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		runtimetxt.setColumns(10);
		runtimetxt.setBounds(99, 90, 324, 30);
		panel_2.add(runtimetxt);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Studio");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(446, 90, 93, 30);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		studiotxt = new JTextField();
		studiotxt.setForeground(Color.LIGHT_GRAY);
		studiotxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		studiotxt.setColumns(10);
		studiotxt.setBounds(546, 90, 254, 30);
		panel_2.add(studiotxt);
		
		JLabel lblNewLabel_2_1_1_1_3 = new JLabel("Language");
		lblNewLabel_2_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_3.setBounds(10, 130, 79, 30);
		panel_2.add(lblNewLabel_2_1_1_1_3);
		
		subtitletxt = new JTextField();
		subtitletxt.setForeground(Color.LIGHT_GRAY);
		subtitletxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		subtitletxt.setColumns(10);
		subtitletxt.setBounds(546, 130, 254, 30);
		panel_2.add(subtitletxt);
		
		JLabel lblNewLabel_2_1_1_1_4 = new JLabel("Subtitles");
		lblNewLabel_2_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_4.setBounds(446, 130, 93, 30);
		panel_2.add(lblNewLabel_2_1_1_1_4);
		
		JButton imgButton = new JButton("Choose Image");
		imgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(null);
				String string = fileChooser.getSelectedFile().toString();
				image = string.substring(string.indexOf("img"));
				lblImg.setText(image);
			}
		});
		imgButton.setBounds(546, 13, 117, 30);
		panel_2.add(imgButton);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImage.setBounds(446, 11, 61, 20);
		panel_2.add(lblImage);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboBox.setBounds(99, 134, 198, 27);
		panel_2.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = comboBox.getSelectedItem().toString();
				id_language = Integer.toString(languages.get(value)).trim();
			}
		});
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setBounds(99, 176, 198, 27);
		panel_2.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = comboBox_1.getSelectedItem().toString();
				id_theloai = Integer.toString(categorys.get(value)).trim();
			}
		});
		
		JLabel lblNewLabel_2_1_1_1_4_1 = new JLabel("Value");
		lblNewLabel_2_1_1_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_4_1.setBounds(446, 170, 93, 30);
		panel_2.add(lblNewLabel_2_1_1_1_4_1);
		
		JLabel lblNewLabel_2_1_1_1_4_2 = new JLabel("Price");
		lblNewLabel_2_1_1_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_4_2.setBounds(446, 212, 93, 30);
		panel_2.add(lblNewLabel_2_1_1_1_4_2);
		
		valuetxt = new JTextField();
		valuetxt.setForeground(Color.LIGHT_GRAY);
		valuetxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		valuetxt.setColumns(10);
		valuetxt.setBounds(546, 173, 254, 30);
		panel_2.add(valuetxt);
		
		valuetxt.getDocument().addDocumentListener(this);
		
		pricetxt = new JTextField();
		pricetxt.setForeground(Color.LIGHT_GRAY);
		pricetxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pricetxt.setColumns(10);
		pricetxt.setBounds(546, 215, 254, 30);
		panel_2.add(pricetxt);
		pricetxt.setEditable(false);
		
		lblImg = new JLabel("");
		lblImg.setBounds(663, 11, 145, 30);
		panel_2.add(lblImg);

	}

	public String[] getValidation() {
		return validation;
	}
	
	public void setValidation() {
		// media
				this.validation[0] = nametxt.getText();
				this.validation[1] = valuetxt.getText();
				this.validation[2] = pricetxt.getText();
				this.validation[3] = "2";
				this.validation[4] = image;
		// book
				this.validation[5] = id_dia;
				this.validation[6] = runtimetxt.getText();
				this.validation[7] = studiotxt.getText();
				this.validation[8] = id_language;
				this.validation[9] = id_theloai;
				this.validation[10] = subtitletxt.getText();
		// sang gia
				this.validation[11] = directortxt.getText();
			}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if ("Blu-ray".equals(e.getActionCommand())) {
			this.id_dia = "1";
		} else {
			this.id_dia = "2";
		}
		
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
	
	public void display(HashMap<String, Integer> languageMap, HashMap<String, Integer> categoryMap) {
		languages = languageMap;
		categorys = categoryMap;
		
		int i = 0;
		String[] language_array = new String[languages.size()];
		String[] category_array = new String[categorys.size()];
		
		for (String string : languages.keySet()) {
			language_array[i] = string;
			i++;
		}
		i = 0;
		for (String string : categorys.keySet()) {
			category_array[i] = string;
			i++;
		}
		
		
		comboBox.setModel(new DefaultComboBoxModel(language_array));
		comboBox_1.setModel(new DefaultComboBoxModel(category_array));
	}
	
	public void display_edit(DVD dvd) {
		
		media_id = dvd.getId();
		nametxt.setText(dvd.getNameString());
		valuetxt.setEditable(false);
		valuetxt.setText(""+ dvd.getValue());
		pricetxt.setEditable(true);
		pricetxt.setText(""+ dvd.getPriceFloat());
		image = dvd.getImage();
		lblImg.setText(image);
		directortxt.setText(dvd.getDaoDienString());
		runtimetxt.setText(""+ dvd.getThoiLuong());
		studiotxt.setText(dvd.getStudioString());
		subtitletxt.setText(dvd.getPhudeString());
		
		if ("Blu-ray".equals(dvd.getKieuDia())) {
			this.id_dia = "1";
			rdbtnNewRadioButton.setEnabled(true);
			rdbtnNewRadioButton.setSelected(true);
			rdbtnHardcover.setEnabled(false);
		} else {
			this.id_dia = "2";
			rdbtnNewRadioButton.setEnabled(false);
			rdbtnHardcover.setSelected(true);
			rdbtnHardcover.setEnabled(true);
		}
		
		display(
				adminApplication.adminConnect.getLanguages()
				, 
				adminApplication.adminConnect.getTheLoais(2)
		);
		
		comboBox.setSelectedItem(dvd.getNgonNguString());
		comboBox_1.setSelectedItem(dvd.getTheLoaiString());
		
	}
	
	public void clear_display() {
		media_id = 0;
		nametxt.setText("");
		valuetxt.setEditable(true);
		valuetxt.setText("");
		pricetxt.setEditable(false);
		pricetxt.setText("");
		image = "";
		lblImg.setText(image);
		directortxt.setText("");
		runtimetxt.setText("");
		studiotxt.setText("");
		subtitletxt.setText("");
	}
}
