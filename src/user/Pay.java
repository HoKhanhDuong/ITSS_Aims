package user;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class Pay extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Pay() {
		setBackground(Color.WHITE);
        setSize(1100,1000);
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 1100, 100);
        add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("S2");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 60));
        btnNewButton.setBounds(10, 10, 132, 80);
        btnNewButton.setBorderPainted(false);
        panel.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Sign In - Addess - Order & Pay");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(131, 10, 858, 80);
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(100, 100, 900, 735);
        add(panel_1);
        panel_1.setLayout(null);

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
        lblNewLabel_2.setBounds(10, 62, 860, 23);
        panel_2.add(lblNewLabel_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.WHITE);
        panel_3.setBounds(10, 95, 860, 180);
        panel_2.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("Nguyen Thi Thu Phuong");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_3.setBounds(10, 10, 840, 30);
        panel_3.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Address : Thanh Xuyen, Hoang Long, Phu Xuyen, Ha Noi");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(10, 50, 840, 30);
        panel_3.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Phone : 0382140588");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_5.setBounds(10, 90, 840, 30);
        panel_3.add(lblNewLabel_5);
        
        JButton btnNewButton_1 = new JButton("Ship to this address");
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.setBackground(new Color(51, 51, 204));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_1.setBounds(10, 129, 219, 30);
        panel_3.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Edit");
        btnNewButton_2.setBackground(Color.WHITE);
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_2.setBounds(239, 130, 85, 30);
        panel_3.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Delete");
        btnNewButton_3.setBackground(Color.WHITE);
        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_3.setBounds(338, 130, 85, 30);
        panel_3.add(btnNewButton_3);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new LineBorder(new Color(227, 227, 227)));
        panel_4.setBounds(10, 319, 860, 386);
        panel_2.add(panel_4);
        panel_4.setLayout(null);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBounds(100, 10, 660, 366);
        panel_4.add(panel_5);
        panel_5.setLayout(null);
        
        JLabel lblNewLabel_7 = new JLabel("Name");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_7.setBounds(10, 10, 85, 30);
        panel_5.add(lblNewLabel_7);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField.setBounds(139, 10, 511, 30);
        panel_5.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_8 = new JLabel("Phone\r\n");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_8.setBounds(10, 50, 85, 30);
        panel_5.add(lblNewLabel_8);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_1.setBounds(139, 50, 511, 30);
        panel_5.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_9 = new JLabel("City");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_9.setBounds(10, 90, 85, 30);
        panel_5.add(lblNewLabel_9);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ha Noi", "Ho Chi Minh", "Other city"}));
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(139, 90, 511, 30);
        panel_5.add(comboBox);
        
        JLabel lblNewLabel_10 = new JLabel("District");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_10.setBounds(10, 130, 100, 30);
        panel_5.add(lblNewLabel_10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(139, 130, 511, 30);
        panel_5.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_11 = new JLabel("Ward");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_11.setBounds(10, 170, 85, 30);
        panel_5.add(lblNewLabel_11);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(139, 170, 511, 30);
        panel_5.add(textField_3);
        
        JLabel lblNewLabel_12 = new JLabel("Address");
        lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_12.setBounds(10, 210, 100, 30);
        panel_5.add(lblNewLabel_12);
        
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textArea.setBounds(139, 215, 511, 76);
        panel_5.add(textArea);
        
        JButton btnNewButton_4 = new JButton("Cancel");
        btnNewButton_4.setBackground(SystemColor.controlHighlight);
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_4.setBounds(139, 313, 237, 30);
        panel_5.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Ship to this address");
        btnNewButton_5.setForeground(Color.WHITE);
        btnNewButton_5.setBackground(new Color(51, 51, 204));
        btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_5.setBounds(407, 313, 243, 30);
        panel_5.add(btnNewButton_5);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(10, 274, 860, 47);
        panel_2.add(panel_6);
        panel_6.setLayout(null);
        
        JLabel lblNewLabel_2_1 = new JLabel("You want to ship to a different address?");
        lblNewLabel_2_1.setBounds(10, 10, 285, 20);
        panel_6.add(lblNewLabel_2_1);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JLabel lblNewLabel_6 = new JLabel("Add new shipping address");
        lblNewLabel_6.setBounds(300, -1, 218, 42);
        panel_6.add(lblNewLabel_6);
        lblNewLabel_6.setForeground(new Color(51, 51, 204));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
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
}
