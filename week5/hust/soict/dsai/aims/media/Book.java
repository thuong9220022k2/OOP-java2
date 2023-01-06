package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	private List<String> authors = new ArrayList<String>();
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("the " + authorName + " has been added");
		}
		else System.out.println("the author " + authorName + " is already");
	}
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("the " + authorName + " has been removed");
		}
		else System.out.println("that the author " + authorName + " is not in");
	}
	public String toString() {
		return "Book " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " : " + this.getCost() + "$";
	}
}
