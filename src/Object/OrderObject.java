package Object;

public class OrderObject {
	public Address address;
	public float price;
	public float ship;
	public float total;
	public int iddh;
	
	public OrderObject(Address address, float price, float ship) {
		this.address = address;
		this.price = price;
		this.ship = ship;
		this.total = (float) (price*1.1 + ship);
	}
	
}
