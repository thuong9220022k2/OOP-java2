package lab2;

public class Store {
	
	public static final int MAX_NUMBERS_ORDERS = 200;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERS];
	private  int qtyOrdered = 0 ;
	public  void addDigitalVideDisc(DigitalVideoDisc disc) {
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered ++;
		
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equals(disc)) {
				if (i == qtyOrdered - 1) {
					qtyOrdered--;
				} else {
					for (int j = i + 1; j < qtyOrdered; j++) {
						itemsOrdered[j] = itemsOrdered[j - 1];
					}
					qtyOrdered--;
				}
				System.out.println("The disc removed");
			}
		}

	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
		for(int i=0;i<qtyOrdered;i++) {
			if(qtyOrdered >= MAX_NUMBERS_ORDERS) {
				System.out.println("Store is full");
			}
			else {
				itemsOrdered[i] = dvd;
				qtyOrdered ++;
			}
		}
	}

}
