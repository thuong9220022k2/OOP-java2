package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
		super(id, title, category, cost, director);
		this.artist = artist;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("the " + track.getTitle() + " has been added");
		}
		else System.out.println("the track " + track.getTitle() + " is already");
	}
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("the " + track.getTitle() + " has been removed");
		}
		else System.out.println("that the track " + track.getTitle() + " is not in");
	}
	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	@Override
	public StringBuffer play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			
			StringBuffer info = new StringBuffer("");
			info.append("Playing CD: " + this.getTitle() + "\n" + "CD length: " + this.getLength() + "\n");
			
			for (Track t : tracks) {
				try {
					StringBuffer trackInfo = t.play();
					info.append(trackInfo + "\n");
				} catch (PlayerException e) {
					throw e;
				}
			}
			return info;
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
		
	}
	public String toString() {
		return "CD " + this.getId() + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getArtist() + " : " + this.getCost() + "$";
	}
}
