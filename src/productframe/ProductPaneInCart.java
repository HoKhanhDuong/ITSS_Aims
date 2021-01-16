package productframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Manager.Application;

import javax.swing.JTextField;

public class ProductPaneInCart extends JPanel implements ActionListener {
	public int id;
	public JLabel SoLuong;
	public JLabel imageLabel;
	public JLabel nameLabel;
	public JLabel priceLabel;
	private Application application;
	
	public ProductPaneInCart(String name, String image, int id, int price, int soluong, int i) {
		setBackground(Color.WHITE);
		// TODO Auto-generated constructor stub				
		setLayout(null);
		setBounds(0, 200*i, 551, 200);
		imageLabel = new JLabel("img");
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBounds(20, 28, 107, 133);
		try {
			BufferedImage image1 = ImageIO.read(new File(image));
            ImageIcon icon = new ImageIcon(image1.getScaledInstance(240, 220, image1.SCALE_SMOOTH));
            imageLabel.setIcon(icon);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		add(imageLabel);
		
		nameLabel = new JLabel(name);
		nameLabel.setBackground(new Color(240, 240, 240));
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		nameLabel.setBounds(161, 28, 256, 19);
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
		priceLabel.setBounds(255, 69, 88, 30);
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(priceLabel);
		
		SoLuong = new JLabel();
		SoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SoLuong.setBounds(254, 109, 93, 31);
		SoLuong.setText(soluong+"");
		add(SoLuong);
		this.id = id;
		
		JLabel lblNewLabel = new JLabel("Price :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(161, 69, 88, 31);
		add(lblNewLabel);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(161, 108, 88, 31);
		add(lblQuantity);
	}
	public void addApp(Application application) {
		this.application = application;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		application.cart.listp.remove(this);
		application.connect.removeInCart(application.getID(), id);
		application.cart.setList(application.cart.listp);
		
	}
}
