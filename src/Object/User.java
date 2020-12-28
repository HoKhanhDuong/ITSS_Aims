package Object;

public class User {

	private String name;
	private String phone;
	private String address;
	private String email;
	private String card_number;
	public int isblock;
	
	private int id;
	
	public User(String name, String phone, 
			String address, String email, 
			String card_number, int id, int isblock) {
		// TODO Auto-generated constructor stub
		
		this.id = id;
		this.address = address;
		this.card_number = card_number;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.isblock = isblock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
