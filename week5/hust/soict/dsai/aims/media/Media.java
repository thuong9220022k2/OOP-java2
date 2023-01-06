package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public boolean equals(Object o) {
		try {
			return ((Media)o).getId() == this.id;
		} catch (NullPointerException e) {
			return false;
		} catch (ClassCastException e1) {
			return false;
		}
	}
	public String toString() {
		return "Media " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " : " + this.getCost() + "$";
	}
	
	public boolean filterProperty(String filter, String type) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else {
    		if (type == "title") {
    			if (this.getTitle().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    				return true;
    			}
    		} else if (type == "id") {
    			if(Integer.toString(this.getId()).toLowerCase().indexOf(filter.toLowerCase()) != -1) {
    				return true;
    			}
    		}
        }
        return false;
	}
	public static void main(String[] args) {
		ArrayList<Media> media1 = new ArrayList<Media>();
		CompactDisc cd = new CompactDisc(1, "cd01", "music", 10.2f, "abcd", "xyz");
		DigitalVideoDisc dvd = new DigitalVideoDisc(2, "dvd01", "amime", 20.5f, "hkjh", 20);
		Book book = new Book(3, "book01", "comics", 15.3f);
		media1.add(cd);
		media1.add(dvd);
		media1.add(book);
		Collections.sort(media1, COMPARE_BY_TITLE_COST);
		for (Media media : media1) {
			System.out.println(media.toString());
		}
	}
}
