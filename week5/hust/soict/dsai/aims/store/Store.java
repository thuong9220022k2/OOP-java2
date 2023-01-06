package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_DVDS_STORE = 20;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	public void addMedia(Media media) {
		if(itemsInStore.size() < MAX_DVDS_STORE) {
			itemsInStore.add(media);
			System.out.println("The media" + media.getTitle() + " has been added to store");
		}
		else System.out.println("the store is full");
	}
	public void removeMedia(Media media) {
		if(itemsInStore.isEmpty())
			System.out.println("the store is empty");
		else {
			itemsInStore.remove(media);
			System.out.println("The media" + media.getTitle() + " has been removed from store");
		}
	}
	public void print() {
		for (Media media : itemsInStore) {
			System.out.println(media.toString());
		}
	}
}
