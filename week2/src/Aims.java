
public class Aims {
	
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king","Animation","Roger Allers",87,19.95f);
		anOrder.addDigitalVideDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start Wars","Science Fiction","Animation",87,24.95f);
		anOrder.addDigitalVideDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		anOrder.addDigitalVideDisc(dvd3);
		
		System.out.println("Total cost is :");
		System.out.println(anOrder.totalCost());
		removeDigitalVideoDisc(dvd3);
		System.out.println(dvd3);
		
		
	}

}
