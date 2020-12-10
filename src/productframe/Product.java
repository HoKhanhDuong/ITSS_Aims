package productframe;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Manager.Application;
import Object.Media;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

public class Product extends MenuProduct {

	/**
	 * Create the panel.
	 */
	public JScrollPane scrollPane;
	public JList list;
	private JPanel panel_1;
	
	public Product( Application application) {
		super(application);
		setBorder(new EmptyBorder(3,3,3,3));
		setSize(1100, 900);
		setLayout(null);
		
		JPanel ProductPortfolioPanel = new JPanel();
		ProductPortfolioPanel.setBounds(0, 70, 220, 770);
		ProductPortfolioPanel.setBackground(Color.WHITE);
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
		SortProduct.setBounds(220, 70, 880, 60);
		SortProduct.setBackground(Color.WHITE);
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
		
		
		
//		list = new JList();
//		list.setSelectedIndex(0);  
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        scrollPane.setViewportView(list);
	}
	
	public void addListProduct(List<ProductPanel> listProduct) {
		ListIterator<ProductPanel> itr = listProduct.listIterator();
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 2000, 2000);
		panel.setLayout(null);
		while(itr.hasNext()) {
			ProductPanel element =itr.next();
			panel.add(element);
		}
		scrollPane = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//scrollPane.setBounds(230, 140, 860, 230);
		scrollPane.setLocation(230, 140);
		scrollPane.setSize(new Dimension(860, 230));
		add(scrollPane);
	}
}
