package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();;
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	public void addMedia(Media media) {
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The media " + media.getTitle() + " has been added to cart");
		}
		else System.out.println("the cart is full");
	}
	public void removeMedia(Media media) {
		if(itemsOrdered.isEmpty())
			System.out.println("the cart is empty");
		else {
			itemsOrdered.remove(media);
			System.out.println("The media " + media.getTitle() + " has been removed from cart");
		}
	}
	public float totalCost() {
		int total = 0;
		for (Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}
	public void print() {
		for (Media media : itemsOrdered) {
			System.out.println(media.toString());
		}
	}
	public void searchById(int id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if(media.getId() == id) {
				System.out.println(media.toString());
				found = true;
			}
		}
		if(!found) {
			System.out.println("the media not in cart");
		}
	}
	public void searchByTitle(String title) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if(media.getTitle().equals(title)) {
				System.out.println(media.toString());
				found = true;
			}
		}
		if(!found) {
			System.out.println("the media not in cart");
		}
	}
	public void sortCartByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	public void sortCartByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	public void setEmpty() {
		itemsOrdered.removeAll(itemsOrdered);
	}
}
