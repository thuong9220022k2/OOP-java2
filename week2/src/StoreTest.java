package lab2;

public class StoreTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king","Animation","Roger Allers",87,19.95f);
		cart.addDigitalVideDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start Wars","Science Fiction","Animation",87,24.95f);
		cart.addDigitalVideDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		cart.addDigitalVideDisc(dvd3);
		
		cart.removeDigitalVideoDisc(dvd3);
	}

}
