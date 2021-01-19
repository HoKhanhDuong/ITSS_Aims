package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Manager.AdminApplication;
import Object.Media;

public class SaleMedia extends JPanel {
	public JTextField sale;
	JComboBox media;
	private ArrayList<Media> list;
	public int mediaid = 0;
	public SaleMedia(AdminApplication adminApplication, int i) {

		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(10, 40 + 51*(i), 805, 51);
		setLayout(null);
		
		sale = new JTextField();
		sale.setBounds(371, 10, 105, 30);
		sale.setColumns(10);
		this.add(sale);
		
		JButton btnVnd_1 = new JButton("%");
		btnVnd_1.setBounds(511, 10, 50, 30);
		btnVnd_1.setBackground(SystemColor.textHighlight);
		btnVnd_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVnd_1.setBorder(null);
		this.add(btnVnd_1);
		
		JComboBox group = new JComboBox();
		group.setBounds(2, 10, 128, 30);
		group.setModel(new DefaultComboBoxModel(new String[] {"Book", "CD", "LD", "DVD"}));
		group.setFont(new Font("Tahoma", Font.PLAIN, 14));
		group.setBackground(Color.WHITE);
		this.add(group);
		
		media = new JComboBox();
		media.setBounds(183, 10, 128, 30);
		media.setModel(new DefaultComboBoxModel());
		media.setFont(new Font("Tahoma", Font.PLAIN, 14));
		media.setBackground(Color.WHITE);
		this.add(media);
		
		group.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				list = adminApplication.saleController.getListMedia(group.getSelectedIndex()+1);
				media.removeAllItems();
				
				for(int index=0; index<list.size(); index++) {
					media.addItem(list.get(index).getNameString());
				}
			}
		});
		
		
		
//		JButton btnNewButton = new JButton("Delete");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				listSale.remove(i);
//				adminApplication.addPromitions.promitionPanel.remove(i);
//			}
//		});
//		btnNewButton.setBounds(679, 14, 89, 23);
//		add(btnNewButton);

		media.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mediaid = list.get(media.getSelectedIndex()).getId();
			}
		});
	}
	
	public void update(ArrayList<Media> list) {
		
		media.removeAllItems();
		for(int i = 0; i < list.size(); i++) {
			media.addItem(list.get(i).getNameString());
		}
	}
}
