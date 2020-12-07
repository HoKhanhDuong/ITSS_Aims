package Object;

public class Media {
	String nameString;
	Float priceFloat;
	public Media(String name, Float price) {
		// TODO Auto-generated constructor stub
		nameString = name;
		priceFloat = price;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public Float getPriceFloat() {
		return priceFloat;
	}
	public void setPriceFloat(Float priceFloat) {
		this.priceFloat = priceFloat;
	}

}
