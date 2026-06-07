


package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // Thêm media
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    // Xóa media
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media is not in the cart");
        }
    }

    // Tính tổng tiền
    public float totalCost() {
        float sum = 0;
        for (Media m : itemsOrdered) {
            sum += m.getCost();
        }
        return sum;
    }
   
    public void addMedia(Media... medias) {
        for (Media media : medias) {
            addMedia(media);
        }
    }
    public void addMedia(Media media1, Media media2) {
        addMedia(media1);
        addMedia(media2);
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        
        for (int i = 0; i < itemsOrdered.size(); i++) {
            // Sử dụng phương thức toString() đã viết ở Bước 1
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
    public void searchById(int id) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println("Found match for ID " + id + ": " + m.toString());
                found = true;
                break; // Vì ID là duy nhất nên có thể dừng ngay khi tìm thấy
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id); 
        }
    }
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.isMatch(title)) {
                System.out.println("Found match for title '" + title + "': " + m.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title containing: " + title); 
        }
    }
}

