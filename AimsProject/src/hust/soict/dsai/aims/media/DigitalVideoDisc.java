package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

// DVD nên kế thừa Disc (Disc chứa director và length)
public class DigitalVideoDisc extends Disc implements Playable {

    // 1. CHỈ khai báo các thuộc tính riêng biệt (nếu chưa có ở Disc/Media)
    // Sau khi có Disc, bạn thậm chí không cần khai báo director và length ở đây nữa.

    // 2. Sử dụng super() trong Constructor
    public DigitalVideoDisc(String title) {
        super(title); 
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    // 3. Cài đặt phương thức play() từ interface Playable [cite: 156, 158]
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: Media length is non-positive!");
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public String toString() {
        return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getCost() + " $";
    }
}