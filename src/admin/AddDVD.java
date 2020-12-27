package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Manager.AdminApplication;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDVD extends AddProduct implements DocumentListener {
	private JTextField nametxt;
	private JTextField disktypetxt;
	private JTextField directortxt;
	private JTextField textField_3;
	private JTextField runtimetxt;
	private JTextField studiotxt;
	private JTextField subtitletxt;
	AdminApplication adminApplication;
	private JTextField valuetxt;
	private JTextField pricetxt;


	public AddDVD(AdminApplication adminApplication) {
		
		super(adminApplication);
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
		
		JLabel lblNewLabel_2 = new JLabel("Disk Type");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(446, 50, 93, 30);
		panel_2.add(lblNewLabel_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(676, 277, 124, 30);
		panel_2.add(btnAdd);
		
		JLabel lblNewLabel_2_1 = new JLabel("Director");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 50, 79, 30);
		panel_2.add(lblNewLabel_2_1);
		
		disktypetxt = new JTextField();
		disktypetxt.setForeground(Color.LIGHT_GRAY);
		disktypetxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		disktypetxt.setColumns(10);
		disktypetxt.setBounds(546, 50, 254, 30);
		panel_2.add(disktypetxt);
		
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
		lblNewLabel_2_1_1_1_1.setBounds(10, 212, 79, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setText("pages");
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(99, 130, 324, 30);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Ngay Ph");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_2.setBounds(10, 130, 79, 30);
		panel_2.add(lblNewLabel_2_1_1_1_2);
		
		JButton cancelbtn = new JButton("Cancel");
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
		lblNewLabel_2_1_1_1_3.setBounds(10, 170, 79, 30);
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
				string = string.substring(string.indexOf("img"));
//				validation[4] = string;
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"C-POP", "K-POP", "US-UK"}));
		comboBox.setBounds(99, 174, 198, 27);
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"C-POP", "K-POP", "US-UK"}));
		comboBox_1.setBounds(99, 216, 198, 27);
		panel_2.add(comboBox_1);
		
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
