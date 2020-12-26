package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Manager.AdminApplication;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class AddBook extends AddProduct {
	private JTextField name;
	private JTextField author;
	private JTextField publisher;
	private JTextField publicationDate;
	private JTextField pages;
	private JTextField language;
	private JTextField theloai;
	AdminApplication adminApplication;
	private JTextField Value;
	private JTextField Price;

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
		lblNewLabel_1.setBounds(10, 10, 124, 30);
		panel_2.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setText("name");
		name.setForeground(Color.LIGHT_GRAY);
		name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		name.setColumns(10);
		name.setBounds(146, 10, 654, 30);
		panel_2.add(name);
		
		JLabel lblNewLabel_2 = new JLabel("Author");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 50, 110, 30);
		panel_2.add(lblNewLabel_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(676, 273, 124, 30);
		panel_2.add(btnAdd);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cover type");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 90, 110, 30);
		panel_2.add(lblNewLabel_2_1);
		
		author = new JTextField();
		author.setText("name");
		author.setForeground(Color.LIGHT_GRAY);
		author.setFont(new Font("Tahoma", Font.PLAIN, 16));
		author.setColumns(10);
		author.setBounds(146, 50, 654, 30);
		panel_2.add(author);
		
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
		
		publisher = new JTextField();
		publisher.setText("name");
		publisher.setForeground(Color.LIGHT_GRAY);
		publisher.setFont(new Font("Tahoma", Font.PLAIN, 16));
		publisher.setColumns(10);
		publisher.setBounds(146, 126, 175, 30);
		panel_2.add(publisher);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Publication Date");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(10, 170, 124, 30);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		publicationDate = new JTextField();
		publicationDate.setText("mm/dd/yy");
		publicationDate.setForeground(Color.LIGHT_GRAY);
		publicationDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		publicationDate.setColumns(10);
		publicationDate.setBounds(146, 170, 654, 30);
		panel_2.add(publicationDate);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Pages");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(146, 210, 61, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1);
		
		pages = new JTextField();
		pages.setText("pages");
		pages.setForeground(Color.LIGHT_GRAY);
		pages.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pages.setColumns(10);
		pages.setBounds(217, 210, 86, 30);
		panel_2.add(pages);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Language");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_1.setBounds(340, 210, 86, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1_1);
		
		language = new JTextField();
		language.setText("language");
		language.setForeground(Color.LIGHT_GRAY);
		language.setFont(new Font("Tahoma", Font.PLAIN, 16));
		language.setColumns(10);
		language.setBounds(436, 210, 110, 30);
		panel_2.add(language);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Category");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(576, 210, 75, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1_1_1);
		
		theloai = new JTextField();
		theloai.setForeground(Color.LIGHT_GRAY);
		theloai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		theloai.setColumns(10);
		theloai.setBounds(661, 210, 139, 30);
		panel_2.add(theloai);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Other");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_2.setBounds(10, 210, 124, 30);
		panel_2.add(lblNewLabel_2_1_1_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Cance");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(506, 273, 124, 30);
		panel_2.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_2 = new JLabel("Value");
		lblNewLabel_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_2.setBounds(354, 126, 56, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1_2);
		
		Value = new JTextField();
		Value.setForeground(Color.LIGHT_GRAY);
		Value.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Value.setColumns(10);
		Value.setBounds(416, 126, 121, 30);
		panel_2.add(Value);
		
		JLabel lblNewLabel_2_1_1_1_1_2_1 = new JLabel("Price");
		lblNewLabel_2_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_2_1.setBounds(559, 126, 56, 30);
		panel_2.add(lblNewLabel_2_1_1_1_1_2_1);
		
		Price = new JTextField();
		Price.setForeground(Color.LIGHT_GRAY);
		Price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Price.setColumns(10);
		Price.setBounds(621, 126, 121, 30);
		panel_2.add(Price);

	}
}
