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

public class DetailProduct extends MenuProduct {
	private JTextField textField;

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
        detailPanel.setBackground(Color.WHITE);
        detailPanel.setBounds(400, 0, 600, 530);
        detailProductPanel.add(detailPanel);
        detailPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("NAME PRODUCT");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(50, 40, 500, 30);
        detailPanel.add(lblNewLabel);
        
        JPanel quantityPanel = new JPanel();
        quantityPanel.setBackground(Color.WHITE);
        quantityPanel.setBounds(40, 116, 193, 60);
        detailPanel.add(quantityPanel);
        quantityPanel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Quantity");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1.setBounds(10, 10, 82, 40);
        quantityPanel.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField.setBounds(103, 10, 62, 40);
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
        buyNowButton.setBounds(288, 125, 180, 40);
        detailPanel.add(buyNowButton);
        
        JPanel informationPanel = new JPanel();
        informationPanel.setBackground(Color.WHITE);
        informationPanel.setBounds(40, 220, 560, 232);
        detailPanel.add(informationPanel);
        informationPanel.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("The detail information of product");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(10, 10, 540, 34);
        informationPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Thong tin san pham");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_3.setBounds(10, 54, 524, 168);
        informationPanel.add(lblNewLabel_3);
        
        
	}
}
