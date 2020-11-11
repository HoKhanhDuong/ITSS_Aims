import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

public class GioHang extends JPanel {

	/**
	 * Create the panel.
	 */
	public GioHang(JFrame f) {
		setSize(1100,600);
		setLayout(null);
		JPanel mediaJPanel = new JPanel();
		mediaJPanel.setLayout(null);
		mediaJPanel.setPreferredSize(new Dimension(800,350));
		//mediaJPanel.setBounds(200, 200, 310, 300);
		
		JLabel lblNewLabel_1 = new JLabel("Don gia");
		lblNewLabel_1.setBounds(113, 124, 46, 14);
		mediaJPanel.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Tong Tien");
		lblNewLabel_2.setBounds(645, 143, 65, 14);
		mediaJPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("So luong");
		lblNewLabel_3.setBounds(646, 94, 79, 25);
		mediaJPanel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Giam");
		btnNewButton_1.setBounds(546, 97, 65, 19);
		mediaJPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tang");
		btnNewButton_2.setBounds(735, 97, 65, 19);
		mediaJPanel.add(btnNewButton_2);
		
		JButton btnButton3 = new JButton("OK");
		btnButton3.setBounds(103, 300, 65, 65);
		mediaJPanel.add(btnButton3);
		
		JScrollPane jScrollPane = new JScrollPane(mediaJPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(72, 80, 92, 33);
		mediaJPanel.add(lblNewLabel);
		jScrollPane.setBounds(100, 100, 900, 300);
		//jScrollPane.setPreferredSize(new Dimension(900, 300));
		//jScrollPane.setBounds(100, 100, 900, 200);
		f.add(jScrollPane);
		JScrollBar scrollBar = new JScrollBar();
		//scrollBar.setBounds(1030, 105, 17, 284);
		
		
		//add(scrollBar);
		
		
		JButton btnNewButton = new JButton("Dat Hang");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(798, 483, 178, 68);
		add(btnNewButton);
		
		
	}
}
