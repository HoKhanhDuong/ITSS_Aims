package Object;

public class Book extends Media{	
	
	private String biaString;
	private String nhaXBString;
	private String ngayXBString;
	private int sotrang;
	private String ngonNguString;
	private String theloaiString;
	private String tacGiaString;

	public Book(String name, int price, String category, int IDMedia){
		super(name, price, category,IDMedia);
		// TODO Auto-generated constructor stub
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getBiaString() {
		return biaString;
	}

	public void setBiaString(String biaString) {
		this.biaString = biaString;
	}

	public String getNhaXBString() {
		return nhaXBString;
	}

	public void setNhaXBString(String nhaXBString) {
		this.nhaXBString = nhaXBString;
	}

	public String getNgayXBString() {
		return ngayXBString;
	}

	public void setNgayXBString(String ngayXBString) {
		this.ngayXBString = ngayXBString;
	}

	public int getSotrang() {
		return sotrang;
	}

	public void setSotrang(int sotrang) {
		this.sotrang = sotrang;
	}

	public String getNgonNguString() {
		return ngonNguString;
	}

	public void setNgonNguString(String ngonNguString) {
		this.ngonNguString = ngonNguString;
	}

	public String getTheloaiString() {
		return theloaiString;
	}

	public void setTheloaiString(String theloaiString) {
		this.theloaiString = theloaiString;
	}

	public String getTacGiaString() {
		return tacGiaString;
	}

	public void setTacGiaString(String tacGiaString) {
		this.tacGiaString = tacGiaString;
	}
	
}
