package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ItemListener;

import Manager.AdminApplication;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class AddCD_LP extends AddProduct implements ActionListener, DocumentListener{

	AdminApplication adminApplication;
	private JTextField recordTXT;
	private JTextField trackTXT;
	private JTextField artistsTXT;
	private JTextField nameTXT;
	
	private String theloai;
	public int id_theloai;
	
	private String[] validation;
	private JTextField valueTXT;
	private JTextField priceTXT;

	public AddCD_LP(AdminApplication adminApplication) {
		
		super(adminApplication);
		
		validation = new String[9];
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 120, 830, 400);
		addProductPanel.add(panel_1);
		
		JLabel lblAddCd = new JLabel("2. ADD CD/LP");
		lblAddCd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddCd.setBounds(10, 10, 206, 30);
		panel_1.add(lblAddCd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 35, 810, 301);
		panel_1.add(panel_2);
		
		JLabel lblTheLoai = new JLabel("The loai");
		lblTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTheLoai.setBounds(477, 155, 61, 30);
		panel_2.add(lblTheLoai);
		
		JLabel lblRecord = new JLabel("Record Label");
		lblRecord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRecord.setBounds(6, 142, 110, 30);
		panel_2.add(lblRecord);
		
		recordTXT = new JTextField();
		recordTXT.setForeground(Color.LIGHT_GRAY);
		recordTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		recordTXT.setColumns(10);
		recordTXT.setBounds(142, 142, 250, 30);
		panel_2.add(recordTXT);
		
		JLabel lblTrack = new JLabel("Tracklist");
		lblTrack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTrack.setBounds(6, 181, 110, 30);
		panel_2.add(lblTrack);
		
		trackTXT = new JTextField();
		trackTXT.setForeground(Color.LIGHT_GRAY);
		trackTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		trackTXT.setColumns(10);
		trackTXT.setBounds(142, 181, 250, 30);
		panel_2.add(trackTXT);
		
		JLabel lblArtists = new JLabel("Artists");
		lblArtists.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblArtists.setBounds(6, 111, 110, 30);
		panel_2.add(lblArtists);
		
		artistsTXT = new JTextField();
		artistsTXT.setForeground(Color.LIGHT_GRAY);
		artistsTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		artistsTXT.setColumns(10);
		artistsTXT.setBounds(142, 111, 250, 30);
		panel_2.add(artistsTXT);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(6, 71, 124, 30);
		panel_2.add(lblName);
		
		nameTXT = new JTextField();
		nameTXT.setForeground(Color.LIGHT_GRAY);
		nameTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameTXT.setColumns(10);
		nameTXT.setBounds(142, 71, 250, 30);
		panel_2.add(nameTXT);
		
		JRadioButton cdRadio = new JRadioButton("CD");
		cdRadio.setBounds(142, 6, 61, 23);
		panel_2.add(cdRadio);
		
		JRadioButton lpRadio = new JRadioButton("LP");
		lpRadio.setBounds(248, 6, 61, 23);
		panel_2.add(lpRadio);
// cho vao 1 group
		ButtonGroup group = new ButtonGroup();
		group.add(cdRadio);
		group.add(lpRadio);
		
// dang ky 1 bo lang nghe
		cdRadio.addActionListener(this);
		lpRadio.addActionListener(this);
		
		JButton btnAdd = new JButton("Add");
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
				boolean check_add = adminApplication.adminController.createCD_LP(getValidation());
				boolean check_artists = adminApplication.adminController.create_artists_sangtac(getValidation());
				boolean check_listtrack = adminApplication.adminController.create_listTrack(trackTXT.getText());
				
				if (!check_media || !check_artists || !check_add || !check_listtrack) {
					JOptionPane.showMessageDialog(null, "Them khong thanh cong",
							"Add Product", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				adminApplication.setSua(true);
				
				adminApplication.switchPanel(adminApplication.physicalManagement);
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(676, 254, 124, 30);
		panel_2.add(btnAdd);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminApplication.setThem(true);
				adminApplication.setSua(true);
				
				adminApplication.switchPanel(adminApplication.productManagement);
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelButton.setBounds(540, 254, 124, 30);
		panel_2.add(cancelButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = comboBox.getSelectedItem().toString();
				if (value.equals("C-POP")) {
					id_theloai = 1;
				} else if (value.equals("K-POP")) {
					id_theloai = 2;
				} else if (value.equals("US-UK")) {
					id_theloai = 3;
				}
			}
		});
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"C-POP", "K-POP", "US-UK"}));
		comboBox.setBounds(550, 156, 128, 30);
		panel_2.add(comboBox);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setBounds(6, 41, 61, 16);
		panel_2.add(lblImage);
		
		JButton imgButton = new JButton("Choose Image");
		imgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(null);
				if (fileChooser.getSelectedFile() != null) {
					String string = fileChooser.getSelectedFile().toString();
					string = string.substring(string.indexOf("img"));
					validation[4] = string;
				}
				
			}
		});
		imgButton.setBounds(142, 41, 117, 29);
		panel_2.add(imgButton);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValue.setBounds(477, 71, 51, 30);
		panel_2.add(lblValue);
		
		valueTXT = new JTextField();
		valueTXT.setForeground(Color.LIGHT_GRAY);
		valueTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		valueTXT.setColumns(10);
		valueTXT.setBounds(540, 71, 250, 30);
		panel_2.add(valueTXT);
		
		valueTXT.getDocument().addDocumentListener(this);
		
		priceTXT = new JTextField();
		priceTXT.setForeground(Color.LIGHT_GRAY);
		priceTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		priceTXT.setColumns(10);
		priceTXT.setBounds(540, 113, 250, 30);
		panel_2.add(priceTXT);
		
		priceTXT.setEditable(false);
		
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrice.setBounds(477, 113, 51, 30);
		panel_2.add(lblPrice);
		
		JLabel lblCho = new JLabel("Chosse");
		lblCho.setBounds(6, 10, 61, 16);
		panel_2.add(lblCho);
			
	}

	public String getTheloai() {
		return theloai;
	}

	public void setTheloai(String theloai) {
		this.theloai = theloai;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if ("CD".equals(e.getActionCommand())) {
			this.theloai = "2";
		} else {
			this.theloai = "4";
		}
		
	}

	public String[] getValidation() {
		return validation;
	}

	public void setValidation() {
		this.validation[0] = nameTXT.getText();
		this.validation[1] = valueTXT.getText();
		this.validation[2] = priceTXT.getText();
		this.validation[3] = getTheloai();
		this.validation[5] = artistsTXT.getText();
		this.validation[6] = recordTXT.getText();
		this.validation[7] = trackTXT.getText();
		this.validation[8] = ""+id_theloai;
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		int value_int = (int) (Integer.parseInt(valueTXT.getText())*1.1);
		String valueString = String.valueOf(value_int); 
		priceTXT.setText(valueString);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		int value_int = (int) (Integer.parseInt(valueTXT.getText())*1.1);
		String valueString = String.valueOf(value_int); 
		priceTXT.setText(valueString);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
	}
}
