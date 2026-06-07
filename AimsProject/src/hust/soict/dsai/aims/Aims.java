package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class Aims {

    public static void main(String[] args) {
        // Khởi tạo Store và Cart chung
        Store store = new Store();
        Cart  cart  = new Cart();

        // Thêm dữ liệu mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        Book book1 = new Book("Java Programming", "Education", 25.0f);
        book1.addAuthor("James Gosling");

        CompactDisc cd1 = new CompactDisc(
                "Greatest Hits", "Music", "Various", 15.5f, "Queen");
        cd1.addTrack(new Track("Bohemian Rhapsody", 6));
        cd1.addTrack(new Track("Don't Stop Me Now", 4));

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Inception", "Sci-Fi", "Christopher Nolan", 148, 29.95f);
        Book book2 = new Book("Clean Code", "Education", 35.0f);
        book2.addAuthor("Robert C. Martin");
        CompactDisc cd2 = new CompactDisc(
                "Abbey Road", "Rock", "George Martin", 12.5f, "The Beatles");
        cd2.addTrack(new Track("Come Together", 4));
        cd2.addTrack(new Track("Something", 3));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);
        store.addMedia(cd2);

        // Khởi động GUI trên Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }
}