package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {	
	static Cart anOrder = new Cart();
	static Store myStore = new Store();
// the cart menu
	public static void filterMedia() {
		Scanner myInput = new Scanner(System.in);
		System.out.print("search by id or title: ");
		String filterInput = myInput.nextLine();
		if(filterInput.equals("id")) {
			System.out.print("input id: ");
			int filterId = myInput.nextInt();
			anOrder.searchById(filterId);
		}
		if (filterInput.equals("title")) {
			System.out.print("input title: ");
			String filterTitle = myInput.nextLine();
			anOrder.searchByTitle(filterTitle);
		}
	}
	public static void sortMedia() {
		Scanner myInput = new Scanner(System.in);
		System.out.print("search by title or cost: ");
		String sortInput = myInput.nextLine();
		if(sortInput.equals("title")) {
			anOrder.sortCartByTitle();
			anOrder.print();
		}
		if(sortInput.equals("cost")) {
			anOrder.sortCartByCost();
			anOrder.print();
		}
	}
	public static void removeMediaFromCart() {
		Scanner myInput = new Scanner(System.in);
		anOrder.print();
		System.out.println("print title of media: ");
		String removeMediaTitle = myInput.nextLine();
		for (Media media : anOrder.getItemsOrdered()) {
			if(media.getTitle().equals(removeMediaTitle)) {
				anOrder.removeMedia(media);
				break;
			}
		}
	}
	public static void playMediaCart() {
		System.out.print("enter the title of the media: ");
		Scanner myInput = new Scanner(System.in);
		String inputMedia = myInput.nextLine();
		for (Media media : anOrder.getItemsOrdered()) {
			if(media.getTitle().equals(inputMedia)) {
				if(media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					try {
						cd.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					try {
						dvd.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Can not play");
				}
			}
		}
	}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static int chonCartMenu() {
		int n = -1;
		Scanner myInput = new Scanner(System.in);
		n = myInput.nextInt();
		if(n>=0 && n<=5) return n;
		else return chonCartMenu();
	}
	public static boolean xuLyCartMenu() {
		int chon = chonCartMenu();
		boolean continueCart = true;
		switch (chon) {
		case 1:
			System.out.println("1. Filter medias in cart");
			filterMedia();
			break;
		case 2:
			System.out.println("2. Sort medias in cart");
			sortMedia();
			break;
		case 3:
			System.out.println("3. Remove media from cart");
			removeMediaFromCart();
			break;
		case 4:
			System.out.println("4. Play a media");
			playMediaCart();
			break;
		case 5:
			System.out.println("5. Place order");
			System.out.println("order is created");
			anOrder.setEmpty();
			break;
		case 0:
			System.out.println("0. Back");
			continueCart = false;
			break;
		}
		return continueCart;
	} 
// the media details menu
	public static void addToCart() {
		myStore.print();
		System.out.print("enter the title of the media: ");
		Scanner myInput = new Scanner(System.in);
		String inputMedia = myInput.nextLine();
		for (Media media : myStore.getItemsInStore()) {
			if(media.getTitle().equals(inputMedia)) {
				anOrder.addMedia(media);
			}
		}
	}
	public static void play() {
		System.out.print("enter the title of the media: ");
		Scanner myInput = new Scanner(System.in);
		String inputMedia = myInput.nextLine();
		for (Media media : myStore.getItemsInStore()) {
			if(media.getTitle().equals(inputMedia)) {
				if(media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					try {
						cd.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					try {
						dvd.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Can not play");
				}
			}
		}
	}
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	public static int chonMediaDetailsMenu() {
		int n = -1;
		Scanner myInput = new Scanner(System.in);
		n = myInput.nextInt();
		if(n>=0 && n<=2) return n;
		else return chonMediaDetailsMenu();
	}
	public static boolean xuMediaDetailsMenu() {
		int chon = chonMediaDetailsMenu();
		boolean continueMediaDetails = true;
		switch (chon) {
		case 1:
			System.out.println("1. Add to cart");
			addToCart();
			break;
		case 2:
			System.out.println("2. Play");
			play();
			break;
		case 0:
			System.out.println("0. Back");
			continueMediaDetails = false;
			break;
		}
		return continueMediaDetails;
	}
// the store menu
	public static void addMediaToCart() {
		myStore.print();
		System.out.print("enter the title of the media: ");
		Scanner myInput = new Scanner(System.in);
		String inputMedia = myInput.nextLine();
		int numberDVD = 0;
		for (Media media : anOrder.getItemsOrdered()) {
			if(media instanceof DigitalVideoDisc) {
				numberDVD++;
			}
		}
		for (Media media : myStore.getItemsInStore()) {
			if(media.getTitle().equals(inputMedia)) {
				anOrder.addMedia(media);
				if(media instanceof DigitalVideoDisc) {
					System.out.println("number of DVDs: " + ++numberDVD);
				}
			}
		}
	}
	public static void playMedia() {
		System.out.print("enter the title of the media: ");
		Scanner myInput = new Scanner(System.in);
		String inputMedia = myInput.nextLine();
		for (Media media : myStore.getItemsInStore()) {
			if(media.getTitle().equals(inputMedia)) {
				if(media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					try {
						cd.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					try {
						dvd.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Can not play");
				}
			}
		}
	}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static int chonStoreMenu() {
		int n = -1;
		Scanner myInput = new Scanner(System.in);
		n = myInput.nextInt();
		if(n>=0 && n<=4) return n;
		else return chonStoreMenu();
	}
	public static boolean xuLyStoreMenu() {
		int chon = chonStoreMenu();
		boolean continueViewStore = true;
		switch (chon) {
		case 1:
			System.out.println("1. See a media details");
			boolean continueMediaDetails = true;
			while(continueMediaDetails) {
				mediaDetailsMenu();
				continueMediaDetails = xuMediaDetailsMenu();
			}
			break;
		case 2:
			System.out.println("2. Add a media to cart");
			addMediaToCart();
			break;
		case 3:
			System.out.println("3. Play a media");
			playMedia();
			break;
		case 4:
			System.out.println("4. See current cart");
			boolean contunueSeeCart = true;
			while(contunueSeeCart) {
				cartMenu();
				contunueSeeCart = xuLyCartMenu();
			}
			break;
		case 0:
			System.out.println("0. Back");
			continueViewStore = false;
			break;
		}
		return continueViewStore;
	}
// the update store menu
	public static void addMediaToStore() {
		Scanner myInput = new Scanner(System.in);
		System.out.print("add book, cd or dvd: ");
		String addItem = myInput.nextLine();
		if(addItem.equals("book")) {
			System.out.print("input book id: ");
			int inputBookId = myInput.nextInt();
			System.out.print("input book title: ");
			String inputBookTitle = myInput.next();
			System.out.print("input book category: ");
			String inputBookCategory = myInput.next();
			System.out.print("input book cost: ");
			float inputBookCost = myInput.nextFloat();
			Book book = new Book(inputBookId, inputBookTitle, inputBookCategory, inputBookCost);
			myStore.addMedia(book);
		}
		if(addItem.equals("dvd")) {
			System.out.print("input dvd id: ");
			int inputDvdId = myInput.nextInt();
			System.out.print("input dvd title: ");
			String inputDvdTitle = myInput.next();
			System.out.print("input dvd category: ");
			String inputDvdCategory = myInput.next();
			System.out.print("input dvd cost: ");
			float inputDvdCost = myInput.nextFloat();
			System.out.print("input dvd director: ");
			String inputDvdDirector = myInput.next();
			System.out.print("input dvd length: ");
			int inputDvdLength = myInput.nextInt();
			DigitalVideoDisc dvd = new DigitalVideoDisc(inputDvdId, inputDvdTitle, inputDvdCategory, inputDvdCost, inputDvdDirector, inputDvdLength);
			myStore.addMedia(dvd);
		}
		if(addItem.equals("cd")) {
			System.out.print("input cd id: ");
			int inputCdId = myInput.nextInt();
			System.out.print("input cd title: ");
			String inputCdTitle = myInput.next();
			System.out.print("input cd category: ");
			String inputCdCategory = myInput.next();
			System.out.print("input cd cost: ");
			float inputCdCost = myInput.nextFloat();
			System.out.print("input cd director: ");
			String inputCdDirector = myInput.next();
			System.out.print("input cd artist: ");
			String inputCdArtist = myInput.nextLine();
			CompactDisc cd = new CompactDisc(inputCdId, inputCdTitle, inputCdCategory, inputCdCost, inputCdDirector, inputCdArtist);
			myStore.addMedia(cd);
		}
	}
	public static void removeMediaFromStore() {
		Scanner myInput = new Scanner(System.in);
		myStore.print();
		System.out.println("print title of media: ");
		String removeMediaTitle = myInput.nextLine();
		for (Media media : myStore.getItemsInStore()) {
			if(media.getTitle().equals(removeMediaTitle)) {
				myStore.removeMedia(media);
				break;
			}
		}
	}
	public static void showUpdateStoreMenu() {
		System.out.println("Update store: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add media to store");
		System.out.println("2. Remove media from store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");		
	}
	public static int chonUpdateStoreMenu() {
		int n = -1;
		Scanner myInput = new Scanner(System.in);
		n = myInput.nextInt();
		if(n>=0 && n<=2) return n;
		else return chonUpdateStoreMenu();
	}
	public static boolean xuLyUpdateStoreMenu() {
		int chon = chonUpdateStoreMenu();
		boolean continueUpdateStoreMenu = true;
		switch(chon) {
		case 1: 
			System.out.println("1. Add media to store");
			addMediaToStore();
			break;
		case 2:
			System.out.println("2. Remove media from store");
			removeMediaFromStore();
			break;
		case 0:
			System.out.println("0. Back");
			continueUpdateStoreMenu = false;
			break;
		}
		return continueUpdateStoreMenu;
	}
// the main menu
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static int chonMenu() {
		int n = -1;
		Scanner myInput = new Scanner(System.in);
		n = myInput.nextInt();
		if(n>=0 && n<=3) return n;
		else return chonMenu();
	}
	public static void xuLyMenu() {
		int chon = chonMenu();
		switch (chon) {
		case 1:
			System.out.println("1. View store");
			boolean continueViewStore = true;
			while(continueViewStore) {
				storeMenu();
				continueViewStore = xuLyStoreMenu();
			}
			break;
		case 2:
			System.out.println("2. Update store");
			boolean continueUpdateStoreMenu = true;
			while(continueUpdateStoreMenu) {
				showUpdateStoreMenu();
				continueUpdateStoreMenu = xuLyUpdateStoreMenu();
			}
			break;
		case 3:
			System.out.println("3. See current cart");
			boolean continueCart = true;
			while(continueCart) {
				cartMenu();
				continueCart = xuLyCartMenu();
			}
			break;
		case 0:
			System.out.println("0. Exit");
			System.exit(1);
			break;
		}
		
	}
	public static void main(String[] args) {
		CompactDisc cd = new CompactDisc(1, "cd01", "music", 10.2f, "abcd", "xyz");
		Track t1 = new Track("t1", 10);
		Track t2 = new Track("t2", 8);
		cd.addTrack(t1);
		cd.addTrack(t2);
		DigitalVideoDisc dvd = new DigitalVideoDisc(2, "dvd01", "amime", 20.5f, "hkjh", 20);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(3, "dvd011", "jav", 22.3f, "afdaf", 30);
		Book book = new Book(4, "book01", "comics", 15.3f);
		myStore.addMedia(cd);
		myStore.addMedia(dvd);
		myStore.addMedia(book);
		myStore.addMedia(dvd1);
		while(true) {
			showMenu();
			xuLyMenu();
		}
	}

}
