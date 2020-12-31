package Controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Manager.Application;
import Object.Address;
import Object.OrderObject;
import productframe.ProductPaneInCart;

public class PayController {
	private Application application;
	public Address address;
	public ArrayList<Address> list;
	int i;
	public OrderObject order;
	public PayController(Application application) {
		this.application = application;
	}
	public void deleteAddress(int IDAddress) {
		application.connect.deleteAdd(IDAddress);
		
		application.pay.changeAddress(getNextAddress());
		if( i != 0) list.remove(i-1);
		else list.remove(list.size()-1);
	}
	public Address addAddress(String name, String phone, String city, String district, String addressString) {
		if(name == null || phone == null || city == null || district == null || addressString == null) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "Please enter all field!",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if(!phone.matches("(\\d+)?")) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "Your phone is incorrect",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);
			return null;
		}
		address = new Address(name, phone, city, district, addressString, application.getID());
		application.connect.addAdd(address);
		list.add(address);
		return address;
	}
	public ArrayList<Address> getlistAddress() {
		list = application.connect.getAddresses(application.getID());
		return list;
	}
	
	public Address getNextAddress() {
		if(list == null) {
			getlistAddress();
			i=0;
		}
		if(i > list.size() - 1) i = 0;
		address = list.get(i);
		return list.get(i++);
	}
	
	public float shipMoney() {
		float ship = 0;
		float kg = application.connect.getKg(application.getID());
		String[] hanoi = {"Quan Ba Dinh", "Quan Hoan Kiem", "Quan Dong Da", "Quan Thanh Xuan", "Quan Cau Giay", "Quan Hoang Mai"
				, "Quan Hai Ba Trung", "Quan Tay Ho"};
		String[] hochiminh = {"Quan 1", "Quan 2", "Quan 3", "Quan 4", "Quan 5", "Quan 6", "Quan 7", "Quan 8", "Quan 9", "Quan 10", 
				"Quan 11", "Quan 12", "Quan Tan Binh", "Quan Binh Thanh", "Quan Phu Nhuan", "Quan Thu Duc", "Quan Go Vap",
				"Quan Binh Tan", "Quan Tan Phu" };
		if(address.getCity().equalsIgnoreCase("Ha Noi")) {
			for(int i=0; i<hanoi.length-1; i++) {
				if(hanoi[i].equalsIgnoreCase(address.getDistrict())) {
					ship = 22000;
					break;
				}
			}
		}else {
			if(address.getCity().equalsIgnoreCase("Ho Chi Minh")) {
				for(int i=0; i<hochiminh.length-1; i++) {
					if(hochiminh[i].equalsIgnoreCase(address.getDistrict())) {
						ship = 22000;
						break;
					}
				}
			} else ship = 30000;
		}
		if(ship == 22000) {
			kg = kg - 3;
		}else {
			kg = (float) (kg - 0.5);
		}
		kg = Math.round(kg);
		ship += kg*2.5;
		
		return ship;
	}
	
	public void makeOrder() {
		order = new OrderObject(address, application.cart.total, shipMoney());
		application.order.setValue(order);
		application.switchPanel(application.order);
	}
}
