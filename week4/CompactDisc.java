package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	// constructor
	public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
		super();
		this.artist = artist;
	}
	public CompactDisc(String title, String category, float cost, String director, int length, String artist, ArrayList<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
	}
	public void addTrack(Track track) {
		// check if track is already in the list
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				System.out.println("Track is already in the list");
				return;
			}
		}
		tracks.add(track);
	}
	public void removeTrack(Track track) {
		// check if track is in the list
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				tracks.remove(i);
				return;
			}
		}
		System.out.println("Track is not in the list");
	}
	public int getLength() {
		int length = 0;
		for (int i = 0; i < tracks.size(); i++) {
			length += tracks.get(i).getLength();
		}
		return length;
	}
	@Override
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for (int i = 0; i < tracks.size(); i++) {
			tracks.get(i).play();
		}
	}

}
