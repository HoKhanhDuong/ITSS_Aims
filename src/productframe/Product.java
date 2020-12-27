package productframe;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Controller.MediaController;
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
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;

import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import java.awt.Component;

public class Product extends MenuProduct {

	/**
	 * Create the panel.
	 */
	public JScrollPane scrollPane;
	public List<ProductPanel> list;
	private JPanel panel_1;
	private JPanel panel_2;
	JPanel productPanel;
	

	public Product(Application application) {
		super(application);
		
		setBorder(new EmptyBorder(3,3,3,3));
		setSize(1100, 1500);
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
		
		JPanel SortProduct = new JPanel();
		SortProduct.setBounds(220, 70, 880, 60);
		SortProduct.setBackground(Color.WHITE);
		add(SortProduct);
		SortProduct.setLayout(null);
		
		JComboBox sortComboBox = new JComboBox();
		sortComboBox.setBackground(Color.WHITE);
		sortComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Fetured", "Price : Low to High", "Price : High to Low"}));
		sortComboBox.setBounds(724, 15, 128, 30);
		SortProduct.add(sortComboBox);
		
		sortComboBox.addActionListener (new ActionListener () {
		       public void actionPerformed(ActionEvent e) {
		    	   String value = sortComboBox.getSelectedItem().toString();
		    	   if(value == "Price : Low to High") {
		    		   	application.mediaControl.hiddenCurrentPanel(list, page);
						page = 0;
						setList(application.mediaControl.get_ListProductSort(0));
						setListProduct(list);
						application.mediaControl.screen_ListProduct(getList()); 
		    	   }
		    	   else if(value == "Price : High to Low") {
		    		   	application.mediaControl.hiddenCurrentPanel(list, page);
						page = 0;
						setList(application.mediaControl.get_ListProductSort(7));
						setListProduct(list);
						application.mediaControl.screen_ListProduct(getList());
		    	   }
		       }
		});
		
		JButton bookButton = new JButton("BOOK");
		bookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortComboBox.setSelectedIndex(0);
				application.mediaControl.hiddenCurrentPanel(list, page);
				page = 0;
				setList(application.mediaControl.get_ListProduct(1));
				setListProduct(list);
				application.mediaControl.screen_ListProduct(getList());
				
			}
			
		});
		bookButton.setHorizontalAlignment(SwingConstants.LEFT);
		bookButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bookButton.setBackground(Color.WHITE);
		bookButton.setBounds(0, 10, 200, 31);
		bookButton.setBorderPainted(false);
		panel.add(bookButton);
		
		sortComboBox.addActionListener (new ActionListener () {
		       public void actionPerformed(ActionEvent e) {
		    	   String value = sortComboBox.getSelectedItem().toString();
		    	   if(value=="Price : Low to High") {
		    		   application.mediaControl.hiddenCurrentPanel(list, page);
						page = 0;
						setList(application.mediaControl.get_ListProductSort(-2));
						setListProduct(list);
						application.mediaControl.screen_ListProduct(getList());
		    		   
		    	   }
		    	   else if(value=="Price : High to Low") {
		    		   application.mediaControl.hiddenCurrentPanel(list, page);
						page = 0;
						setList(application.mediaControl.get_ListProductSort(2));
						setListProduct(list);
						application.mediaControl.screen_ListProduct(getList());
		    	   }
		       }
		});
		
		JButton cdButton = new JButton("CD");
		cdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortComboBox.setSelectedIndex(0);
				application.mediaControl.hiddenCurrentPanel(list, page);
				page = 0;
				setList(application.mediaControl.get_ListProduct(2));
				setListProduct(list);
				application.mediaControl.screen_ListProduct(getList());
			}
		});
		cdButton.setBackground(Color.WHITE);
		cdButton.setHorizontalAlignment(SwingConstants.LEADING);
		cdButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cdButton.setBounds(0, 39, 200, 31);
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
				sortComboBox.setSelectedIndex(0);
				application.mediaControl.hiddenCurrentPanel(list, page);
				page = 0;
				setList(application.mediaControl.get_ListProduct(3));
				setListProduct(list);
				application.mediaControl.screen_ListProduct(getList());
			}
		});
		dvdButton.setBounds(0, 70, 200, 31);
		panel.add(dvdButton);
		
		JButton lpButton = new JButton("LP");
		lpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortComboBox.setSelectedIndex(0);
				application.mediaControl.hiddenCurrentPanel(list, page);
				page = 0;
				setList(application.mediaControl.get_ListProduct(4));
				setListProduct(list);
				application.mediaControl.screen_ListProduct(getList());
				
			}
		});
		lpButton.setBackground(Color.WHITE);
		lpButton.setHorizontalAlignment(SwingConstants.LEADING);
		lpButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lpButton.setBounds(0, 104, 200, 31);
		lpButton.setBorderPainted(false);
		panel.add(lpButton);
		
		JLabel sortLabel = new JLabel("Sort by :");
		sortLabel.setBounds(614, 10, 100, 40);
		SortProduct.add(sortLabel);
		sortLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		sortLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		panel_2 = new JPanel();
		panel_2.setBounds(230, 140, 850, 454);
		panel_2.setLayout(null);
		add(panel_2);
		
		productPanel = new JPanel();
		scrollPane = new JScrollPane();
		scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(840, 410);
		scrollPane.setLocation(10, 10);
		
	}
	
	public void addListProduct(List<ProductPanel> listProduct) {
		this.list = listProduct;
		setListProduct(getList());
		scrollPane.remove(productPanel);		
		
		productPanel = new JPanel();
		productPanel.setLayout(null);
		productPanel.setPreferredSize(new Dimension(765, Math.round(list.size()/3 + 2)*310));
		
		for(int i = 0; i<list.size() -1; i++) {
			productPanel.add(list.get(i));
		}
		productPanel.setVisible(true);
		
		scrollPane.add(productPanel);
		scrollPane.setViewportView(productPanel);
		panel_2.add(scrollPane);
	}

		public List<ProductPanel> getList() {
			return list;
		}

		public void setList(List<ProductPanel> list) {
			this.list = list;
		}

	
}
