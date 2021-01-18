package admin;

import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MediaPanel extends JPanel {

	public MediaPanel(String image, String name, String sale, int i) {
		// TODO Auto-generated constructor stub
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(10, 51*i, 805, 51);
		setLayout(null);
		
		JLabel imageLabel = new JLabel("New label");
		BufferedImage image1;
		try {
			image1 = ImageIO.read(new File(image));
			ImageIcon icon = new ImageIcon(image1.getScaledInstance(270, 340, image1.SCALE_SMOOTH));
			imageLabel.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		imageLabel.setBounds(10, 0, 69, 51);
		add(imageLabel);
		
		JLabel nameLabel = new JLabel(name);
		nameLabel.setBounds(139, 18, 114, 14);
		add(nameLabel);
		
		JLabel saleLabel = new JLabel(sale);
		saleLabel.setBounds(393, 18, 46, 14);
		add(saleLabel);
		
	}

}
