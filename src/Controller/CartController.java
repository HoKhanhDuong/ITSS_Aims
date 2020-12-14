package Controller;

import Manager.Application;

public class CartController {

	private Application application;
	public CartController(Application application) {
		// TODO Auto-generated constructor stub
		this.application = application;
	}
	public int addMedia(int IDMedia, int soluong) {
		if(application.getID() != 0) {
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
}
