package Object;

public class Media {
	String nameString;
	int priceFloat;
	String categoryString;
	
	public Media() {}
	
	public Media(String name, int price, String category) {
		// TODO Auto-generated constructor stub
		this.nameString = name;
		this.priceFloat = price;
		this.categoryString=category;
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
	

}
