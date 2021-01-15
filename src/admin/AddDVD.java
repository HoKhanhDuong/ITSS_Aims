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

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
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

	private String[] validation;
	private String image;
	private String id_theloai = "";
	private String id_language = "";
	private String id_dia = "";
	
	public AddDVD(AdminApplication adminApplication) {
		
		super(adminApplication);
		
		validation = new String[12];
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 120, 830, 369);
		addProductPanel.add(panel_1);
		
		JLabel lblAddDvd = new JLabel("3. ADD DVD");
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Blu-ray");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(545, 49, 118, 30);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnHardcover = new JRadioButton("HD-DVD");
		rdbtnHardcover.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnHardcover.setBackground(Color.WHITE);
		rdbtnHardcover.setBounds(673, 49, 118, 30);
		panel_2.add(rdbtnHardcover);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnHardcover);
		
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnHardcover.addActionListener(this);
		
		JButton btnAdd = new JButton("Next");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adminApplication.isThem() == true) {
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
					boolean check_insert = adminApplication.adminController.create_DVD(getValidation());
					boolean check_artists = adminApplication.adminController.create_artists_sangtac(getValidation());
					
					if (!check_media || !check_artists || !check_insert) {
						JOptionPane.showMessageDialog(null, "Them khong thanh cong",
								"Add Product", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					adminApplication.switchPanel(adminApplication.physicalManagement);
				} else {
					JOptionPane.showMessageDialog(null, 
							"He thong dang trong trang thai sua\n", 
							"Trang thai", 
							JOptionPane.ERROR_MESSAGE);
				}
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
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("The loai");
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
				
			}
		});
		imgButton.setBounds(546, 13, 117, 29);
		panel_2.add(imgButton);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImage.setBounds(446, 11, 61, 20);
		panel_2.add(lblImage);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Vietnamese", "English", "Japanese"}));
		comboBox.setBounds(99, 134, 198, 27);
		panel_2.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = comboBox.getSelectedItem().toString();
				switch (value) {
				case "Vietnamese":
					id_language = "1";
					break;
				case "English":
					id_language = "2";
					break;
				case "Japanese":
					id_language = "3";
					break;
				default:
					break;
				}
			}
		});
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Phim le", "Phim bo"}));
		comboBox_1.setBounds(99, 176, 198, 27);
		panel_2.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = comboBox_1.getSelectedItem().toString();
				switch (value) {
					case "Phim le":
						id_theloai = "12";
						break;
					case "Phim bo":
						id_theloai = "13";
						break;
					default:
						break;
				}
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
