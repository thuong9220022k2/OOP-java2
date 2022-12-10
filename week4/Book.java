package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public Book() {
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(String author) {
		// ensure that the author is not already in the ArrayList before adding
		if (!this.authors.contains(author)){
			this.authors.add(author);
		}
		else{
			System.out.println("The author is already in the list");
		}
	}
	public void removeAuthor(String author) {
		// ensure that the author is in the ArrayList before removing
		if (this.authors.contains(author)){
			this.authors.remove(author);
		}
		else{
			System.out.println("The author is not in the list");
		}
	}
}
