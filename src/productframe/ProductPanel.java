package productframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private final int WIDTH = 240;
	private final int HEIGHT = 300;
	
	public ProductPanel(Media media, int x, Application application) {
		setBackground(Color.WHITE);
		
		setBounds(35+x*(WIDTH+15), 35, WIDTH, HEIGHT);
		setLayout(null);
		
		JLabel imgProduct = new JLabel("img1");
		imgProduct.setBackground(Color.WHITE);
		imgProduct.setHorizontalAlignment(SwingConstants.CENTER);
		imgProduct.setBounds(10, 10, 230, 220);
		add(imgProduct);
		
		JButton nameProductButton = new JButton(media.getNameString());
		nameProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.mediaControl.showMedia(media.getId(), media.getCategoryString());
			}
		});
		nameProductButton.setBackground(Color.WHITE);
		nameProductButton.setBorderPainted(false);
		nameProductButton.setHorizontalAlignment(SwingConstants.LEADING);
		nameProductButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameProductButton.setBounds(0, 240, 230, 21);
		add(nameProductButton);
		
		JLabel priceLabel = new JLabel(media.getPriceFloat()+"");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		priceLabel.setBounds(10, 271, 104, 21);
		add(priceLabel);
		
		JButton btnNewButton = new JButton("BUY ");
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(141, 269, 99, 23);
		add(btnNewButton);
	}

}
