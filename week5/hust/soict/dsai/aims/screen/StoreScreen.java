package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.stage.Stage;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;
	JPanel createNoth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update store");
		JMenuItem addBookMenu = new JMenuItem("Add Book");
		JMenuItem addCDMenu = new JMenuItem("Add CD");
		JMenuItem addDVDMenu = new JMenuItem("Add DVD");
		
		smUpdateStore.add(addBookMenu);
		addBookMenu.addActionListener(new btnMenuListener());
		smUpdateStore.add(addCDMenu);
		addCDMenu.addActionListener(new btnMenuListener());
		smUpdateStore.add(addDVDMenu);
		addDVDMenu.addActionListener(new btnMenuListener());
		menu.add(smUpdateStore);
		JMenuItem viewCartMenu = new JMenuItem("View Cart");
		menu.add(viewCartMenu);
		viewCartMenu.addActionListener(new ViewCartListener());
		JMenuItem viewStoreMenu = new JMenuItem("View store");
		menu.add(viewStoreMenu);
		viewStoreMenu.addActionListener(new btnMenuListener());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		JButton cart = new JButton("View Cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		cart.addActionListener(new ViewCartListener());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}
		return center;
	}
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNoth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	private class btnMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen(store, cart);
			} else if (command.equals("Add Book")) {
				new AddBookToStoreScreen(store, cart);
			} else if (command.equals("Add CD")) {
				new AddCompactDiscToStoreScreen(store, cart);
			} else if (command.equals("View Store")) {
				
			}
			dispose();
		}
	}
	private class ViewCartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new CartScreen(cart, store);
			dispose();
		}
		
	}
	public static void main(String[] args) {
		Store store = new Store();
		CompactDisc cd = new CompactDisc(1, "cd01", "music", 10.2f, "abcd", "xyz");
		Track t1 = new Track("t1", 10);
		Track t2 = new Track("t2", 8);
		cd.addTrack(t1);
		cd.addTrack(t2);
		DigitalVideoDisc dvd = new DigitalVideoDisc(2, "dvd01", "amime", 20.5f, "hkjh", 20);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(3, "dvd011", "jav", 22.3f, "afdaf", 30);
		Book book = new Book(4, "book01", "comics", 15.3f);
		store.addMedia(cd);
		store.addMedia(dvd);
		store.addMedia(book);
		store.addMedia(dvd1);
		Cart cart = new Cart();
		new StoreScreen(store, cart);
	}
}
