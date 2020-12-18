package productframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ProductPaneInCart extends JPanel {
	public int id;
	private JTextField SoLuong;
	public JLabel imageLabel;
	public JLabel nameLabel;
	public JLabel priceLabel;
	public ProductPaneInCart(String name, String image, int id, int price, int soluong, int i) {
		// TODO Auto-generated constructor stub				
		setLayout(null);
		imageLabel = new JLabel("img");
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBounds(20, 28*(1+i), 107, 133);
		add(imageLabel);
		
		nameLabel = new JLabel(name);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameLabel.setBounds(0, 10*(1+i), 150, 19);
		add(nameLabel);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(117, 77*(1+i), 76, 19);
		deleteButton.setHorizontalAlignment(SwingConstants.LEADING);
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setForeground(new Color(255, 0, 0));
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		deleteButton.setBorderPainted(false);
		add(deleteButton);
		
		priceLabel = new JLabel(price+"");
		priceLabel.setBounds(0, 41*(1+i), 88, 30);
		priceLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(priceLabel);
		
		SoLuong = new JTextField();
		SoLuong.setBounds(428, 64*(1+i), 86, 31);
		SoLuong.setColumns(10);
		SoLuong.setText(soluong+"");
		add(SoLuong);
	}
}
