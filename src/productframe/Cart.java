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
	public List<ProductPaneInCart> listp;

	JLabel moneylabel;

	private List<ProductPaneInCart> list;

	JScrollPane scrollPane;
	JPanel panel_1;
	JPanel panel_4;
	JButton orderButton;
	public float total;
	
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
		cart_image.setHorizontalAlignment(SwingConstants.CENTER);
		cart_image.setLayout(null);
		cart_image.setIcon(new ImageIcon("img/cart.jpg"));
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
				shoppingButton.setForeground(Color.BLUE);
				application.mediaControl.hiddenCurrentPanel(listProduct, page);
				page = 0;
				setListProduct( application.mediaControl.get_ListProduct(0, page*20) );
				application.mediaControl.screen_ListProduct(listProduct,page);
			}
		});
		
		continuebtn.setBackground(new Color(255, 153, 51));
		continuebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		continuebtn.setBounds(321, 218, 219, 36);
		panel_3.add(continuebtn);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(568, 58, 322, 450);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 10, 305, 91);
		panel_4.add(panel_6);
		panel_6.setBackground(SystemColor.control);
		panel_6.setLayout(null);
		
		JLabel totalLabel = new JLabel("Total");
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		totalLabel.setBounds(10, 11, 285, 25);
		panel_6.add(totalLabel);
		
		moneylabel = new JLabel(" 111.000 d");
		moneylabel.setForeground(Color.RED);
		moneylabel.setHorizontalAlignment(SwingConstants.TRAILING);
		moneylabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		moneylabel.setBounds(10, 47, 285, 35);
		panel_6.add(moneylabel);
		
		orderButton = new JButton("ORDER");
		orderButton.setBounds(10, 171, 305, 35);
		panel_4.add(orderButton);
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.pay.changeAddress(application.payController.getNextAddress());
				application.switchPanel(application.pay);
			}
		});
		orderButton.setForeground(Color.RED);
		orderButton.setBackground(new Color(255, 0, 0));
		orderButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		panel_4.setVisible(false);
		scrollPane = new JScrollPane();
		
	}

	public void setList(List<ProductPaneInCart> list) {
		listp = list;
		if(application.getID() < 0) {
			panel_4.setVisible(false);
		}
		
		if(list.size() == 0) {
			scrollPane.setVisible(false);
			panel_3.setVisible(true);
			panel_4.setVisible(false);
		}else if(application.getID() > 0 && list.size() > 0) {
			panel_3.setVisible(false);
			panel_4.setVisible(true);
			scrollPane.setVisible(true);
			total = 0;
			JPanel productJPanel = new JPanel();
			productJPanel.setLayout(null);
			Iterator<ProductPaneInCart> iterator = list.iterator();
			while(iterator.hasNext()) {
				ProductPaneInCart paneInCart = iterator.next();
				productJPanel.add(paneInCart);
				total+=  Float.parseFloat(paneInCart.priceLabel.getText()) * Integer.parseInt(paneInCart.SoLuong.getText());
			}
			productJPanel.setPreferredSize(new Dimension(560, list.size()*200));
			scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setViewportView(productJPanel);
			scrollPane.setSize(new Dimension(550,400));
			scrollPane.setLocation(10, 70);
			moneylabel.setText(total+" d");
			productJPanel.setVisible(true);
			panel_1.add(scrollPane);
		}
	}
}