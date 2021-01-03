package user;

import javax.swing.JPanel;

import Manager.Application;
import Object.OrderObject;
import productframe.MenuProduct;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Order extends MenuProduct {
	public JLabel nameLabel;
	JLabel phoneLabel;
	JLabel addressLabel;
	JLabel priceLabel;
	JLabel shipLabel;
	JLabel totalLabel;
	JLabel VATLabel;
	OrderObject orderObject;
	
	public Order(Application application) {
		super(application);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 70, 1100, 530);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(170, 15, 770, 500);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Receiver's information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 750, 30);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(9, 45, 750, 138);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 10, 78, 30);
		panel_2.add(lblNewLabel_1);
		
		nameLabel = new JLabel("NGUYEN THI THU PHUONG");
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameLabel.setBounds(100, 10, 642, 30);
		panel_2.add(nameLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 45, 78, 30);
		panel_2.add(lblNewLabel_1_1);
		
		phoneLabel = new JLabel("0382140588");
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneLabel.setBackground(Color.WHITE);
		phoneLabel.setBounds(100, 45, 642, 30);
		panel_2.add(phoneLabel);
		
		addressLabel = new JLabel("Thanh Xuyen, Hoang Long, Phu Xuyen, Ha Noi");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addressLabel.setBackground(Color.WHITE);
		addressLabel.setBounds(100, 85, 642, 30);
		panel_2.add(addressLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 85, 78, 30);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblOrderInformation = new JLabel("Order Information");
		lblOrderInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblOrderInformation.setBounds(10, 190, 750, 30);
		panel_1.add(lblOrderInformation);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(10, 221, 745, 203);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Money goods :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(10, 10, 142, 30);
		panel_2_1.add(lblNewLabel_1_2);
		
		priceLabel = new JLabel("100000");
		priceLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		priceLabel.setBackground(Color.WHITE);
		priceLabel.setBounds(196, 10, 520, 30);
		panel_2_1.add(priceLabel);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Transport fee:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(10, 45, 157, 30);
		panel_2_1.add(lblNewLabel_1_1_2);
		
		shipLabel = new JLabel("10000");
		shipLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		shipLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		shipLabel.setBackground(Color.WHITE);
		shipLabel.setBounds(181, 45, 532, 30);
		panel_2_1.add(shipLabel);
		
		totalLabel = new JLabel("110000");
		totalLabel.setForeground(new Color(255, 0, 51));
		totalLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		totalLabel.setBackground(Color.WHITE);
		totalLabel.setBounds(98, 127, 615, 30);
		panel_2_1.add(totalLabel);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Total :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 127, 78, 30);
		panel_2_1.add(lblNewLabel_1_1_1_1);
		
		JLabel vat = new JLabel("VAT (10%)");
		vat.setBounds(10, 86, 104, 30);
		panel_2_1.add(vat);
		vat.setHorizontalAlignment(SwingConstants.CENTER);
		vat.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		VATLabel = new JLabel("10000");
		VATLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		VATLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		VATLabel.setBackground(Color.WHITE);
		VATLabel.setBounds(184, 86, 532, 30);
		panel_2_1.add(VATLabel);
		
		JButton orderButton = new JButton("Order");
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.orderController.saveOrder(orderObject);
				
			}
		});
		orderButton.setForeground(new Color(51, 51, 255));
		orderButton.setBackground(Color.WHITE);
		orderButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		orderButton.setBounds(637, 453, 112, 30);
		panel_1.add(orderButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.switchPanel(application.home);
				orderObject = null;
			}
		});
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(462, 454, 114, 30);
		panel_1.add(btnCancel);
		
	}
	
	public void setValue(OrderObject order) {
		this.orderObject = order;
		nameLabel.setText(order.address.getName());
		phoneLabel.setText(order.address.getPhone());
		addressLabel.setText(order.address.getAddress()+", "+order.address.getDistrict()+", "+order.address.getCity());
		priceLabel.setText(order.price+"");
		shipLabel.setText(order.ship+"");
		VATLabel.setText((order.price*0.1)+"");
		totalLabel.setText(order.total+"");
	}
}
