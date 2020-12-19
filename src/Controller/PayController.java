package Controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Manager.Application;
import Object.Address;

public class PayController {
	private Application application;
	public Address address;
	public ArrayList<Address> list;
	int i;
	public PayController(Application application) {
		this.application = application;
	}
	public void deleteAddress(int IDAddress) {
		application.connect.deleteAdd(IDAddress);
		
		application.pay.changeAddress(getNextAddress());
		if( i != 0) list.remove(i-1);
		else list.remove(list.size()-1);
	}
	public void addAddress(String name, String phone, String city, String district, String addressString) {
		if(name == null || phone == null || city == null || district == null || addressString == null) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "Please enter all field!",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!phone.matches("(\\d+)?")) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "Your phone is incorrect",
				    "Inane error",
				    JOptionPane.ERROR_MESSAGE);
			return;
		}
		address = new Address(name, phone, city, district, addressString, application.getID());
		application.connect.addAdd(address);
		list.add(address);
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
		return list.get(i++);
	}

}
