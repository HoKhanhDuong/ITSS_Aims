package Controller;

import java.util.ArrayList;

import Manager.Application;
import Object.Media;
import productframe.ProductPaneInCart;

public class CartController {

	private Application application;
	public CartController(Application application) {
		// TODO Auto-generated constructor stub
		this.application = application;
	}
	
	public int checkSL(int IDMedia, int soluong) {
		int kho = application.connect.getSLKho(IDMedia);
		if(soluong > kho) {
			return -2;
		}
		return 1;
	}
	
	public int addMedia(int IDMedia, int soluong) {
		if(application.getID() != 0) {
			if(checkSL(IDMedia, soluong) == -2)
				return -2;
			
			int sl = application.connect.searchCart(application.getID(), IDMedia);
			if( sl == 0) {
				application.connect.addCart(application.getID(), IDMedia, soluong);
				return 1;
			}else {
				soluong += sl;
				application.connect.updateCart(application.getID(), IDMedia, soluong);
				return 1;
			}
		}
		return -1;
	}
	
	public ArrayList<ProductPaneInCart> getMediaInCart(){
		ArrayList<ProductPaneInCart> list;
		list = application.connect.getMediaInCart(application.getID());
		application.cart.setList(list);
		return list;
	}
}
