

package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;
import java.util.Collections;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo một số media mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book1 = new Book("Java Programming", "Education", 25.0f);
        book1.addAuthor("James Gosling");
        CompactDisc cd1 = new CompactDisc("Greatest Hits", "Music", "Various", 15.5f, "Queen");
        cd1.addTrack(new Track("Bohemian Rhapsody", 6));
        cd1.addTrack(new Track("Don't Stop Me Now", 4));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);

        showMenu();
    }

    public static void showMenu() {
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    storeMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cartMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void storeMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void cartMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Implement các method helper
    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println(m.toString());
                return;
            }
        }
        System.out.println("Media not found.");
    }

    public static void addMediaToCart() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                cart.addMedia(m);
                return;
            }
        }
        System.out.println("Media not found.");
    }

    public static void playMedia() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        for (Media m : store.getItemsInStore()) {
            if (m.getTitle().equalsIgnoreCase(title) && m instanceof Playable) {
                ((Playable) m).play();
                return;
            }
        }
        System.out.println("Playable media not found.");
    }

    public static void updateStoreMenu() {
        System.out.println("Update Store: ");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            // Simple add, assume DVD for now
            System.out.print("Enter DVD title: ");
            String title = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();
            System.out.print("Cost: ");
            float cost = scanner.nextFloat();
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
            store.addMedia(dvd);
        } else if (choice == 2) {
            System.out.print("Enter media title to remove: ");
            String title = scanner.nextLine();
            for (Media m : store.getItemsInStore()) {
                if (m.getTitle().equalsIgnoreCase(title)) {
                    store.removeMedia(m);
                    return;
                }
            }
            System.out.println("Media not found.");
        }
    }

    public static void filterCart() {
        System.out.println("Filter by: 1. ID, 2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            cart.searchById(id);
        } else {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        }
    }

    public static void sortCart() {
        System.out.println("Sort by: 1. Title then Cost, 2. Cost then Title");
        int choice = scanner.nextInt();
        if (choice == 1) {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
        } else {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
        }
        System.out.println("Cart sorted.");
        cart.print();
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();
        for (Media m : cart.getItemsOrdered()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                cart.removeMedia(m);
                return;
            }
        }
        System.out.println("Media not found in cart.");
    }

    public static void playMediaFromCart() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        for (Media m : cart.getItemsOrdered()) {
            if (m.getTitle().equalsIgnoreCase(title) && m instanceof Playable) {
                ((Playable) m).play();
                return;
            }
        }
        System.out.println("Playable media not found in cart.");
    }

    public static void placeOrder() {
        System.out.println("Order created. Total: " + cart.totalCost() + " $");
        cart.getItemsOrdered().clear();
    }
}