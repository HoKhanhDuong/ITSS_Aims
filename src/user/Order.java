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

public class Order extends MenuProduct {

	/**
	 * Create the panel.
	 */
	JLabel nameLabel;
	JLabel phoneLabel;
	JLabel addressLabel;
	JLabel priceLabel;
	JLabel shipLabel;
	JLabel totalLabel;
	
	public Order(Application application) {
		super(application);
		
		JLabel lblNewLabel = new JLabel("Thong tin nguoi nhan :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(289, 125, 201, 55);
		add(lblNewLabel);
		
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(360, 185, 341, 19);
		add(nameLabel);
		
		phoneLabel = new JLabel("phone");
		phoneLabel.setBounds(360, 215, 341, 14);
		add(phoneLabel);
		
		addressLabel = new JLabel("Address");
		addressLabel.setBounds(360, 245, 341, 14);
		add(addressLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tien hang : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(289, 270, 107, 44);
		add(lblNewLabel_1);
		
		priceLabel = new JLabel("price");
		priceLabel.setBounds(442, 287, 193, 14);
		add(priceLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Phi ship :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(289, 342, 107, 30);
		add(lblNewLabel_2);
		
		shipLabel = new JLabel("ship");
		shipLabel.setBounds(442, 352, 193, 14);
		add(shipLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Tong :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(289, 401, 107, 36);
		add(lblNewLabel_3);
		
		totalLabel = new JLabel("total");
		totalLabel.setBounds(442, 414, 232, 14);
		add(totalLabel);
		
		JButton orderButton = new JButton("order");
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.orderController.saveOrder(application.payController.order);
			}
		});
		orderButton.setBackground(Color.RED);
		orderButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		orderButton.setForeground(Color.DARK_GRAY);
		orderButton.setBounds(377, 482, 89, 23);
		add(orderButton);
		
	}
	
	public void setValue(OrderObject order) {
		nameLabel.setText(order.address.getName());
		phoneLabel.setText(order.address.getPhone());
		addressLabel.setText(order.address.getAddress()+", "+order.address.getDistrict()+", "+order.address.getCity());
		priceLabel.setText(order.price+"");
		shipLabel.setText(order.ship+"");
		totalLabel.setText(order.total+"");
	}
}
