package productframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Manager.Application;
import Object.Media;

public class ProductPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private final int WIDTH = 250;
	private final int HEIGHT = 300;
	
	public Media media;
	
	public ProductPanel(Media media, int x, int y, Application application) {
		setBackground(Color.WHITE);
		
		this.media = media;
		setBounds(15+x*(WIDTH+15), 15 + y*(HEIGHT+15), WIDTH, HEIGHT);
		setLayout(null);
		
		JLabel imgProduct = new JLabel(new ImageIcon(media.getImage()));
		imgProduct.setBackground(Color.WHITE);
		imgProduct.setHorizontalAlignment(SwingConstants.CENTER);
		imgProduct.setBounds(10, 10, 230, 220);
		imgProduct.setLayout(null);
		
		try {
			BufferedImage image = ImageIO.read(new File(media.getImage()));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(240, 220, image.SCALE_SMOOTH));
            imgProduct.setIcon(icon);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		add(imgProduct);
		
		JButton nameProductButton = new JButton(media.getNameString());
		nameProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.mediaControl.showMedia(media.getId(), media.getCategory());
			}
		});
		nameProductButton.setBackground(Color.WHITE);
		nameProductButton.setBorderPainted(false);
		nameProductButton.setHorizontalAlignment(SwingConstants.LEADING);
		nameProductButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameProductButton.setBounds(0, 240, 230, 21);
		add(nameProductButton);
		
//		JLabel priceLabel = new JLabel(media.getPriceFloat()+"");
//		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		priceLabel.setBounds(10, 271, 104, 21);
//		add(priceLabel);
		
		JLabel priceLabel = new JLabel(media.getPriceFloat()+"");
		
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel.setBounds(10, 271, 66, 21);
		add(priceLabel);
		if(media.getSale()>0) {
			priceLabel.setForeground(Color.GRAY);
			JLabel priceSaleLabel = new JLabel((int)(media.getPriceFloat()*(1-media.getSale()))+"");
			priceSaleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			priceSaleLabel.setBounds(84, 271, 66, 21);
			priceSaleLabel.setForeground(Color.RED);
			add(priceSaleLabel);
		}
		
		JButton btnNewButton = new JButton("BUY ");
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(141, 269, 99, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.mediaControl.showMedia(media.getId(), media.getCategory());
			}
		});
		add(btnNewButton);
	}

}
