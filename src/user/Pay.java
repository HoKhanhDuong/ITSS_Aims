package user;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import Manager.Application;
import Object.Address;
import productframe.MenuProduct;

import javax.swing.UIManager;

public class Pay extends MenuProduct {
	private JTextField nameTextfield;
	private JTextField phonetextField;
	private JTextField districtText;
	String cityString;
	JPanel panel_5;
	JLabel nameLabel;
	JLabel addressLabel;
	JLabel phoneLabel;
	Address address;
	ArrayList<Address> list;
	/**
	 * Create the panel.
	 */
	public Pay(Application application) {
		super(application);
		setBackground(Color.WHITE);
    
        setLayout(null);
        JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setSize(842, 500);
        scrollPane.setLocation(125, 76);
        scrollPane.setPreferredSize(new Dimension(800, 500));
        add(scrollPane);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setLocation(0, 0);
        panel_1.setPreferredSize(new Dimension(900, 735));
        panel_1.setLayout(null);
        scrollPane.setViewportView(panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 10, 880, 715);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("1. Selecte delivery address");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_1.setBounds(10, 10, 860, 42);
        panel_2.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Choose the shipping address available below:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(10, 62, 761, 23);
        panel_2.add(lblNewLabel_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
        panel_3.setBounds(10, 95, 760, 180);
        panel_2.add(panel_3);
        panel_3.setLayout(null);
        
        nameLabel = new JLabel("Nguyen Thi Thu Phuong");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        nameLabel.setBounds(10, 10, 750, 30);
        panel_3.add(nameLabel);
        
        addressLabel = new JLabel("Address : Thanh Xuyen, Hoang Long, Phu Xuyen, Ha Noi");
        addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        addressLabel.setBounds(10, 50, 750, 30);
        panel_3.add(addressLabel);
        
        phoneLabel = new JLabel("Phone : 0382140588");
        phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        phoneLabel.setBounds(10, 90, 750, 30);
        panel_3.add(phoneLabel);
        
        JButton ship1Button = new JButton("Ship to this address");
        ship1Button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// qua order r ms goi ship money
        		application.payController.makeOrder();
        		
        	}
        });
        ship1Button.setForeground(Color.BLUE);
        ship1Button.setBackground(new Color(51, 51, 204));
        ship1Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ship1Button.setBounds(10, 129, 219, 30);
        panel_3.add(ship1Button);
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		application.payController.deleteAddress(address.getID());
        	}
        });
        deleteButton.setBackground(Color.WHITE);
        deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        deleteButton.setBounds(261, 129, 85, 30);
        panel_3.add(deleteButton);
        
        JButton changeButton = new JButton("Change");
        changeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		changeAddress(application.payController.getNextAddress());
        	}
        });
        changeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        changeButton.setBackground(Color.WHITE);
        changeButton.setBounds(383, 129, 101, 30);
        panel_3.add(changeButton);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new LineBorder(new Color(227, 227, 227)));
        panel_4.setBounds(10, 319, 860, 386);
        panel_2.add(panel_4);
        panel_4.setLayout(null);

        
        panel_5 = new JPanel();
        panel_5.setVisible(false);

        panel_5.setBounds(100, 10, 660, 366);
        panel_4.add(panel_5);
        panel_5.setLayout(null);
        
        JLabel lblNewLabel_7 = new JLabel("Name");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_7.setBounds(10, 10, 85, 30);
        panel_5.add(lblNewLabel_7);
        
        nameTextfield = new JTextField();
        nameTextfield.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameTextfield.setBounds(139, 10, 511, 30);
        panel_5.add(nameTextfield);
        nameTextfield.setColumns(10);
        
        JLabel lblNewLabel_8 = new JLabel("Phone\r\n");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_8.setBounds(10, 50, 85, 30);
        panel_5.add(lblNewLabel_8);
        
        phonetextField = new JTextField();
        phonetextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        phonetextField.setBounds(139, 50, 511, 30);
        panel_5.add(phonetextField);
        phonetextField.setColumns(10);
        
        JLabel lblNewLabel_9 = new JLabel("City");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_9.setBounds(10, 90, 85, 30);
        panel_5.add(lblNewLabel_9);
        
        cityString = "Ha Noi";
        
        JComboBox cityCombo = new JComboBox();
        cityCombo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cityCombo.setModel(new DefaultComboBoxModel(new String[] {"Ha Noi", "Ho Chi Minh", "Other city"}));
        cityCombo.setBackground(Color.WHITE);
        cityCombo.setBounds(139, 90, 511, 30);
        cityCombo.addActionListener (new ActionListener () {
		       public void actionPerformed(ActionEvent e) {
		    	   cityString = cityCombo.getSelectedItem().toString();
		    	   if(cityString == "Other city") {
		    		   cityString = (String)JOptionPane.showInputDialog(new JFrame(), "Enter your city :", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, "");
		    	   }
		       }
        });
        panel_5.add(cityCombo);
        
        JLabel lblNewLabel_10 = new JLabel("District");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_10.setBounds(10, 130, 100, 30);
        panel_5.add(lblNewLabel_10);
        
        districtText = new JTextField();
        districtText.setBounds(139, 130, 511, 30);
        panel_5.add(districtText);
        districtText.setColumns(10);
        
        JLabel lblNewLabel_12 = new JLabel("Address");
        lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_12.setBounds(10, 170, 100, 30);
        panel_5.add(lblNewLabel_12);
        
        JTextArea addressText = new JTextArea();
        addressText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addressText.setBounds(139, 170, 511, 76);
        panel_5.add(addressText);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(SystemColor.controlHighlight);
        cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cancelButton.setBounds(139, 313, 237, 30);
        cancelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_5.setVisible(false);
        	}
        });
        panel_5.add(cancelButton);
        
        JButton ship2Button = new JButton("Ship to this address");
        ship2Button.setForeground(Color.BLUE);
        ship2Button.setBackground(new Color(51, 51, 204));
        ship2Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ship2Button.setBounds(407, 313, 243, 30);
        ship2Button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		application.payController.addAddress(nameTextfield.getText(), phonetextField.getText(), cityString, districtText.getText(), addressText.getText());
        		application.payController.makeOrder();
        	}
        });
        
        panel_5.add(ship2Button);

        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(10, 274, 760, 47);
        panel_2.add(panel_6);
        panel_6.setLayout(null);
        
        JLabel lblNewLabel_2_1 = new JLabel("You want to ship to a different address?");
        lblNewLabel_2_1.setBounds(10, 10, 285, 20);
        panel_6.add(lblNewLabel_2_1);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JButton newAddressButton = new JButton("Add new shipping address");
        newAddressButton.setForeground(Color.BLUE);
        newAddressButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        newAddressButton.setBounds(305, 10, 232, 23);
        newAddressButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_5.setVisible(true);
        	}
        });
        panel_6.add(newAddressButton);
        
        /*
         JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 10, 880, 331);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(10, 351, 880, 293);
        panel_1.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel lblNewLabel_1_1 = new JLabel("2. Product");
        lblNewLabel_1_1.setBounds(10, 10, 860, 31);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel_4.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("ORDER (1 product )");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2_2.setBounds(10, 50, 860, 23);
        panel_4.add(lblNewLabel_2_2);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(Color.WHITE);
        panel_5.setBounds(10, 83, 860, 140);
        panel_4.add(panel_5);
        panel_5.setLayout(null);
        
        JButton btnNewButton_4 = new JButton("Name Product");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton_4.setBackground(Color.WHITE);
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_4.setBounds(10, 10, 480, 30);
        btnNewButton_4.setBorderPainted(false);
        panel_5.add(btnNewButton_4);
        
        JLabel lblNewLabel_7 = new JLabel("x SL");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_7.setBounds(500, 10, 159, 30);
        panel_5.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("110.000 d");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_8.setBounds(669, 10, 181, 30);
        panel_5.add(lblNewLabel_8);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 86, 840, 1);
        panel_5.add(separator);
        
        JLabel lblNewLabel_9 = new JLabel("Into money:");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_9.setBounds(20, 97, 470, 30);
        panel_5.add(lblNewLabel_9);
        
        JLabel lblNewLabel_8_1 = new JLabel("110.000 d");
        lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_8_1.setBounds(669, 97, 181, 30);
        panel_5.add(lblNewLabel_8_1);
        
        JButton btnEdit = new JButton("Edit");
        btnEdit.setBackground(Color.WHITE);
        btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnEdit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnEdit.setBounds(10, 233, 85, 30);
        panel_4.add(btnEdit);
        
        JButton btnNewButton_5 = new JButton("PAY");
        btnNewButton_5.setBounds(620, 654, 259, 30);
        panel_1.add(btnNewButton_5);
        btnNewButton_5.setBackground(new Color(255, 51, 51));
        btnNewButton_5.setForeground(Color.WHITE);
        btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
        */
	}
	public void changeAddress(Address address) {
		this.address = address;
		nameLabel.setText(address.getName());
		phoneLabel.setText(address.getPhone());
		addressLabel.setText(address.getAddress()+", "+address.getDistrict()+", "+address.getCity());
		
	}
}

