package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void add(Media media) {
		if (itemsInStore.size() < MAX_NUMBERS_ORDERED) {
			itemsInStore.add(media);
			System.out.println("The media has been added");
		} else {
			System.out.println("The store is almost full");
		}
	}
	public void remove(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("The media has been removed");
		} else {
			System.out.println("The media is not in the store");
		}
	}
}
