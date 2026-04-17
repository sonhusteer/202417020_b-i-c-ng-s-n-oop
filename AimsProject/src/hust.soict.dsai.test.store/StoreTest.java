public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        
        // Tạo một vài đĩa mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
        
        // Thử nghiệm thêm đĩa
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        
        // Thử nghiệm xóa đĩa đang có
        store.removeDVD(dvd2);
        
        // Thử nghiệm xóa đĩa không tồn tại
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen");
        store.removeDVD(dvd4);
    }
}