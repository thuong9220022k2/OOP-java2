package hust.soict.dsai.test.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

public class Store {
	public static final int MAX_DVDS_STORE = 20;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) {
		if(itemsInStore.size() < MAX_DVDS_STORE)
			itemsInStore.add(media);
		else System.out.println("the cart is full");
	}
	public void removeMedia(Media media) {
		if(itemsInStore.isEmpty())
			System.out.println("the cart is empty");
		else itemsInStore.remove(media);
	}
}
