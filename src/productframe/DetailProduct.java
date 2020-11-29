package productframe;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class DetailProduct extends MenuProduct {
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public DetailProduct() {
        setSize(1100, 600);
        setLayout(null);
        
        JPanel detailProductPanel = new JPanel();
        detailProductPanel.setBackground(Color.WHITE);
        detailProductPanel.setBounds(0, 70, 1100, 530);
        add(detailProductPanel);
        detailProductPanel.setLayout(null);
        
        JPanel imgPanel = new JPanel();
        imgPanel.setBackground(Color.WHITE);
        imgPanel.setBounds(100, 0, 300, 530);
        detailProductPanel.add(imgPanel);
        imgPanel.setLayout(null);
        
        JLabel imgLabel = new JLabel("img");
        imgLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        imgLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\sach-anh-dep3-788x445.jpg"));
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imgLabel.setBounds(10, 40, 280, 350);
        imgPanel.add(imgLabel);
        
        JPanel detailPanel = new JPanel();
        detailPanel.setBorder(null);
        detailPanel.setBackground(Color.WHITE);
        detailPanel.setBounds(400, 0, 600, 530);
        detailProductPanel.add(detailPanel);
        detailPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("NAME PRODUCT");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(40, 40, 510, 30);
        detailPanel.add(lblNewLabel);
        
        JPanel quantityPanel = new JPanel();
        quantityPanel.setBackground(Color.WHITE);
        quantityPanel.setBounds(40, 143, 193, 60);
        detailPanel.add(quantityPanel);
        quantityPanel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Quantity");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1.setBounds(10, 10, 82, 40);
        quantityPanel.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField.setBounds(102, 17, 62, 26);
        quantityPanel.add(textField);
        textField.setColumns(10);
        
        JButton buyNowButton = new JButton("BUY NOW");
        buyNowButton.setForeground(Color.ORANGE);
        buyNowButton.setBackground(Color.WHITE);
        buyNowButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        buyNowButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        buyNowButton.setBounds(40, 208, 138, 40);
        detailPanel.add(buyNowButton);
        
        JPanel informationPanel = new JPanel();
        informationPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        informationPanel.setBackground(Color.WHITE);
        informationPanel.setBounds(40, 272, 550, 168);
        detailPanel.add(informationPanel);
        informationPanel.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("The detail information of product");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(10, 10, 480, 34);
        informationPanel.add(lblNewLabel_2);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 54, 550, 114);
        informationPanel.add(panel);
        panel.setLayout(null);
        
        table = new JTable();
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);
        table.setShowGrid(false);
        table.setRowSelectionAllowed(false);
        table.setEnabled(false);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"Author :", "Nguyen Nhat Anh"},
        		{"Publication date :", "July 7, 2020"},
        		{"Print length :", "320 pages"},
        		{"Publisher :", "Penguin Press"},
        		{"Language :", "English"},
        	},
        	new String[] {
        		"DETAIL", "INFORMATION"
        	}
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(106);
        table.getColumnModel().getColumn(1).setPreferredWidth(369);
        table.setBounds(10, 10, 530, 94);
        panel.add(table);
        
        JButton btnNewButton = new JButton("Add to Cart");
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(199, 208, 152, 40);
        detailPanel.add(btnNewButton);
        
        JLabel lblNewLabel_3 = new JLabel("120.000 \u0111");
        lblNewLabel_3.setForeground(Color.BLACK);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_3.setBounds(40, 116, 152, 60);
        detailPanel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Price");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(102, 85, 84, 23);
        detailPanel.add(lblNewLabel_4);
        
        
	}
}
