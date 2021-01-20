package productframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Manager.Application;

public class SaleProduct extends MenuProduct {
	public JScrollPane scrollPane;
	JButton back = new JButton("<<");
	JButton next = new JButton(">>");
	public List<ProductPanel> list;
	private JPanel panel_1;
	private JPanel panel_2;
	JPanel productPanel;
	private int type = 0;
	private boolean flag = false;

	public SaleProduct(Application application) {
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
						setList(application.mediaControl.get_ListProductSaleSort(type, 0));
						setListProduct(list);
						application.mediaControl.screen_ListProductSale(getList(),page); 
		    	   }
		    	   else if(value == "Price : High to Low") {
		    		   type = -type;
		    		   	application.mediaControl.hiddenCurrentPanel(list, page);
						page = 0;
						setList(application.mediaControl.get_ListProductSaleSort(type, 0));
						setListProduct(list);
						application.mediaControl.screen_ListProductSale(getList(),page);
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
				setList(application.mediaControl.get_ListProductSale(type, page*20));
				setListProduct(list);
				application.mediaControl.screen_ListProductSale(getList(),page);
				
			}
			
		});
		
//		sortComboBox.addActionListener (new ActionListener () {
//		       public void actionPerformed(ActionEvent e) {
//		    	   String value = sortComboBox.getSelectedItem().toString();
//		    	   if(value=="Price : Low to High") {
//		    		   application.mediaControl.hiddenCurrentPanel(list, page);
//						page = 0;
//						setList(application.mediaControl.get_ListProductSort(-2, 0));
//						setListProduct(list);
//						application.mediaControl.screen_ListProductSale(getList(),page);
//		    		   
//		    	   }
//		    	   else if(value=="Price : High to Low") {
//		    		   application.mediaControl.hiddenCurrentPanel(list, page);
//						page = 0;
//						setList(application.mediaControl.get_ListProductSort(2, 0));
//						setListProduct(list);
//						application.mediaControl.screen_ListProductSale(getList(),page);
//		    	   }
//		       }
//		});
		
		
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
				setList(application.mediaControl.get_ListProductSale(type, page*20));
				setListProduct(list);
				application.mediaControl.screen_ListProductSale(getList(),page);
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
				setList(application.mediaControl.get_ListProductSale(type, page*20));
				setListProduct(list);
				application.mediaControl.screen_ListProductSale(getList(),page);
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
				setList(application.mediaControl.get_ListProductSale(type, page*20));
				setListProduct(list);
				application.mediaControl.screen_ListProductSale(getList(),page);
				
			}
		});
		
		JLabel sortLabel = new JLabel("Sort by :");
		sortLabel.setBounds(647, 10, 67, 40);
		SortProduct.add(sortLabel);
		sortLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		sortLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
//		JButton back = new JButton("<<");
		back.setBounds(534, 15, 55, 30);
		SortProduct.add(back);
		back.setBackground(Color.LIGHT_GRAY);
//		JButton next = new JButton(">>");
		next.setBounds(590, 15, 55, 30);
		SortProduct.add(next);
		next.setBackground(Color.LIGHT_GRAY);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(application.mediaControl.get_ListProductSale(type, (page+1)*20).size() > 0) {
					application.mediaControl.hiddenCurrentPanel(list, page);
					page++;
					if(flag == false)
						setList(application.mediaControl.get_ListProductSale(type, page*20));
					else
						setList(application.mediaControl.get_ListProductSaleSort(type, page*20));
					setListProduct(list);
					application.mediaControl.screen_ListProductSale(getList(),page);
				}
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(page>0) {
					application.mediaControl.hiddenCurrentPanel(list, page);
					page--;
					if(flag == false)
						setList(application.mediaControl.get_ListProductSale(type, page*20));
					else
						setList(application.mediaControl.get_ListProductSaleSort(type, page*20));
					setListProduct(list);
					application.mediaControl.screen_ListProductSale(getList(),page);
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
//			for(int i=page*20; i<page*20+20;i++) {
//				list.add(list.get(i));
//			}
			this.list = list;
		}
}
