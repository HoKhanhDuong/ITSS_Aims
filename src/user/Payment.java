package user;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.OrderController;
import Manager.Application;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {
	private JTextField cardNumbertextField;
	public Payment(Application application, float totalBill, OrderController orderController, int i) {
		setBounds(500, 200, 300, 400);
		JPanel contentPane = new JPanel();
		this.setContentPane(contentPane);
		contentPane.setBounds(0, 0, 300, 400);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("PAYMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(50, 11, 169, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total :");
		lblNewLabel_1.setBounds(25, 107, 66, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel totalLabel = new JLabel(totalBill+"");
		totalLabel.setBounds(149, 107, 109, 30);
		contentPane.add(totalLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Card Number : ");
		lblNewLabel_2.setBounds(6, 157, 95, 30);
		contentPane.add(lblNewLabel_2);
		
		cardNumbertextField = new JTextField();
		cardNumbertextField.setBounds(126, 162, 148, 20);
		contentPane.add(cardNumbertextField);
		cardNumbertextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i==1) {
					int flag = application.paymentController.check(cardNumbertextField.getText(), totalBill);
					if( flag == 1) {
						JOptionPane.showMessageDialog(new JFrame(), "Thanh toan thanh cong");
						dispose();
						orderController.saveOrder2();
					}else if(flag == 0) {
						JOptionPane.showMessageDialog(new JFrame(), "Thanh toan khong thanh cong \nKhong ton tai tai khoan"
								+cardNumbertextField.getText(),
							    "error", JOptionPane.ERROR_MESSAGE);
					}else if(flag == -1) {
						JOptionPane.showMessageDialog(new JFrame(), "Thanh toan khong thanh cong \nKhong du tien trong tai khoan",
								"error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					boolean flag = application.paymentController.refund(cardNumbertextField.getText(), totalBill);
					if( flag == true) {
						JOptionPane.showMessageDialog(new JFrame(), "Thanh toan thanh cong");
						dispose();
						orderController.cancelOrder2();
					}else if(flag == false) {
						JOptionPane.showMessageDialog(new JFrame(), "Thanh toan khong thanh cong \nKhong ton tai tai khoan"
								+cardNumbertextField.getText(),
							    "error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(50, 281, 169, 49);
		contentPane.add(btnNewButton);
	}
}
