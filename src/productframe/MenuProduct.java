package productframe;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.MediaController;
import Manager.Application;
import login.Login;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class MenuProduct extends JPanel implements KeyListener{

	/**
	 * Create the panel.
	 */
	private JPanel contentPane;
	private JTextField searchTextField;
	public Login login;
	
	protected int page;
	private String search;
	
	public JButton shoppingButton;
	protected List<ProductPanel> listProduct;
	
	public Application application;
	public JPanel homePanel;
	public JButton signInButton;
	public JMenuBar menuBar;
  
	public MenuProduct(Application application ) {
		this.application = application;
		
		this.page = 0;
		this.listProduct = new ArrayList<ProductPanel>();
		
		setSize(1100, 600);
		setLayout(null);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		logoPanel.setBounds(0, 0, 80, 70);
		add(logoPanel);
		logoPanel.setLayout(null);
		
		JButton logoButton = new JButton("S2");
		logoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.switchPanel(application.home);
			}
		});
		logoButton.setBackground(Color.WHITE);
		logoButton.setFont(new Font("Savoye LET", Font.BOLD, 40));
		logoButton.setBounds(0, 0, 102, 70);
		logoButton.setBorderPainted(false);
		logoPanel.add(logoButton);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(Color.WHITE);
		searchPanel.setBounds(80, 0, 400, 70);
		add(searchPanel);
		searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		searchTextField = new JTextField();
		searchTextField.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		searchPanel.add(searchTextField);
		searchTextField.setColumns(20);
		searchTextField.addKeyListener(this);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBackground(Color.WHITE);
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchPanel.add(searchButton);
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				search = searchTextField.getText().trim();
				application.mediaControl.hiddenCurrentPanel(listProduct, page);
				setListProduct(application.mediaControl.get_product_search(search));
				
				if (getListProduct().size() == 0) {
					JOptionPane.showMessageDialog(null, "Khong co san pham nao", 
							"Search Message", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				page = 0;
				application.product.setType(7);
				application.mediaControl.screen_ListProduct(listProduct,page);
			}
		});
		
		homePanel = new JPanel();
		homePanel.setBackground(Color.WHITE);
		homePanel.setBounds(478, 0, 612, 70);
		add(homePanel);
        homePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 20));
		
		JButton homeButton = new JButton("HOME");
		homeButton.setForeground(Color.BLUE);
		homeButton.setBackground(Color.WHITE);
		homeButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		homeButton.setBorderPainted(false);
		
		
		shoppingButton = new JButton("SHOPPING");
		shoppingButton.setForeground(Color.BLACK);
		shoppingButton.setBackground(Color.WHITE);
		shoppingButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		shoppingButton.setBorderPainted(false);
		
		
		JButton saleButton = new JButton("SALE");
		saleButton.setForeground(Color.BLACK);
		saleButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		saleButton.setBorderPainted(false);
		saleButton.setBackground(Color.WHITE);
		
		
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeButton.setForeground(Color.BLUE);
				shoppingButton.setForeground(Color.BLACK);
				saleButton.setForeground(Color.BLACK);
				application.mediaControl.hiddenCurrentPanel(listProduct, page);
				page = 0;
				application.product.setType(7);
				application.switchPanel(application.home);
			}
		});
		
		shoppingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shoppingButton.setForeground(Color.BLUE);
				homeButton.setForeground(Color.BLACK);
				saleButton.setForeground(Color.BLACK);
				application.mediaControl.hiddenCurrentPanel(listProduct, page);
				page = 0;
				application.product.setType(7);
				setListProduct( application.mediaControl.get_ListProduct(0, page*20) );
				application.mediaControl.screen_ListProduct(listProduct,page);
			}
		});
		
		
		saleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleButton.setForeground(Color.BLUE);
				shoppingButton.setForeground(Color.BLACK);
				homeButton.setForeground(Color.BLACK);
				application.mediaControl.hiddenCurrentPanel(listProduct, page);
				page = 0;
				application.product.setType(7);
				setListProduct(application.mediaControl.get_ListProductSale(0, page*20) );
				if (getListProduct().size() != 0) {
					application.mediaControl.screen_ListProductSale(listProduct,page);
				} else {
					return;
				}
			}
		});
		homePanel.add(homeButton);
		homePanel.add(shoppingButton);
		homePanel.add(saleButton);
		
		
		signInButton = new JButton("SIGN IN");
		signInButton.setForeground(Color.ORANGE);
		signInButton.setBackground(Color.WHITE);
		signInButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		signInButton.setBorderPainted(false);
		homePanel.add(signInButton);
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(application);
			}
		});
		
		
		JButton cart = new JButton("CART");
		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cart.setForeground(Color.BLUE);
				application.mediaControl.hiddenCurrentPanel(listProduct, page);
				page = 0;
				application.product.setType(7);
				application.cartController.getMediaInCart();
				application.switchPanel(application.cart);
			}
		});
		cart.setBackground(Color.WHITE);
		cart.setForeground(Color.BLACK);
		cart.setFont(new Font("Times New Roman", Font.BOLD, 22));
		homePanel.add(cart);
		
		menuBar = new JMenuBar();
		menuBar.setVisible(false);

		homePanel.add(menuBar);
		
		JMenu account = new JMenu("ACCOUNT");
		account.setHorizontalAlignment(SwingConstants.CENTER);
		account.setBackground(Color.WHITE);
		account.setForeground(Color.BLACK);
		account.setBorderPainted(false);
		account.setFont(new Font("Times New Roman", Font.BOLD, 22));
		menuBar.add(account);
		
		JMenuItem taikhoanitem = new JMenuItem("T\u00E0i kho\u1EA3n c\u1EE7a t\u00F4i");
		taikhoanitem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		account.add(taikhoanitem);
		taikhoanitem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				application.userController.screenInfo(application.getID());
			}
		});
		
		JMenuItem taikhoanitem_3 = new JMenuItem("Qu\u1EA3n l\u00FD \u0111\u01A1n h\u00E0ng");
		taikhoanitem_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		account.add(taikhoanitem_3);
		taikhoanitem_3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					application.orderHisrory.setTable();
					application.switchPanel(application.orderHisrory);
				}
			});
			
			JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u0110\u0103ng Xu\u1EA5t");
			mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			account.add(mntmNewMenuItem_2);
			
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					application.setID(0);
					application.switchPanel(application.home);
				}
			});
	}

	public List<ProductPanel> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<ProductPanel> listProduct) {
		if(listProduct == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Khong co san pham");
			application.switchPanel(application.home);
		} else
			this.listProduct = listProduct;
	}
  
	public void switchStatus() {
		if(application.getID() != 0) {
			signInButton.setVisible(false);
			menuBar.setVisible(true);
			
		} else {
			menuBar.setVisible(false);
			signInButton.setVisible(true);
    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER: {
			search = searchTextField.getText().trim();
			application.mediaControl.hiddenCurrentPanel(listProduct, page);
			setListProduct(application.mediaControl.get_product_search(search));
			
			if (getListProduct() == null || getListProduct().size() == 0) {
				JOptionPane.showMessageDialog(null, "Khong co san pham nao", 
						"Search Message", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			page = 0;
			searchTextField.setText("");
			application.mediaControl.screen_ListProduct(getListProduct(),page);
			
			break;
		}
		
		default:
			break;
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		
		}
	}
}
