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

import Manager.Application;

import javax.swing.JTextField;

public class ProductPaneInCart extends JPanel implements ActionListener {
	public int id;
	public JTextField SoLuong;
	public JLabel imageLabel;
	public JLabel nameLabel;
	public JLabel priceLabel;
	private Application application;
	
	public ProductPaneInCart(String name, String image, int id, int price, int soluong, int i) {
		// TODO Auto-generated constructor stub				
		setLayout(null);
		setBounds(0, 200*i, 560, 200);
		imageLabel = new JLabel("img");
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBounds(20, 28, 107, 133);
		add(imageLabel);
		
		nameLabel = new JLabel(name);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameLabel.setBounds(130, 28, 150, 19);
		add(nameLabel);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		deleteButton.setBounds(451, 69, 76, 19);
		deleteButton.setHorizontalAlignment(SwingConstants.LEADING);
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setForeground(new Color(255, 0, 0));
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		deleteButton.setBorderPainted(false);
		add(deleteButton);
		
		priceLabel = new JLabel(price+"");
		priceLabel.setBounds(140, 50, 88, 30);
		priceLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(priceLabel);
		
		SoLuong = new JTextField();
		SoLuong.setBounds(137, 100, 86, 31);
		SoLuong.setColumns(10);
		SoLuong.setText(soluong+"");
		add(SoLuong);
		this.id = id;
	}
	public void addApp(Application application) {
		this.application = application;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		application.cart.listp.remove(this);
		application.connect.removeInCart(application.getID(), id);
		System.out.println(application.getID()+"neb"+id);
		application.cart.setList(application.cart.listp);
		
	}
}
