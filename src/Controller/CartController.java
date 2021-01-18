package Controller;

import java.util.ArrayList;

import Manager.Application;
import Object.Media;
import productframe.ProductPaneInCart;

public class CartController {

	private Application application;
	ArrayList<ProductPaneInCart> list;
	
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
				for(int i=0 ; i< application.cart.listp.size(); i++) {
					if(IDMedia == application.cart.listp.get(i).id) {
						application.cart.listp.get(i).SoLuong.setText(soluong+"");
						break;
					}
				}
				application.connect.updateCart(application.getID(), IDMedia, soluong);
				return 1;
			}
		}
		return -1;
	}
	
	public ArrayList<ProductPaneInCart> getMediaInCart(){
		list = application.connect.getMediaInCart(application.getID());
		for(int i=0; i<list.size(); i++) {
			list.get(i).addApp(application);
		}
		application.cart.setList(list);
		return list;
	}
	
}
