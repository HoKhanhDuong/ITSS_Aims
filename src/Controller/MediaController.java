package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.DefaultListModel;

import Manager.Application;
import Object.Book;
import Object.CD;
import Object.DVD;
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
			ProductPanel productPanel= new ProductPanel(e, j, application);
			
			listProduct.add(productPanel);
			j++;
		}
		
		return listProduct;
	}
	
public List<ProductPanel> get_ListProductSort(int type) {
		
		int j = 0;
		
		listMedia = application.connect.getListMediaSort(type);
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
	
	public void showMedia(int id, String categoryString) {
		if(categoryString.equals("book")) {
			Book book = application.connect.getBook(id);
			book.setId(id);
			book.setCategoryString(categoryString);
			application.detailProduct.changeValue(book);
			application.detailProduct.setBookValue(book);
			application.switchPanel(application.detailProduct);
		}else if(categoryString.equals("CD")) {
			CD cd = application.connect.getCd(id);
			cd.setId(id);
			cd.setCategoryString(categoryString);
			application.detailProduct.changeValue(cd);
			application.switchPanel(application.detailProduct);
		}else if(categoryString.equals("LD")) {
			CD ldCd = application.connect.getlD(id);
			ldCd.setId(id);
			ldCd.setCategoryString(categoryString);
			application.detailProduct.changeValue(ldCd);
			application.switchPanel(application.detailProduct);
		}else if(categoryString.equals("DVD")) {
			DVD dvd = application.connect.getDvd(id);
			dvd.setId(id);
			dvd.setCategoryString(categoryString);
			application.detailProduct.changeValue(dvd);
			application.switchPanel(application.detailProduct);
		}
	}
	

}
