package Object;

public class Media {
	String nameString;
	int priceFloat;
	String categoryString;

	String imageString;
	private int id;
	
	public Media() {}
	
	public Media(String name, int price, String category, int id) {
		// TODO Auto-generated constructor stub
		this.nameString = name;
		this.priceFloat = price;
		this.categoryString=category;
		this.id = id;
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

	public String getImageString() {
		return imageString;
	}

	public void setImageString(String imageString) {
		this.imageString = imageString;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
