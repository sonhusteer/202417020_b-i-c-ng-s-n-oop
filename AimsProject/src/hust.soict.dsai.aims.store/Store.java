package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    // Phương thức thêm media vào kho
    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_ITEMS_IN_STORE) {
            itemsInStore.add(media);
            System.out.println("Media " + media.getTitle() + " đã được thêm vào kho.");
        } else {
            System.out.println("Kho hàng đã đầy, không thể thêm!");
        }
    }

    // Phương thức xóa media khỏi kho
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media " + media.getTitle() + " đã được xóa khỏi kho.");
        } else {
            System.out.println("Không tìm thấy media " + media.getTitle() + " trong kho.");
        }
    }
}