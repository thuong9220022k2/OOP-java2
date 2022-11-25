package lab2;
public class TestingPassingParameter {
	public static void main (String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		swap(jungleDVD, cinderellaDVD);
		
		System.out.println("jung dvd title :" + jungleDVD.getTilte());
		System.out.println("cinderella dvd title : " + cinderellaDVD.getTilte());
		
		changeTitle(jungleDVD,cinderellaDVD.getTilte());
		System.out.println("jungle dvd title :" + jungleDVD.getTilte());
		
	}
	public static void swap(Object a1, Object a2) {
		Object tmp = a1;
		a1 = a2;
		a2 = tmp;
	}
	public static void changeTitle(DigitalVideoDisc dvd , String title) {
		String oldTitle = dvd.getTilte();
		dvd.setTilte(title);
		dvd = new DigitalVideoDisc(oldTitle);
		
	}

}
