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
	JButton back = new JButton("<<");
	JButton next = new JButton(">>");
	public List<ProductPanel> list;
	private JPanel panel_1;
	private JPanel panel_2;
	JPanel productPanel;
	private int type = 0;
	private boolean flag = false;

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
		    	   flag = true;
		    	   String value = sortComboBox.getSelectedItem().toString();
		    	   if(type == 0)
	    		    	type = 7;
		    	   if(value == "Price : Low to High") {
		    		   	application.mediaControl.hiddenCurrentPanel(list, page);
						page = 0;
						setList(application.mediaControl.get_ListProductSort(type, 0));
						setListProduct(list);
						application.mediaControl.screen_ListProduct(getList(),page); 
		    	   }
		    	   else if(value == "Price : High to Low") {
		    		   type = -type;
		    		   	application.mediaControl.hiddenCurrentPanel(list, page);
						page = 0;
						setList(application.mediaControl.get_ListProductSort(type, 0));
						setListProduct(list);
						application.mediaControl.screen_ListProduct(getList(),page);
		    	   }
		       }
		});
		
		JButton bookButton = new JButton("BOOK");
		bookButton.setHorizontalAlignment(SwingConstants.LEFT);
		bookButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bookButton.setBackground(Color.WHITE);
		bookButton.setBounds(0, 10, 200, 31);
		bookButton.setBorderPainted(false);
		panel.add(bookButton);
		
		JButton cdButton = new JButton("CD");
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
		
		JButton lpButton = new JButton("LP");
		lpButton.setBackground(Color.WHITE);
		lpButton.setHorizontalAlignment(SwingConstants.LEADING);
		lpButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lpButton.setBounds(0, 104, 200, 31);
		lpButton.setBorderPainted(false);
		panel.add(lpButton);
		
		bookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookButton.setForeground(Color.BLUE);
				dvdButton.setForeground(Color.BLACK);
				cdButton.setForeground(Color.BLACK);
				lpButton.setForeground(Color.BLACK);
				type = 1;
				sortComboBox.setSelectedIndex(0);
				application.mediaControl.hiddenCurrentPanel(list, page);
				page = 0;
				setList(application.mediaControl.get_ListProduct(type, page*20));
				setListProduct(list);
				application.mediaControl.screen_ListProduct(getList(),page);
				
			}
			
		});
		
		
		cdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cdButton.setForeground(Color.BLUE);
				dvdButton.setForeground(Color.BLACK);
				bookButton.setForeground(Color.BLACK);
				lpButton.setForeground(Color.BLACK);
				type = 2;
				sortComboBox.setSelectedIndex(0);
				application.mediaControl.hiddenCurrentPanel(list, page);
				page = 0;
				setList(application.mediaControl.get_ListProduct(type, page*20));
				setListProduct(list);
				application.mediaControl.screen_ListProduct(getList(),page);
			}
		});
		
		
		
		dvdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dvdButton.setForeground(Color.BLUE);
				cdButton.setForeground(Color.BLACK);
				bookButton.setForeground(Color.BLACK);
				lpButton.setForeground(Color.BLACK);
				type = 3;
				sortComboBox.setSelectedIndex(0);
				application.mediaControl.hiddenCurrentPanel(list, page);
				page = 0;
				setList(application.mediaControl.get_ListProduct(type, page*20));
				setListProduct(list);
				application.mediaControl.screen_ListProduct(getList(),page);
			}
		});
		dvdButton.setBounds(0, 70, 200, 31);
		panel.add(dvdButton);
		
		
		lpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lpButton.setForeground(Color.BLUE);
				dvdButton.setForeground(Color.BLACK);
				cdButton.setForeground(Color.BLACK);
				bookButton.setForeground(Color.BLACK);
				type = 4;
				sortComboBox.setSelectedIndex(0);
				application.mediaControl.hiddenCurrentPanel(list, page);
				page = 0;
				setList(application.mediaControl.get_ListProduct(type, page*20));
				setListProduct(list);
				application.mediaControl.screen_ListProduct(getList(),page);
				
			}
		});
		
		
		JLabel sortLabel = new JLabel("Sort by :");
		sortLabel.setBounds(647, 10, 67, 40);
		SortProduct.add(sortLabel);
		sortLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		sortLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		back.setBounds(534, 15, 55, 30);
		SortProduct.add(back);
		back.setBackground(Color.LIGHT_GRAY);
		next.setBounds(590, 15, 55, 30);
		SortProduct.add(next);
		next.setBackground(Color.LIGHT_GRAY);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(application.mediaControl.get_ListProduct(type, (page+1)*20).size() > 0) {
					application.mediaControl.hiddenCurrentPanel(list, page);
					page++;
					if(flag == false)
						setList(application.mediaControl.get_ListProduct(type, page*20));
					else
						setList(application.mediaControl.get_ListProductSort(type, page*20));
					setListProduct(list);
					application.mediaControl.screen_ListProduct(getList(),page);
				}
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(page > 0) {
					application.mediaControl.hiddenCurrentPanel(list, page);
					page--;
					if(flag == false)
						setList(application.mediaControl.get_ListProduct(type, page*20));
					else
						setList(application.mediaControl.get_ListProductSort(type, page*20));
					setListProduct(list);
					application.mediaControl.screen_ListProduct(getList(),page);
				}
			}
		});
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
	
	public void addListProduct(List<ProductPanel> listProduct, int page) {
		
		this.list = listProduct;
		
		setListProduct(getList());
		
		scrollPane.remove(productPanel);		
		
		productPanel = new JPanel();
		productPanel.setLayout(null);
		productPanel.setPreferredSize(new Dimension(765, Math.round(list.size()/10 + 6)*310));

		for(int i = 0; i<=list.size() -1; i++) {
			productPanel.add(list.get(i));
		}
		
		productPanel.setVisible(true);
		
		scrollPane.add(productPanel);
		scrollPane.setViewportView(productPanel);
		panel_2.add(scrollPane);
		System.out.println(page);
	}
	

		public List<ProductPanel> getList() {
			return list;
		}

		public void setList(List<ProductPanel> list) {
			this.list = list;
		}
}
