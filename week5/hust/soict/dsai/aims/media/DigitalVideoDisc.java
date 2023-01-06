package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost, director, length);
	}
	public boolean equals(DigitalVideoDisc disc) {
		return this.getTitle().equals(disc.getTitle()) ? true : false;
	}
	public boolean isMatch(String title) {
		return this.getTitle().equals(title) ? true : false;
	}

	@Override
	public StringBuffer play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
			
			StringBuffer info = new StringBuffer("");
			info.append("Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength());
			return info;
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		
	}
	public String toString() {
		return "DVD " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + "$";
	}
}
