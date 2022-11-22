import java.lang.ArrayUtils;
public class Cart {
	public static final int MAX_NUMBERS_ORDERS = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERS];
	private  int qtyOrdered = 0 ;
	public  void addDigitalVideDisc(DigitalVideoDisc disc) {
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered ++;
	}
	public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
		for(int i =0;i<itemsOrdered.length ;i++) {
			if(itemsOrdered[i] == disc) 
				itemsOrdered = ArrayUtils.remove(itemsOrdered,i);
		}
	}
	
	public float totalCost() {
		float sum = 0;
		for(int i =0 ; i< itemsOrdered.length;i++) {
			 sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
	

}
