package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		JPanel directoryPanel = super.createSubPanel("Director");
		JPanel lengthPanel = super.createSubPanel("Length");
		super.centerPanel.add(directoryPanel, BorderLayout.CENTER);
		super.centerPanel.add(lengthPanel, BorderLayout.CENTER);
		btnAdd.addActionListener(new btnAddListener());
		super.setTitle("Add DVD");
	}
	private class btnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String title=null, category=null, director=null;
			float cost = 0f; int length = 0; int id = 0;
			for(JTextField tf: tfs) {
				if(tf.getName().equals("ID")) {
					id = Integer.parseInt(tf.getText());
				}
				if(tf.getName().equals("Title")) {
					title = tf.getText();
				}
				if(tf.getName().equals("Cost")) {
					cost = Float.parseFloat(tf.getText());
				}
				if(tf.getName().equals("Category")) {
					category = tf.getText();
				}
				if(tf.getName().equals("Director")) {
					System.out.println(tf.getText());
					director = tf.getText();
				}
				if(tf.getName().equals("Length")) {
					length = Integer.parseInt(tf.getText());
				}	
			}
			DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category,cost, director, length);
			store.addMedia(dvd);
			JOptionPane.showMessageDialog(null, "the "+ dvd.getTitle() + " added to store");
		}
	}
}
