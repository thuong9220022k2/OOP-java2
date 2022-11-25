package lab2;

public class DigitalVideoDisc {
	private String tilte;
	private String category;
	private String director;
	private int length;
	private float cost;
	//private static int nbDigitalVideoDisc = 0;
	public String getTilte() {
		return tilte;
	}
	public String getCategory() {
		return category;
	}
	public DigitalVideoDisc(String tilte) {
		super();
		this.tilte = tilte;
	}
	public DigitalVideoDisc(String tilte, String category, float cost) {
		super();
		this.tilte = tilte;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String tilte, String category, String director, float cost) {
		super();
		this.tilte = tilte;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String tilte, String category, String director, int length, float cost) {
		super();
		this.tilte = tilte;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTilte(String tilte) {
		this.tilte = tilte;
	}
	@Override
	public String toString() {
		return "DigitalVideoDisc [tilte=" + tilte + ", category=" + category + ", director=" + director + ", length="
				+ length + ", cost=" + cost + "]";
	}
	
	

}
