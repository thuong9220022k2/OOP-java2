package lab2;
public class Cart {
	public static final int MAX_NUMBERS_ORDERS = 20;
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
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for(int i=0;i<dvdList.length;i++) {
			itemsOrdered[qtyOrdered] = dvdList[i];
			qtyOrdered ++;
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		 itemsOrdered[qtyOrdered] = dvd1;
		 qtyOrdered ++;
		 itemsOrdered[qtyOrdered] = dvd2;
		 qtyOrdered ++;		
	}
	
	public float totalCost() {
		float sum = 0;
		for(int i =0 ; i< qtyOrdered;i++) {
			 System.out.println(itemsOrdered[i]);
			 sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
	
    public void print() {
    	float sum =0;
    	System.out.println("Ordered Item");
    	for(int i=0;i<qtyOrdered;i++) {
    		System.out.println("DVD - Title" + itemsOrdered[i].getTilte() + "Director " + itemsOrdered[i].getDirector() + " Length" + qtyOrdered + " Price" + itemsOrdered[i].getCost());
    		System.out.println("DVD " + itemsOrdered[i].getTilte());
    		sum += itemsOrdered[i].getCost();
    	}
    	System.out.println(sum);
    }
    public boolean isMatch(String title) {
    	for(int i=0;i<qtyOrdered;i++) {
    		if(title.equals(itemsOrdered[i].getTilte())) return true;		
    	}
    	return false;
    }
	

}
