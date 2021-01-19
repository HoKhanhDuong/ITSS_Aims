package Controller;

import Manager.Application;
import Object.OrderObject;
import user.Payment;

public class OrderController {

	private Application application;
	
	private final int SIZE = 10000;
	OrderObject orderObject;
	String lydoString;
	public OrderController(Application application) {
		// TODO Auto-generated constructor stub
		this.application = application;
	}
	public void saveOrder(OrderObject orderObject) {
		Payment payment = new Payment(application, orderObject.total, this, 1);
		this.orderObject = orderObject;
	}
	public void saveOrder2() {
		
		application.connect.saveOrder(orderObject, application.getID(), application.cart.listp);
		
		application.switchPanel(application.home);
	}
	
	public void cancelOrder(OrderObject orderObject, String lydo) {
		lydoString = lydo;
		Payment payment = new Payment(application, orderObject.total, this, 2);
		
		this.orderObject = orderObject;
	}
	public void cancelOrder2() {
		application.connect.cancelOrder(orderObject, lydoString);
		application.orderHisrory.getTxt_id_order().setText("");
		application.switchPanel(application.home);
	}
}
