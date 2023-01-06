package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public StringBuffer play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
			
			StringBuffer info = new StringBuffer("");
			info.append("Playing track: " + this.getTitle() + "\n" + "Track length: " + this.getLength());
			return info;
		} else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
		
	}
	public boolean equals(Object obj) {
		if(!(obj instanceof Track)) {
			return false;
		}
		Track track = (Track) obj;
		return this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength();
	}
}
