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
	
	
	public Product( Application application) {
		super(application);
		//this.page = 0;
		
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
		    	   if(value=="Price : Low to High") {
		    		   application.mediaControl.hiddenCurrentPanel(list, page);
						page = 0;
						setList(application.mediaControl.get_ListProductSort(0));
						setListProduct(list);
						application.mediaControl.screen_ListProduct(getList());
		    		   
		    	   }
		    	   else if(value=="Price : High to Low") {
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
				sortComboBox.addActionListener (new ActionListener () {
				       public void actionPerformed(ActionEvent e) {
				    	   String value = sortComboBox.getSelectedItem().toString();
				    	   if(value=="Price : Low to High") {
				    		   application.mediaControl.hiddenCurrentPanel(list, page);
								page = 0;
								setList(application.mediaControl.get_ListProductSort(-1));
								setListProduct(list);
								application.mediaControl.screen_ListProduct(getList());
				    		   
				    	   }
				    	   else if(value=="Price : High to Low") {
				    		   application.mediaControl.hiddenCurrentPanel(list, page);
								page = 0;
								setList(application.mediaControl.get_ListProductSort(1));
								setListProduct(list);
								application.mediaControl.screen_ListProduct(getList());
				    	   }
				       }
				});
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
				sortComboBox.setSelectedIndex(0);
				application.mediaControl.hiddenCurrentPanel(list, page);
				page = 0;
				setList(application.mediaControl.get_ListProduct(2));
				setListProduct(list);
				application.mediaControl.screen_ListProduct(getList());
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
				sortComboBox.setSelectedIndex(0);
				application.mediaControl.hiddenCurrentPanel(list, page);
				page = 0;
				setList(application.mediaControl.get_ListProduct(3));
				setListProduct(list);
				application.mediaControl.screen_ListProduct(getList());
				sortComboBox.addActionListener (new ActionListener () {
				       public void actionPerformed(ActionEvent e) {
				    	   String value = sortComboBox.getSelectedItem().toString();
				    	   if(value=="Price : Low to High") {
				    		   application.mediaControl.hiddenCurrentPanel(list, page);
								page = 0;
								setList(application.mediaControl.get_ListProductSort(-3));
								setListProduct(list);
								application.mediaControl.screen_ListProduct(getList());
				    		   
				    	   }
				    	   else if(value=="Price : High to Low") {
				    		   application.mediaControl.hiddenCurrentPanel(list, page);
								page = 0;
								setList(application.mediaControl.get_ListProductSort(3));
								setListProduct(list);
								application.mediaControl.screen_ListProduct(getList());
				    	   }
				       }
				});
				
			}
		});
		dvdButton.setBounds(0, 72, 200, 31);
		panel.add(dvdButton);
		
		
		JLabel sortLabel = new JLabel("Sort by :");
		sortLabel.setBounds(614, 10, 100, 40);
		SortProduct.add(sortLabel);
		sortLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		sortLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		panel_2 = new JPanel();
		panel_2.setBounds(230, 140, 795, 454);
		panel_2.setLayout(null);
		add(panel_2);
		
		JButton nextBtn = new JButton("Next");
		nextBtn.setBounds(653,362,74,21);
		panel_2.add(nextBtn);
		
		JButton backBtn = new JButton("Prev");
		backBtn.setBounds(577, 363, 69, 21);
		panel_2.add(backBtn);
		
		nextBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(page != -1 && page < Math.ceil((double)list.size()/3)-1) {
					page++;
					next(page);
				}
			}
		});
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((page-1) != -1) {
					page--;
					back(page);
				}
				
			}
		});
		
	}
	
	public void addListProduct(List<ProductPanel> listProduct) {
		this.list = listProduct;
		next(page);
	}
	
	
	public void next(int page) {
		
		int i=0;
		
		if(3*page > list.size()) {
			page = -1;
			return;
		}
		if(page > 0) {
			list.get((page-1)*3).setVisible(false);
			list.get((page-1)*3+1).setVisible(false);
			list.get((page-1)*3+2).setVisible(false);
		}
		for(i=3*page;i<=(3*page+2) && i<list.size();i++) {
			list.get(i).setVisible(true);
			panel_2.add(list.get(i));	
			
		}
	}
	public void back(int page) {
		
		for(int i=3*(page+1);i<=(3*(page+1)+2) && i<list.size();i++) {
			list.get(i).setVisible(false);
		}
		if(page >= 0) {
			list.get(page*3).setVisible(true);
			list.get(page*3+1).setVisible(true);
			list.get(page*3+2).setVisible(true);
		}
		
	}

	public List<ProductPanel> getList() {
		return list;
	}

	public void setList(List<ProductPanel> list) {
		this.list = list;
	}
	
	
	
	
}
