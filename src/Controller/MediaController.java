package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.DefaultListModel;

import Manager.Application;
import Object.Media;
import productframe.ProductPanel;

public class MediaController {
	
	private Application application;
	
	private List<Media> listMedia;
	private List<ProductPanel> listProduct;

	public MediaController(Application application) {
		// TODO Auto-generated constructor stub
		
		this.application = application;
	}
	
	public void screen_ListProduct(List<ProductPanel> listProduct) {
		application.product.addListProduct(listProduct);
		application.switchPanel(application.product);
	}
	
	public List<ProductPanel> get_ListProduct(int type) {
		
		int j = 0;
		
		listMedia = application.connect.getListMedia(type);
		listProduct = new ArrayList<ProductPanel>();
		ListIterator<Media> itr = listMedia.listIterator();
		
		while (itr.hasNext()) {
			if (j > 2) {
				j = 0;
				continue;
			}
			Media e = itr.next();
			ProductPanel productPanel= new ProductPanel(e, j);
			
			listProduct.add(productPanel);
			j++;
		}
		
		return listProduct;
	}
	
	public void hiddenCurrentPanel(List<ProductPanel> list, int page) {
		
		if (list != null && list.size() != 0) {
			for(int i=0 ; i < list.size(); i++) {
				list.get(i).setVisible(false);
			}
		}
	}
	

}
