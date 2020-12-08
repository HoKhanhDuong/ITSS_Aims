package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.DefaultListModel;

import Manager.Application;
import Object.Media;
import productframe.ProductPanel;

public class MediaController {
	
	private int i = 0, j = 0;
	
	private List<Media> listMedia;
	private List<ProductPanel> listProduct;

	public MediaController(Application application) {
		// TODO Auto-generated constructor stub
		
		listProduct = new ArrayList<ProductPanel>();
		listMedia = application.connect.getListMedia();
		ListIterator<Media> itr = listMedia.listIterator();
		
		while (itr.hasNext()) {
			if (j > 2) {
				j = 0;
				i++;
				System.out.println(i);
				continue;
			}
			Media e = itr.next();
			ProductPanel productPanel= new ProductPanel(e, j, i);
			listProduct.add(productPanel);
			j++;
		}
		
		application.product.addListProduct(listProduct);
	}
	
	
	

}
