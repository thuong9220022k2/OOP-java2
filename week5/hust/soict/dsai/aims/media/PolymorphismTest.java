package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {

	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		CompactDisc cd = new CompactDisc(1, "cd01", "music", 10.2f, "abcd", "xyz");
		Track t1 = new Track("t1", 10);
		Track t2 = new Track("t2", 8);
		cd.addTrack(t1);
		cd.addTrack(t2);
		DigitalVideoDisc dvd = new DigitalVideoDisc(2, "dvd01", "amime", 20.5f, "hkjh", 20);
		Book book = new Book(3, "book01", "comics", 15.3f);
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
	}

}
