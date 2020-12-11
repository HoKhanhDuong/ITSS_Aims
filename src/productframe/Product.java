package productframe;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Manager.Application;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Product extends MenuProduct {

	/**
	 * Create the panel.
	 */
	public Product( Application application) {
		super(application);
		setBorder(new EmptyBorder(3,3,3,3));
		setSize(1100, 1500);
		setLayout(null);
		
		JPanel ProductPortfolioPanel = new JPanel();
		ProductPortfolioPanel.setBackground(Color.WHITE);
		ProductPortfolioPanel.setBounds(0, 70, 220, 770);
		add(ProductPortfolioPanel);
		ProductPortfolioPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product portfoliol");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 200, 40);
		ProductPortfolioPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 60, 200, 460);
		ProductPortfolioPanel.add(panel);
		panel.setLayout(null);
		
		JButton bookButton = new JButton("BOOK");
		bookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bookButton.setHorizontalAlignment(SwingConstants.LEFT);
		bookButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bookButton.setBackground(Color.WHITE);
		bookButton.setBounds(0, 10, 200, 31);
		bookButton.setBorderPainted(false);
		panel.add(bookButton);
		
		JButton cdButton = new JButton("CD");
		cdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cdButton.setBackground(Color.WHITE);
		cdButton.setHorizontalAlignment(SwingConstants.LEADING);
		cdButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cdButton.setBounds(0, 41, 200, 31);
		cdButton.setBorderPainted(false);
		panel.add(cdButton);
		
		JButton dvdButton = new JButton("DVD");
		dvdButton.setForeground(Color.BLACK);
		dvdButton.setBackground(Color.WHITE);
		dvdButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dvdButton.setHorizontalAlignment(SwingConstants.LEFT);
		dvdButton.setBorderPainted(false);
		dvdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dvdButton.setBounds(0, 72, 200, 31);
		panel.add(dvdButton);
		
		JPanel SortProduct = new JPanel();
		SortProduct.setBackground(Color.WHITE);
		SortProduct.setBounds(220, 70, 880, 60);
		add(SortProduct);
		SortProduct.setLayout(null);
		
		JLabel sortLabel = new JLabel("Sort by :");
		sortLabel.setBounds(614, 10, 100, 40);
		SortProduct.add(sortLabel);
		sortLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		sortLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JComboBox sortComboBox = new JComboBox();
		sortComboBox.setBackground(Color.WHITE);
		sortComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Fetured", "Price : Low to High", "Price : High to Low"}));
		sortComboBox.setBounds(724, 15, 128, 30);
		SortProduct.add(sortComboBox);
		
		
		
		JPanel productPanel = new JPanel();
		productPanel.setBounds(244, 796, 635, 1000);
		productPanel.setLayout(null);
		
		
		
		JPanel productPanel_1 = new JPanel();
		productPanel_1.setBounds(35, 35, 250, 300);
		productPanel.add(productPanel_1);
		productPanel_1.setBackground(Color.WHITE);
		productPanel_1.setLayout(null);
		
		JLabel imgProduct = new JLabel("img1");
		imgProduct.setBackground(Color.WHITE);
		imgProduct.setHorizontalAlignment(SwingConstants.CENTER);
		imgProduct.setBounds(10, 10, 230, 220);
		productPanel_1.add(imgProduct);
		
		JButton nameProductButton = new JButton("Name Product");
		nameProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nameProductButton.setBackground(Color.WHITE);
		nameProductButton.setBorderPainted(false);
		nameProductButton.setHorizontalAlignment(SwingConstants.LEADING);
		nameProductButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameProductButton.setBounds(10, 240, 230, 21);
		productPanel_1.add(nameProductButton);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel.setBounds(27, 271, 104, 21);
		productPanel_1.add(priceLabel);
		
		JButton btnNewButton = new JButton("BUY ");
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(141, 269, 99, 23);
		productPanel_1.add(btnNewButton);
		
		JPanel productPanel_1_1 = new JPanel();
		productPanel_1_1.setBounds(290, 35, 250, 300);
		productPanel.add(productPanel_1_1);
		productPanel_1_1.setLayout(null);
		productPanel_1_1.setBackground(Color.WHITE);
		
		JLabel imgProduct_1 = new JLabel("img1");
		imgProduct_1.setHorizontalAlignment(SwingConstants.CENTER);
		imgProduct_1.setBackground(Color.WHITE);
		imgProduct_1.setBounds(10, 10, 230, 220);
		productPanel_1_1.add(imgProduct_1);
		
		JButton nameProductButton_1 = new JButton("Name Product");
		nameProductButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		nameProductButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameProductButton_1.setBorderPainted(false);
		nameProductButton_1.setBackground(Color.WHITE);
		nameProductButton_1.setBounds(10, 240, 230, 21);
		productPanel_1_1.add(nameProductButton_1);
		
		JLabel priceLabel_1 = new JLabel("Price");
		priceLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel_1.setBounds(27, 271, 104, 21);
		productPanel_1_1.add(priceLabel_1);
		
		JButton btnNewButton_1 = new JButton("BUY ");
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(141, 269, 99, 23);
		productPanel_1_1.add(btnNewButton_1);
		
		JPanel productPanel_2 = new JPanel();
		productPanel_2.setBounds(35, 345, 250, 300);
		productPanel.add(productPanel_2);
		productPanel_2.setBackground(Color.WHITE);
		productPanel_2.setLayout(null);
		
		JLabel imgProduct_1_1 = new JLabel("img1");
		imgProduct_1_1.setBackground(Color.WHITE);
		imgProduct_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		imgProduct_1_1.setBounds(10, 10, 230, 220);
		productPanel_2.add(imgProduct_1_1);
		
		JButton nameProductButton_2 = new JButton("Name Product");
		nameProductButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		nameProductButton_2.setBackground(Color.WHITE);
		nameProductButton_2.setBorderPainted(false);
		nameProductButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		nameProductButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameProductButton_2.setBounds(10, 240, 230, 21);
		productPanel_2.add(nameProductButton_2);
		
		JLabel priceLabel_2 = new JLabel("Price");
		priceLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel_2.setBounds(27, 271, 104, 21);
		productPanel_2.add(priceLabel_2);
		
		JButton btnNewButton_2 = new JButton("BUY ");
		btnNewButton_2.setForeground(Color.ORANGE);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(141, 269, 99, 23);
		productPanel_2.add(btnNewButton_2);
		
		JPanel productPanel_3 = new JPanel();
		productPanel_3.setBackground(Color.WHITE);
		productPanel_3.setBounds(595, 35, 250, 300);
		
		JScrollPane scrollPane = new JScrollPane(productPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(230, 142, 864, 652);
		add(scrollPane);
	}
}
