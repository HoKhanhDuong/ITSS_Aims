package Object;

public class Media {
	private String nameString;
	private int priceFloat;
	private String category;
	private String image;
	private String date;
	private float sale = 0;

	int soluong;
	private int id;
	
	public Media() {}
	
	public Media(String name, int price, String category,String img, int id) {
		// TODO Auto-generated constructor stub
		this.nameString = name;
		this.priceFloat = price;
		this.category = category;
		this.id = id;
		this.image = img;
	}
	public Media(String name, int price, String category,String img, int id, float sale) {
		// TODO Auto-generated constructor stub
		this.nameString = name;
		this.priceFloat = price;
		this.category = category;
		this.id = id;
		this.image = img;
		this.sale = sale;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public int getPriceFloat() {
		return priceFloat;
	}
	public void setPriceFloat(int priceFloat) {
		this.priceFloat = priceFloat;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getSale() {
		return sale;
	}

	public void setSale(float sale) {
		this.sale = sale;
	}
	
	
}
