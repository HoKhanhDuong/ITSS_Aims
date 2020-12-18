package Object;

public class Media {
	private String nameString;
	private int priceFloat;
	private String categoryString;
	private String image;

	int soluong;
	private int id;
	
	public Media() {}
	
	public Media(String name, int price, String category,String img, int id) {
		// TODO Auto-generated constructor stub
		this.nameString = name;
		this.priceFloat = price;
		this.categoryString = category;
		this.id = id;
		this.image = img;
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
	public String getCategoryString() {
		return categoryString;
	}
	public void setCategoryString(String categoryString) {
		this.categoryString = categoryString;
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
	
	
}
