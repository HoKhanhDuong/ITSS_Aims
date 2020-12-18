package productframe;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Manager.Application;
import Object.Book;
import Object.CD;
import Object.DVD;
import Object.LD;
import Object.Media;

import javax.swing.border.LineBorder;

public class DetailProduct extends MenuProduct {
	private JTextField textField;
	private JTable table;
	JPanel panel;
	JLabel priceLabel;
	JLabel nameLabel;
	JLabel imgLabel;
	int IDMedia;
	/**
	 * Create the panel.
	 */
	public DetailProduct(Application application) {
		super(application);
        setSize(1100, 600);
        setLayout(null);
        
        JPanel detailProductPanel = new JPanel();
        detailProductPanel.setBackground(Color.WHITE);
        detailProductPanel.setBounds(0, 70, 1100, 530);
        add(detailProductPanel);
        detailProductPanel.setLayout(null);
        
        JPanel imgPanel = new JPanel();
        imgPanel.setBackground(Color.WHITE);
        imgPanel.setBounds(100, 0, 300, 530);
        detailProductPanel.add(imgPanel);
        imgPanel.setLayout(null);
        
        imgLabel = new JLabel("img");
        imgLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // image
        imgLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\sach.jpg"));
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imgLabel.setBounds(10, 40, 280, 350);
        imgPanel.add(imgLabel);
        
        JPanel detailPanel = new JPanel();
        detailPanel.setBorder(null);
        detailPanel.setBackground(Color.WHITE);
        detailPanel.setBounds(400, 0, 600, 530);
        detailProductPanel.add(detailPanel);
        detailPanel.setLayout(null);
        
        nameLabel = new JLabel();
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        nameLabel.setBounds(40, 23, 510, 30);
        detailPanel.add(nameLabel);
        
        priceLabel = new JLabel();
        priceLabel.setForeground(Color.BLACK);
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        priceLabel.setBounds(67, 64, 152, 60);
        detailPanel.add(priceLabel);
        
        JPanel quantityPanel = new JPanel();
        quantityPanel.setBackground(Color.WHITE);
        quantityPanel.setBounds(40, 124, 193, 60);
        detailPanel.add(quantityPanel);
        quantityPanel.setLayout(null);
        
        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        quantityLabel.setBounds(10, 10, 82, 40);
        quantityPanel.add(quantityLabel);
        
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField.setBounds(102, 17, 62, 26);
        quantityPanel.add(textField);
        textField.setColumns(10);
        
        JButton buyNowButton = new JButton("BUY NOW");
        buyNowButton.setForeground(Color.ORANGE);
        buyNowButton.setBackground(Color.WHITE);
        buyNowButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        buyNowButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(textField.getText() != null) {
        		int soluong = Integer.parseInt(textField.getText());
        		int status;
        		if(soluong > 0) {
        			status = application.cartController.addMedia(IDMedia, soluong);
        			if(status == -1) {
        				JOptionPane.showMessageDialog(new JFrame(), "Please login or Sign up", "Inane error", JOptionPane.ERROR_MESSAGE);
        			}else if(status == -2) {
        				JOptionPane.showMessageDialog(new JFrame(), "Sorry we don't have enough stock", "Inane error", JOptionPane.ERROR_MESSAGE);        				
        			}else {
        				JOptionPane.showMessageDialog(new JFrame(), "Inserted into your cart", "Inane custom dialog", JOptionPane.INFORMATION_MESSAGE);        					
        			}
        		}else {
    				JOptionPane.showMessageDialog(new JFrame(), "Please enter count > 0", "Inane error", JOptionPane.ERROR_MESSAGE);
        		}
        		
        		}
        	}
        });
        buyNowButton.setBounds(40, 208, 138, 40);
        detailPanel.add(buyNowButton);
        
        JPanel informationPanel = new JPanel();
        informationPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        informationPanel.setBackground(Color.WHITE);
        informationPanel.setBounds(40, 272, 550, 168);
        detailPanel.add(informationPanel);
        informationPanel.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("The detail information of product");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(10, 10, 480, 34);
        informationPanel.add(lblNewLabel_2);
        
        panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 54, 550, 114);
        informationPanel.add(panel);
        panel.setLayout(null);
        
        JButton addCart = new JButton("Add to Cart");
        addCart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int status = application.cartController.addMedia(IDMedia, (Integer.parseInt(textField.getText())));
        		if(status == -2) {
        			JOptionPane.showMessageDialog(new JFrame(),
        				    "We haven't enough",
        				    "Inane error",
        				    JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        addCart.setBackground(Color.WHITE);
        addCart.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addCart.setBounds(199, 208, 152, 40);
        detailPanel.add(addCart);
        
        table = new JTable();
        panel.add(table);
        
	}
	public void setBookValue(Book book) {
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);
        table.setShowGrid(false);
        table.setRowSelectionAllowed(false);
        table.setEnabled(false);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{"Author :", book.getTacGiaString()},
	        		{"Type : ", book.getTheloaiString()},
	        		{"Publication date :", book.getNgayXBString()},
	        		{"Print length :", book.getSotrang()},
	        		{"Publisher :", book.getNgayXBString()},
	        		{"Language :", book.getNgonNguString()},
	        	},
	        	new String[] {
	        		"DETAIL", "INFORMATION"
	        	}
	        ));
		table.getColumnModel().getColumn(0).setPreferredWidth(106);
        table.getColumnModel().getColumn(1).setPreferredWidth(369);
        table.setBounds(10, 10, 530, 94);
        //panel.add(table);
	}
	
	public void setCDValue(CD cd) {
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);
        table.setShowGrid(false);
        table.setRowSelectionAllowed(false);
        table.setEnabled(false);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{"Artists :", cd.getTenNgheSyString()},
	        		{"Tracklist", cd.getBaihatString()},
	        		{"Type : ", cd.getTheLoaiString()},
	        		{"Record label :", cd.getHangGhiAmString()},
	        	},
	        	new String[] {
	        		"DETAIL", "INFORMATION"
	        	}
	        ));
		table.getColumnModel().getColumn(0).setPreferredWidth(106);
        table.getColumnModel().getColumn(1).setPreferredWidth(369);
        table.setBounds(10, 10, 530, 94);
        //panel.add(table);
	}
	public void setLDValue(LD ld) {
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);
        table.setShowGrid(false);
        table.setRowSelectionAllowed(false);
        table.setEnabled(false);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{"Artists :", ld.getTenNgheSyString()},
	        		{"Tracklist", ld.getBaihatString()},
	        		{"Type : ", ld.getTheLoaiString()},
	        		{"Record label :", ld.getHangGhiAmString()},
	        	},
	        	new String[] {
	        		"DETAIL", "INFORMATION"
	        	}
	        ));
		table.getColumnModel().getColumn(0).setPreferredWidth(106);
        table.getColumnModel().getColumn(1).setPreferredWidth(369);
        table.setBounds(10, 10, 530, 94);
        //panel.add(table);
	}
	
	public void setDVDValue(DVD dvd) {
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(false);
        table.setShowGrid(false);
        table.setRowSelectionAllowed(false);
        table.setEnabled(false);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{"Director :", dvd.getDaoDienString()},
	        		{"Runtime :", dvd.getThoiLuong()},
	        		{"Studio : ", dvd.getStudioString()},
	        		{"Leanguage :", dvd.getNgonNguString()},
	        		{"Subtitles :", dvd.getPhudeString()},
	        		{"Type :", dvd.getTheLoaiString()},
	        	},
	        	new String[] {
	        		"DETAIL", "INFORMATION"
	        	}
	        ));
		table.getColumnModel().getColumn(0).setPreferredWidth(106);
        table.getColumnModel().getColumn(1).setPreferredWidth(369);
        table.setBounds(10, 10, 530, 94);
        //panel.add(table);
	}
	
	public void changeValue(Media media) {
		imgLabel.setIcon(new ImageIcon(media.getImageString()));
		nameLabel.setText(media.getNameString());
		priceLabel.setText(media.getPriceFloat()+"");
		IDMedia = media.getId();
	}
}
