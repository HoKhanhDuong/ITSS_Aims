package Controller;

import java.util.List;
import java.util.ListIterator;

import Manager.Application;
import Object.Media;

public class MediaController {

	public MediaController(Application application) {
		// TODO Auto-generated constructor stub
		
		List<Media> media = application.connect.getListMedia();
		ListIterator<Media> itr = media.listIterator();
		while(itr.hasNext()) {
			
		}
	}

}
