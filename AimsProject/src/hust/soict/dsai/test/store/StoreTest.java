package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        
        // Tạo một vài đĩa mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
        
        // Thử nghiệm thêm đĩa
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        
        // Thử nghiệm xóa đĩa đang có
        store.removeMedia(dvd2);
        
        // Thử nghiệm xóa đĩa không tồn tại
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen");
        store.removeMedia(dvd4);
    }
}