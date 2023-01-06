package hust.soict.dsai.aims.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	public AddBookToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		
		btnAdd.addActionListener(new btnAddListener());
		super.setTitle("Add Book");
	}
	
	private class btnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String title=null, category=null;
			float cost=0; int id = 0;
			for (JTextField tf : tfs) {
				if(tf.getName().equals("ID")) {
					id = Integer.parseInt(tf.getText());
				}
				if (tf.getName().equals("Title")) {
					title = tf.getText();
				}
				if (tf.getName().equals("Category")) {
					category = tf.getText();
				}
				if (tf.getName().equals("Cost")) {
					cost = Float.parseFloat(tf.getText());
				}
			}
			
			Book b =  new Book(id, title, category, cost);
			store.addMedia(b);
			JOptionPane.showMessageDialog(null, "the "+ b.getTitle() + " added to store");
		}
	}
}
