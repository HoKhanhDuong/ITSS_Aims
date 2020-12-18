package productframe;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import Manager.Application;
import Object.Media;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Cart extends MenuProduct {

	/**
	 * Create the panel.
	 */
	JPanel panel_3;
	private List<ProductPaneInCart> listp;
	JScrollPane scrollPane;
	JPanel panel_1;
	
	public Cart(Application application) {
		super(application);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(0, 70, 1100, 530);
		add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(100, 0, 900, 530);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 10, 900, 40);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CART");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 5, 73, 30);
		panel_2.add(lblNewLabel);
		
		//no product in cart
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 60, 880, 375);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel cart_image = new JLabel("img");
		cart_image.setIcon(new ImageIcon("img\\cart.jpg"));
		cart_image.setHorizontalAlignment(SwingConstants.CENTER);
		cart_image.setBounds(311, 27, 229, 144);
		panel_3.add(cart_image);
		
		JLabel empty_label = new JLabel("Your shopping cart is empty!");
		empty_label.setHorizontalAlignment(SwingConstants.CENTER);
		empty_label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		empty_label.setBounds(229, 181, 396, 27);
		panel_3.add(empty_label);
		
		JButton continuebtn = new JButton("Shopping continue");
		continuebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				application.mediaControl.hiddenCurrentPanel(list, page);
//				page = 0;
//				setList(application.mediaControl.get_ListProductSort(0));
//				setListProduct(list);
//				application.mediaControl.screen_ListProduct(getList());
			}
		});
		continuebtn.setBackground(new Color(255, 153, 51));
		continuebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		continuebtn.setBounds(321, 218, 219, 36);
		panel_3.add(continuebtn);
		
//		scrollPane = new JScrollPane();
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.setBounds(10, 70, 560, 350);
//		scrollPane.setLayout(null);
//		panel_1.add(scrollPane);
//		scrollPane.setVisible(false);
	    
	    
//		ProductPaneInCart paneInCart = new ProductPaneInCart();
//		panel_1.add(paneInCart);

		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.control);
		panel_4.setBounds(575, 49, 325, 481);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 10, 305, 113);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Delivery address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 10, 122, 25);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nguyen Thi Thu Phuong");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 42, 285, 25);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Thanh Xuyen, Hoang Long, Phu Xuyen, Ha Noi");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 77, 285, 25);
		panel_5.add(lblNewLabel_4);
		
		JButton changeButton = new JButton("Change");
		changeButton.setHorizontalAlignment(SwingConstants.TRAILING);
		changeButton.setBackground(Color.WHITE);
		changeButton.setForeground(Color.BLUE);
		changeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		changeButton.setBounds(210, 10, 85, 21);
		changeButton.setBorderPainted(false);
		panel_5.add(changeButton);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 133, 305, 91);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 10, 285, 25);
		panel_6.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" 111.000 d");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(10, 45, 285, 35);
		panel_6.add(lblNewLabel_6);
		
		JButton orderButton = new JButton("ORDER");
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//application.switchPanel(application.pay);
			}
		});
		orderButton.setForeground(Color.WHITE);
		orderButton.setBackground(new Color(255, 0, 0));
		orderButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		orderButton.setBounds(10, 234, 305, 35);
		panel_4.add(orderButton);
		
		scrollPane = new JScrollPane();
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.setBounds(10, 70, 560, 200);
//		scrollPane.setVisible(false);
//		panel_1.add(scrollPane);
		
	}

	public void setList(List<ProductPaneInCart> list) {
		if(list.size() == 0) {
			scrollPane.setVisible(false);
			panel_3.setVisible(true);
		}else {
			panel_3.setVisible(false);
			scrollPane.setVisible(true);
			Iterator<ProductPaneInCart> iterator = list.iterator();
			while(iterator.hasNext()) {
				ProductPaneInCart paneInCart = iterator.next();
				paneInCart.setPreferredSize(new Dimension(560, 350));
				scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane.getViewport().add(paneInCart);
				scrollPane.setSize(new Dimension(560,200));
				scrollPane.setPreferredSize(new Dimension(560, 200));
				scrollPane.setLocation(10, 70);
				paneInCart.setVisible(true);
				panel_1.add(scrollPane);
				System.out.println(paneInCart.nameLabel.getText());
			}
			
		
		}
	}
}
